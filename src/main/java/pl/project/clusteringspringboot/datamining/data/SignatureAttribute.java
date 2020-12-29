package pl.project.clusteringspringboot.datamining.data;

public interface SignatureAttribute extends Attribute {

    AttributeType getAttributeType();

    AttributeDataType getDataType();

    int getRank();

    double getImportanceValue();
}
