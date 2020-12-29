package pl.project.clusteringspringboot.datamining.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.project.clusteringspringboot.algorithms.CDBSCAN.CDBSCANAlgorithm;
import pl.project.clusteringspringboot.algorithms.CDBSCAN.CDBSCANAlgorithmSettings;
import pl.project.clusteringspringboot.algorithms.CNBC.CNBCAlgorithm;
import pl.project.clusteringspringboot.algorithms.CNBC.CNBCAlgorithmSettings;
import pl.project.clusteringspringboot.algorithms.DBSCAN.DBSCANAlgorithm;
import pl.project.clusteringspringboot.algorithms.DBSCAN.DBSCANAlgorithmSettings;
import pl.project.clusteringspringboot.algorithms.NBC.NBCAlgorithm;
import pl.project.clusteringspringboot.algorithms.NBC.NBCAlgorithmSettings;
import pl.project.clusteringspringboot.algorithms.PiMeans.PiMeansAlgorithm;
import pl.project.clusteringspringboot.algorithms.PiMeans.PiMeansAlgorithmSettings;
import pl.project.clusteringspringboot.clustering.CDMClusteringModel;
import pl.project.clusteringspringboot.algorithms.KMeans.DM.DM_KMeansAlgorithm;
import pl.project.clusteringspringboot.algorithms.KMeans.KMeansAlgorithm;
import pl.project.clusteringspringboot.algorithms.KMeans.KMeansAlgorithmSettings;
import pl.project.clusteringspringboot.algorithms.KMeans.KMeansPpAlgorithm;
import pl.project.clusteringspringboot.algorithms.KMeans.KMeansPpAlgorithmSettings;

import pl.project.clusteringspringboot.clustering.CDMClusteringSettings;
import pl.project.clusteringspringboot.datamining.*;
import pl.project.clusteringspringboot.datamining.base.AlgorithmSettings;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringSettings;
import pl.project.clusteringspringboot.datamining.data.CDMFilePhysicalDataSet;

import pl.project.clusteringspringboot.datamining.resource.Connection;
import pl.project.clusteringspringboot.datamining.task.BuildTask;
import pl.project.clusteringspringboot.datamining.base.Task;
import pl.project.clusteringspringboot.datamining.Enum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/**
 * 
 * @author Piotr Lasek
 *
 */
public class CDMFileConnection implements Connection {

	HashMap<String, MiningObject> miningObjects =
			new HashMap<String, MiningObject>();
	
	CDMFileConnectionFactory factory;
	
	ConnectionSpec connectionSpec;

	protected final static Logger log = LogManager.getLogger(CDMFileConnection.class.getSimpleName());

	/**
	 * 
	 * @param factory
	 * @param cs
	 */
	public CDMFileConnection(CDMFileConnectionFactory factory, ConnectionSpec cs)
	{
		this.factory = factory;
		this.connectionSpec = cs;
	}

