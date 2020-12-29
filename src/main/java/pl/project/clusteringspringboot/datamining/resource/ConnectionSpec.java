package pl.project.clusteringspringboot.datamining.resource;

import java.util.Locale;

public interface ConnectionSpec {

    String getName();

    void setName(String var1);

    String getURI();

    void setURI(String var1);

    void setPassword(String var1);

    void setLocale(Locale var1);

    Locale getLocale();
}
