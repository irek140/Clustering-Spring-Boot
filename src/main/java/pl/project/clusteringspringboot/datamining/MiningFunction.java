package pl.project.clusteringspringboot.datamining;

import java.util.Collection;
import java.util.Hashtable;

public class MiningFunction extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"association", "attributeImportance", "regression", "clustering", "classification"};
    private static final MiningFunction[] values;
    public static final MiningFunction association;
    public static final MiningFunction attributeImportance;
    public static final MiningFunction regression;
    public static final MiningFunction clustering;
    public static final MiningFunction classification;

    private MiningFunction(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static MiningFunction[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            MiningFunction[] values2 = new MiningFunction[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static MiningFunction valueOf(String name) throws CDMException {
        MiningFunction _enum = (MiningFunction)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        MiningFunction _enum = new MiningFunction(name);
        enumList.put(name, _enum);
    }

    static {
        values = new MiningFunction[]{new MiningFunction(names[0]), new MiningFunction(names[1]), new MiningFunction(names[2]), new MiningFunction(names[3]), new MiningFunction(names[4])};
        association = values[0];
        attributeImportance = values[1];
        regression = values[2];
        clustering = values[3];
        classification = values[4];
    }
}
