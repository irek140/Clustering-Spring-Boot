package pl.project.clusteringspringboot.datamining;


/**
 * @ author Piotr Lasek
 */
public class CDMException extends Exception implements CDMErrorCodes {

	private int m_errorCode = 0;
	private String m_vendorMessage = null;
	private int m_vendorCode = 0;

	public CDMException(String description) {
		super(description);
		this.setErrorCode(0);
	}

	public CDMException() {
		this.setErrorCode(1000);
	}

	public CDMException(int errorCode, String errorMessage) {
		super(errorMessage);
		this.setErrorCode(errorCode);
	}

	public CDMException(int errorCode, String errorMessage, int vendorCode, String vendorMessage) {
		super(errorMessage);
		this.setErrorCode(errorCode);
		this.setVendorErrorCode(vendorCode);
		this.setVendorErrorMessage(vendorMessage);
	}

	public int getErrorCode() {
		return this.m_errorCode;
	}

	protected void setErrorCode(int errorCode) {
		this.m_errorCode = errorCode;
	}

	public int getVendorErrorCode() {
		return this.m_vendorCode;
	}

	protected void setVendorErrorCode(int vendorCode) {
		this.m_vendorCode = vendorCode;
	}

	public String getVendorErrorMessage() {
		return this.m_vendorMessage;
	}

	protected void setVendorErrorMessage(String vendorMessage) {
		this.m_vendorMessage = vendorMessage;
	}

}
