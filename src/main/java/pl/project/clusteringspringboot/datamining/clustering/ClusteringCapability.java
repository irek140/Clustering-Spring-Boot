package pl.project.clusteringspringboot.datamining.clustering;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class ClusteringCapability extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"minClusterCaseCount", "maxClusterCaseCount", "maxNumberOfClusters", "weightedAttributes", "automatedDataPreparation", "supplementaryAttributes", "weightAttribute", "hierarchicalClusters", "outlierTreatment", "logicalAttributeUsage", "logicalData"};
    private static final ClusteringCapability[] values;
    public static final ClusteringCapability minClusterCaseCount;
    public static final ClusteringCapability maxClusterCaseCount;
    public static final ClusteringCapability maxNumberOfClusters;
    public static final ClusteringCapability weightedAttributes;
    public static final ClusteringCapability automatedDataPreparation;
    public static final ClusteringCapability supplementaryAttributes;
    public static final ClusteringCapability weightAttribute;
    public static final ClusteringCapability hierarchicalClusters;
    public static final ClusteringCapability outlierTreatment;
    public static final ClusteringCapability logicalAttributeUsage;
    public static final ClusteringCapability logicalData;

    private ClusteringCapability(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static ClusteringCapability[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            ClusteringCapability[] values2 = new ClusteringCapability[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static ClusteringCapability valueOf(String name) throws CDMException {
        ClusteringCapability _enum = (ClusteringCapability)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        ClusteringCapability _enum = new ClusteringCapability(name);
        enumList.put(name, _enum);
    }

    static {
        values = new ClusteringCapability[]{new ClusteringCapability(names[0]), new ClusteringCapability(names[1]), new ClusteringCapability(names[2]), new ClusteringCapability(names[3]), new ClusteringCapability(names[4]), new ClusteringCapability(names[5]), new ClusteringCapability(names[6]), new ClusteringCapability(names[7]), new ClusteringCapability(names[8]), new ClusteringCapability(names[9]), new ClusteringCapability(names[10])};
        minClusterCaseCount = values[0];
        maxClusterCaseCount = values[1];
        maxNumberOfClusters = values[2];
        weightedAttributes = values[3];
        automatedDataPreparation = values[4];
        supplementaryAttributes = values[5];
        weightAttribute = values[6];
        hierarchicalClusters = values[7];
        outlierTreatment = values[8];
        logicalAttributeUsage = values[9];
        logicalData = values[10];
    }
}
