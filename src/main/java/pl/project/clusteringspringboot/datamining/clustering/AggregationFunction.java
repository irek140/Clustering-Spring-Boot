package pl.project.clusteringspringboot.datamining.clustering;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class AggregationFunction extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"systemDefault", "systemDetermined", "euclidean", "squaredEuclidean", "chebychev", "cityBlock", "minkowski", "simpleMatching", "jaccard", "tanimoto", "binarySimilarity"};
    private static final AggregationFunction[] values;
    public static final AggregationFunction systemDefault;
    public static final AggregationFunction systemDetermined;
    public static final AggregationFunction euclidean;
    public static final AggregationFunction squaredEuclidean;
    public static final AggregationFunction chebychev;
    public static final AggregationFunction cityBlock;
    public static final AggregationFunction minkowski;
    public static final AggregationFunction simpleMatching;
    public static final AggregationFunction jaccard;
    public static final AggregationFunction tanimoto;
    public static final AggregationFunction binarySimilarity;

    private AggregationFunction(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static AggregationFunction[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            AggregationFunction[] values2 = new AggregationFunction[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static AggregationFunction valueOf(String name) throws CDMException {
        AggregationFunction _enum = (AggregationFunction)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        AggregationFunction _enum = new AggregationFunction(name);
        enumList.put(name, _enum);
    }

    static {
        values = new AggregationFunction[]{new AggregationFunction(names[0]), new AggregationFunction(names[1]), new AggregationFunction(names[2]), new AggregationFunction(names[3]), new AggregationFunction(names[4]), new AggregationFunction(names[5]), new AggregationFunction(names[6]), new AggregationFunction(names[7]), new AggregationFunction(names[8]), new AggregationFunction(names[9]), new AggregationFunction(names[10])};
        systemDefault = values[0];
        systemDetermined = values[1];
        euclidean = values[2];
        squaredEuclidean = values[3];
        chebychev = values[4];
        cityBlock = values[5];
        minkowski = values[6];
        simpleMatching = values[7];
        jaccard = values[8];
        tanimoto = values[9];
        binarySimilarity = values[10];
    }
}
