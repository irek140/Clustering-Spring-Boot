package pl.project.clusteringspringboot.datamining.resource;


import pl.project.clusteringspringboot.datamining.*;
import pl.project.clusteringspringboot.datamining.Enum;
import pl.project.clusteringspringboot.datamining.base.Task;

import java.util.Collection;
import java.util.Date;
import java.util.Locale;

public interface Connection {

    void close() throws CDMException;

    Factory getFactory(String var1) throws CDMException;

    ConnectionMetaData getMetaData() throws CDMException;

    ConnectionSpec getConnectionSpec();

    void setLocale(Locale var1) throws CDMException;

    Locale getLocale();

    MiningFunction[] getSupportedFunctions() throws CDMException;

    MiningAlgorithm[] getSupportedAlgorithms(MiningFunction var1) throws CDMException;

    boolean supportsCapability(MiningFunction var1, MiningAlgorithm var2, MiningTask var3) throws CDMException;

    boolean supportsCapability(NamedObject var1, PersistenceOption var2) throws CDMException;

    NamedObject[] getNamedObjects(PersistenceOption var1) throws CDMException;

    int getMaxNameLength();

    int getMaxDescriptionLength();

    String getDescription(String var1, NamedObject var2) throws CDMException;

    void setDescription(String var1, NamedObject var2, String var3) throws CDMException;

    void saveObject(String var1, MiningObject var2, boolean var3) throws CDMException;

    void removeObject(String var1, NamedObject var2) throws CDMException;

    void renameObject(String var1, String var2, NamedObject var3) throws CDMException;

    boolean doesObjectExist(String var1, NamedObject var2) throws CDMException;

    MiningObject retrieveObject(String var1, NamedObject var2) throws CDMException;

    MiningObject retrieveObject(String var1) throws CDMException;

    Collection retrieveObjects(Date var1, Date var2, NamedObject var3) throws CDMException;

    Collection retrieveObjects(Date var1, Date var2, NamedObject var3, Enum var4) throws CDMException;

    Collection getObjectNames(NamedObject var1) throws CDMException;

    Collection getObjectNames(Date var1, Date var2, NamedObject var3) throws CDMException;

    Collection getObjectNames(Date var1, Date var2, NamedObject var3, Enum var4) throws CDMException;

    Collection getModelNames(MiningFunction var1, MiningAlgorithm var2, Date var3, Date var4) throws CDMException;

    Date getCreationDate(String var1, NamedObject var2) throws CDMException;

    Collection retrieveModelObjects(MiningFunction var1, MiningAlgorithm var2, Date var3, Date var4) throws CDMException;

    ExecutionHandle getLastExecutionHandle(String var1) throws CDMException;

    ExecutionHandle[] getExecutionHandles(String var1) throws CDMException;

    ExecutionHandle execute(String var1) throws CDMException;

    ExecutionStatus execute(Task var1, Long var2) throws CDMException;

    void requestModelLoad(String var1) throws CDMException;

    void requestModelUnload(String var1) throws CDMException;

    String[] getLoadedModels() throws CDMException;

    void requestDataLoad(String var1) throws CDMException;

    void requestDataUnload(String var1) throws CDMException;

    String[] getLoadedData() throws CDMException;
}
