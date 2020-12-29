package pl.project.clusteringspringboot.algorithms.KMeans.DM;


import pl.project.clusteringspringboot.datamining.MiningAlgorithm;
import pl.project.clusteringspringboot.datamining.VerificationReport;
import pl.project.clusteringspringboot.datamining.base.AlgorithmSettings;

public class DM_KMeansAlgorithmSettings implements AlgorithmSettings {

	@Override
	public MiningAlgorithm getMiningAlgorithm() {
		// TODO Auto-generated method stub
		return MiningAlgorithm.kMeans;
	}

	@Override
	public VerificationReport verify() {
		// TODO Auto-generated method stub
		return null;
	}
}

