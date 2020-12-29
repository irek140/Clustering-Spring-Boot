package pl.project.clusteringspringboot.datamining.base;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningAlgorithm;
import pl.project.clusteringspringboot.datamining.MiningFunction;
import pl.project.clusteringspringboot.datamining.NamedObject;
import pl.project.clusteringspringboot.datamining.data.ModelSignature;
import pl.project.clusteringspringboot.datamining.statistics.AttributeStatisticsSet;

import java.util.Date;

public abstract class CDMAbstractModel implements Model {

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
	public AttributeStatisticsSet getAttributeStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getBuildDuration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuildSettings getBuildSettings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuildSettings getEffectiveBuildSettings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMajorVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiningAlgorithm getMiningAlgorithm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiningFunction getMiningFunction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMinorVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelDetail getModelDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProviderName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProviderVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelSignature getSignature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTaskIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniqueIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
