package league.delegate;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import league.ViewBean.CheckReputationInBean;
import league.ViewBean.CheckReputationOutBean;
import league.ViewBean.UploadPackageDetailBean;
import league.model.Device;
import league.model.Group;
import league.model.TransDevice;
import league.model.TransLocation;
import league.model.Transaction;
import league.service.IDeviceService;
import league.service.ITransactionService;
import league.util.SecurityUtil;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

@Repository
public class CheckReputationDelegate {
	@Resource
	private IDeviceService deviceService;
	
	@Resource
	private ITransactionService transactionService;

	public ITransactionService getTransactionService() {
		return this.transactionService;
	}

	public void setTransactionService(ITransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
//	/**
//	 * 检查submit用户的合法性
//	 * 
//	 * @param username
//	 * @param password
//	 * @return
//	 * @throws SQLException
//	 */
//	public Account getValidSubmitAccount(String username, String password) throws SQLException {
//		String mask = "md5&&%%";
//		String md5Pass = SecurityUtil.getMD5(password + mask);
//
//		return transactionService.getValidSubmitAccount(username, md5Pass);
//	}
	
//	/**
//	 * 接受submit数据，并返回check结果的json字串
//	 * 
//	 * @param checkBean
//	 * @param session
//	 * @return
//	 * @throws SQLException
//	 */
//	public String doCheckReputation(CheckReputationInBean checkBean, HttpSession session) throws SQLException {
//		// 返回结果
//		CheckReputationOutBean out = new CheckReputationOutBean();
//		
//		int ret = 0;
//		//检查submit用户的合法性
//		Group account = getValidSubmitAccount(checkBean.getSubmitName(), checkBean.getSubmitPassword());
//		if (account == null) {
//			out.setResult("AccountFail");
//			out.setMessage("Submit account doesn't exist.");
//		} else {
//			int deviceId;
//			// 解析uploadPackaging信息json
//			UploadPackageDetailBean in = JSON.parseObject(checkBean.getUploadPackaging(), UploadPackageDetailBean.class);
//			if(in.getDVID() == null || in.getDVID().isEmpty()) {
//				return "";
//			}
//			// 检查此设备在device表里是否存在
//			Device dev = deviceService.getDeviceByBBID(in.getDVID());
//			if (dev != null) {
//				// 如存在，则取得 device id
//				deviceId = dev.getId();
//			} else {
//				// 若不存在，则插入一个新的 device，并取得device id
//				Device device = new Device();
//				device.setBbGuid(in.getDVID());
//				device.setFontsCode(in.getFNSCODE());
//				ret = deviceService.insertDevice(device);
//				deviceId = device.getId();
//			}
//			// 在transaction表里插入当前数据
//			Transaction trans = new Transaction();
//			trans.setAccountId(account.getId());
//			trans.setDeviceId(deviceId);
//			trans.setCheckName(checkBean.getClientName());
//			// TODO
//			// trans.setRuleSetId(checkBean.getRules());
//			trans.setRuleSetId(1);
//			trans.setRuleCheckResult("true");
//			trans.setResult((short) 1);
//			ret = transactionService.insertTransaction(trans);
//
//			// 在trans_device表里插入当前数据
//			TransDevice transDevice = new TransDevice();
//			ret /= 0;
//			transDevice.setTransactionId(trans.getId());
//			transDevice.setBrowserLanguage(in.getBSLA());
//			transDevice.setBrowserType(in.getBS());
//			transDevice.setBrowserVersion(in.getBSVS());
//			transDevice.setDeviceType("");
//			transDevice.setFlashEnabled(true);
//			transDevice.setFlashStorageEnabled(true);
//			transDevice.setFlashVersion(in.getFLSVER());
//			transDevice.setOperationSystem(in.getOS());
//			transDevice.setScreenResolution(in.getSCNRES());
//			transDevice.setTimeZone(in.getTZON());
//			ret = transactionService.insertTransDevice(transDevice);
//
//			// 在trans_location表里插入当前数据
//			TransLocation transLocation = new TransLocation();
//			transLocation.setTransactionId(trans.getId());
//			transLocation.setIp(checkBean.getClientIp());
//			// TODO
//			transLocation.setCountryId("CN");
//			transLocation.setCity("test");
//			transLocation.setIsp("ISPTest");
//			transactionService.insertTransLocation(transLocation);
//
//			out.setDeviceId(String.format("%012d", deviceId));
//			out.setResult("Allowed");
//			
//		}
//		
//		return JSON.toJSONString(out);
//	}
}
