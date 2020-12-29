package pl.project.clusteringspringboot.datamining;

import java.util.Collection;
import java.util.Hashtable;

public class MiningAlgorithm extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"feedForwardNeuralNet", "kMeans", "naiveBayes", "decisionTree", "svmRegression", "svmClassification"};
    private static final MiningAlgorithm[] values;
    public static final MiningAlgorithm feedForwardNeuralNet;
    public static final MiningAlgorithm kMeans;
    public static final MiningAlgorithm naiveBayes;
    public static final MiningAlgorithm decisionTree;
    public static final MiningAlgorithm svmRegression;
    public static final MiningAlgorithm svmClassification;

    private MiningAlgorithm(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static MiningAlgorithm[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            MiningAlgorithm[] values2 = new MiningAlgorithm[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static MiningAlgorithm valueOf(String name) throws CDMException {
        MiningAlgorithm _enum = (MiningAlgorithm)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        MiningAlgorithm _enum = new MiningAlgorithm(name);
        enumList.put(name, _enum);
    }

    static {
        values = new MiningAlgorithm[]{new MiningAlgorithm(names[0]), new MiningAlgorithm(names[1]), new MiningAlgorithm(names[2]), new MiningAlgorithm(names[3]), new MiningAlgorithm(names[4]), new MiningAlgorithm(names[5])};
        feedForwardNeuralNet = values[0];
        kMeans = values[1];
        naiveBayes = values[2];
        decisionTree = values[3];
        svmRegression = values[4];
        svmClassification = values[5];
    }
}
