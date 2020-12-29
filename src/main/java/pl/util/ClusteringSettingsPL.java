package pl.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.project.clusteringspringboot.algorithms.CDBSCAN.CDBSCANAlgorithmSettings;
import pl.project.clusteringspringboot.algorithms.CNBC.CNBCAlgorithmSettings;
import pl.project.clusteringspringboot.algorithms.DBSCAN.DBSCANAlgorithmSettings;
import pl.project.clusteringspringboot.algorithms.NBC.NBCAlgorithmSettings;
import pl.project.clusteringspringboot.algorithms.PiMeans.PiMeansAlgorithmSettings;
import pl.project.clusteringspringboot.clustering.CDMBaseAlgorithmSettings;
import pl.project.clusteringspringboot.algorithms.KMeans.DM.DM_KMeansAlgorithmSettings;
import pl.project.clusteringspringboot.algorithms.KMeans.KMeansAlgorithmSettings;
import pl.project.clusteringspringboot.algorithms.KMeans.KMeansPpAlgorithmSettings;
import pl.project.clusteringspringboot.datamining.base.AlgorithmSettings;

import java.util.HashMap;

/**
 * Created by Piotr Lasek on 30.05.2017.
 */
public class ClusteringSettingsPL {

    private final static Logger log = LogManager.getLogger("ClusteringSettings");

    /**
     *
     * @param algorithm
     * @param parameters
     * @return
     */
    public static AlgorithmSettings prepare(String algorithm, HashMap<String, String> parameters) {
        AlgorithmSettings algorithmSettings = null;


        switch (algorithm) {
            case KMeansAlgorithmSettings.NAME:
                algorithmSettings = new KMeansAlgorithmSettings();
                int k  = new Integer(parameters.get("k"));
                int maxIterations = new Integer(parameters.get("maxIterations"));
                ((KMeansAlgorithmSettings) algorithmSettings).setK(k);
                ((KMeansAlgorithmSettings) algorithmSettings).setMaxIterations(maxIterations);
                break;
            case KMeansPpAlgorithmSettings.NAME:
                algorithmSettings = new KMeansPpAlgorithmSettings();
                int kPp  = new Integer(parameters.get("k"));
                int maxIterationsPp = new Integer(parameters.get("maxIterations"));
                ((KMeansPpAlgorithmSettings) algorithmSettings).setK(kPp);
                ((KMeansPpAlgorithmSettings) algorithmSettings).setMaxIterations(maxIterationsPp);
                break;
            case "DM_K-Means":
                algorithmSettings = new DM_KMeansAlgorithmSettings();
                break;
            case CNBCAlgorithmSettings.NAME:
                algorithmSettings = new CNBCAlgorithmSettings();
                int kCNBC = new Integer(parameters.get("k"));
                String icNBC = parameters.get("ic");
                ((CNBCAlgorithmSettings) algorithmSettings).setK(kCNBC);
                ((CNBCAlgorithmSettings) algorithmSettings).setIC(icNBC);
                break;
            case NBCAlgorithmSettings.NAME:
                algorithmSettings = new NBCAlgorithmSettings();
                int kNBC = new Integer(parameters.get("k"));
                ((NBCAlgorithmSettings) algorithmSettings).setK(kNBC);
                break;
            case DBSCANAlgorithmSettings.NAME:
                algorithmSettings = new DBSCANAlgorithmSettings();
                double EpsDB = new Double(parameters.get("Eps"));
                int MinPtsDB = new Integer(parameters.get("MinPts"));
                ((DBSCANAlgorithmSettings) algorithmSettings).setEps(EpsDB);
                ((DBSCANAlgorithmSettings) algorithmSettings).setMinPts(MinPtsDB);
                break;
            case CDBSCANAlgorithmSettings.NAME:
                algorithmSettings = new CDBSCANAlgorithmSettings();
                double EpsCDB = new Double(parameters.get("Eps"));
                int MinPtsCDB = new Integer(parameters.get("MinPts"));
                int deltaCDB = new Integer(parameters.get("d"));
                String icCDB = parameters.get("ic");
                ((CDBSCANAlgorithmSettings) algorithmSettings).setEps(EpsCDB);
                ((CDBSCANAlgorithmSettings) algorithmSettings).setMinPts(MinPtsCDB);
                ((CDBSCANAlgorithmSettings) algorithmSettings).setIC(icCDB);
                ((CDBSCANAlgorithmSettings) algorithmSettings).setDelta(deltaCDB);
                break;
            case PiMeansAlgorithmSettings.NAME: {
                algorithmSettings = new PiMeansAlgorithmSettings();
                int pk = new Integer(parameters.get("k"));
                int pmaxIterations = new Integer(parameters.get("maxIterations"));
                int deepest = new Integer(parameters.get("deepest"));
                int depth = new Integer(parameters.get("depth"));
                int starting = new Integer(parameters.get("starting"));
                ((PiMeansAlgorithmSettings) algorithmSettings).setK(pk);
                ((PiMeansAlgorithmSettings) algorithmSettings).setDepth(depth);
                ((PiMeansAlgorithmSettings) algorithmSettings).setDeepest(deepest);
                ((PiMeansAlgorithmSettings) algorithmSettings).setStarting(starting);
                ((PiMeansAlgorithmSettings) algorithmSettings).setMaxIterations(pmaxIterations);
            }
            break;
        }



        CDMBaseAlgorithmSettings baseAlgorithmSettings = (CDMBaseAlgorithmSettings) algorithmSettings;

        if (parameters.containsKey("plot")) {
            baseAlgorithmSettings.setPlot(true);
        }
        if (parameters.containsKey("dump")) {
            baseAlgorithmSettings.setDump(true);
        }
        if (parameters.containsKey("close_plot")) {
            baseAlgorithmSettings.setClosePlot(true);
        }

        return algorithmSettings;
    }
}
