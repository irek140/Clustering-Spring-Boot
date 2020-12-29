package pl.project.clusteringspringboot.datamining;

import java.util.Date;

public interface MiningObject {

    NamedObject getObjectType();

    String getDescription();

    void setDescription(String var1) throws CDMException;

    String getName();

    String getCreatorInfo();

    Date getCreationDate();

    String getObjectIdentifier();
}
