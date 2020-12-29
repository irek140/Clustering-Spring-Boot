package pl.project.clusteringspringboot.datamining.resource;

public interface ConnectionMetaData {

    String getVersion();

    int getMajorVersion();

    int getMinorVersion();

    String getProviderName();

    String getProviderVersion();
}
