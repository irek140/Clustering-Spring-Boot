package pl.project.clusteringspringboot.datamining;

import java.util.Collection;
import java.util.Hashtable;

public class LogicalAttributeUsage extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"active", "supplementary", "inactive"};
    private static final LogicalAttributeUsage[] values;
    public static final LogicalAttributeUsage active;
    public static final LogicalAttributeUsage supplementary;
    public static final LogicalAttributeUsage inactive;

    private LogicalAttributeUsage(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static LogicalAttributeUsage[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            LogicalAttributeUsage[] values2 = new LogicalAttributeUsage[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static LogicalAttributeUsage valueOf(String name) throws CDMException {
        LogicalAttributeUsage _enum = (LogicalAttributeUsage)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        LogicalAttributeUsage _enum = new LogicalAttributeUsage(name);
        enumList.put(name, _enum);
    }

    static {
        values = new LogicalAttributeUsage[]{new LogicalAttributeUsage(names[0]), new LogicalAttributeUsage(names[1]), new LogicalAttributeUsage(names[2])};
        active = values[0];
        supplementary = values[1];
        inactive = values[2];
    }
}
