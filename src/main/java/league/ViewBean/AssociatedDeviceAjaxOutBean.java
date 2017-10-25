package league.ViewBean;

import java.util.List;

public class AssociatedDeviceAjaxOutBean {
	String msg;
	List<AssociatedDeviceAjaxOutOneBean> deviceList;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<AssociatedDeviceAjaxOutOneBean> getDeviceList() {
		return deviceList;
	}
	public void setDeviceList(List<AssociatedDeviceAjaxOutOneBean> deviceList) {
		this.deviceList = deviceList;
	}
}
