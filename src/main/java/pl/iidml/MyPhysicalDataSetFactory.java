package pl.iidml;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.PhysicalDataSet;
import pl.project.clusteringspringboot.datamining.data.PhysicalDataSetCapability;
import pl.project.clusteringspringboot.datamining.data.PhysicalDataSetFactory;

/**
 * 
 */

/**
 * @author Piotrek
 *
 */
public class MyPhysicalDataSetFactory implements PhysicalDataSetFactory {

	/* (non-Javadoc)
	 * @see javax.datamining.data.PhysicalDataSetFactory#create(java.lang.String, boolean)
	 */
	@Override
	public PhysicalDataSet create(String arg0, boolean arg1)
			throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.datamining.data.PhysicalDataSetFactory#supportsCapability(javax.datamining.data.PhysicalDataSetCapability)
	 */
	@Override
	public boolean supportsCapability(PhysicalDataSetCapability arg0)
			throws CDMException {
		// TODO Auto-generated method stub
		return false;
	}


}
