/**
 * 
 */
package pl.project.clusteringspringboot.datamining.base;

import javax.datamining.JDMException;
import javax.datamining.MiningObject;
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
	public void setDescription(String description) throws JDMException {
		this.description = description;
	}

}
