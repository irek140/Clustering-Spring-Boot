package pl.project.clusteringspringboot.datamining.resource;

import pl.project.clusteringspringboot.datamining.ExecutionState;
import pl.project.clusteringspringboot.datamining.ExecutionStatus;
import java.util.Date;

/**
 * Created by Piotr Lasek on 05.06.2017.
 */
public class CDMExecutionStatus implements ExecutionStatus {

    private String description;

    @Override
    public ExecutionState getState() {
        return null;
    }

    @Override
    public Date getTimestamp() {
        return new Date();
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean containsWarning() {
        return false;
    }
}
