package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.PhysicalDataSet;

public interface PhysicalDataSetFactory {

    PhysicalDataSet create(String var1, boolean var2) throws CDMException;

    boolean supportsCapability(PhysicalDataSetCapability var1) throws CDMException;
}
