package league.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import league.ViewBean.AssociatedDeviceAjaxOutBean;
import league.ViewBean.AssociatedDeviceAjaxOutOneBean;
import league.dao.DeviceMapper;
import league.dao.DeviceMapperA;
import league.dao.TransactionDetailMapperA;
import league.model.AssociatedDevicesInfo;
import league.model.Device;
import league.model.DeviceExample;
import league.model.Group;
import league.service.IDeviceService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author harvey.zhao
 *
 */
@Service("deviceService")  
public class DeviceServiceImpl implements IDeviceService {

	@Resource
	private DeviceMapper deviceDao;
	
	@Resource
	private DeviceMapperA deviceDaoA;
	
	@Resource
	private TransactionDetailMapperA TransactionDetailDao;
	
	@Override
	public Device getDeviceByBBID(String BBID) throws SQLException {
		DeviceExample example = new DeviceExample();

		example.createCriteria().andBbGuidEqualTo(BBID);
		List<Device> deviceList = deviceDao.selectByExample(example);
		if (deviceList.size() > 0) {
			return deviceList.get(0);
		}

		return null;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public int insertDevice(Device device) throws SQLException {
		int ret = deviceDao.insertSelective(device);
		return ret;
	}

	@Override
	public AssociatedDeviceAjaxOutBean getDeviceListByTransactionAccountName(List<String> accountList, HttpSession session) throws SQLException {
		AssociatedDeviceAjaxOutBean out = new AssociatedDeviceAjaxOutBean();
		// Check user's validity
		if(session.getAttribute("user") == null || session.getAttribute("group") == null) {
			out.setMsg("Timeout, please re-login.");
			return out;
		}
		int group_id = ((Group)(session.getAttribute("group"))).getId();
		//List<String> accountNames = new ArrayList<String>();
		
		List<AssociatedDevicesInfo> ret = deviceDaoA.selectDeviceListByTransactionAccountName(group_id, accountList);
		//List<AssociatedDevicesInfo> assList = TransactionDetailDao.selectAssociatedAccountsByAccountName(accountName, group_id);
		
		List<AssociatedDeviceAjaxOutOneBean> l = new ArrayList<AssociatedDeviceAjaxOutOneBean>();
		for (AssociatedDevicesInfo d : ret) {
			AssociatedDeviceAjaxOutOneBean one = new AssociatedDeviceAjaxOutOneBean();
			one.setDeviceId(String.format("%010d", d.getDeviceId()));
			one.setFirstSeen((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(d.getFirstSeenDate()));
			one.setAccountsInCommon(d.getAccountsInCommon());
			one.setOtherAccounts(d.getOtherAccounts());
			one.setAssociatedAccounts(d.getAssociatedDevices());

			// for(AssociatedDevicesInfo t : assList) {
			// if(t.getDeviceId() == d.getId().intValue()) {
			// one.setAssociatedAccounts(t.getAssociatedAccounts());
			// break;
			// }
			// }
			// Get Associated Accounts
			// TransactionExample example = new TransactionExample();
			// example.
			// example.createCriteria().andDeviceIdEqualTo(d.getId());
			// //example.setDistinct(true);
			// one.setAssociatedAccounts(TransactionDao.selectByExample(example).size());
			// Get Associated Devices

			l.add(one);
		}
		out.setDeviceList(l);
		return out;
	}
	
}
