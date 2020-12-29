package pl.project.clusteringspringboot.datamining.statistics;

import pl.project.clusteringspringboot.datamining.data.Interval;

public interface ContinuousStatistics {

    Interval[] getIntervals();

    long getFrequency(Interval var1);

    long[] getFrequencies();

    double getSum(Interval var1);

    double[] getSum();

    double getSumOfSquares(Interval var1);

    double[] getSumOfSquares();
}
