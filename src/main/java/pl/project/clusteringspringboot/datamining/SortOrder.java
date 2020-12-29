package pl.project.clusteringspringboot.datamining;

import java.util.Collection;
import java.util.Hashtable;

public class SortOrder extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"systemDefault", "asIs", "ascending", "descending"};
    private static final SortOrder[] values;
    public static final SortOrder systemDefault;
    public static final SortOrder asIs;
    public static final SortOrder ascending;
    public static final SortOrder descending;

    private SortOrder(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static SortOrder[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            SortOrder[] values2 = new SortOrder[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static SortOrder valueOf(String name) throws CDMException {
        SortOrder _enum = (SortOrder)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        SortOrder _enum = new SortOrder(name);
        enumList.put(name, _enum);
    }

    static {
        values = new SortOrder[]{new SortOrder(names[0]), new SortOrder(names[1]), new SortOrder(names[2]), new SortOrder(names[3])};
        systemDefault = values[0];
        asIs = values[1];
        ascending = values[2];
        descending = values[3];
    }
}
