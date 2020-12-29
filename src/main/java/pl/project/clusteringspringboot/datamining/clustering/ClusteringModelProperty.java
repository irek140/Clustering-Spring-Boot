package pl.project.clusteringspringboot.datamining.clustering;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class ClusteringModelProperty extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"centroid", "hierarchy", "statistics", "similarityScale", "clusterSimilarity", "splitPredicate", "rules"};
    private static final ClusteringModelProperty[] values;
    public static final ClusteringModelProperty centroid;
    public static final ClusteringModelProperty hierarchy;
    public static final ClusteringModelProperty statistics;
    public static final ClusteringModelProperty similarityScale;
    public static final ClusteringModelProperty clusterSimilarity;
    public static final ClusteringModelProperty splitPredicate;
    public static final ClusteringModelProperty rules;

    private ClusteringModelProperty(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static ClusteringModelProperty[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            ClusteringModelProperty[] values2 = new ClusteringModelProperty[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static ClusteringModelProperty valueOf(String name) throws CDMException {
        ClusteringModelProperty _enum = (ClusteringModelProperty)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        ClusteringModelProperty _enum = new ClusteringModelProperty(name);
        enumList.put(name, _enum);
    }

    static {
        values = new ClusteringModelProperty[]{new ClusteringModelProperty(names[0]), new ClusteringModelProperty(names[1]), new ClusteringModelProperty(names[2]), new ClusteringModelProperty(names[3]), new ClusteringModelProperty(names[4]), new ClusteringModelProperty(names[5]), new ClusteringModelProperty(names[6])};
        centroid = values[0];
        hierarchy = values[1];
        statistics = values[2];
        similarityScale = values[3];
        clusterSimilarity = values[4];
        splitPredicate = values[5];
        rules = values[6];
    }
}
