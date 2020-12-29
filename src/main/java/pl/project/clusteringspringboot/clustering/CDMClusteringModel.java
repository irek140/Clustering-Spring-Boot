package pl.project.clusteringspringboot.clustering;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.base.CDMAbstractModel;
import pl.project.clusteringspringboot.datamining.clustering.Cluster;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringModel;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringModelProperty;
import pl.project.clusteringspringboot.datamining.rule.Rule;

import java.util.ArrayList;
import java.util.Collection;


public class CDMClusteringModel extends CDMAbstractModel implements ClusteringModel {

	ArrayList<Cluster> clusters = new ArrayList<Cluster>();
	ArrayList<Rule> rules = new ArrayList<Rule>();
	
	@Override
	public Cluster getCluster(int clusterIndex) throws CDMException {
		return clusters.get(clusterIndex);
	}
	@Override
	public Collection getClusters() throws CDMException {
		return clusters;
	}
	@Override
	public Collection getLeafClusters() throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getNumberOfClusters() {
		// TODO Auto-generated method stub
		return clusters.size();
	}
	@Override
	public int getNumberOfLevels() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Collection getRootClusters() throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Collection getRules() throws CDMException {
		return rules;
	}
	@Override
	public Double getSimilarity(int arg0, int arg1) throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean hasProperty(ClusteringModelProperty arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
