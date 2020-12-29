package pl.project.clusteringspringboot.algorithms.DBSCAN;

import pl.project.clusteringspringboot.clustering.CDMBaseAlgorithmSettings;
import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningAlgorithm;
import pl.project.clusteringspringboot.datamining.VerificationReport;
import pl.project.clusteringspringboot.datamining.base.AlgorithmSettings;


public class DBSCANAlgorithmSettings extends CDMBaseAlgorithmSettings implements AlgorithmSettings {

	public static final String NAME = "DBSCAN";
	private int minPts;
	private double eps;

	static {
		try {
			MiningAlgorithm.addExtension(NAME);
		} catch (CDMException e) {
			e.printStackTrace();
		}
	}

	public int getMinPts() {
		return minPts;
	}

	public double getEps() {
		return eps;
	}

	@Override
	public VerificationReport verify() {
		return null;
	}

	@Override
	public MiningAlgorithm getMiningAlgorithm() {
		try {
			return MiningAlgorithm.valueOf(NAME);
		} catch (CDMException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setMinPts(int minPts) {
		this.minPts = minPts;
	}

	public void setEps(double eps) {
		this.eps = eps;
	}
}
