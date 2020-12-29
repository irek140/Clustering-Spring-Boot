package pl.project.clusteringspringboot.algorithms.CDBSCAN;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import pl.project.clusteringspringboot.clustering.CDMBasicClusteringAlgorithm;
import pl.project.clusteringspringboot.algorithms.CNBC.InstanceConstraints;
import pl.project.clusteringspringboot.algorithms.common.PlotPanel;
import pl.project.clusteringspringboot.clustering.CDMClusteringSettings;
import pl.project.clusteringspringboot.clustering.model.IClusteringData;
import pl.project.clusteringspringboot.datamining.MiningObject;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringSettings;
import pl.project.clusteringspringboot.datamining.PhysicalDataSet;
import pl.project.clusteringspringboot.spatialindex.spatialindex.Point;
import pl.util.Dump;

import java.util.ArrayList;

/**
 * Created by Piotr Lasek on 30.05.2017.
 */
public class CDBSCANAlgorithm extends CDMBasicClusteringAlgorithm {

    @Autowired
    private static Dump dump;

    private final static Logger log = LogManager.getLogger("CDBSCANAlgorithm");

    private double Eps;
    private int MinPts;
    private int delta;

    String ic = null;

    /**
     *
     * @param clusteringSettings
     * @param physicalDataSet
     */
    public CDBSCANAlgorithm(CDMClusteringSettings clusteringSettings, PhysicalDataSet physicalDataSet) {
        super(clusteringSettings, physicalDataSet);

        CDBSCANAlgorithmSettings cdas = (CDBSCANAlgorithmSettings) clusteringSettings.getAlgorithmSettings();
        Eps = cdas.getEps();
        MinPts = cdas.getMinPts();
        ic = cdas.getIC();
        delta = cdas.getDelta();
    }

    /**
     *
     * @return
     */
    @Override
    public MiningObject run() {
        log.info(CDBSCANAlgorithmSettings.NAME + " start.");
        CDBSCANRTree dbscan = new CDBSCANRTree();

        log.info(CDBSCANAlgorithmSettings.NAME + " preparing data.");
        IClusteringData data = prepareData();

        timer.setAlgorithmName(CDBSCANAlgorithmSettings.NAME);
        timer.setParameters(getDescription());

        timer.indexStart();
        dbscan.setData(data);
        timer.indexEnd();

        dbscan.setConstraints(ic);
        dbscan.setEps(Eps);
        dbscan.setMinPts(MinPts);
        dbscan.setDelta(delta);

        log.info(CDBSCANAlgorithmSettings.NAME + " run");
        timer.clusteringStart();
        dbscan.run();
        timer.clusteringEnd();

        // merging with internal measurements
        timer.merge(dbscan.getInternalTimer());

        log.info(CDBSCANAlgorithmSettings.NAME + " finished.");

        IClusteringData resultToDump = dbscan.getResult();

        String logFileName = dump.getLogFileName(CDBSCANAlgorithmSettings.NAME, getPhysicalDataSet().getDescription(),
                getDescription() + " (clusters=" + dbscan.clusterCount() + ")");

        if (dump()) {
            dump.toFile(resultToDump.get(), logFileName + ".csv", true);
        }

        if (plot()) {
            // Show result
            ArrayList<Point> result = dbscan.getDataset();
            InstanceConstraints constraints = dbscan.getConstraints();
            PlotPanel.plotResult(result, max[0], max[1], constraints, null, null, null, logFileName + ".png", closePlot(), dbscan.clusterCount());
        }

        basicMiningObject.setDescription(timer.getLog() + "\t" + dbscan.clusterCount());

        return basicMiningObject;
    }
    @Override
    public String getDescription() {
        return "(Eps="+ Eps + ", minPts=" + MinPts + ")";
    }
}
