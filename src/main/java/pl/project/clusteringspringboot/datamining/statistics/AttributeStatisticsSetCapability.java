package pl.project.clusteringspringboot.datamining.statistics;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class AttributeStatisticsSetCapability extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"missingFrequency", "invalidValuesFrequency", "continuousSum", "continuousSumOfSquares", "continuousSumsByInterval", "numericalQuantiles", "numericalMedian", "numericalInterQuartileRange"};
    private static final AttributeStatisticsSetCapability[] values;
    public static final AttributeStatisticsSetCapability missingFrequency;
    public static final AttributeStatisticsSetCapability invalidValuesFrequency;
    public static final AttributeStatisticsSetCapability continuousSum;
    public static final AttributeStatisticsSetCapability continuousSumOfSquares;
    public static final AttributeStatisticsSetCapability continuousSumsByInterval;
    public static final AttributeStatisticsSetCapability numericalQuantiles;
    public static final AttributeStatisticsSetCapability numericalMedian;
    public static final AttributeStatisticsSetCapability numericalInterQuartileRange;

    private AttributeStatisticsSetCapability(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static AttributeStatisticsSetCapability[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            AttributeStatisticsSetCapability[] values2 = new AttributeStatisticsSetCapability[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static AttributeStatisticsSetCapability valueOf(String name) throws CDMException {
        AttributeStatisticsSetCapability _enum = (AttributeStatisticsSetCapability)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        AttributeStatisticsSetCapability _enum = new AttributeStatisticsSetCapability(name);
        enumList.put(name, _enum);
    }

    static {
        values = new AttributeStatisticsSetCapability[]{new AttributeStatisticsSetCapability(names[0]), new AttributeStatisticsSetCapability(names[1]), new AttributeStatisticsSetCapability(names[2]), new AttributeStatisticsSetCapability(names[3]), new AttributeStatisticsSetCapability(names[4]), new AttributeStatisticsSetCapability(names[5]), new AttributeStatisticsSetCapability(names[6]), new AttributeStatisticsSetCapability(names[7])};
        missingFrequency = values[0];
        invalidValuesFrequency = values[1];
        continuousSum = values[2];
        continuousSumOfSquares = values[3];
        continuousSumsByInterval = values[4];
        numericalQuantiles = values[5];
        numericalMedian = values[6];
        numericalInterQuartileRange = values[7];
    }
}
