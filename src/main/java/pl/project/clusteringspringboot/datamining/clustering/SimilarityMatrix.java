package pl.project.clusteringspringboot.datamining.clustering;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.data.CategoryMatrix;

public interface SimilarityMatrix extends CategoryMatrix {

    /** @deprecated */
    void setSimilarityValue(Object var1, Object var2, double var3) throws CDMException;

    double getCellValue(Object var1, Object var2) throws CDMException;

    void setCellValue(Object var1, Object var2, double var3) throws CDMException;
}
