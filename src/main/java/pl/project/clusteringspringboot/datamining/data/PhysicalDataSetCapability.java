package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class PhysicalDataSetCapability extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"singleRecordCaseData", "multiRecordCaseData"};
    private static final PhysicalDataSetCapability[] values;
    public static final PhysicalDataSetCapability singleRecordCaseData;
    public static final PhysicalDataSetCapability multiRecordCaseData;

    private PhysicalDataSetCapability(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static PhysicalDataSetCapability[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            PhysicalDataSetCapability[] values2 = new PhysicalDataSetCapability[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static PhysicalDataSetCapability valueOf(String name) throws CDMException {
        PhysicalDataSetCapability _enum = (PhysicalDataSetCapability)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        PhysicalDataSetCapability _enum = new PhysicalDataSetCapability(name);
        enumList.put(name, _enum);
    }

    static {
        values = new PhysicalDataSetCapability[]{new PhysicalDataSetCapability(names[0]), new PhysicalDataSetCapability(names[1])};
        singleRecordCaseData = values[0];
        multiRecordCaseData = values[1];
    }
}
