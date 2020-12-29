package pl.project.clusteringspringboot.datamining.clustering;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.base.BuildSettings;

public interface ClusteringSettings extends BuildSettings {

    int getMaxNumberOfClusters();

    void setMaxNumberOfClusters(int var1);

    long getMinClusterCaseCount();

    void setMinClusterCaseCount(long var1);

    long getMaxClusterCaseCount();

    void setMaxClusterCaseCount(long var1);

    AggregationFunction getAggregationFunction();

    void setAggregationFunction(AggregationFunction var1);

    AttributeComparisonFunction getAttributeComparisonFunction(String var1) throws CDMException;

    void setAttributeComparisonFunction(String var1, AttributeComparisonFunction var2) throws CDMException;

    int getMaxLevels();

    void setMaxLevels(int var1);

    SimilarityMatrix getSimilarityMatrix(String var1) throws CDMException;

    void setSimilarityMatrix(String var1, SimilarityMatrix var2) throws CDMException;
}
