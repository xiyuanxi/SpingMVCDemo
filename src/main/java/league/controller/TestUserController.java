package league.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import league.ViewBean.LoginBean;
import league.model.Group;
import league.model.GroupUser;
import league.service.ITransactionService;
import league.service.IUserService;
import league.util.CSRFTokenManager;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author harvey.zhao
 *
 */
@Controller
@RequestMapping("/")
public class TestUserController extends BaseController {
	private static Logger logger = Logger.getLogger(TestUserController.class);

	@Resource
	private IUserService userService;
	
	@Resource
	private ITransactionService transService;
	
	@RequestMapping(value = {"/TestLogin", "/"}, method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		logger.debug("displayLogin");
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		model.addObject("csrf", CSRFTokenManager.getTokenForSession(session));
		session.removeAttribute("user");
		return model;
		//return "login";
	}
	
	@RequestMapping(value = "/TestLogin", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean") LoginBean loginBean, HttpSession session)
			throws SQLException {
		logger.debug("executeLogin");
		ModelAndView model = null;

		session.setAttribute("userip", request.getRemoteAddr());
		GroupUser groupUser = transService.getValidLoginAccount(loginBean.getUsername(), loginBean.getPassword(), session);
		if (groupUser != null) {
			// request.setAttribute("loggedInUser", user.getUserFullname());
//			session.setAttribute("user", groupUser);
			model = new ModelAndView("main");
			model.addObject("content", "transactionList");
			//model.addObject("loggedInUser", account.getDisplayUserName() + "[" + account.getDisplayCompanyName() + "]");
		} else {
			model = new ModelAndView("testLogin");
			request.setAttribute("message", "Unauthorized User!");
		}

		return model;
	}

	@RequestMapping(value = "/TestLogout", method = RequestMethod.GET)
	public ModelAndView executeLogout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException {
		logger.debug("executeLogout");
		transService.setHistoryRecord("executeLogout", "", session);
		ModelAndView model = new ModelAndView("testLogin");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		session.removeAttribute("user");
		return model;
	}

}
