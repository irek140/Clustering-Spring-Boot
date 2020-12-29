package pl.project.clusteringspringboot.algorithms.KMeans;

import pl.project.clusteringspringboot.clustering.CDMBaseAlgorithmSettings;
import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningAlgorithm;
import pl.project.clusteringspringboot.datamining.VerificationReport;
import pl.project.clusteringspringboot.datamining.base.AlgorithmSettings;

public class KMeansAlgorithmSettings extends CDMBaseAlgorithmSettings implements AlgorithmSettings {

	public static final String NAME = "k-Means";
	private int k;
	private int maxIterations;

	@Override
	public MiningAlgorithm getMiningAlgorithm() {
		try {
			return MiningAlgorithm.valueOf(NAME);
		} catch (CDMException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 */
	static {
		try {
			MiningAlgorithm.addExtension(NAME);
		} catch (CDMException e) {
			e.printStackTrace();
		}
	}
	@Override
	public VerificationReport verify() {
		return null;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getK() {
		return k;
	}

	public void setMaxIterations(int maxIterations) {
		this.maxIterations = maxIterations;
	}

	public int getMaxIterations() {
		return maxIterations;
	}
}

