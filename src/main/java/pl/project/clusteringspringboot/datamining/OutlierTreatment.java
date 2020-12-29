package pl.project.clusteringspringboot.datamining;

import java.util.Collection;
import java.util.Hashtable;

public class OutlierTreatment extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"systemDefault", "systemDetermined", "asIs", "asMissing"};
    private static final OutlierTreatment[] values;
    public static final OutlierTreatment systemDefault;
    public static final OutlierTreatment systemDetermined;
    public static final OutlierTreatment asIs;
    public static final OutlierTreatment asMissing;

    private OutlierTreatment(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static OutlierTreatment[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            OutlierTreatment[] values2 = new OutlierTreatment[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static OutlierTreatment valueOf(String name) throws CDMException {
        OutlierTreatment _enum = (OutlierTreatment)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        OutlierTreatment _enum = new OutlierTreatment(name);
        enumList.put(name, _enum);
    }

    static {
        values = new OutlierTreatment[]{new OutlierTreatment(names[0]), new OutlierTreatment(names[1]), new OutlierTreatment(names[2]), new OutlierTreatment(names[3])};
        systemDefault = values[0];
        systemDetermined = values[1];
        asIs = values[2];
        asMissing = values[3];
    }
}
