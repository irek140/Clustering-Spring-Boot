package pl.project.clusteringspringboot.datamining.task;


import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningAlgorithm;
import pl.project.clusteringspringboot.datamining.MiningFunction;

public class CDMBuildTaskFactory implements BuildTaskFactory {

	@Override
	public BuildTask create(String buildData, String buildSettingsName,
                            String modelName)
			throws CDMException {
		// TODO Auto-generated method stub
		CDMBuildTask mbt = new CDMBuildTask();
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
