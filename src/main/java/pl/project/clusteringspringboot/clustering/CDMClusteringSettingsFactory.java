package pl.project.clusteringspringboot.clustering;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningAlgorithm;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringSettingsFactory;
import pl.project.clusteringspringboot.datamining.clustering.AggregationFunction;
import pl.project.clusteringspringboot.datamining.clustering.AttributeComparisonFunction;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringSettings;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringCapability;

public class CDMClusteringSettingsFactory implements ClusteringSettingsFactory {

	@Override
	public ClusteringSettings create() throws CDMException {
		// TODO Auto-generated method stub
		//return null;
		return new CDMClusteringSettings();
	}

	@Override
	public boolean supportsCapability(ClusteringCapability arg0)
			throws CDMException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCapability(AggregationFunction arg0)
			throws CDMException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCapability(AttributeComparisonFunction arg0)
			throws CDMException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCapability(MiningAlgorithm var1, ClusteringCapability var2) throws CDMException {
		return false;
	}

	@Override
	public boolean supportsCapability(AggregationFunction arg0,
                                      AttributeComparisonFunction arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
