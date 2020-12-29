package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;

public interface PhysicalAttributeFactory {

    PhysicalAttribute create(String var1, AttributeDataType var2) throws CDMException;

    PhysicalAttribute[] create(String[] var1, AttributeDataType var2) throws CDMException;

    PhysicalAttribute create(String var1, AttributeDataType var2, PhysicalAttributeRole var3) throws CDMException;

    boolean supportsCapability(PhysicalAttributeCapability var1) throws CDMException;
}
