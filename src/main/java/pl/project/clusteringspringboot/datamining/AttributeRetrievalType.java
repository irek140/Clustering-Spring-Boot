package pl.project.clusteringspringboot.datamining;

import java.util.Collection;
import java.util.Hashtable;

public class AttributeRetrievalType extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"usage", "weight", "outlierTreatment", "outlierIdentification"};
    private static final AttributeRetrievalType[] values;
    public static final AttributeRetrievalType usage;
    public static final AttributeRetrievalType weight;
    public static final AttributeRetrievalType outlierTreatment;
    public static final AttributeRetrievalType outlierIdentification;

    private AttributeRetrievalType(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static AttributeRetrievalType[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            AttributeRetrievalType[] values2 = new AttributeRetrievalType[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static AttributeRetrievalType valueOf(String name) throws CDMException {
        AttributeRetrievalType _enum = (AttributeRetrievalType)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        AttributeRetrievalType _enum = new AttributeRetrievalType(name);
        enumList.put(name, _enum);
    }

    static {
        values = new AttributeRetrievalType[]{new AttributeRetrievalType(names[0]), new AttributeRetrievalType(names[1]), new AttributeRetrievalType(names[2]), new AttributeRetrievalType(names[3])};
        usage = values[0];
        weight = values[1];
        outlierTreatment = values[2];
        outlierIdentification = values[3];
    }
}
