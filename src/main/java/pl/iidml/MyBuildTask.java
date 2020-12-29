package pl.iidml;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.ExecutionHandle;
import pl.project.clusteringspringboot.datamining.NamedObject;
import pl.project.clusteringspringboot.datamining.VerificationReport;
import pl.project.clusteringspringboot.datamining.task.BuildTask;

import java.util.Date;
import java.util.Map;

public class MyBuildTask implements BuildTask {
	
	private String buildDataName;
	private String buildSettingsName;
	private String modelName;

	@Override
	public ExecutionHandle getExecutionHandle() throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VerificationReport verify() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreationDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCreatorInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getObjectIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamedObject getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescription(String arg0) throws CDMException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getApplicationName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getBuildDataMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBuildDataName() {
		return buildDataName;
	}

	@Override
	public String getBuildSettingsName() {
		return buildSettingsName;
	}

	@Override
	public String getInputModelName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModelDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModelName() {
		return modelName;
	}

	@Override
	public Map getValidationDataMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValidationDataName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setApplicationName(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBuildDataMap(Map arg0) throws CDMException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBuildDataName(String arg0) throws CDMException {
		buildDataName = arg0;

	}

	@Override
	public void setBuildSettingsName(String arg0) throws CDMException {
		buildSettingsName = arg0;
	}

	@Override
	public void setInputModelName(String arg0) throws CDMException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setModelDescription(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setModelName(String arg0) throws CDMException {
		modelName = arg0;

	}

	@Override
	public void setValidationDataMap(Map arg0) throws CDMException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValidationDataName(String arg0) throws CDMException {
		// TODO Auto-generated method stub

	}

}
