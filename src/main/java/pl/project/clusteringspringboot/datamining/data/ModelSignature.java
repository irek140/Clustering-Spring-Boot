package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.SortOrder;

import java.util.Collection;

public interface ModelSignature {

    Collection getAttributes() throws CDMException;

    SignatureAttribute getAttribute(String var1) throws CDMException;

    Collection getAttributesByRank(SortOrder var1) throws CDMException;
}
