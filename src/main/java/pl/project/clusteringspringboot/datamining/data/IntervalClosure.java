package pl.project.clusteringspringboot.datamining.data;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class IntervalClosure extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"closedClosed", "closedOpen", "openClosed", "openOpen"};
    private static final IntervalClosure[] values;
    public static final IntervalClosure closedClosed;
    public static final IntervalClosure closedOpen;
    public static final IntervalClosure openClosed;
    public static final IntervalClosure openOpen;

    private IntervalClosure(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static IntervalClosure[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            IntervalClosure[] values2 = new IntervalClosure[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static IntervalClosure valueOf(String name) throws CDMException {
        IntervalClosure _enum = (IntervalClosure)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        IntervalClosure _enum = new IntervalClosure(name);
        enumList.put(name, _enum);
    }

    static {
        values = new IntervalClosure[]{new IntervalClosure(names[0]), new IntervalClosure(names[1]), new IntervalClosure(names[2]), new IntervalClosure(names[3])};
        closedClosed = values[0];
        closedOpen = values[1];
        openClosed = values[2];
        openOpen = values[3];
    }
}
