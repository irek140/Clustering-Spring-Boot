package pl.project.clusteringspringboot.datamining.resource;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Factory;

public interface ConnectionFactory extends Factory {

    Connection getConnection() throws CDMException;

    Connection getConnection(ConnectionSpec var1) throws CDMException;

    Connection getConnection(Connection var1) throws CDMException;

    ConnectionSpec getConnectionSpec();

    boolean supportsCapability(ConnectionCapability var1) throws CDMException;
}
