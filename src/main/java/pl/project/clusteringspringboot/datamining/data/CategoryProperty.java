package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class CategoryProperty extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"valid", "error", "unknown", "missing"};
    private static final CategoryProperty[] values;
    public static final CategoryProperty valid;
    public static final CategoryProperty error;
    public static final CategoryProperty unknown;
    public static final CategoryProperty missing;

    private CategoryProperty(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static CategoryProperty[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            CategoryProperty[] values2 = new CategoryProperty[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static CategoryProperty valueOf(String name) throws CDMException {
        CategoryProperty _enum = (CategoryProperty)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        CategoryProperty _enum = new CategoryProperty(name);
        enumList.put(name, _enum);
    }

    static {
        values = new CategoryProperty[]{new CategoryProperty(names[0]), new CategoryProperty(names[1]), new CategoryProperty(names[2]), new CategoryProperty(names[3])};
        valid = values[0];
        error = values[1];
        unknown = values[2];
        missing = values[3];
    }
}
