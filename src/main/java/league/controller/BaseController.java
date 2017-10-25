package league.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import league.util.CSRFTokenManager;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
	private static Logger logger = Logger.getLogger(BaseController.class);
	
	protected String validateCSRFToken(HttpServletRequest request, HttpSession session) {
		String CSRFToken = (String)request.getAttribute("CSRFToken");
	        if(CSRFToken == null || !CSRFToken.equals(session.getAttribute(CSRFTokenManager.CSRF_TOKEN_FOR_SESSION_ATTR_NAME).toString())){
	                logger.debug("CSRF attack detected.");
	                return "redirect:/login.form";
	        } 
	                
	    //Delete region name=@name....
	        
	    return "redirect:/region.html";
	}
	
	@ExceptionHandler({ RuntimeException.class })  
    public String exception(RuntimeException e) {  
        //
		logger.error("Exception happened!", e);
        return "/error";  
    }  
}
