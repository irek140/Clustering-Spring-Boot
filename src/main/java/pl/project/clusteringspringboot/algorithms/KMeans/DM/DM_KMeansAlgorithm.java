package pl.project.clusteringspringboot.algorithms.KMeans.DM;

import pl.project.clusteringspringboot.clustering.CDMCluster;
import pl.project.clusteringspringboot.clustering.CDMClusteringModel;
import pl.project.clusteringspringboot.clustering.CDMClusteringSettings;
import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningObject;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringSettings;
import pl.project.clusteringspringboot.datamining.data.PhysicalAttribute;
import pl.project.clusteringspringboot.datamining.PhysicalDataSet;
import pl.project.clusteringspringboot.datamining.base.ScatterAdd;
import pl.project.clusteringspringboot.clustering.CDMBasicClusteringAlgorithm;

import java.util.ArrayList;
import java.util.Collection;

public class DM_KMeansAlgorithm extends CDMBasicClusteringAlgorithm {
	
	int k = 0;
	ArrayList<double[]> data;
	int numberOfDimensions; 
	double[] min = null;
	double[] max = null;
	Collection<PhysicalAttribute> attributes;
	ArrayList<double[]> tempPoints;
	int maxRuns = 4;
	int[] clusterCount;
	
	public DM_KMeansAlgorithm(CDMClusteringSettings clusteringSettings,
							  PhysicalDataSet physicalDataSet)
	{
		super(clusteringSettings, physicalDataSet);
		
		//k = ((PiMeansAlgorithmSettings) clusteringSettings.getAlgorithmSettings()).getK();
		k = (int) clusteringSettings.getMinClusterCaseCount();
		clusterCount = new int[k];
		// get attributes
		
		try {
			attributes = physicalDataSet.getAttributes();
		} catch (CDMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		numberOfDimensions = attributes.size();
		
		min = new double[numberOfDimensions];
		max = new double[numberOfDimensions];
	}

	@Override
	public MiningObject run() {
		CDMClusteringModel ccm = new CDMClusteringModel();
		
		prepareData();
		
		initializeTemporaryPoints();
		
		for(int i = 0; i < maxRuns; i++)
		{
			
			for(double[] point : data)
			{
				int indexOfClosestTempPoint = 0;
				indexOfClosestTempPoint = getIndexOfClosestCluster(point);
				point[numberOfDimensions] = indexOfClosestTempPoint; 
			}
			
			ScatterAdd sa = new ScatterAdd("K-Means - step " + (i + 1), data, tempPoints);
			sa.setSize(400, 500);
			sa.setVisible(true);
			sa.toFront();
			
			updateTemporaryPoints();
		}
		
		CDMCluster cluster = new CDMCluster();
		
		
		return ccm;
	}

	@Override
	public String getDescription() {
		return null;
	}

	/**
	 * 
	 * @param point
	 * @return
	 */
	private int getIndexOfClosestCluster(double[] point) {
		
		double[] dists = new double[k];
		
		int indexOfClosestTempPoint = 0;
		
		for(int i = 0; i < k; i++)
		{
			double[] ti = tempPoints.get(i);
			dists[i] = dist(point, ti);
		}
		
		for(int i = 1; i < k; i++)
		{
			if (dists[i - 1] > dists[i])
			{
				indexOfClosestTempPoint = i;
			}
		}
		
		return indexOfClosestTempPoint;
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double dist(double[] a, double[] b)
	{
		double dist = 0;
		double temp = 0;
		
		
		for(int i = 0; i < Math.min(a.length, b.length); i++)
		{
			temp += Math.pow(a[i] - b[i], 2);
		}
		
		return Math.sqrt(temp);
	}
	
	private void clearClusterCount()
	{
		for(int i  = 0; i < k; i++)
		{
			clusterCount[i] = 0;
		}
	}
	
	/**
	 * 
	 */
	private void updateTemporaryPoints()
	{
		updateClusterCount();
		
		zeroTemporaryPoints();
		
		for(double[] point : data)
		{
			int clusterId = (int) point[numberOfDimensions];

			for(int d  = 0; d < numberOfDimensions; d++)
			{
				tempPoints.get(clusterId)[d] += point[d];
			}
		}
		
		for(int i = 0; i < k; i++)
		{
			double[] point = tempPoints.get(i);
			
			if (clusterCount[i] > 0)
			{
				for(int j = 0; j < numberOfDimensions; j++)
				{
					point[j] = point[j] / clusterCount[i];
				}
			}
		}
		
	}	

	/**
	 * 
	 */
	private void initializeTemporaryPoints() {
		tempPoints = new ArrayList<double[]>();
		
		for(int i = 0; i < k; i++)
		{
			double[] tempPoint = new double[numberOfDimensions];
			
			for (int j = 0; j < numberOfDimensions; j++)
			{
				tempPoint[j] = randomFromRange(j);
			}
			
			tempPoints.add(tempPoint);
		}
	}
	
	private void updateClusterCount()
	{
		clearClusterCount();
		
		for(double[] point : data)
		{
			int clusterId = (int) point[numberOfDimensions];
			clusterCount[clusterId] = clusterCount[clusterId] + 1;
		}
	}
	
	/**
	 * 
	 */
	private void zeroTemporaryPoints() {
		
		for(int i = 0; i < k; i++)
		{
			if (clusterCount[i] != 0)
			{
				double[] tempPoint = tempPoints.get(i);
				
				for (int j = 0; j < numberOfDimensions; j++)
				{
					tempPoint[j] = 0;
				}
			}
		}
	}

	/**
	 * 
	 * @param j
	 * @return
	 */
	private double randomFromRange(int j) {
		return min[j] + (Math.random() * (max[j] - min[j]));
	}
	
}


