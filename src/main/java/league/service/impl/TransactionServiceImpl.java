package league.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import league.ViewBean.AssociatedAccountAjaxOutBean;
import league.ViewBean.AssociatedAccountAjaxOutOneBean;
import league.ViewBean.CheckReputationInBean;
import league.ViewBean.CheckReputationOutBean;
import league.ViewBean.TransactionListAjaxInBean;
import league.ViewBean.TransactionListAjaxOutBean;
import league.ViewBean.TransactionListAjaxOutOneBean;
import league.ViewBean.UploadPackageDetailBean;
import league.controller.TransactionController;
import league.dao.DeviceMapper;
import league.dao.GroupMapper;
import league.dao.GroupUserMapper;
import league.dao.HistoryMapper;
import league.dao.TransDeviceMapper;
import league.dao.TransLocationMapper;
import league.dao.TransactionDetailMapperA;
import league.dao.TransactionMapper;
import league.model.AssociatedAccountsInfo;
import league.model.Device;
import league.model.DeviceExample;
import league.model.Group;
import league.model.GroupExample;
import league.model.GroupUser;
import league.model.GroupUserExample;
import league.model.History;
import league.model.TransDevice;
import league.model.TransLocation;
import league.model.Transaction;
import league.model.TransactionDetail;
import league.model.TransactionExample;
import league.model.TransactionExample.Criteria;
import league.service.ITransactionService;
import league.util.SecurityUtil;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TransactionServiceImpl implements ITransactionService {
	private static Logger logger = Logger.getLogger(ITransactionService.class);

	@Resource
	private GroupMapper groupDao;
	
	@Resource
	private GroupUserMapper groupUserDao;

	@Resource
	private DeviceMapper deviceDao;
	
	@Resource
	private TransactionDetailMapperA transDetailDao;
	
	@Resource
	private TransactionMapper transactionDao;

	@Resource
	private TransDeviceMapper transDeviceDao;

	@Resource
	private TransLocationMapper transLocationDao;
	
	@Resource
	private TransactionDetailMapperA transactionDetailMapperADao;
	
	@Resource
	private HistoryMapper historyDao;

	@Override
	public Group getValidSubmitAccount(String submitName, String submitPassword) throws SQLException
	{
		GroupExample example = new GroupExample();

		example.createCriteria().andSubmitNameEqualTo(submitName).andSubmitPasswordEqualTo(submitPassword);

		List<Group> groupList = groupDao.selectByExample(example);
		if (groupList.size() > 0) {
			return groupList.get(0);
		}
		return null;
	}

	@Override
	public GroupUser getValidLoginAccount(String loginName, String loginPassword, HttpSession session) throws SQLException {
		String mask = "md5&&%%";
		String md5Pass = SecurityUtil.getMD5(loginPassword + mask);
		History historyRecord = new History();
		historyRecord.setIp((String) session.getAttribute("userip"));
		historyRecord.setLoginName(loginName);
		historyRecord.setPagename("login");
		
		GroupUserExample example = new GroupUserExample();

		example.createCriteria().andLoginNameEqualTo(loginName).andLoginPasswordEqualTo(md5Pass);

		List<GroupUser> groupUserList = groupUserDao.selectByExample(example);
		if (groupUserList.size() > 0) {
			Group group = groupDao.selectByPrimaryKey(groupUserList.get(0).getGroupId());
			if (group != null) {
				session.setAttribute("user", groupUserList.get(0));
				session.setAttribute("group", group);
				historyRecord.setMessage("login success");
				historyDao.insertSelective(historyRecord);
				return groupUserList.get(0);
			}
		}
		String tmp = "login failed. password:" + loginPassword;
		historyRecord.setMessage(tmp.substring(0, tmp.length() > 44 ? 44 : tmp.length()));
		historyDao.insertSelective(historyRecord);
		return null;
	}

//	@Override
//	public List<TransactionDetail> getTransactionDetail(int deviceId) throws SQLException {
//		List<TransactionDetail> transDetailList = transDetailDao.selectByDeviceId(deviceId);
//		return transDetailList;
//	}

	@Override
	public int insertTransaction(Transaction trans) throws SQLException {
		int ret = transactionDao.insertSelective(trans);
		return ret;
	}

	@Override
	public int insertTransDevice(TransDevice transDevice) throws SQLException {
		int ret = transDeviceDao.insertSelective(transDevice);
		return ret;
	}

	@Override
	public int insertTransLocation(TransLocation transLocation) throws SQLException {
		int ret = transLocationDao.insertSelective(transLocation);
		return ret;
	}
	
	/**
	 * Accept submit data, and return check result in JSON format
	 * 
	 * @param checkBean
	 * @param session
	 * @return
	 * @throws SQLException
	 */
	@Override
	public String doCheckReputation(CheckReputationInBean checkBean, HttpSession session) throws SQLException {
		// Result data
		CheckReputationOutBean out = new CheckReputationOutBean();
		
		int ret = 0;
		//Check submit user's validity
		String mask = "md5&&%%";
		String md5Pass = SecurityUtil.getMD5(checkBean.getSubmitPassword() + mask);
		Group group = getValidSubmitAccount(checkBean.getSubmitName(), md5Pass);
		if (group == null) {
			out.setResult("AccountFail");
			out.setMessage("Submit account doesn't exist.");
		} else {
			int deviceId;
			// Parse uploadPackaging json string
			String json = new String(SecurityUtil.decode(checkBean.getUploadPackaging()));
			logger.debug("json decode = " + json);
			UploadPackageDetailBean in = JSON.parseObject(json, UploadPackageDetailBean.class);
			if(in.getDVID() == null || in.getDVID().isEmpty()) {
				return "";
			}
			// Check whether this device exist in device table 
			Device dev = null;
			DeviceExample example = new DeviceExample();
			example.createCriteria().andBbGuidEqualTo(in.getDVID());
			List<Device> deviceList = deviceDao.selectByExample(example);
			if (deviceList.size() > 0) {
				dev = deviceList.get(0);
			}
			//Device dev = deviceService.getDeviceByBBID(in.getDVID());
			if (dev != null) {
				// If exist, get device id
				deviceId = dev.getId();
			} else {
				// If not exist, insert a new device data into device table
				Device device = new Device();
				device.setBbGuid(in.getDVID());
				device.setFontsCode(in.getFNSCODE());
				//ret = deviceService.insertDevice(device);
				ret = deviceDao.insertSelective(device);
				deviceId = device.getId();
			}
			// Insert transaction data
			Transaction trans = new Transaction();
			trans.setGroupId(group.getId());
			trans.setDeviceId(deviceId);
			trans.setAccountName(checkBean.getClientName());
			// TODO
			// trans.setRuleSetId(checkBean.getRules());
			trans.setRuleSetId(1);
			trans.setRuleCheckResult("true");
			trans.setResult((short) 1);
			trans.setIsNewDevice(dev == null);
			trans.setFnsCode(in.getFNSCODE());
			ret = this.insertTransaction(trans);

			// Insert trans_device data
			TransDevice transDevice = new TransDevice();
			//ret /= 0;
			transDevice.setTransactionId(trans.getId());
			transDevice.setBrowserLanguage(in.getBSLA());
			transDevice.setBrowserType(in.getBS());
			transDevice.setBrowserVersion(in.getBSVS());
			transDevice.setDeviceType("");
			transDevice.setFlashEnabled(true);
			transDevice.setFlashStorageEnabled(true);
			transDevice.setFlashVersion(in.getFLSVER());
			transDevice.setOperationSystem(in.getOS());
			transDevice.setScreenResolution(in.getSCNRES());
			transDevice.setTimeZone(in.getTZON());
			ret = this.insertTransDevice(transDevice);

			// Insert trans_location data
			TransLocation transLocation = new TransLocation();
			transLocation.setTransactionId(trans.getId());
			transLocation.setIp(checkBean.getClientIp());
			// TODO
			transLocation.setCountryId("CN");
			transLocation.setCity("test");
			transLocation.setIsp("ISPTest");
			this.insertTransLocation(transLocation);

			out.setDeviceId(String.format("%012d", deviceId));
			out.setResult("Allowed");
			
		}
		
		return JSON.toJSONString(out);
	}
	
	@Override
	public TransactionListAjaxOutBean getTransactionList(TransactionListAjaxInBean inBean, HttpSession session) throws SQLException {
		TransactionListAjaxOutBean out = new TransactionListAjaxOutBean();
		
		if(session.getAttribute("user") == null || session.getAttribute("group") == null) {
			out.setMsg("Timeout, please re-login.");
			return out;
		}
		int groupId = ((Group)(session.getAttribute("group"))).getId();
		TransactionExample example = new TransactionExample();
		example.createCriteria().andGroupIdEqualTo(groupId);
		if (inBean.getAccountName() != null) {
			example.getOredCriteria().get(0).andAccountNameEqualTo(inBean.getAccountName());
		} else if (inBean.getDeviceId() != null) {
			example.getOredCriteria().get(0).andDeviceIdEqualTo(Integer.valueOf(inBean.getDeviceId()));
		}
		
		example.setOrderByClause("id desc");
		
		int limit = Integer.valueOf(inBean.getCount());
		int maxCount = Integer.valueOf(inBean.getMaxCount());
		int offset = Integer.valueOf(inBean.getStart());
		// Exceed maximum number?
		if(offset + limit > maxCount) {
			limit = maxCount - offset;
		}
		List<TransactionDetail> list = transDetailDao.selectDetailList(example, offset, limit);
		logger.debug(list);
		int count = transDetailDao.selectDetailListCount(example, inBean.getMaxCount() == null?400:Integer.valueOf(inBean.getMaxCount()));
		
		List<TransactionListAjaxOutOneBean> l = new ArrayList<TransactionListAjaxOutOneBean>();
		for (TransactionDetail o : list) {
			TransactionListAjaxOutOneBean n = new TransactionListAjaxOutOneBean();

			n.setAccountName(o.getAccountName());
			n.setDateTime((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(o.getInsertDate()));
			n.setDeviceId(String.format("%010d", o.getDeviceId()));
			n.setResult(o.getResult().toString());
			n.setRule(o.getRuleSetId() == null ? "" : o.getRuleSetId().toString());
			n.setTransactionNum(String.format("%012d", o.getId()));
			n.setIsNewDevice(o.getIsNewDevice() ? "Yes" : "No");
			if (o.getLocation() != null) {
				n.setIp(o.getLocation().getIp());
			}
			TransDevice d;
			if ((d = o.getDevice()) != null) {
				n.setBrowserType(d.getBrowserType());
				n.setBrowserLanguage(d.getBrowserLanguage());
				n.setBrowserVersion(d.getBrowserVersion());
				n.setDeviceType(d.getDeviceType());
				n.setFlashEnabled(d.getFlashEnabled() == null ? "" : d.getFlashEnabled().toString());
				n.setFlashVersion(d.getFlashVersion());
				n.setOperatingSys(d.getOperationSystem());
				n.setScreenResolution(d.getScreenResolution());
				n.setTimeZone(d.getTimeZone());
			}

			l.add(n);
		}
 		out.setResult(l);
		
 		out.setCount(count);
		return out;
	}

	@Override
	public AssociatedAccountAjaxOutBean getAccountListByTransactionDevices(List<Integer> devices, HttpSession session) throws SQLException {
		AssociatedAccountAjaxOutBean out = new AssociatedAccountAjaxOutBean();
		
		if(session.getAttribute("user") == null || session.getAttribute("group") == null) {
			out.setMsg("Timeout, please re-login.");
			return out;
		}
		
		int groupId = ((Group)(session.getAttribute("group"))).getId();
		
		List<AssociatedAccountsInfo> l = transactionDetailMapperADao.selectAllAssociatedAccountsByDeviceIds(devices, groupId);
		
		List<AssociatedAccountAjaxOutOneBean> r = new ArrayList<AssociatedAccountAjaxOutOneBean>();
		for(AssociatedAccountsInfo o : l ) {
			AssociatedAccountAjaxOutOneBean a = new AssociatedAccountAjaxOutOneBean();
			a.setAccountName(o.getAccountName());
			a.setDeviceInCommon(o.getDeviceInCommon());
			a.setOtherDevice(o.getOtherDevices());
			a.setAssociatedAccounts(String.valueOf((Integer.parseInt(a.getDeviceInCommon())+Integer.parseInt(a.getOtherDevice()))));
			a.setAssociatedDevices(o.getAssociatedDevices());
			
			r.add(a);
		}
		
		out.setAccountList(r);
		
		return out;
	}

	@Override
	public void setHistoryRecord(String pagename, String message, HttpSession session) throws SQLException {
		History historyRecord = new History();

		historyRecord.setIp((String) session.getAttribute("userip"));
		historyRecord.setLoginName(((GroupUser) session.getAttribute("user")).getLoginName());
		historyRecord.setPagename(pagename);
		historyRecord.setMessage(message.substring(0, message.length() > 44 ? 44 : message.length()));
		historyDao.insertSelective(historyRecord);
	}
	
}
