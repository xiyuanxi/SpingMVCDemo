package league.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import league.ViewBean.AssociatedAccountAjaxOutBean;
import league.ViewBean.AssociatedAccountAjaxOutOneBean;
import league.ViewBean.AssociatedDeviceAjaxOutBean;
import league.ViewBean.AssociatedDeviceAjaxOutOneBean;
import league.model.TransactionExample;
import league.service.IDeviceService;
import league.service.ITransactionService;
import league.util.ValidationUtil;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

/**
 * @author harvey.zhao
 *
 */
@Controller
@RequestMapping("/")
public class SearchController extends BaseController {
	private static Logger logger = Logger.getLogger(SearchController.class);
	
	@Resource
	private IDeviceService deviceService;
	
	@Resource
	private ITransactionService transactionService;
	
	@RequestMapping(value = "/SimpleSearch", method = RequestMethod.GET)
	public ModelAndView initSimpleSearch(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		logger.debug("initSimpleSearch");
		
		ModelAndView model = new ModelAndView("main");
		model.addObject("content", "simpleSearch");
		if (request.getParameter("Transction") != null) {
			model.addObject("function", "Transction");
//			model.addObject("actionName", "deviceDetail");
//			model.addObject("parameterName", "account");
		} else if (request.getParameter("Device") != null) {
			model.addObject("function", "Device");
			model.addObject("paraName", "deviceId");
			model.addObject("actionName", "deviceDetail");
			model.addObject("parameterName", "device");
		} else if (request.getParameter("Account") != null) {
			model.addObject("function", "Account");
			model.addObject("paraName", "account");
			model.addObject("actionName", "accountDetail");
			model.addObject("parameterName", "account");
		} else {
			model.addObject("content", "welcome");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/SimpleSearch", method = RequestMethod.POST)
	public ModelAndView doSimpleSearch(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws SQLException {
		logger.debug("doSimpleSearch");
		
		ModelAndView model = new ModelAndView("main");
		String fun = request.getParameter("function");
		String val = request.getParameter("search_val");
		
		if (fun.equals("Device")) {
			model.addObject("content", "deviceDetail");
		} else if (fun.equals("Account")) {
			model.addObject("content", "accountDetail");
		} else {
			model.addObject("content", "welcome");
		}
		
		transactionService.setHistoryRecord("doSimpleSearch", "function=" + fun + " search_val=" + val, session);
		
		return model;
	}
	
	@RequestMapping(value = "/deviceDetail", method = RequestMethod.GET)
	public ModelAndView initDeviceDetail(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws SQLException {
		logger.debug("initDeviceDetail");
		ModelAndView model = new ModelAndView("main");
		//Input data validation check
		if (!ValidationUtil.IsNumeric(request.getParameter("deviceId"))) {
			model.addObject("errMessage", "Data Validation Failed.");
			//return null;
		}
		
		model.addObject("content", "deviceDetail");

		transactionService.setHistoryRecord("initDeviceDetail", "deviceId=" + request.getParameter("deviceId"), session);
		
		return model;
	}
	
	@RequestMapping(value = "/accountDetail", method = RequestMethod.GET)
	public ModelAndView initAccountDetail(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws SQLException {
		logger.debug("initAccountDetail");
		
		String accountName = request.getParameter("account");
		logger.debug("account name="+accountName);
		
		ModelAndView model = new ModelAndView("main");
		
		// Input data validation check
		if (!ValidationUtil.IsAccountName(accountName)) {
			model.addObject("errMessage", "Data Validation Failed.");
			// return null;
		}
		
		model.addObject("content", "accountDetail");

		transactionService.setHistoryRecord("initAccountDetail", "accountName=" + accountName, session);
		
		return model;
	}
	
	
	/**
	 * Get Device List according to Account
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/AssociatedDevicesAjax", method = RequestMethod.POST)
	public @ResponseBody String doAssociatedDevicesAjax(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException {
		logger.debug("doAssociatedDevicesAjax");
		
		String accountName = request.getParameter("account_name");
		
		transactionService.setHistoryRecord("doAssociatedDevicesAjax", "accountName=" + accountName, session);
		
		List<String> accountList = new ArrayList<String>();
		if(accountName != null) {
			accountList.add(accountName);
		} else {
			List<AssociatedAccountAjaxOutOneBean> accounts = (List<AssociatedAccountAjaxOutOneBean>) session.getAttribute("account_list"); 
			for(AssociatedAccountAjaxOutOneBean a:accounts) {
				accountList.add(a.getAccountName());
			}
		}
		AssociatedDeviceAjaxOutBean ret = deviceService.getDeviceListByTransactionAccountName(accountList, session);
		session.setAttribute("device_list", ret.getDeviceList());
		Map<String,Object> map = new HashMap<String, Object>();
		if(ret.getMsg() == null || ret.getMsg().isEmpty()) {
			map.put("Result", "OK");
			map.put("Records", ret.getDeviceList());
			map.put("TotalRecordCount", ret.getDeviceList().size());
			return JSON.toJSONString(map);
		} else {
			map.put("Result", "ERROR");
			map.put("Message", ret.getMsg());
		}
		return JSON.toJSONString(map);
	}
	
	/**
	 * Obtain user list based on the device list
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/AssociatedAccountsAjax", method = RequestMethod.POST)
	public @ResponseBody String doAssociatedAccountAjax(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException {
		logger.debug("doAssociatedAccountAjax");
		
		String deviceId = request.getParameter("device_id");
		
		transactionService.setHistoryRecord("doAssociatedAccountAjax", "deviceId=" + deviceId, session);
		
		// Obtain device id list from session which created by /AssociatedDevicesAjax
		List<AssociatedDeviceAjaxOutOneBean> deviceList = (List<AssociatedDeviceAjaxOutOneBean>) session.getAttribute("device_list"); 
		
		List<Integer> deviceIds = new ArrayList<Integer>();
		if(deviceId != null ) {
			// From "Device Detail"?
			deviceIds.add(Integer.valueOf(deviceId));
		} else if (deviceList != null) {
			// From "Account Detail"?
			for (AssociatedDeviceAjaxOutOneBean d : deviceList) {
				// deviceIds+= Integer.valueOf(d.getDeviceId()).toString()+",";
				deviceIds.add(Integer.valueOf(d.getDeviceId()));
			}
		}
		
//		if (deviceIds.length() > 0) {
//			deviceIds = deviceIds.substring(0, deviceIds.length() - 1);
//		}
	
		AssociatedAccountAjaxOutBean ret = transactionService.getAccountListByTransactionDevices(deviceIds, session);
		
		session.setAttribute("account_list", ret.getAccountList());
		Map<String,Object> map = new HashMap<String, Object>();
		if(ret.getMsg() == null || ret.getMsg().isEmpty()) {
			map.put("Result", "OK");
			map.put("Records", ret.getAccountList());
			map.put("TotalRecordCount", ret.getAccountList().size());
			return JSON.toJSONString(map);
		} else {
			map.put("Result", "ERROR");
			map.put("Message", ret.getMsg());
		}
		return "";
	}
}
