package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class AttributeDataType extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"integerType", "doubleType", "stringType", "unknownType"};
    private static final AttributeDataType[] values;
    public static final AttributeDataType integerType;
    public static final AttributeDataType doubleType;
    public static final AttributeDataType stringType;
    public static final AttributeDataType unknownType;

    private AttributeDataType(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static AttributeDataType[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            AttributeDataType[] values2 = new AttributeDataType[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static AttributeDataType valueOf(String name) throws CDMException {
        AttributeDataType _enum = (AttributeDataType)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        AttributeDataType _enum = new AttributeDataType(name);
        enumList.put(name, _enum);
    }

    static {
        values = new AttributeDataType[]{new AttributeDataType(names[0]), new AttributeDataType(names[1]), new AttributeDataType(names[2]), new AttributeDataType(names[3])};
        integerType = values[0];
        doubleType = values[1];
        stringType = values[2];
        unknownType = values[3];
    }

}
