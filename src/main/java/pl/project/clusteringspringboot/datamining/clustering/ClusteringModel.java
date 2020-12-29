package pl.project.clusteringspringboot.datamining.clustering;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.base.Model;

import java.util.Collection;

public interface ClusteringModel extends Model {

    Cluster getCluster(int var1) throws CDMException;

    int getNumberOfClusters();

    int getNumberOfLevels();

    Collection getRootClusters() throws CDMException;

    Collection getClusters() throws CDMException;

    Collection getLeafClusters() throws CDMException;

    Collection getRules() throws CDMException;

    Double getSimilarity(int var1, int var2) throws CDMException;

    boolean hasProperty(ClusteringModelProperty var1);
}
