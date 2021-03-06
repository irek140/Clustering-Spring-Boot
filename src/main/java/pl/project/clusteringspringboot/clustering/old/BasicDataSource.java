package pl.project.clusteringspringboot.clustering.old;

import pl.project.clusteringspringboot.clustering.model.IClusteringData;
import pl.project.clusteringspringboot.clustering.model.IClusteringDataSource;
import pl.project.clusteringspringboot.clustering.model.IClusteringObserver;


/**
 * 
 * @author Piotr Lasek
 *
 */
public class BasicDataSource implements IClusteringObserver, IClusteringDataSource
{

	private static final long serialVersionUID = 1L;
	
	IClusteringData data;
	String id;  //  @jve:decl-index=0:


	/**
	 * This is the default constructor
	 */
	public BasicDataSource()
	{
	}

	@Override
	public void handleNotify(Object object) {
		// TODO Auto-generated method stub
	}

	@Override
	public void handleNotify(IClusteringData data) {
		// TODO Auto-generated method stub
		this.data = data;
	}

	@Override
	public void handleNotify(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IClusteringData getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void saveDataSource() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setData(IClusteringData clusteringOutput) {
		// TODO Auto-generated method stub
		data = clusteringOutput;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	@Override
	public void showDataSource() {
		// TODO Auto-generated method stub
		//this.setVisible(true);
	}

    @Override
    public void close() {
        //System.out.println("DataViewTable.close()");
        // TODO Auto-generated method stub
        
    }

}
