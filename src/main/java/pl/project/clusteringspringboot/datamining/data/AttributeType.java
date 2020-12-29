package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class AttributeType extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"categorical", "ordinal", "numerical", "notSpecified"};
    private static final AttributeType[] values;
    public static final AttributeType categorical;
    public static final AttributeType ordinal;
    public static final AttributeType numerical;
    public static final AttributeType notSpecified;

    private AttributeType(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static AttributeType[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            AttributeType[] values2 = new AttributeType[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static AttributeType valueOf(String name) throws CDMException {
        AttributeType _enum = (AttributeType)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        AttributeType _enum = new AttributeType(name);
        enumList.put(name, _enum);
    }

    static {
        values = new AttributeType[]{new AttributeType(names[0]), new AttributeType(names[1]), new AttributeType(names[2]), new AttributeType(names[3])};
        categorical = values[0];
        ordinal = values[1];
        numerical = values[2];
        notSpecified = values[3];
    }
}
