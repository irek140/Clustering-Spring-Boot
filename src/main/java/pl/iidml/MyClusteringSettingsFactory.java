package pl.iidml;


import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningAlgorithm;
import pl.project.clusteringspringboot.datamining.clustering.AggregationFunction;
import pl.project.clusteringspringboot.datamining.clustering.AttributeComparisonFunction;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringCapability;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringSettings;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringSettingsFactory;


public class MyClusteringSettingsFactory implements ClusteringSettingsFactory {

	@Override
	public ClusteringSettings create() throws CDMException {
		// TODO Auto-generated method stub
		//return null;
		return new MyClusteringSettings();
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
	public boolean supportsCapability(MiningAlgorithm arg0,
			ClusteringCapability arg1) throws CDMException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCapability(AggregationFunction arg0,
			AttributeComparisonFunction arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
