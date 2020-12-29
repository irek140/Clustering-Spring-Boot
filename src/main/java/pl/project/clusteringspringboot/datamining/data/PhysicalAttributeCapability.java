package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class PhysicalAttributeCapability extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"caseIdRequired", "multiAttributeCaseId"};
    private static final PhysicalAttributeCapability[] values;
    public static final PhysicalAttributeCapability caseIdRequired;
    public static final PhysicalAttributeCapability multiAttributeCaseId;

    private PhysicalAttributeCapability(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static PhysicalAttributeCapability[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            PhysicalAttributeCapability[] values2 = new PhysicalAttributeCapability[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static PhysicalAttributeCapability valueOf(String name) throws CDMException {
        PhysicalAttributeCapability _enum = (PhysicalAttributeCapability)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        PhysicalAttributeCapability _enum = new PhysicalAttributeCapability(name);
        enumList.put(name, _enum);
    }

    static {
        values = new PhysicalAttributeCapability[]{new PhysicalAttributeCapability(names[0]), new PhysicalAttributeCapability(names[1])};
        caseIdRequired = values[0];
        multiAttributeCaseId = values[1];
    }
}
