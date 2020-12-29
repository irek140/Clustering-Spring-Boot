/**
 * 
 */
package pl.project.clusteringspringboot.datamining.base;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.MiningObject;

import java.util.Date;

/**
 * @author Piotr Lasek
 *
 */
public abstract class CDMAbstractMiningObject implements MiningObject {

	Date creationDate;
	String creationInfo;
	String name;
	String objectIdentifier;
	String description;
	
	@Override
	public Date getCreationDate() {
		return creationDate;
	}

	@Override
	public String getCreatorInfo() {
		return "DMT";
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getObjectIdentifier() {
		return null;
	}

	@Override
	public void setDescription(String description) throws CDMException {
		this.description = description;
	}

}
