package pl.project.clusteringspringboot.datamining.statistics;

public interface NumericalStatistics {

    double getVariance();

    double[] getQuantileLimits();

    double getQuantile(double var1);

    double getMinimumValue();

    double getMaximumValue();

    double getMeanValue();

    double getStandardDeviation();

    double getMedianValue();

    double getInterQuartileRange();
}
