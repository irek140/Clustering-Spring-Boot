package pl.project.clusteringspringboot.datamining.base;


import pl.project.clusteringspringboot.datamining.MiningAlgorithm;
import pl.project.clusteringspringboot.datamining.VerificationReport;

public interface AlgorithmSettings {

    VerificationReport verify();

    MiningAlgorithm getMiningAlgorithm();
}
