package league.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import league.ViewBean.LoginBean;
import league.delegate.LoginDelegate;
import league.model.UserT;
import league.service.ITransactionService;
import league.service.IUserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class UserController extends BaseController {
	private static Logger logger = Logger.getLogger(UserController.class);

	@Resource
	private IUserService userService;
	
	@Resource
	private ITransactionService transService;

//	@Autowired
//	private LoginDelegate loginDelegate;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		logger.debug("toIndex");
		int userId = Integer.parseInt(request.getParameter("id"));
		UserT user = this.userService.getUserById(userId);
		//UserT user = this.userService.getUserByAge();
		model.addAttribute("user", user);
		return "showUser";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("displayLogin");
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean") LoginBean loginBean, HttpSession session)
			throws SQLException {
		logger.debug("executeLogin");
		ModelAndView model = null;

//		UserT user = loginDelegate.getValidUser(loginBean.getUsername(), loginBean.getPassword());
//		if (user != null) {
//			request.setAttribute("loggedInUser", user.getUserFullname());
//			session.setAttribute("user", user);
//			model = new ModelAndView("main");
//		} else {
//			model = new ModelAndView("login");
//			request.setAttribute("message", "Unauthorized User!");
//		}

		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView executeLogout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException {
		logger.debug("executeLogout");
		transService.setHistoryRecord("executeLogout", "", session);
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		session.removeAttribute("user");
		return model;
	}
	
	@RequestMapping(value = "/testAngularJS", method = RequestMethod.GET)
	public ModelAndView displayTestAngularJS(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("displayLogin");
		ModelAndView model = new ModelAndView("testAngularJS");
//		LoginBean loginBean = new LoginBean();
//		model.addObject("loginBean", loginBean);
		return model;
	}
	
//	@RequestMapping("/showUser")
//	public String toIndex(HttpServletRequest request, Model model) {
//		int userId = Integer.parseInt(request.getParameter("id"));
//		LoginBusiness loginBusiness = new LoginBusiness();
//		UserT user = loginBusiness.getUserInfo(userId);
//		//UserT user = this.userService.getUserById(userId);
//		model.addAttribute("user", user);
//		return "showUser";
//	}
}
