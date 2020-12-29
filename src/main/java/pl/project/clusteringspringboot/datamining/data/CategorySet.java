package pl.project.clusteringspringboot.datamining.data;


import pl.project.clusteringspringboot.datamining.CDMException;

public interface CategorySet {

    int addCategory(Object var1, CategoryProperty var2) throws CDMException;

    void insertCategory(Object var1, CategoryProperty var2, int var3) throws CDMException;

    void removeCategory(int var1) throws CDMException;

    int getSize();

    AttributeDataType getDataType();

    Integer getIndex(Object var1) throws CDMException;

    Object getValue(int var1);

    Object[] getValues();

    Object[] getValues(CategoryProperty var1) throws CDMException;

    String getName(int var1);

    void setName(int var1, String var2);

    CategoryProperty getProperty(int var1);

    CategoryProperty getDefaultProperty();

    void setDefaultProperty(CategoryProperty var1);
}
