package pl.project.clusteringspringboot.datamining.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.project.clusteringspringboot.datamining.CDMErrorCodes;
import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.resource.Connection;

import java.io.File;
import java.util.HashMap;

public class CDMFileConnectionFactory implements ConnectionFactory {

	HashMap<String, CDMFileConnection> fileConnections;

	protected final static Logger log = LogManager.getLogger(CDMFileConnectionFactory.class.getSimpleName());

	@Override
	public Connection getConnection() throws CDMException {
		return null;
	}

	@Override
	public Connection getConnection(ConnectionSpec cs) throws CDMException {
		CDMFileConnection fc = new CDMFileConnection(this, cs);

		if (cs.getURI().contains("[CUSTOM]")) {
			log.warn("Dataset was not defined correctly! " +
					"Continuing in case the algorithm can load data.");
		} else {
			File f = new File(cs.getURI());

			if (!f.exists() || f.isDirectory()) {
				throw new CDMException(CDMErrorCodes.CONNECTION_FAILURE,
						"File " + cs.getURI() + " does not exist!");
			}
		}

		return fc;
	}

	@Override
	public ConnectionSpec getConnectionSpec() {
		return new CDMFileConnectionSpec();
	}

	@Override
	public boolean supportsCapability(ConnectionCapability arg0)
			throws CDMException {
		return false;
	}

	@Override
	public Connection getConnection(Connection arg0)
			throws CDMException {
		return null;
	}

}
