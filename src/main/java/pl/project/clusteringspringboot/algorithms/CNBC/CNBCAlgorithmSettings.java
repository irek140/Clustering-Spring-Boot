package pl.project.clusteringspringboot.algorithms.CNBC;


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
public class CNBCAlgorithmSettings extends CDMBaseAlgorithmSettings implements AlgorithmSettings {

	public static final String NAME = "C-NBC";
	private int k;
	private String ic = null; // instance constraints

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

	public String getIC() {
		return ic;
	}

	public void setIC(String ic) {
		this.ic = ic;
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

