package pl.project.clusteringspringboot.datamining.data;

public interface PhysicalAttribute extends Attribute {

    void setName(String var1);

    void setDescription(String var1);

    AttributeDataType getDataType();

    void setDataType(AttributeDataType var1);

    PhysicalAttributeRole getRole();

    void setRole(PhysicalAttributeRole var1);
}
