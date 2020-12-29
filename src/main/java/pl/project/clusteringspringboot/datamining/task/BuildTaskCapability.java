package pl.project.clusteringspringboot.datamining.task;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class BuildTaskCapability extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"inputModel", "validationData", "dataMapping"};
    private static final BuildTaskCapability[] values;
    public static final BuildTaskCapability inputModel;
    public static final BuildTaskCapability validationData;
    public static final BuildTaskCapability dataMapping;

    private BuildTaskCapability(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static BuildTaskCapability[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            BuildTaskCapability[] values2 = new BuildTaskCapability[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static BuildTaskCapability valueOf(String name) throws CDMException {
        BuildTaskCapability _enum = (BuildTaskCapability)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        BuildTaskCapability _enum = new BuildTaskCapability(name);
        enumList.put(name, _enum);
    }

    static {
        values = new BuildTaskCapability[]{new BuildTaskCapability(names[0]), new BuildTaskCapability(names[1]), new BuildTaskCapability(names[2])};
        inputModel = values[0];
        validationData = values[1];
        dataMapping = values[2];
    }
}
