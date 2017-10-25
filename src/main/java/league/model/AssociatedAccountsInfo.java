package league.model;

public class AssociatedAccountsInfo{
	String accountName;
	String deviceInCommon;
	String otherDevices;
	String associatedDevices;
	
	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * @return the deviceInCommon
	 */
	public String getDeviceInCommon() {
		return deviceInCommon;
	}
	/**
	 * @param deviceInCommon the deviceInCommon to set
	 */
	public void setDeviceInCommon(String deviceInCommon) {
		this.deviceInCommon = deviceInCommon;
	}
	/**
	 * @return the otherDevices
	 */
	public String getOtherDevices() {
		return otherDevices;
	}
	/**
	 * @param otherDevices the otherDevices to set
	 */
	public void setOtherDevices(String otherDevices) {
		this.otherDevices = otherDevices;
	}
	/**
	 * @return the associatedDevices
	 */
	public String getAssociatedDevices() {
		return associatedDevices;
	}
	/**
	 * @param associatedDevices the associatedDevices to set
	 */
	public void setAssociatedDevices(String associatedDevices) {
		this.associatedDevices = associatedDevices;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssociatedAccountsInfo [accountName=" + accountName + ", deviceInCommon=" + deviceInCommon + ", otherDevices=" + otherDevices
				+ ", associatedDevices=" + associatedDevices + "]";
	}
	

}