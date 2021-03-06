package pl.project.clusteringspringboot.algorithms.KMeans;

import pl.project.clusteringspringboot.clustering.CDMBasicClusteringAlgorithm;
import pl.project.clusteringspringboot.clustering.CDMClusteringSettings;
import pl.project.clusteringspringboot.clustering.model.IClusteringData;
import pl.project.clusteringspringboot.clustering.old.ClusteringTimer;
import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningObject;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringSettings;
import pl.project.clusteringspringboot.datamining.PhysicalDataSet;
import weka.clusterers.SimpleKMeans;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import java.util.ArrayList;

/**
 * Author: Piotr Lasek
 * Date: November 17, 2015
 */
public class KMeansPpAlgorithm extends CDMBasicClusteringAlgorithm {

	// parameters
	int k;
	int maxIterations;

	Instances instances;

	ClusteringTimer timer = new ClusteringTimer(getName());

	/**
	 * @return
	 */
	public String getName() {
		return KMeansPpAlgorithmSettings.NAME;
	}

	/**
	 * @param clusteringSettings
	 * @param physicalDataSet
	 */
	public KMeansPpAlgorithm(CDMClusteringSettings clusteringSettings,
							 PhysicalDataSet physicalDataSet) {
		super(clusteringSettings, physicalDataSet);

		KMeansPpAlgorithmSettings kmas = (KMeansPpAlgorithmSettings) clusteringSettings.getAlgorithmSettings();

		this.physicalDataSet = physicalDataSet;

		k = kmas.getK();

		maxIterations = kmas.getMaxIterations();

		// get attributes
		try {
			attributes = physicalDataSet.getAttributes();
		} catch (CDMException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	public MiningObject run() {
		SimpleKMeans kmeans = new SimpleKMeans();

		timer.setParameters("(k=" + k + ", mi=" + maxIterations + ")");

        try {
			timer.indexStart();
			prepareData();
			kmeans.setMaxIterations(k);
            kmeans.setNumClusters(maxIterations);
            timer.indexEnd();

            timer.clusteringStart();
			kmeans.buildClusterer(instances);

			// TODO: invoke cluster instance

			timer.clusteringEnd();
		} catch (Exception e) {
			e.printStackTrace();
		}

		basicMiningObject.setDescription(timer.getLog());
		return basicMiningObject;
	}

	@Override
	public IClusteringData prepareData() {
		IClusteringData idata = super.prepareData();

		ArrayList<Attribute> attributes = new ArrayList();
		attributes.add(new Attribute("x"));
		attributes.add(new Attribute("y"));

		instances = new Instances("KMeansPPInstances", attributes, 0);

		for (double[] r : data) {
			Instance i = new DenseInstance(2);
			i.setValue(0, r[0]);
			i.setValue(1, r[1]);
			instances.add(i);
		}

		return idata;
	}

	@Override
	public String getDescription() {
		return "(k = " + k + ")";
	}

	public PhysicalDataSet getPhysicalDataSet() {
		return physicalDataSet;
	}
}


