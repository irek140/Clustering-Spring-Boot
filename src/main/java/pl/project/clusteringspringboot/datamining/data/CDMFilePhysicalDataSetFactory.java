package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.PhysicalDataSet;

/**
 * @author Piotr Lasek
 *
 */
public class CDMFilePhysicalDataSetFactory implements PhysicalDataSetFactory {

	String fileName;
	
	/* (non-Javadoc)
	 * @see javax.datamining.data.PhysicalDataSetFactory#create(java.lang.String, boolean)
	 */
	@Override
	public PhysicalDataSet create(String uri, boolean arg1)
			throws CDMException {
		CDMFilePhysicalDataSet fpds = new CDMFilePhysicalDataSet();
		fpds.setDescription(uri);
		return fpds;
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
