package pl.project.clusteringspringboot.datamining.data;

public interface LogicalAttribute extends Attribute {

    void setName(String var1);

    void setDescription(String var1);

    AttributeType getAttributeType();

    void setAttributeType(AttributeType var1);

    DataPreparationStatus getDataPreparationStatus();

    void setDataPreparationStatus(DataPreparationStatus var1);

    void isDiscrete(boolean var1);

    boolean isDiscrete();

    void setCategorySet(CategorySet var1);

    CategorySet getCategorySet();
}
