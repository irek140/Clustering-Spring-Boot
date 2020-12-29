package pl.project.clusteringspringboot.datamining.base;

import pl.project.clusteringspringboot.datamining.MiningAlgorithm;
import pl.project.clusteringspringboot.datamining.MiningFunction;
import pl.project.clusteringspringboot.datamining.MiningObject;
import pl.project.clusteringspringboot.datamining.data.ModelSignature;
import pl.project.clusteringspringboot.datamining.statistics.AttributeStatisticsSet;

public interface Model extends MiningObject {

    String getUniqueIdentifier();

    String getVersion();

    String getMajorVersion();

    String getMinorVersion();

    String getProviderName();

    String getProviderVersion();

    String getApplicationName();

    MiningFunction getMiningFunction();

    MiningAlgorithm getMiningAlgorithm();

    ModelSignature getSignature();

    BuildSettings getBuildSettings();

    BuildSettings getEffectiveBuildSettings();

    ModelDetail getModelDetail();

    AttributeStatisticsSet getAttributeStatistics();

    String getTaskIdentifier();

    Integer getBuildDuration();
}
