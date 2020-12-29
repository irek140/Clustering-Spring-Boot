package pl.project.clusteringspringboot.datamining;

import java.util.Collection;
import java.util.Hashtable;

public class ExecutionState extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"submitted", "executing", "success", "error", "terminating", "terminated"};
    private static final ExecutionState[] values;
    public static final ExecutionState submitted;
    public static final ExecutionState executing;
    public static final ExecutionState success;
    public static final ExecutionState error;
    public static final ExecutionState terminating;
    public static final ExecutionState terminated;

    private ExecutionState(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static ExecutionState[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            ExecutionState[] values2 = new ExecutionState[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static ExecutionState valueOf(String name) throws CDMException {
        ExecutionState _enum = (ExecutionState)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        ExecutionState _enum = new ExecutionState(name);
        enumList.put(name, _enum);
    }

    static {
        values = new ExecutionState[]{new ExecutionState(names[0]), new ExecutionState(names[1]), new ExecutionState(names[2]), new ExecutionState(names[3]), new ExecutionState(names[4]), new ExecutionState(names[5])};
        submitted = values[0];
        executing = values[1];
        success = values[2];
        error = values[3];
        terminating = values[4];
        terminated = values[5];
    }

}