	@Override
	public void close() throws CDMException {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean doesObjectExist(String arg0, NamedObject arg1)
			throws CDMException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ExecutionHandle execute(String arg0) throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExecutionStatus execute(Task task, Long timeOut)
			throws CDMException {
		
		BuildTask bt = (BuildTask) task;
		
		String buildDataName = bt.getBuildDataName();		
		String settingsName = bt.getBuildSettingsName();
		String outputModelName = bt.getModelName();
		
		CDMClusteringModel mcm = new CDMClusteringModel();
		
		CDMFilePhysicalDataSet pds = (CDMFilePhysicalDataSet) 
				retrieveObject(buildDataName);

		if (!pds.getDescription().contains("[CUSTOM]")) {
			pds.setSeparator(",");
			pds.readData(this);
		} else {
			pds.setDescription(pds.getDescription().replace("[CUSTOM]", ""));
			log.warn("Data set not defined!");
		}

		// Get mining algorithm
		CDMClusteringSettings cs = (CDMClusteringSettings)
				retrieveObject(settingsName);
		
		cs.setLogicalDataName(buildDataName);
		
		AlgorithmSettings as = cs.getAlgorithmSettings();
		
		MiningAlgorithm ma = as.getMiningAlgorithm();

		CDMExecutionStatus executionStatus = new CDMExecutionStatus();
		MiningObject miningObject;


		if (ma.equals(MiningAlgorithm.valueOf(KMeansPpAlgorithmSettings.NAME))) {
			KMeansPpAlgorithm pkma = new KMeansPpAlgorithm(cs, pds);
			miningObject = pkma.run();
		} else if (ma.equals(MiningAlgorithm.valueOf(KMeansAlgorithmSettings.NAME))) {
			// kMeans
			KMeansAlgorithm kma = new KMeansAlgorithm(cs, pds);
			miningObject = kma.run();
		} else if (ma.equals(MiningAlgorithm.valueOf("K-Means_DM"))) {
			// K-Means_DM
			DM_KMeansAlgorithm kma = new DM_KMeansAlgorithm(cs, pds);
			miningObject = kma.run();
		} else if (ma.equals(MiningAlgorithm.valueOf(CNBCAlgorithmSettings.NAME))) {
			// NBC
			CNBCAlgorithm kma = new CNBCAlgorithm(cs, pds);
			miningObject = kma.run();
		} else if (ma.equals(MiningAlgorithm.valueOf(NBCAlgorithmSettings.NAME))) {
			// NBC
			NBCAlgorithm kma = new NBCAlgorithm(cs, pds);
			miningObject = kma.run();
		} else if (ma.equals(MiningAlgorithm.valueOf(DBSCANAlgorithmSettings.NAME))) {
			// NBC
			DBSCANAlgorithm kma = new DBSCANAlgorithm(cs, pds);
			miningObject = kma.run();
		} else if (ma.equals(MiningAlgorithm.valueOf(CDBSCANAlgorithmSettings.NAME))) {
			// NBC
			CDBSCANAlgorithm kma = new CDBSCANAlgorithm(cs, pds);
			miningObject = kma.run();
		} else if (ma.equals(MiningAlgorithm.valueOf(PiMeansAlgorithmSettings.NAME))) {
			PiMeansAlgorithm pkma = new PiMeansAlgorithm(cs, pds);
			miningObject = pkma.run();
		} else {
			throw new CDMException(0, "Not supported.");
		}

		saveObject("clustering_result", miningObject, true);

		executionStatus.setDescription(miningObject.getDescription());

		saveObject(outputModelName, mcm, true);

		return executionStatus;
	}

	@Override
	public ConnectionSpec getConnectionSpec() {
		return connectionSpec;
	}

	@Override
	public Date getCreationDate(String arg0, NamedObject arg1)
			throws CDMException {
		Date date = null;
	    Path p = Paths.get(connectionSpec.getURI());
	    BasicFileAttributes view;
		try {
			view = Files.getFileAttributeView(p, BasicFileAttributeView.class)
			          .readAttributes();
			FileTime ft = view.creationTime();
			date = new Date(ft.toMillis());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return date;
	}

	@Override
	public String getDescription(String arg0, NamedObject arg1)
			throws CDMException {

		
		return null;
	}

	@Override
	public ExecutionHandle[] getExecutionHandles(String arg0)
			throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factory getFactory(String arg0) throws CDMException {
		// TODO Auto-generated method stub
		return factory;
	}

	@Override
	public ExecutionHandle getLastExecutionHandle(String arg0)
			throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getLoadedData() throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getLoadedModels() throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Locale getLocale() {
		return null;
	}

	@Override
	public int getMaxDescriptionLength() {
		return 0;
	}

	@Override
	public int getMaxNameLength() {
		return 0;
	}

	@Override
	public ConnectionMetaData getMetaData() throws CDMException {
		ConnectionMetaData cmd = null;
		
		return cmd;
	}

	@Override
	public Collection getModelNames(MiningFunction arg0, MiningAlgorithm arg1,
                                    Date arg2, Date arg3) throws CDMException {
		return null;
	}

	@Override
	public NamedObject[] getNamedObjects(PersistenceOption arg0)
			throws CDMException {
		return null;
	}

	@Override
	public Collection getObjectNames(NamedObject arg0) throws CDMException {
		return null;
	}

	@Override
	public Collection getObjectNames(Date arg0, Date arg1, NamedObject arg2)
			throws CDMException {
		return null;
	}

	@Override
	public Collection getObjectNames(Date var1, Date var2, NamedObject var3, Enum var4) throws CDMException {
		return null;
	}

	@Override
	public MiningAlgorithm[] getSupportedAlgorithms(MiningFunction arg0)
			throws CDMException {
		return null;
	}

	@Override
	public MiningFunction[] getSupportedFunctions() throws CDMException {
		return null;
	}

	@Override
	public void removeObject(String arg0, NamedObject arg1) throws CDMException {
		
	}

	@Override
	public void renameObject(String arg0, String arg1, NamedObject arg2)
			throws CDMException {
		
	}

	@Override
	public void requestDataLoad(String arg0) throws CDMException {
		
	}

	@Override
	public void requestDataUnload(String arg0) throws CDMException {
		
	}

	@Override
	public void requestModelLoad(String arg0) throws CDMException {
		
	}

	@Override
	public void requestModelUnload(String arg0) throws CDMException {
		
	}

	@Override
	public Collection retrieveModelObjects(MiningFunction arg0,
                                           MiningAlgorithm arg1, Date arg2, Date arg3) throws CDMException {
		return null;
	}

	@Override
	public MiningObject retrieveObject(String miningObjectName)
			throws CDMException {
		return miningObjects.get(miningObjectName);
	}

	@Override
	public MiningObject retrieveObject(String arg0, NamedObject arg1)
			throws CDMException {
		return null;
	}

	@Override
	public Collection retrieveObjects(Date arg0, Date arg1, NamedObject arg2)
			throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection retrieveObjects(Date var1, Date var2, NamedObject var3, Enum var4) throws CDMException {
		return null;
	}

	@Override
	public void saveObject(String miningObjectName, MiningObject miningObject,
			boolean overwrite)
			throws CDMException {
		
		if (overwrite && miningObjects.containsKey(miningObjectName)) {
			miningObjects.put(miningObjectName, miningObject);
		}
		else {
			miningObjects.put(miningObjectName, miningObject);
		}		
	}

	@Override
	public void setDescription(String arg0, NamedObject arg1, String arg2)
			throws CDMException {
		
	}

	@Override
	public void setLocale(Locale arg0) throws CDMException {
		
	}

	@Override
	public boolean supportsCapability(NamedObject arg0, PersistenceOption arg1)
			throws CDMException {
		
		throw new CDMException(0, "Function not supported");
	}

	@Override
	public boolean supportsCapability(MiningFunction arg0,
                                      MiningAlgorithm arg1, MiningTask arg2) throws CDMException {
		return false;
	}
}
