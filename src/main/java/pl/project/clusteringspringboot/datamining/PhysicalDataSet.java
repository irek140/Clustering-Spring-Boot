package pl.project.clusteringspringboot.datamining;

import pl.project.clusteringspringboot.datamining.data.AttributeDataType;
import pl.project.clusteringspringboot.datamining.data.PhysicalAttribute;
import pl.project.clusteringspringboot.datamining.data.PhysicalAttributeRole;
import pl.project.clusteringspringboot.datamining.statistics.AttributeStatisticsSet;

import java.util.Collection;

public interface PhysicalDataSet extends MiningObject {

    Collection getAttributes() throws CDMException;

    Collection getAttributeNames(AttributeDataType var1) throws CDMException;

    Collection getAttributeNames(PhysicalAttributeRole var1) throws CDMException;

    int getAttributeCount();

    PhysicalAttribute getAttribute(String var1) throws CDMException;

    Integer getAttributeIndex(String var1) throws CDMException;

    PhysicalAttribute getAttribute(int var1);

    void addAttribute(PhysicalAttribute var1) throws CDMException;

    void addAttributes(PhysicalAttribute[] var1) throws CDMException;

    void removeAttribute(String var1) throws CDMException;

    void removeAllAttributes();

    void importMetaData() throws CDMException;

    AttributeStatisticsSet getAttributeStatistics() throws CDMException;

    String getURI();
}
