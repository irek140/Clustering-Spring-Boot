package pl.project.clusteringspringboot.datamining.resource;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class PersistenceOption extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"transientObject", "persistentObject"};
    private static final PersistenceOption[] values;
    public static final PersistenceOption transientObject;
    public static final PersistenceOption persistentObject;

    private PersistenceOption(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static PersistenceOption[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            PersistenceOption[] values2 = new PersistenceOption[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static PersistenceOption valueOf(String name) throws CDMException {
        PersistenceOption _enum = (PersistenceOption)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        PersistenceOption _enum = new PersistenceOption(name);
        enumList.put(name, _enum);
    }

    static {
        values = new PersistenceOption[]{new PersistenceOption(names[0]), new PersistenceOption(names[1])};
        transientObject = values[0];
        persistentObject = values[1];
    }
}
