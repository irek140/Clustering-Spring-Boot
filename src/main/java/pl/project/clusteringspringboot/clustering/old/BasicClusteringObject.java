package pl.project.clusteringspringboot.clustering.old;

import pl.project.clusteringspringboot.clustering.model.IClusterInfo;
import pl.project.clusteringspringboot.clustering.model.IClusteringObject;
import pl.project.clusteringspringboot.clustering.model.ISpatialObject;

import java.util.HashMap;

public class BasicClusteringObject implements IClusteringObject
{
	BasicClusterInfo bci;
	ISpatialObject so;
	
	HashMap<String, String> has = new HashMap();
	
	@Override
	public IClusterInfo getClusterInfo() {
		// TODO Auto-generated method stub
		return bci;
	}

	@Override
	public ISpatialObject getSpatialObject() {
		return so;
	}

	@Override
	public void setClusterInfo(IClusterInfo clusterInfo) {
		bci = (BasicClusterInfo) clusterInfo;
		
	}

	@Override
	public void setSpatialObject(ISpatialObject spatialObject) {
		so = spatialObject;
	}

	public void addParameter(String key, String value) {
		has.put(key, value);
		
	}
	
	public String getParameter(String key) {
		return has.get(key);
	}


}
