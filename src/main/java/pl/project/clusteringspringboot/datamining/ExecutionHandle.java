package pl.project.clusteringspringboot.datamining;

import java.util.Collection;
import java.util.Date;

public interface ExecutionHandle {

    ExecutionStatus terminate() throws CDMException;

    ExecutionStatus getLatestStatus() throws CDMException;

    Collection getStatus(Date var1) throws CDMException;

    Date getStartTime() throws CDMException;

    ExecutionStatus waitForCompletion(int var1) throws CDMException;

    Integer getDurationInSeconds() throws CDMException;

    String getTaskName();

    ExecutionStatus[] getWarnings() throws CDMException;

    boolean containsWarning() throws CDMException;
}
