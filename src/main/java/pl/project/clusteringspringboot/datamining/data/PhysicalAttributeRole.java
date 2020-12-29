package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class PhysicalAttributeRole extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"data", "caseId", "attributeName", "attributeValue", "taxonomyChildId", "taxonomyParentId"};
    private static final PhysicalAttributeRole[] values;
    public static final PhysicalAttributeRole data;
    public static final PhysicalAttributeRole caseId;
    public static final PhysicalAttributeRole attributeName;
    public static final PhysicalAttributeRole attributeValue;
    public static final PhysicalAttributeRole taxonomyChildId;
    public static final PhysicalAttributeRole taxonomyParentId;

    private PhysicalAttributeRole(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static PhysicalAttributeRole[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            PhysicalAttributeRole[] values2 = new PhysicalAttributeRole[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static PhysicalAttributeRole valueOf(String name) throws CDMException {
        PhysicalAttributeRole _enum = (PhysicalAttributeRole)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        PhysicalAttributeRole _enum = new PhysicalAttributeRole(name);
        enumList.put(name, _enum);
    }

    static {
        values = new PhysicalAttributeRole[]{new PhysicalAttributeRole(names[0]), new PhysicalAttributeRole(names[1]), new PhysicalAttributeRole(names[2]), new PhysicalAttributeRole(names[3]), new PhysicalAttributeRole(names[4]), new PhysicalAttributeRole(names[5])};
        data = values[0];
        caseId = values[1];
        attributeName = values[2];
        attributeValue = values[3];
        taxonomyChildId = values[4];
        taxonomyParentId = values[5];
    }
}
