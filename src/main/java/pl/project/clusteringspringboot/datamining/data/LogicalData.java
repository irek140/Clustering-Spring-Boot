package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningObject;

import java.util.Collection;

public interface LogicalData extends MiningObject {

    Collection getAttributes();

    LogicalAttribute getAttribute(String var1) throws CDMException;

    Collection getAttributes(AttributeType var1) throws CDMException;

    void addAttribute(LogicalAttribute var1) throws CDMException;

    void removeAttribute(String var1) throws CDMException;

    void removeAllAttributes();
}
