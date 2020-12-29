package pl.iidml;


import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningAlgorithm;
import pl.project.clusteringspringboot.datamining.MiningFunction;
import pl.project.clusteringspringboot.datamining.task.BuildTask;
import pl.project.clusteringspringboot.datamining.task.BuildTaskCapability;
import pl.project.clusteringspringboot.datamining.task.BuildTaskFactory;


public class MyBuildTaskFactory implements BuildTaskFactory {

	@Override
	public BuildTask create(String buildData, String buildSettingsName,
			String modelName)
			throws CDMException {
		// TODO Auto-generated method stub
		MyBuildTask mbt = new MyBuildTask();
		mbt.setBuildDataName(buildData);
		mbt.setBuildSettingsName(buildSettingsName);
		mbt.setModelName(modelName);
		return mbt;
	}

	@Override
	public boolean supportsCapability(MiningFunction arg0,
			MiningAlgorithm arg1, BuildTaskCapability arg2) throws CDMException {
		// TODO Auto-generated method stub
		return false;
	}

}
