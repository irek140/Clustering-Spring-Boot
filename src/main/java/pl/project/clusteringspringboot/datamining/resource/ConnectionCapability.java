package pl.project.clusteringspringboot.datamining.resource;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class ConnectionCapability extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"containerManaged", "connectionSpec", "jcxConnection", "scoringEngine"};
    private static final ConnectionCapability[] values;
    public static final ConnectionCapability containerManaged;
    public static final ConnectionCapability connectionSpec;
    public static final ConnectionCapability jcxConnection;
    public static final ConnectionCapability scoringEngine;

    private ConnectionCapability(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static ConnectionCapability[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            ConnectionCapability[] values2 = new ConnectionCapability[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static ConnectionCapability valueOf(String name) throws CDMException {
        ConnectionCapability _enum = (ConnectionCapability)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        ConnectionCapability _enum = new ConnectionCapability(name);
        enumList.put(name, _enum);
    }

    static {
        values = new ConnectionCapability[]{new ConnectionCapability(names[0]), new ConnectionCapability(names[1]), new ConnectionCapability(names[2]), new ConnectionCapability(names[3])};
        containerManaged = values[0];
        connectionSpec = values[1];
        jcxConnection = values[2];
        scoringEngine = values[3];
    }
}
