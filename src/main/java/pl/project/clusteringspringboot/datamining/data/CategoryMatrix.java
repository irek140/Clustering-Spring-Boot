package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;

import java.util.Collection;

public interface CategoryMatrix {

    Collection getCategories();

    /** @deprecated */
    Double getValue(Object var1, Object var2) throws CDMException;

    CategorySet getCategorySet();
}
