package pl.project.clusteringspringboot.algorithms.NBC;

import pl.project.clusteringspringboot.clustering.CDMBaseAlgorithmSettings;
import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningAlgorithm;
import pl.project.clusteringspringboot.datamining.VerificationReport;
import pl.project.clusteringspringboot.datamining.base.AlgorithmSettings;

/**
 * 
 * @author Piotr Lasek
 *
 */
public class NBCAlgorithmSettings extends CDMBaseAlgorithmSettings implements AlgorithmSettings {

	private int k;
	public static final String NAME = "NBC";

	static {
		try {
			MiningAlgorithm.addExtension(NAME);
		} catch (CDMException e) {
			e.printStackTrace();
		}
	}

   	public void setK(int k) {
		this.k = k;
	}

	public int getK() {
		return k;
	}

	@Override
	public String toString() {
		return NAME + ", k = " + k;
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

}

