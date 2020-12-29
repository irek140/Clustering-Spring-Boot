package pl.project.clusteringspringboot.datamining.statistics;

import pl.project.clusteringspringboot.datamining.CDMException;

public interface DiscreteStatistics {

    Object getModalValue();

    Object[] getDiscreteValues();

    long getFrequency(Object var1) throws CDMException;

    long[] getFrequencies();
}
