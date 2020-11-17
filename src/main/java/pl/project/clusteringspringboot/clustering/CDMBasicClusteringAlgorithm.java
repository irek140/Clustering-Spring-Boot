package pl.project.clusteringspringboot.clustering;

import pl.project.clusteringspringboot.clustering.old.ClusteringTimer;
import pl.project.clusteringspringboot.datamining.data.CDMAlgorithm;

import javax.datamining.MiningObject;
import javax.datamining.clustering.ClusteringSettings;
import javax.datamining.data.PhysicalAttribute;
import javax.datamining.data.PhysicalDataSet;
import java.util.ArrayList;
import java.util.Collection;

public class CDMBasicClusteringAlgorithm implements CDMAlgorithm {

    protected MiningObject result;
    protected ArrayList<double[]> data;
    protected double[] min = null;
    protected double[] max = null;
    protected Collection<PhysicalAttribute> attributes;
    protected ClusteringSettings clusteringSettings;
    protected PhysicalDataSet physicalDataSet;
    protected int numberOfDimensions;
    protected ClusteringTimer timer = new ClusteringTimer();
    protected ClusteringAlgorithm algorithm;
    protected CDMBasicMiningObject basicMiningObject = new CDMBasicMiningObject();


}
