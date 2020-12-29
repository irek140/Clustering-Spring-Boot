package pl.project.clusteringspringboot.algorithms.PiMeans;

import pl.project.clusteringspringboot.clustering.CDMBaseAlgorithmSettings;
import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningAlgorithm;
import pl.project.clusteringspringboot.datamining.VerificationReport;
import pl.project.clusteringspringboot.datamining.base.AlgorithmSettings;


public class PiKMeansAlgorithmSettings extends CDMBaseAlgorithmSettings implements AlgorithmSettings {

	public static final String NAME = "pikMeans";
	private int k;
	private int maxIterations;
	private int deepest;
	private int depth;


    static {
		try {
			MiningAlgorithm.addExtension(NAME);
		} catch (CDMException e) {
			e.printStackTrace();
		}
	}

	private int starting;

	@Override
	public MiningAlgorithm getMiningAlgorithm() {
		try {
			return MiningAlgorithm.valueOf(NAME);
		} catch (CDMException e) {
			e.printStackTrace();
		}
		return null;
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

	public void setDeepest(int deepest) {
		this.deepest = deepest;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public void setStarting(int starting) {
		this.starting = starting;
	}

	public int getStarting() {
		return starting;
	}

	public int getDeepest() {
		return deepest;
	}

	public int getDepth() {
		return depth;
	}
}

