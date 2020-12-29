package pl.project.clusteringspringboot.datamining.statistics;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.data.CategoryProperty;

public interface UnivariateStatistics {

    String getName();

    Object[] getValues();

    long getFrequency(int var1) throws CDMException;

    long[] getFrequencies();

    double[] getProbabilities();

    long getFrequency(CategoryProperty var1);

    DiscreteStatistics getDiscreteStatistics();

    NumericalStatistics getNumericalStatistics();

    ContinuousStatistics getContinuousStatistics();
}
