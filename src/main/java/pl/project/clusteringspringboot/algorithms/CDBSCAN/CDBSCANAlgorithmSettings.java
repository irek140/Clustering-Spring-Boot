package pl.project.clusteringspringboot.algorithms.CDBSCAN;

import pl.project.clusteringspringboot.clustering.CDMBaseAlgorithmSettings;
import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningAlgorithm;
import pl.project.clusteringspringboot.datamining.VerificationReport;
import pl.project.clusteringspringboot.datamining.base.AlgorithmSettings;

/**
 * Created by Piotr Lasek on 30.05.2017.
 */
public class CDBSCANAlgorithmSettings extends CDMBaseAlgorithmSettings implements AlgorithmSettings {
    public static final String NAME = "C-DBSCAN";
    private int minPts;
    private double eps;
    private int delta;

    private String ic = null; // instance constraints

    static {
        try {
            MiningAlgorithm.addExtension(NAME);
        } catch (CDMException e) {
            e.printStackTrace();
        }
    }

    public int getMinPts() {
        return minPts;
    }

    public double getEps() {
        return eps;
    }

    @Override
    public VerificationReport verify() {
        return null;
    }

    @Override
    public MiningAlgorithm getMiningAlgorithm() {
        try {
            return MiningAlgorithm.valueOf(NAME);
        } catch (CDMException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setMinPts(int minPts) {
        this.minPts = minPts;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public String getIC() {
        return ic;
    }

    public void setIC(String ic) {
        this.ic = ic;
    }

    public int getDelta() {
        return delta;
    }
}
