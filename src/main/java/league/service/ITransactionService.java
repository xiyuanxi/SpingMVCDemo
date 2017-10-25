package league.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import league.ViewBean.AssociatedAccountAjaxOutBean;
import league.ViewBean.AssociatedDeviceAjaxOutBean;
import league.ViewBean.CheckReputationInBean;
import league.ViewBean.TransactionListAjaxInBean;
import league.ViewBean.TransactionListAjaxOutBean;
import league.model.Group;
import league.model.GroupUser;
import league.model.TransDevice;
import league.model.TransLocation;
import league.model.Transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author harvey.zhao
 *
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface ITransactionService {
	
	public Group getValidSubmitAccount(String username, String password) throws SQLException;
	
	/**
	 * @param trans
	 * @return
	 * @throws SQLException
	 */
	public int insertTransaction(Transaction trans) throws SQLException;

	/**
	 * @param transDevice
	 * @return
	 * @throws SQLException
	 */
	public int insertTransDevice(TransDevice transDevice) throws SQLException;
	
	/**
	 * @param transLocation
	 * @return
	 * @throws SQLException
	 */
	public int insertTransLocation(TransLocation transLocation) throws SQLException;

	/**
	 * Accept submit data, and return check result in JSON format
	 * 
	 * @param checkBean
	 * @param session
	 * @return
	 * @throws SQLException
	 */
	public String doCheckReputation(CheckReputationInBean checkBean, HttpSession session) throws SQLException;

	/**
	 * get valid login account
	 * 
	 * @param loginName
	 * @param loginPassword
	 * @return
	 * @throws SQLException
	 */
	public GroupUser getValidLoginAccount(String loginName, String loginPassword, HttpSession session) throws SQLException;

	/**
	 * Get Transaction list
	 * 
	 * @param inBean
	 * @param session
	 * @return
	 * @throws SQLException
	 */
	public TransactionListAjaxOutBean getTransactionList(TransactionListAjaxInBean inBean, HttpSession session) throws SQLException;
	
	/**
	 * Get Associated Account list by device list
	 * 
	 * @param devices
	 * @param session
	 * @return
	 * @throws SQLException
	 */
	public AssociatedAccountAjaxOutBean getAccountListByTransactionDevices(List<Integer>  devices, HttpSession session) throws SQLException;
	
	/**
	 * @param pagename
	 * @param message
	 * @param session
	 * @throws SQLException
	 */
	public void setHistoryRecord(String pagename, String message, HttpSession session ) throws SQLException;
} 
