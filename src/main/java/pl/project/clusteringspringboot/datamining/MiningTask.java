package pl.project.clusteringspringboot.datamining;

import java.util.Collection;
import java.util.Hashtable;

public class MiningTask extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"buildTask", "testTask", "applyTask", "computeStatisticsTask", "exportTask", "importTask"};
    private static final MiningTask[] values;
    public static final MiningTask buildTask;
    public static final MiningTask testTask;
    public static final MiningTask applyTask;
    public static final MiningTask computeStatisticsTask;
    public static final MiningTask exportTask;
    public static final MiningTask importTask;

    private MiningTask(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static MiningTask[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            MiningTask[] values2 = new MiningTask[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static MiningTask valueOf(String name) throws CDMException {
        MiningTask _enum = (MiningTask)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        MiningTask _enum = new MiningTask(name);
        enumList.put(name, _enum);
    }

    static {
        values = new MiningTask[]{new MiningTask(names[0]), new MiningTask(names[1]), new MiningTask(names[2]), new MiningTask(names[3]), new MiningTask(names[4]), new MiningTask(names[5])};
        buildTask = values[0];
        testTask = values[1];
        applyTask = values[2];
        computeStatisticsTask = values[3];
        exportTask = values[4];
        importTask = values[5];
    }
}
