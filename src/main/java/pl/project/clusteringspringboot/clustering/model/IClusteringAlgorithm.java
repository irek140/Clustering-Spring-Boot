package pl.project.clusteringspringboot.clustering.model;

import java.awt.*;

/**
 * 
 * @author Piotr Lasek
 *
 */
public interface IClusteringAlgorithm {

	/**
	 * 
	 * @param data
	 */
	public void setData(IClusteringData data);
	
	/**
	 * 
	 * @return
	 */
	public IClusteringData getResult();
	
	/**
	 * 
	 * @param parameters
	 */
	public void setParameters(IClusteringParameters parameters);
	
	/**
	 * 
	 * @return
	 */
	public IClusteringParameters getParameters();
	
	/**
	 * 
	 */
	public void run();
	
	/**
	 * 
	 */
	public void setObserver(IClusteringObserver observer);
	
	/**
	 * 
	 * @param g
	 */
	public void setGraphics(Graphics g);
	
	/**
	 * 
	 */
	public String getName();
	
	/**
	 * 
	 */
	public void addDescription(String description);
	
        /**
         * 
         */
        public String getDescription();	
}
