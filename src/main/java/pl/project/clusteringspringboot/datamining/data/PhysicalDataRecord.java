package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;

import java.util.Collection;

public interface PhysicalDataRecord {

    Object getValue(String var1) throws CDMException;

    void setValue(String var1, Object var2) throws CDMException;

    Collection getAttributeNames();

    int getAttributeCount();

    void removeAttribute(String var1) throws CDMException;

    void resetValues();

    void removeAllAttributes();
}
