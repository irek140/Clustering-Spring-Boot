package pl.project.clusteringspringboot.datamining.task;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.base.Task;

import java.util.Map;

public interface BuildTask extends Task {

    String getModelName();

    void setModelName(String var1) throws CDMException;

    String getBuildDataName();

    void setBuildDataName(String var1) throws CDMException;

    String getBuildSettingsName();

    void setBuildSettingsName(String var1) throws CDMException;

    String getInputModelName();

    void setInputModelName(String var1) throws CDMException;

    String getValidationDataName();

    void setValidationDataName(String var1) throws CDMException;

    String getApplicationName();

    void setApplicationName(String var1);

    String getModelDescription();

    void setModelDescription(String var1);

    Map getBuildDataMap();

    void setBuildDataMap(Map var1) throws CDMException;

    Map getValidationDataMap();

    void setValidationDataMap(Map var1) throws CDMException;
}
