package pl.project.clusteringspringboot.datamining.base;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.ExecutionHandle;
import pl.project.clusteringspringboot.datamining.MiningObject;
import pl.project.clusteringspringboot.datamining.VerificationReport;

public interface Task extends MiningObject {

    ExecutionHandle getExecutionHandle() throws CDMException;

    VerificationReport verify();
}
