package pl.project.clusteringspringboot.datamining.resource;

import javax.datamining.resource.ConnectionSpec;
import java.util.Locale;


public class CDMFileConnectionSpec implements ConnectionSpec {
	
	String URI;

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return URI;
	}

	@Override
	public void setLocale(Locale arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setName(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPassword(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setURI(String arg0) {
		this.URI = arg0; 
	}

}