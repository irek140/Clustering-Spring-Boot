package pl.project.clusteringspringboot.clustering.model;

public interface IClusteringObject
{
	public ISpatialObject getSpatialObject();
	
	public IClusterInfo getClusterInfo();
	
	public void setSpatialObject(ISpatialObject spatialObject);
	
	public void setClusterInfo(IClusterInfo clusterInfo);
}
