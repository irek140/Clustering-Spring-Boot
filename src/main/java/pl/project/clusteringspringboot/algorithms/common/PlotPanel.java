package pl.project.clusteringspringboot.algorithms.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import pl.project.clusteringspringboot.algorithms.CNBC.CNBCRTreePoint;
import pl.project.clusteringspringboot.algorithms.CNBC.InstanceConstraints;
import pl.project.clusteringspringboot.clustering.CDMCluster;
import pl.project.clusteringspringboot.clustering.model.IConstraintObject;
import pl.project.clusteringspringboot.spatialindex.spatialindex.Point;
import pl.util.Workspace;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class PlotPanel extends JPanel implements MouseListener, MouseWheelListener, MouseMotionListener
{

	@Autowired
	private static Workspace workspace;

	private final double maxX;
	RTreeIndex rtree;

	Collection<CNBCRTreePoint> result;
	InstanceConstraints ic;
	double zoom = 100;
	int width = 1200;
	int height = 1000;
	JScrollPane scrollPane;

	BufferedImage bufferedImage;

	int pWidth = 4;
	int defMargin = 2;
	private ArrayList<double[]> fml;
	private ArrayList<double[]> fcl;

	private ArrayList<double[]> frc;
	public double maxZoomedX;
	public double maxZoomedY;

	ArrayList<Color> colors;

	private int clustersCount;



	protected final static Logger log = LogManager.getLogger(PlotPanel.class.getSimpleName());

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public int getZoomed(double x)
	{
		return (int) (x * zoom);
	}

	public double getIndexedValue(int x) {
		return x / zoom;
	}

	public PlotPanel(Collection<Point> result, double maxX, InstanceConstraints ic,

                     ArrayList<double[]> fml, ArrayList<double[]> fcl, ArrayList<double[]> frc, int clustersCount) {


		this.maxX = maxX;
		this.clustersCount = clustersCount;
		log.info("Generating colors for " + clustersCount + " clusters.");
		colors = ColorUtils.createUniqueColors(clustersCount);
		log.info("Colors prepared.");

		zoom = (height*0.8) / maxX;

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

//        for (Object o : result) {
//            CNBCRTreePoint mp = (CNBCRTreePoint) o;
//
//            double[] coords = mp.m_pCoords;
//
//            for (int x = 0; x < coords.length; x++) {
//				coords[x] = coords[x] / 1;
//			}
//
//            mp.setValues(coords);
//		}

		this.result = new ArrayList<>();
		for (Point p : result) {
			this.result.add((CNBCRTreePoint) p);
		}
		this.ic = ic;
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);
		this.addMouseWheelListener(this);
		this.addMouseMotionListener(this);
		this.fml= fml;
		this.fcl = fcl;
		this.frc = frc;
	}
	
	public Color getColor(int i) {

		if (i == CDMCluster.NOISE || i == CDMCluster.UNCLASSIFIED) {
		    Color c = Color.LIGHT_GRAY;
            int r = c.getRed();
            int g = c.getGreen();
            int b = c.getBlue();
			return new Color(r,g,b,0x33);
		} else if (i == CDMCluster.DEFERRED) {
            Color c = Color.GRAY;
            int r = c.getRed();
            int g = c.getGreen();
            int b = c.getBlue();
            return new Color(r,g,b,0x66);
		} else {
		
			/*Color[] cs = new Color[]{
					Color.decode("0xFF4500"),
					Color.decode("0xB0C4DE"),
					Color.decode("0x0000CD"),
					Color.decode("0x4B0082"),
					Color.decode("0xBC8F8F"),
					Color.decode("0x800000"),
					Color.decode("0x8A2BE2"),
					Color.decode("0xB8860B"),
					Color.decode("0x556B2F"),
					Color.decode("0x8B4513"),
					Color.decode("0x006400"),
					Color.decode("0x2E8B57"),
					Color.decode("0x008080"),
					Color.decode("0xDC143C"),
					Color.decode("0x008080"),
					Color.decode("0xDC143C"),
					Color.BLUE,
					Color.ORANGE, Color.PINK, Color.RED, Color.GREEN, Color.MAGENTA, Color.BLACK};

			for (int index = 0; index < cs.length; index++) {
				Color c = cs[index];
				int r = c.getRed();
				int g = c.getGreen();
				int b = c.getBlue();
				cs[index] = new Color(r,g,b, 0x33);
			}*/

			Color c = colors.get(i);
			int r = c.getRed();
			int g = c.getGreen();
			int b = c.getBlue();
			c = new Color(r,g,b, 0x33);

			// return cs[i%cs.length];
			return c;
		}
	}

	public void saveToFile() {
		Graphics g = this.getGraphics();
		g.drawImage(bufferedImage, 500, 500, null);
		try {
			ImageIO.write(bufferedImage, ".png", new File("xxx.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {			
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		Stroke normalLine = new BasicStroke(1);

		drawConstraints(g, g2);


		/*if (rtree == null) {

            ArrayList<Point> dataset = new ArrayList();

            for(CNBCRTreePoint o : result) {
                double x = o.getValues()[0];
                double y = o.getValues()[1];
                String values = "" + x + ", " + y ;
                byte[] d = values.getBytes();
                CNBCRTreePoint no = new CNBCRTreePoint(new double[]{x,y});
                no.setDescription(values);
                dataset.add(no);
			}

		    log.info("Building an index.");
			rtree = null;
			try {
				rtree = new RTreeIndex();
				rtree.initRTree(dataset, 2);
                int id= 0;
                for(Point o : dataset) {
                    rtree.insertData(new byte[]{CDMCluster.UNCLASSIFIED}, o, id++);
                }
			} catch (Exception e) {
				log.error(e);
			}

		}*/

		for(CNBCRTreePoint o : result)
		{

			double[] coord = o.getValues();

			if (getZoomed(coord[0]) > maxZoomedX) maxZoomedX = getZoomed(coord[0]);
			if (getZoomed(coord[1]) > maxZoomedY) maxZoomedY = getZoomed(coord[1]);

			int id = o.getClusterId();
			g.setColor(getColor(id));
			
			if (id < 0) id = 0;
			
			Polygon p = new Polygon();
			g.fillRect(getZoomed(coord[0]),  getZoomed(coord[1]), pWidth, pWidth);
			/*
			switch(id%8) {
			case 0: g.fillRect(getZoomed(coord[0]),  getZoomed(coord[1]), pWidth, pWidth);
				break;
			case 1: g.drawRect(getZoomed(coord[0]),  getZoomed(coord[1]), pWidth, pWidth);
				break;
			case 2: g.drawLine(getZoomed(coord[0]),  getZoomed(coord[1]), getZoomed(coord[0]) + pWidth,  getZoomed(coord[1])+pWidth);
			g.drawLine(getZoomed(coord[0]),  getZoomed(coord[1])+pWidth, getZoomed(coord[0]) + pWidth,  getZoomed(coord[1]));
				break;
			case 3:
				g.drawLine(getZoomed(coord[0])+pWidth/2,  getZoomed(coord[1]), getZoomed(coord[0]) + pWidth/2,  getZoomed(coord[1])+pWidth);
				g.drawLine(getZoomed(coord[0]),  getZoomed(coord[1])+pWidth/2, getZoomed(coord[0]) + pWidth,  getZoomed(coord[1])+pWidth/2);
				break;
			case 4:
				p.addPoint(getZoomed(coord[0]), getZoomed(coord[1])+pWidth);
				p.addPoint(getZoomed(coord[0])+pWidth, getZoomed(coord[1])+pWidth);
				p.addPoint(getZoomed(coord[0])+pWidth/2, getZoomed(coord[1]));
				p.addPoint(getZoomed(coord[0]), getZoomed(coord[1])+pWidth);
				g.drawPolygon(p);
				break;
			case 5: 
				p.addPoint(getZoomed(coord[0])-1, getZoomed(coord[1])+pWidth+1);
				p.addPoint(getZoomed(coord[0])+pWidth+1, getZoomed(coord[1])+pWidth+1);
				p.addPoint(getZoomed(coord[0])+pWidth/2, getZoomed(coord[1])-1);
				p.addPoint(getZoomed(coord[0])-1, getZoomed(coord[1])+pWidth+1);
				g.fillPolygon(p);
				break;
			case 6:
				p.addPoint(getZoomed(coord[0])-1, getZoomed(coord[1])+pWidth+1);
				p.addPoint(getZoomed(coord[0])+pWidth+1, getZoomed(coord[1])+pWidth+1);
				p.addPoint(getZoomed(coord[0])+pWidth/2, getZoomed(coord[1])-1);
				p.addPoint(getZoomed(coord[0])-1, getZoomed(coord[1])+pWidth+1);
				g.fillPolygon(p);
				break;
			case 7:
				p.addPoint(getZoomed(coord[0]), getZoomed(coord[1]));
				p.addPoint(getZoomed(coord[0]), getZoomed(coord[1])+pWidth);
				p.addPoint(getZoomed(coord[0])+pWidth/2, getZoomed(coord[1])+pWidth);
				p.addPoint(getZoomed(coord[0]), getZoomed(coord[1]));
				g.drawPolygon(p);
				break;
				
			}*/
			
			g2.setStroke(normalLine);

			if (o.wasDeferred()) {
				g.drawOval(getZoomed(coord[0])-defMargin,  getZoomed(coord[1])-defMargin, pWidth+2*defMargin,  pWidth+2*defMargin);
				/*if (o.ndf < 1) {
					g.setColor(Color.red);
					g.drawLine(getZoomed(coord[0]), getZoomed(coord[1]), getZoomed(coord[0])+1, getZoomed(coord[1])+1);
				}*/
			}

			//g.drawOval((int) coord[0],  (int) coord[1], 2,  2);
//			g.drawString("" + coord[0] + "," + coord[1], (int) coord[0],  (int) coord[1]);
		//	g.drawString("" + o.getClusterId(), getZoomed(coord[0]),  getZoomed(coord[1]));
		}
		
		
	}

	private void drawConstraints(Graphics g, Graphics2D g2) {
		 
		if (ic != null) {
		//g2.setStroke(boldLine);
		
		for(int i = 0; i < ic.ml1.size(); i++) {
			
			g.setColor(Color.BLACK);
			
			IConstraintObject p0 = ic.ml1.get(i);
			double[] p0v = p0.getValues(); p0v[0] = p0v[0] / 1; p0v[1] = p0v[1] / 1;
			IConstraintObject p1 = ic.ml2.get(i);
			double[] p1v = p1.getValues(); p1v[0] = p1v[0] / 1; p1v[1] = p1v[1] / 1;

			g2.drawRect(getZoomed(p0v[0])-2*defMargin, getZoomed(p0v[1])-2*defMargin, pWidth + 4*defMargin, pWidth + 4*defMargin);
			g2.drawRect(getZoomed(p1v[0])-2*defMargin, getZoomed(p1v[1])-2*defMargin, pWidth + 4*defMargin, pWidth + 4*defMargin);
			g2.drawLine(getZoomed(p0v[0]), getZoomed(p0v[1]), getZoomed(p1v[0]), getZoomed(p1v[1]));
			
			g.setColor(Color.WHITE);
			g2.fillRect(getZoomed(p0v[0])-2*defMargin+1, getZoomed(p0v[1])-2*defMargin+1, pWidth + 4*defMargin-2, pWidth + 4*defMargin-2);
			g2.fillRect(getZoomed(p1v[0])-2*defMargin+1, getZoomed(p1v[1])-2*defMargin+1, pWidth + 4*defMargin-2, pWidth + 4*defMargin-2);
			
		}
		
		g.setColor(Color.RED);
		
		
		for(int i = 0; i < ic.cl1.size(); i++) {
			IConstraintObject p0 = ic.cl1.get(i);
			double[] p0v = p0.getValues(); p0v[0] = p0v[0] / 1; p0v[1] = p0v[1] / 1;
			IConstraintObject p1 = ic.cl2.get(i);
			double[] p1v = p1.getValues(); p1v[0] = p1v[0] / 1; p1v[1] = p1v[1] / 1;
			g2.drawRect(getZoomed(p0v[0])-2*defMargin, getZoomed(p0v[1])-2*defMargin, pWidth + 4*defMargin, pWidth + 4*defMargin);
			g2.drawRect(getZoomed(p1v[0])-2*defMargin, getZoomed(p1v[1])-2*defMargin, pWidth + 4*defMargin, pWidth + 4*defMargin);
		}
		
		Stroke dotted = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] {8,3}, 0);
		g2.setStroke(dotted);
		
		for(int i = 0; i < ic.cl1.size(); i++) {
			IConstraintObject p0 = ic.cl1.get(i);
			double[] p0v = p0.getValues(); p0v[0] = p0v[0] / 1; p0v[1] = p0v[1] / 1;
			IConstraintObject p1 = ic.cl2.get(i);
			double[] p1v = p1.getValues(); p1v[0] = p1v[0] / 1; p1v[1] = p1v[1] / 1;
			g2.drawLine(getZoomed(p0v[0]), getZoomed(p0v[1]), getZoomed(p1v[0]), getZoomed(p1v[1]));
		}
		
		g.setColor(Color.WHITE);
		
		for(int i = 0; i < ic.cl1.size(); i++) {
			IConstraintObject p0 = ic.cl1.get(i);
			double[] p0v = p0.getValues(); p0v[0] = p0v[0] / 1; p0v[1] = p0v[1] / 1;
			IConstraintObject p1 = ic.cl2.get(i);
			double[] p1v = p1.getValues(); p1v[0] = p1v[0] / 1; p1v[1] = p1v[1] / 1;
			g2.fillRect(getZoomed(p0v[0])-2*defMargin+1, getZoomed(p0v[1])-2*defMargin+1, pWidth + 4*defMargin-2, pWidth + 4*defMargin-2);
			g2.fillRect(getZoomed(p1v[0])-2*defMargin+1, getZoomed(p1v[1])-2*defMargin+1, pWidth + 4*defMargin-2, pWidth + 4*defMargin-2);
		}
		}
		
		if (fcl != null) {
			for(int i = 0; i < fcl.size(); i++) {
				double[] p = fcl.get(i);
				p[0] = p[0] / 1;
				p[1] = p[1] / 1;
				g2.drawOval(getZoomed(p[0])-3*defMargin, getZoomed(p[1])-3*defMargin, pWidth + 6*defMargin, pWidth + 6*defMargin);
			}
			
		}
		
		if (fml != null) {
			for(int i = 0; i < fml.size(); i++) {
				double[] p = fml.get(i);
				p[0] = p[0] / 1;
				p[1] = p[1] / 1;
				g2.drawRect(getZoomed(p[0])-3*defMargin, getZoomed(p[1])-3*defMargin, pWidth + 6*defMargin, pWidth + 6*defMargin);
			}
			
		}
		
		if(frc != null)
		{
			for(int i = 0; i < frc.size(); i++) {
				g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
				double[] p1 = frc.get(i); p1[0] = p1[0] / 1; p1[1] = p1[1] / 1;
				g2.setColor(Color.BLACK);
				g2.drawRoundRect(getZoomed(p1[0])-2*defMargin, getZoomed(p1[1])-2*defMargin, pWidth + 4*defMargin, pWidth + 4*defMargin, 3*defMargin, 3*defMargin);
				 
				i++;
				double[] p2 = frc.get(i); p2[0] = p2[0] / 1; p2[1] = p2[1] / 1;
				g2.setColor(Color.BLUE);
				g2.drawRoundRect(getZoomed(p2[0])-2*defMargin, getZoomed(p2[1])-2*defMargin, pWidth + 4*defMargin, pWidth + 4*defMargin, 3*defMargin, 3*defMargin);
				
				g2.setColor(Color.BLACK);
				g2.drawLine(getZoomed(p2[0]), getZoomed(p2[1]), getZoomed(p1[0]), getZoomed(p1[1]));

				i++;
				double[] p3 = frc.get(i); p3[0] = p3[0] / 1; p3[1] = p3[1] / 1;
				g2.setColor(Color.RED);
				g2.drawRoundRect(getZoomed(p3[0])-2*defMargin, getZoomed(p3[1])-2*defMargin, pWidth + 4*defMargin, pWidth + 4*defMargin, 3*defMargin, 3*defMargin);
				
				g2.setColor(Color.BLACK);
				g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER,	10f, new float[]{3f, 6f}, 0));
				g2.drawLine(getZoomed(p2[0]), getZoomed(p2[1]), getZoomed(p3[0]), getZoomed(p3[1]) );
				g2.setStroke(new BasicStroke());
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = new Point(new double[] {getIndexedValue(e.getX()), getIndexedValue(e.getY())});
		ArrayList<Point> nn = rtree.regionQuery(p, maxX / 10);
		for (Point np : nn) {
			CNBCRTreePoint cnrtp = (CNBCRTreePoint) np;
			log.info(cnrtp.getDescription());
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		ox = e.getX();
		oy = e.getY();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		ox = e.getX();
		oy = e.getY();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		ox = e.getX();
		oy = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		//System.out.println(x + ", " + y);
		
		for(CNBCRTreePoint o : result)
		{
			double[] coord = o.getValues();
			if (Math.abs(coord[0] - x) < 5 && Math.abs(coord[1] - y) < 5) {
				//System.out.println(">>>>>> " + coord[0] + ", " + coord[1]);
			} else {
				//System.out.println(".");
			}
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {

		double preciseWheelRotation = arg0.getPreciseWheelRotation();

		double delta = 100d * 1d / maxX;

		zoom += delta * preciseWheelRotation;
		
        this.setPreferredSize(new Dimension(4800, 4000));

		this.scrollPane.repaint();

		repaint();
	}

	int ox = -1;
	int oy = -1;

	@Override
	public void mouseDragged(MouseEvent arg0) {
		int dx = ox - arg0.getX();
		int dy = oy - arg0.getY();

		JScrollBar sbh = scrollPane.getHorizontalScrollBar();
		JScrollBar sbv = scrollPane.getVerticalScrollBar();

		int nvx = sbh.getValue() + dx;
		int nvy = sbv.getValue() + dy;

		if (nvx >= 0) sbh.setValue(nvx);
		if (nvy >= 0) sbv.setValue(nvy);
			
		ox = arg0.getX();
		oy = arg0.getY();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public static void plotResult(Collection<Point> result, double maxX, double maxY, InstanceConstraints ic,
								  ArrayList<double[]> fml, ArrayList<double[]> fcl, ArrayList<double[]> frc,
								String fileName, boolean closePlot, int clustersCount) {
		PlotPanel plotPanel = new PlotPanel(result, maxX, ic, fml, fcl, frc, clustersCount);
		plotPanel.setPreferredSize(new Dimension(2400, 2000));
		JFrame frame = new JFrame();

		JScrollPane scrollPane = new JScrollPane(plotPanel);
		plotPanel.setScrollPane(scrollPane);

		scrollPane.setAutoscrolls(true);
		frame.add(scrollPane);

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1200, 1000));
		frame.setVisible(true);

		BufferedImage bufferedImage = new BufferedImage((int) plotPanel.getZoomed(maxX), (int) plotPanel.getZoomed(maxY),
            BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.getGraphics();
		plotPanel.paintComponent(g);
		try {
			String filePath = workspace.getWorkspacePath() + "/results/" + fileName;
			boolean res = ImageIO.write(bufferedImage, "png", new File(filePath));
			if (res) {
				log.info("Image saved to: " + filePath);
			} else {
				log.warn("Image was not saved to: " + filePath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (closePlot) {
			try {
				Thread.sleep(2000); // wait two seconds
				frame.dispose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
