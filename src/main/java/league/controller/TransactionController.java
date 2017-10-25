package league.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import league.ViewBean.CheckReputationInBean;
import league.ViewBean.TransactionListAjaxInBean;
import league.ViewBean.TransactionListAjaxOutBean;
import league.ViewBean.TransactionListInBean;
import league.model.Group;
import league.service.IDeviceService;
import league.service.ITransactionService;
import league.service.IUserService;
import league.util.SecurityUtil;
import league.util.ValidationUtil;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
public class TransactionController extends BaseController {
	private static Logger logger = Logger.getLogger(TransactionController.class);

	@Resource
	private IUserService userService;
	
//	@Autowired
//	private LoginDelegate loginDelegate;
//	
//	@Autowired
//	private CheckReputationDelegate checkReputationDelegate;
	
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
	
	/**
	 * Transaction List page initialization
	 * 
	 * @param request
	 * @param response
	 * @param transactionListInBean
	 * @param session
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/TransactionList", method = RequestMethod.GET)
	public ModelAndView doTransactionList(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("transactionListInBean") TransactionListInBean transactionListInBean, HttpSession session) throws SQLException {
		logger.debug("doTransactionList");
		
		ModelAndView model = null;
		
		model = new ModelAndView("main");
		model.addObject("content", "transactionList");
		
		return model;
	}
	
	/**
	 * Obtain Transaction List by AJAX 
	 * 
	 * @param request
	 * @param response
	 * @param inBean
	 * @param session
	 * @return
	 * @throws SQLException
	 */
//	@RequestMapping(value = "/TransactionListAjax", method = RequestMethod.POST)
//	public @ResponseBody TransactionListAjaxOutBean doTransactionListAjax(HttpServletRequest request, HttpServletResponse response,
//			@ModelAttribute("transactionListAjaxInBean") TransactionListAjaxInBean inBean, HttpSession session) throws SQLException {
//		logger.debug("doTransactionListAjax");
//		
//		logger.debug(inBean);
//		inBean.setStart("0");
//		TransactionListAjaxOutBean ret = transactionService.getTransactionList(inBean, session);
//		
//		return ret;
//	}
	 
	@RequestMapping(value = "/TransactionListAjax", method = RequestMethod.POST)
	public @ResponseBody TransactionListAjaxOutBean doTransactionListAjax(@RequestBody TransactionListAjaxInBean inBean, HttpServletResponse response,
			HttpSession session) throws SQLException {
		logger.debug("doTransactionListAjax");

		logger.debug(inBean);
		inBean.setStart("0");
		TransactionListAjaxOutBean ret = transactionService.getTransactionList(inBean, session);

		return ret;
	}
	
	/**
	 * AJAX function to load TransactionList in "Recent Transaction" page
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/TransactionListAjax2", method = RequestMethod.POST)
	public @ResponseBody String doTransactionListAjax2(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws SQLException {
		logger.debug("doTransactionListAjax2");
		
		String msg = "";
		if(request.getParameter("accountName") != null ) {
			msg = "accountName=" + request.getParameter("accountName");
		} else if(request.getParameter("deviceId") != null ) {
			msg = "deviceId=" + request.getParameter("deviceId");
		}
		transactionService.setHistoryRecord("doTransactionListAjax2", msg, session);
//
//		logger.debug(inBean);
//		inBean.setStart("0");
		TransactionListAjaxInBean inBean = new TransactionListAjaxInBean();
		inBean.setCount(request.getParameter("jtPageSize"));
		inBean.setStart(request.getParameter("jtStartIndex"));
		inBean.setSort("");
		inBean.setMaxCount(request.getParameter("maxCount") == null ? "300" : request.getParameter("maxCount"));
		if(request.getParameter("accountName") != null ) {
			inBean.setAccountName(request.getParameter("accountName"));
		} else if(request.getParameter("deviceId") != null ) {
			inBean.setDeviceId(request.getParameter("deviceId"));
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		// Check validation
		if (!ValidationUtil.IsNumeric(inBean.getMaxCount()) || !ValidationUtil.IsNumeric(inBean.getCount()) || !ValidationUtil.IsNumeric(inBean.getStart())) {
			map.put("Result", "ERROR");
			map.put("Message", "Data Validation failed.");
			return JSON.toJSONString(map);
		}
		
		TransactionListAjaxOutBean ret = transactionService.getTransactionList(inBean, session);
		if(ret.getMsg() == null || ret.getMsg().isEmpty()) {
			map.put("Result", "OK");
			map.put("Records", ret.getResult());
			map.put("TotalRecordCount", ret.getCount());
			return JSON.toJSONString(map);
		} else {
			map.put("Result", "ERROR");
			map.put("Message", ret.getMsg());
		}
//
		return JSON.toJSONString(map);
	}
	
	/**
	 * Receive and Process "CheckReputation" Request
	 * 
	 * @param request
	 * @param response
	 * @param checkBean
	 * @param session
	 * @throws SQLException
	 */
	@RequestMapping(value = "/CheckReputation", method = RequestMethod.POST)
	public void executeCheckReputation(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("checkReputationInBean") CheckReputationInBean checkBean, HttpSession session)
			throws SQLException {
		logger.debug("executeCheckReputation");
	
		String retJson = transactionService.doCheckReputation(checkBean, session);
	
		PrintWriter outResp = null;  
		response.setContentType("application/json"); 
		try {  
			outResp = response.getWriter();  
			outResp.write(retJson);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		
	}
	
	/**
	 * Check user's validity
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public Group getValidSubmitAccount(String username, String password) throws SQLException {
		String mask = "md5&&%%";
		String md5Pass = SecurityUtil.getMD5(password + mask);

		return transactionService.getValidSubmitAccount(username, md5Pass);
	}

}
