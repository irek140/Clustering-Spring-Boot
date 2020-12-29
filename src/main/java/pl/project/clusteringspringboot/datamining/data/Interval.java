package pl.project.clusteringspringboot.datamining.data;

public interface Interval {

    IntervalClosure getIntervalClosure();

    double getStartPoint();

    double getEndPoint();
}
