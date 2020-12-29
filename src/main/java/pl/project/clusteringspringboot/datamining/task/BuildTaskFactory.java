package pl.project.clusteringspringboot.datamining.task;


import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Factory;
import pl.project.clusteringspringboot.datamining.MiningAlgorithm;
import pl.project.clusteringspringboot.datamining.MiningFunction;

public interface BuildTaskFactory extends Factory {

    BuildTask create(String var1, String var2, String var3) throws CDMException;

    boolean supportsCapability(MiningFunction var1, MiningAlgorithm var2, BuildTaskCapability var3) throws CDMException;

}
