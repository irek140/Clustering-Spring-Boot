package pl.project.clusteringspringboot.datamining;

import java.util.Collection;
import java.util.Hashtable;

public class NamedObject extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"task", "buildSettings", "model", "logicalData", "physicalDataSet", "testMetrics", "taxonomy", "costMatrix", "applySettings"};
    private static final NamedObject[] values;
    public static final NamedObject task;
    public static final NamedObject buildSettings;
    public static final NamedObject model;
    public static final NamedObject logicalData;
    public static final NamedObject physicalDataSet;
    public static final NamedObject testMetrics;
    public static final NamedObject taxonomy;
    public static final NamedObject costMatrix;
    public static final NamedObject applySettings;

    private NamedObject(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static NamedObject[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            NamedObject[] values2 = new NamedObject[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static NamedObject valueOf(String name) throws CDMException {
        NamedObject _enum = (NamedObject)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        NamedObject _enum = new NamedObject(name);
        enumList.put(name, _enum);
    }

    static {
        values = new NamedObject[]{new NamedObject(names[0]), new NamedObject(names[1]), new NamedObject(names[2]), new NamedObject(names[3]), new NamedObject(names[4]), new NamedObject(names[5]), new NamedObject(names[6]), new NamedObject(names[7]), new NamedObject(names[8])};
        task = values[0];
        buildSettings = values[1];
        model = values[2];
        logicalData = values[3];
        physicalDataSet = values[4];
        testMetrics = values[5];
        taxonomy = values[6];
        costMatrix = values[7];
        applySettings = values[8];
    }
}
