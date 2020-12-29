package pl.project.clusteringspringboot.datamining.clustering;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Factory;
import pl.project.clusteringspringboot.datamining.MiningAlgorithm;

public interface ClusteringSettingsFactory extends Factory {

    ClusteringSettings create() throws CDMException;

    boolean supportsCapability(ClusteringCapability var1) throws CDMException;

    /** @deprecated */
    boolean supportsCapability(AggregationFunction var1) throws CDMException;

    /** @deprecated */
    boolean supportsCapability(AttributeComparisonFunction var1) throws CDMException;

    boolean supportsCapability(MiningAlgorithm var1, ClusteringCapability var2) throws CDMException;

    boolean supportsCapability(AggregationFunction var1, AttributeComparisonFunction var2);
}
