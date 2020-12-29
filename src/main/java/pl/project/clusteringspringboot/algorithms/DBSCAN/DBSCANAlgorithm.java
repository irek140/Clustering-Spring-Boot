package pl.project.clusteringspringboot.algorithms.DBSCAN;

import pl.project.clusteringspringboot.algorithms.common.PlotPanel;
import pl.project.clusteringspringboot.clustering.CDMBasicClusteringAlgorithm;
import pl.project.clusteringspringboot.clustering.CDMClusteringSettings;
import pl.project.clusteringspringboot.clustering.model.IClusteringData;
import pl.project.clusteringspringboot.clustering.model.IClusteringObject;
import pl.project.clusteringspringboot.datamining.MiningObject;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringSettings;
import pl.project.clusteringspringboot.datamining.PhysicalDataSet;
import pl.util.Dump;

import java.util.Collection;

/**
 *
 */
public class DBSCANAlgorithm extends CDMBasicClusteringAlgorithm {


    private double Eps;
    private int MinPts;

    public DBSCANAlgorithm(CDMClusteringSettings clusteringSettings, PhysicalDataSet physicalDataSet) {
        super(clusteringSettings, physicalDataSet);

        DBSCANAlgorithmSettings das = (DBSCANAlgorithmSettings) clusteringSettings.getAlgorithmSettings();
        Eps = das.getEps();
        MinPts = das.getMinPts();
    }

    @Override
    public MiningObject run() {
        log.info(DBSCANAlgorithmSettings.NAME + " start.");

        log.info("Preparing data...");
        IClusteringData data = prepareData();

        DBSCANRTree dbscan = new DBSCANRTree();
        dbscan.setEps(Eps);
        dbscan.setMinPts(MinPts);

        timer.setAlgorithmName(DBSCANAlgorithmSettings.NAME);
        timer.setParameters(getDescription());

        timer.indexStart();
        dbscan.setData(data);
        timer.indexEnd();

        log.info(DBSCANAlgorithmSettings.NAME + " run.");
        timer.clusteringStart();
        dbscan.run();
        timer.clusteringEnd();

        log.info(DBSCANAlgorithmSettings.NAME + " finished.");

        IClusteringData cd = dbscan.getResult();

        String logFileName = Dump.getLogFileName(DBSCANAlgorithmSettings.NAME, getPhysicalDataSet().getDescription(),
                getDescription() + " (clusters=" + dbscan.clusterCount() + ")");

        if (dump()) {
            Dump.toFile(cd.get(), logFileName + ".csv", true); //data to dump
        }

        // Show result
        if (plot()) {
            Collection<IClusteringObject> result = cd.get();
            PlotPanel.plotResult(dbscan.getDataset(), max[0], max[1], null, null, null, null, logFileName + ".png", closePlot(), dbscan.clusterCount());
        }

        basicMiningObject.setDescription(timer.getLog() + "\t" + dbscan.clusterCount());
        return basicMiningObject;
    }

    @Override
    public String getDescription() {
        return "(Eps=" + Eps + ", minPts=" + MinPts + ")";
    }

}
