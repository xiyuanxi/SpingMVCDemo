package league.ViewBean;

public class AssociatedAccountAjaxOutOneBean {
	String accountName;
	String deviceInCommon;
	String otherDevice;
	String associatedDevices;
	String associatedAccounts;
	
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
	 * @return the otherDevice
	 */
	public String getOtherDevice() {
		return otherDevice;
	}
	/**
	 * @param otherDevice the otherDevice to set
	 */
	public void setOtherDevice(String otherDevice) {
		this.otherDevice = otherDevice;
	}
	/**
	 * @return the associatedAccounts
	 */
	public String getAssociatedAccounts() {
		return associatedAccounts;
	}
	/**
	 * @param associatedAccounts the associatedAccounts to set
	 */
	public void setAssociatedAccounts(String associatedAccounts) {
		this.associatedAccounts = associatedAccounts;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssociatedAccountAjaxOutOneBean [accountName=" + accountName + ", deviceInCommon=" + deviceInCommon + ", otherDevice=" + otherDevice
				+ ", associatedDevices=" + associatedDevices + ", associatedAccounts=" + associatedAccounts + "]";
	}
}
