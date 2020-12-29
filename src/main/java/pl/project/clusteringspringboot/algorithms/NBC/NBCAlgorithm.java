package pl.project.clusteringspringboot.algorithms.NBC;

import org.springframework.beans.factory.annotation.Autowired;
import pl.project.clusteringspringboot.clustering.CDMBasicClusteringAlgorithm;
import pl.project.clusteringspringboot.algorithms.common.PlotPanel;
import pl.project.clusteringspringboot.clustering.CDMClusteringSettings;
import pl.project.clusteringspringboot.clustering.model.IClusteringData;
import pl.project.clusteringspringboot.datamining.MiningObject;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringSettings;
import pl.project.clusteringspringboot.datamining.PhysicalDataSet;
import pl.util.Dump;

/**
 *
 * @author Piotr Lasek
 *
 */
public class NBCAlgorithm extends CDMBasicClusteringAlgorithm {

    @Autowired
    private static Dump dump;

    int k = 0;

    /**
     *
     * @param clusteringSettings
     * @param physicalDataSet
     */
    public NBCAlgorithm(CDMClusteringSettings clusteringSettings, PhysicalDataSet physicalDataSet) {
        super(clusteringSettings, physicalDataSet);

        NBCAlgorithmSettings nas = (NBCAlgorithmSettings) clusteringSettings.getAlgorithmSettings();
        k = nas.getK();
    }

    /**
     *
     * @return
     */
    @Override
    public MiningObject run() {
        log.info(NBCAlgorithmSettings.NAME + " preparing data.");
        IClusteringData data = prepareData();
        log.info(NBCAlgorithmSettings.NAME + " done.");

        NBCRTree nbc = new NBCRTree();
        nbc.setK(k);

        timer.setAlgorithmName(NBCAlgorithmSettings.NAME);
        timer.setParameters("k=" + k);

        log.info(NBCAlgorithmSettings.NAME + " indexing.");
        timer.indexStart();
        nbc.setData(data);
        timer.indexEnd();
        log.info(NBCAlgorithmSettings.NAME + " done.");

        log.info(NBCAlgorithmSettings.NAME + " run.");
        timer.clusteringStart();
        nbc.run();
        timer.clusteringEnd();
        log.info(NBCAlgorithmSettings.NAME + " finished.");

        IClusteringData result = nbc.getResult();

        String logFileName = dump.getLogFileName(NBCAlgorithmSettings.NAME,
                getPhysicalDataSet().getDescription(),getDescription() + " (clusters=" + nbc.clusterCount() + ")");

        if (dump()) {
            dump.toFile(result.get(), logFileName + ".csv", true);
        }

        if (plot()) {
            PlotPanel.plotResult(nbc.getDataset(), max[0], max[1], null, null, null, null, logFileName + ".png", closePlot(), nbc.clusterCount());
        }

        basicMiningObject.setDescription(timer.getLog() + "\t" + nbc.clusterCount());
        return basicMiningObject;
    }

    @Override
    public String getDescription() {
        return "(k=" + k + ")";
    }
}


