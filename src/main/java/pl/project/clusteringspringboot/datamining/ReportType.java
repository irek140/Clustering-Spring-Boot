package pl.project.clusteringspringboot.datamining;

import java.util.Collection;
import java.util.Hashtable;

public class ReportType extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"error", "warning"};
    private static final ReportType[] values;
    public static final ReportType error;
    public static final ReportType warning;

    private ReportType(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static ReportType[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            ReportType[] values2 = new ReportType[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static ReportType valueOf(String name) throws CDMException {
        ReportType _enum = (ReportType)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        ReportType _enum = new ReportType(name);
        enumList.put(name, _enum);
    }

    static {
        values = new ReportType[]{new ReportType(names[0]), new ReportType(names[1])};
        error = values[0];
        warning = values[1];
    }
}
