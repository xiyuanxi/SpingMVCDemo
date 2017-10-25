package league.ViewBean;

public class AssociatedDeviceAjaxOutOneBean {
	String deviceId;
	String firstSeen;
	int accountsInCommon;
	int otherAccounts;
	int associatedAccounts;
	int associatedDevices;
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getFirstSeen() {
		return firstSeen;
	}
	public void setFirstSeen(String firstSeen) {
		this.firstSeen = firstSeen;
	}

	public int getAccountsInCommon() {
		return accountsInCommon;
	}

	public void setAccountsInCommon(int accountsInCommon) {
		this.accountsInCommon = accountsInCommon;
	}

	public int getOtherAccounts() {
		return otherAccounts;
	}
	public void setOtherAccounts(int otherAccounts) {
		this.otherAccounts = otherAccounts;
	}
	public int getAssociatedAccounts() {
		return associatedAccounts;
	}
	public void setAssociatedAccounts(int associatedAccounts) {
		this.associatedAccounts = associatedAccounts;
	}
	public int getAssociatedDevices() {
		return associatedDevices;
	}
	public void setAssociatedDevices(int associatedDevices) {
		this.associatedDevices = associatedDevices;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssociatedDeviceAjaxOutOneBean [deviceId=" + deviceId + ", firstSeen=" + firstSeen + ", accountsInCommon=" + accountsInCommon
				+ ", otherAccounts=" + otherAccounts + ", associatedAccounts=" + associatedAccounts + ", associatedDevices=" + associatedDevices + "]";
	}
}
