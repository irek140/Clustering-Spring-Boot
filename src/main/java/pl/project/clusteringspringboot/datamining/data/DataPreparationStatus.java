package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class DataPreparationStatus extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"unprepared", "prepared"};
    private static final DataPreparationStatus[] values;
    public static final DataPreparationStatus unprepared;
    public static final DataPreparationStatus prepared;

    private DataPreparationStatus(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static DataPreparationStatus[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            DataPreparationStatus[] values2 = new DataPreparationStatus[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static DataPreparationStatus valueOf(String name) throws CDMException {
        DataPreparationStatus _enum = (DataPreparationStatus)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        DataPreparationStatus _enum = new DataPreparationStatus(name);
        enumList.put(name, _enum);
    }

    static {
        values = new DataPreparationStatus[]{new DataPreparationStatus(names[0]), new DataPreparationStatus(names[1])};
        unprepared = values[0];
        prepared = values[1];
    }
}
