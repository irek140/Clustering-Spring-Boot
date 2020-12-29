package pl.iidml;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.clustering.Cluster;
import pl.project.clusteringspringboot.datamining.rule.Predicate;
import pl.project.clusteringspringboot.datamining.rule.Rule;
import pl.project.clusteringspringboot.datamining.statistics.AttributeStatisticsSet;

public class MyCluster implements Cluster {

	@Override
	public Cluster[] getAncestors() throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCaseCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 *  Returns the centroid point of the specified categorical attribute
	 *  for a specific category value for the cluster.
	 */
	@Override
	public Double getCentroidCoordinate(String arg0) throws CDMException {
		return Math.random();
	}

	@Override
	public Double getCentroidCoordinate(String arg0, Object arg1)
			throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cluster[] getChildren() throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getClusterId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cluster getParent() throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rule getRule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Predicate getSplitPredicate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttributeStatisticsSet getStatistics() throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSupport() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRoot() {
		// TODO Auto-generated method stub
		return false;
	}

}
