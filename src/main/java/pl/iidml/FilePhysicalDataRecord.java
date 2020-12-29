package pl.iidml;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.NamedObject;
import pl.project.clusteringspringboot.datamining.data.PhysicalDataRecord;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class FilePhysicalDataRecord extends BasicMiningObject implements PhysicalDataRecord {

	HashMap<String, Object> keyValueMap;
	
	@Override
	/**
	 * 
	 */
	public int getAttributeCount() {
		return keyValueMap.size();
	}

	@Override
	/**
	 * 
	 */
	public Collection getAttributeNames() {
		return keyValueMap.keySet();
	}

	@Override
	/**
	 * 
	 */
	public Object getValue(String attributeName) throws CDMException {
		if (keyValueMap.containsKey(attributeName)){
			return keyValueMap.get(attributeName);
		}
		else {
			throw new CDMException(0, "Attribute " + attributeName +
					" not found in FilePhysicalDataRecord.getClusterId(...)");
		}
	}

	@Override
	/**
	 * 
	 */
	public void removeAllAttributes() {
		keyValueMap.clear();
	}

	@Override
	/**
	 * 
	 */
	public void removeAttribute(String attributeName) throws CDMException {
		if (keyValueMap.containsKey(attributeName)){
			keyValueMap.remove(attributeName);
		} else {
			throw new CDMException(0, "Attribute " + attributeName +
					" not found in FilePhysicalDataRecord.removeAttribute" +
					"(...)");
		}
	}

	@Override
	/**
	 * 
	 */
	public void resetValues() {
		Set<String> keys = keyValueMap.keySet();
		
		if (keys != null) {
			for(String key : keys) {
				keyValueMap.put(key, null);
			}
		}
	}

	@Override
	/**
	 * Sets the value of the named attribute with the specified object value.
	 * A null value indicates that the attribute has no value, i.e., missing
	 * value.
	 */
	public void setValue(String attributeName, Object value)
			throws CDMException {
		if (keyValueMap == null) {
			keyValueMap = new HashMap<String, Object>();
		}
		
		keyValueMap.put(attributeName, value);
	}

	@Override
	public NamedObject getObjectType() {
		return null;
	}
}
