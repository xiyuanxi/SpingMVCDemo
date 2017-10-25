package league.model;

public class TransactionDetail extends Transaction  {
	TransDevice device;
	TransLocation location;
	
	/**
	 * @return the device
	 */
	public TransDevice getDevice() {
		return device;
	}
	/**
	 * @param device the device to set
	 */
	public void setDevice(TransDevice device) {
		this.device = device;
	}
	/**
	 * @return the location
	 */
	public TransLocation getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(TransLocation location) {
		this.location = location;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransactionDetail [device=" + device + ", location=" + location + "]";
	}
}