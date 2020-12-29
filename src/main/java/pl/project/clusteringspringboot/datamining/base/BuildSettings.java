package pl.project.clusteringspringboot.datamining.base;

import pl.project.clusteringspringboot.datamining.*;
import pl.project.clusteringspringboot.datamining.data.Interval;
import pl.project.clusteringspringboot.datamining.data.LogicalData;

import java.util.Collection;

public interface BuildSettings extends MiningObject {

    MiningFunction getMiningFunction();

    int getDesiredExecutionTimeInMinutes();

    void setDesiredExecutionTimeInMinutes(int var1);

    AlgorithmSettings getAlgorithmSettings();

    void setAlgorithmSettings(AlgorithmSettings var1);

    LogicalData getLogicalData();

    String getLogicalDataName();

    void setLogicalDataName(String var1) throws CDMException;

    Collection getLogicalAttributes(LogicalAttributeUsage var1) throws CDMException;

    double getWeight(String var1) throws CDMException;

    void setWeight(String var1, double var2) throws CDMException;

    String getWeightAttribute();

    void setWeightAttribute(String var1) throws CDMException;

    LogicalAttributeUsage getUsage(String var1) throws CDMException;

    void setUsage(String var1, LogicalAttributeUsage var2) throws CDMException;

    OutlierTreatment getOutlierTreatment(String var1) throws CDMException;

    void setOutlierTreatment(String var1, OutlierTreatment var2) throws CDMException;

    Interval getOutlierIdentification(String var1) throws CDMException;

    void setOutlierIdentification(String var1, Interval var2) throws CDMException;

    String[] getAttributeNames(AttributeRetrievalType var1);

    VerificationReport verify();
}
