package pl.project.clusteringspringboot.clustering;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningFunction;
import pl.project.clusteringspringboot.datamining.NamedObject;
import pl.project.clusteringspringboot.datamining.base.AlgorithmSettings;
import pl.project.clusteringspringboot.datamining.clustering.AggregationFunction;
import pl.project.clusteringspringboot.datamining.clustering.AttributeComparisonFunction;
import pl.project.clusteringspringboot.datamining.clustering.ClusteringSettings;
import pl.project.clusteringspringboot.datamining.clustering.SimilarityMatrix;
import pl.project.clusteringspringboot.datamining.data.Interval;
import pl.project.clusteringspringboot.datamining.data.LogicalData;
import pl.project.clusteringspringboot.datamining.AttributeRetrievalType;
import pl.project.clusteringspringboot.datamining.LogicalAttributeUsage;
import pl.project.clusteringspringboot.datamining.OutlierTreatment;
import pl.project.clusteringspringboot.datamining.VerificationReport;

import java.util.Collection;
import java.util.Date;

public class CDMClusteringSettings implements ClusteringSettings {

	AlgorithmSettings as;
	
	long minClusterCount;
	 
	
	@Override
	public AlgorithmSettings getAlgorithmSettings() {
		// TODO Auto-generated method stub
		return as;
	}

	@Override
	public int getDesiredExecutionTimeInMinutes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LogicalData getLogicalData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLogicalDataName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiningFunction getMiningFunction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Interval getOutlierIdentification(String arg0) throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getAttributeNames(AttributeRetrievalType var1) {
		return new String[0];
	}

	@Override
	public OutlierTreatment getOutlierTreatment(String arg0)
			throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogicalAttributeUsage getUsage(String arg0) throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getWeight(String arg0) throws CDMException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getWeightAttribute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAlgorithmSettings(AlgorithmSettings arg0) {
		as = arg0;
	}

	@Override
	public void setDesiredExecutionTimeInMinutes(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLogicalDataName(String arg0) throws CDMException {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection getLogicalAttributes(LogicalAttributeUsage var1) throws CDMException {
		return null;
	}

	@Override
	public void setOutlierIdentification(String arg0, Interval arg1)
			throws CDMException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOutlierTreatment(String arg0, OutlierTreatment arg1)
			throws CDMException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUsage(String arg0, LogicalAttributeUsage arg1)
			throws CDMException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setWeight(String arg0, double arg1) throws CDMException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setWeightAttribute(String arg0) throws CDMException {
		// TODO Auto-generated method stub

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
	public AggregationFunction getAggregationFunction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttributeComparisonFunction getAttributeComparisonFunction(
			String arg0) throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getMaxClusterCaseCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxLevels() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxNumberOfClusters() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getMinClusterCaseCount() {
		return minClusterCount;
	}

	@Override
	public SimilarityMatrix getSimilarityMatrix(String arg0)
			throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAggregationFunction(AggregationFunction arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAttributeComparisonFunction(String arg0,
			AttributeComparisonFunction arg1) throws CDMException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaxClusterCaseCount(long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaxLevels(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaxNumberOfClusters(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMinClusterCaseCount(long minClusterCount) {
		this.minClusterCount = minClusterCount;
	}

	@Override
	public void setSimilarityMatrix(String arg0, SimilarityMatrix arg1)
			throws CDMException {
		// TODO Auto-generated method stub

	}
}
