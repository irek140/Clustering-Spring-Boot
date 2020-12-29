package pl.iidml;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.resource.Connection;
import pl.project.clusteringspringboot.datamining.resource.ConnectionCapability;
import pl.project.clusteringspringboot.datamining.resource.ConnectionFactory;
import pl.project.clusteringspringboot.datamining.resource.ConnectionSpec;

import java.util.HashMap;

public class FileConnectionFactory implements ConnectionFactory {

	HashMap<String, FileConnection> fileConnections;
	
	@Override
	public Connection getConnection() throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection(ConnectionSpec cs) throws CDMException {
		// TODO Auto-generated method stub
		FileConnection fc = null;
		
		try
		{
			fc = new FileConnection(this, cs);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return fc;
	}

	@Override
	public Connection getConnection(Connection arg0)
			throws CDMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionSpec getConnectionSpec() {
		// TODO Auto-generated method stub
		return new FileConnectionSpec();
	}

	@Override
	public boolean supportsCapability(ConnectionCapability arg0)
			throws CDMException {
		// TODO Auto-generated method stub
		return false;
	}

}
