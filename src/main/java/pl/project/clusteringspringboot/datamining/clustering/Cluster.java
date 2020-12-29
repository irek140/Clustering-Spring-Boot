package pl.project.clusteringspringboot.datamining.clustering;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.rule.Rule;
import pl.project.clusteringspringboot.datamining.rule.Predicate;
import pl.project.clusteringspringboot.datamining.statistics.AttributeStatisticsSet;

public interface Cluster {

    int getClusterId();

    String getName();

    Cluster getParent() throws CDMException;

    Cluster[] getAncestors() throws CDMException;

    int getLevel();

    long getCaseCount();

    double getSupport();

    Double getCentroidCoordinate(String var1) throws CDMException;

    Double getCentroidCoordinate(String var1, Object var2) throws CDMException;

    Predicate getSplitPredicate();

    Cluster[] getChildren() throws CDMException;

    AttributeStatisticsSet getStatistics() throws CDMException;

    boolean isLeaf();

    boolean isRoot();

    Rule getRule();
}
