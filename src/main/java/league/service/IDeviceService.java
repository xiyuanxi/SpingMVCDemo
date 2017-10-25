package league.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import league.ViewBean.AssociatedDeviceAjaxOutBean;
import league.model.Device;

/**
 * @author harvey.zhao
 *
 */
public interface IDeviceService {
	
	/**
	 * @param BBID
	 * @return
	 * @throws SQLException
	 */
	public Device getDeviceByBBID(String BBID) throws SQLException;
	
	/**
	 * @param device
	 * @return
	 * @throws SQLException
	 */
	public int insertDevice(Device device) throws SQLException;
	
	/**
	 * get Device List by specified account
	 * 
	 * @param checkName
	 * @param session
	 * @return
	 * @throws SQLException
	 */
	public AssociatedDeviceAjaxOutBean getDeviceListByTransactionAccountName(List<String> accountList, HttpSession session) throws SQLException;
}
