package pl.project.clusteringspringboot.datamining.clustering;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class AttributeComparisonFunction extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"systemDefault", "systemDetermined", "absDiff", "gaussSim", "delta", "equal", "similarityMatrix"};
    private static final AttributeComparisonFunction[] values;
    public static final AttributeComparisonFunction systemDefault;
    public static final AttributeComparisonFunction systemDetermined;
    public static final AttributeComparisonFunction absDiff;
    public static final AttributeComparisonFunction gaussSim;
    public static final AttributeComparisonFunction delta;
    public static final AttributeComparisonFunction equal;
    public static final AttributeComparisonFunction similarityMatrix;

    private AttributeComparisonFunction(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static AttributeComparisonFunction[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            AttributeComparisonFunction[] values2 = new AttributeComparisonFunction[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static AttributeComparisonFunction valueOf(String name) throws CDMException {
        AttributeComparisonFunction _enum = (AttributeComparisonFunction)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        AttributeComparisonFunction _enum = new AttributeComparisonFunction(name);
        enumList.put(name, _enum);
    }

    static {
        values = new AttributeComparisonFunction[]{new AttributeComparisonFunction(names[0]), new AttributeComparisonFunction(names[1]), new AttributeComparisonFunction(names[2]), new AttributeComparisonFunction(names[3]), new AttributeComparisonFunction(names[4]), new AttributeComparisonFunction(names[5]), new AttributeComparisonFunction(names[6])};
        systemDefault = values[0];
        systemDetermined = values[1];
        absDiff = values[2];
        gaussSim = values[3];
        delta = values[4];
        equal = values[5];
        similarityMatrix = values[6];
    }
}
