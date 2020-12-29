package pl.project.clusteringspringboot.datamining;

import java.util.Date;

public interface ExecutionStatus {

    ExecutionState getState();

    Date getTimestamp();

    String getDescription();

    boolean containsWarning();
}
