package league.model;

import java.util.Date;

public class AssociatedDevicesInfo{
	int deviceId;
	Date firstSeenDate;
	int accountsInCommon;
	int otherAccounts;
	int associatedDevices;
	
	/**
	 * @return the deviceId
	 */
	public int getDeviceId() {
		return deviceId;
	}
	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * @return the firstSeenDate
	 */
	public Date getFirstSeenDate() {
		return firstSeenDate;
	}
	/**
	 * @param firstSeenDate the firstSeenDate to set
	 */
	public void setFirstSeenDate(Date firstSeenDate) {
		this.firstSeenDate = firstSeenDate;
	}
	/**
	 * @return the accountsInCommon
	 */
	public int getAccountsInCommon() {
		return accountsInCommon;
	}
	/**
	 * @param accountsInCommon the accountsInCommon to set
	 */
	public void setAccountsInCommon(int accountsInCommon) {
		this.accountsInCommon = accountsInCommon;
	}
	/**
	 * @return the otherAccounts
	 */
	public int getOtherAccounts() {
		return otherAccounts;
	}
	/**
	 * @param otherAccounts the otherAccounts to set
	 */
	public void setOtherAccounts(int otherAccounts) {
		this.otherAccounts = otherAccounts;
	}
	/**
	 * @return the associatedDevices
	 */
	public int getAssociatedDevices() {
		return associatedDevices;
	}
	/**
	 * @param associatedDevices the associatedDevices to set
	 */
	public void setAssociatedDevices(int associatedDevices) {
		this.associatedDevices = associatedDevices;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssociatedDevicesInfo [deviceId=" + deviceId + ", firstSeenDate=" + firstSeenDate + ", accountsInCommon=" + accountsInCommon
				+ ", otherAccounts=" + otherAccounts + ", associatedDevices=" + associatedDevices + "]";
	}
}