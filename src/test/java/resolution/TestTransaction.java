package resolution;

import java.sql.SQLException;

import javax.annotation.Resource;

import league.ViewBean.CheckReputationInBean;
import league.ViewBean.UploadPackageDetailBean;
import league.delegate.CheckReputationDelegate;
import league.delegate.LoginDelegate;
import league.model.UserT;
import league.service.IUserService;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  

public class TestTransaction {
    private static Logger logger = Logger.getLogger(TestTransaction.class);  
//  private ApplicationContext ac = null;  
   
    
    @Resource
    private CheckReputationDelegate checkDelegate = null;
    
    
  
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
  
//    @Test  
//    public void test1() {  
//        UserT user = userService.getUserById(1);  
//        // System.out.println(user.getUserName());  
//        // logger.info("值："+user.getUserName());  
//        logger.info(JSON.toJSONString(user));  
//    }  
//    @Test  
//    public void test2() {  
//        UserT user = userService.getUserByAge();  
//        logger.info(JSON.toJSONString(user));  
//    }  
    
	@Test
	public void test1() throws SQLException {
//		Account account = checkDelegate.getValidSubmitAccount("test_harvey", "abcd");
//		logger.info("check reputation is " + (account != null));
//		
		String tt = "{\"USAG\":\"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.97 Safari/537.36\",\"BS\":\"Chrome\",\"BSVS\":\"48.0.2564.97\",\"FLSVER\":\"20.0.0\",\"BSLA\":\"en-US\",\"CXEB\":true,\"OS\":\"Windows NT 6.1\",\"TZON\":300,\"SCNRES\":\"1080:1920\",\"DVID\":\"kIOhlUqlLGIHjoeOuy0mf6agEfaLlazu\",\"FNSCODE\":\"DACB9EA1BC124BB5439ADC68A3DEC8D0\"}";
		
		UploadPackageDetailBean in = JSON.parseObject(tt, UploadPackageDetailBean.class);
		
		//CheckReputationDelegate checkReputationDelegate = new CheckReputationDelegate();
		
		CheckReputationInBean checkBean = new CheckReputationInBean();
		checkBean.setSubmitName("test_harvey");
		checkBean.setSubmitPassword("abcd");
		checkBean.setClientIp("108.63.10.178");
		checkBean.setClientName("harvey_test_account");
		checkBean.setRules("login_rule");
		checkBean.setUploadPackaging(tt);
		
		//checkDelegate.doCheckReputation(checkBean , null);
	}
   
}
