package pl.project.clusteringspringboot.datamining.statistics;

import pl.project.clusteringspringboot.datamining.CDMException;

import pl.project.clusteringspringboot.datamining.statistics.AttributeStatisticsSetCapability;
import pl.project.clusteringspringboot.datamining.statistics.UnivariateStatistics;
import java.util.Collection;
import java.util.Date;

public interface AttributeStatisticsSet {

    UnivariateStatistics getStatistics(String var1) throws CDMException;

    Collection getStatistics() throws CDMException;

    long getNumberOfCases();

    boolean supportsCapabiltiy(AttributeStatisticsSetCapability var1) throws CDMException;

    Date getStatisticsTimestamp();
}
