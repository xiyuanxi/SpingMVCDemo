package league.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import league.dao.UserTMapper;
import league.dao.UserTMapperA;
import league.model.UserT;
import league.model.UserTExample;
import league.service.IUserService;
import league.util.SecurityUtil;

/**
 * @author harvey.zhao
 *
 */
@Service("userService")  
public class UserServiceImpl implements IUserService { 
	@Resource
	private UserTMapper userDao;
	@Resource
	private UserTMapperA userDaoA;

	@Override
	public UserT getUserById(int userId) {

		return this.userDao.selectByPrimaryKey(userId);
	}

	@Override
	public UserT getUserByAge() {

		return this.userDaoA.selectByAge(null).get(0);
	}

	@Override
	public UserT getValidUser(String username, String password) throws SQLException
	{
		String mask = "md5&&%%";
		String md5Pass = SecurityUtil.getMD5(password + mask);
		
		UserTExample example = new UserTExample();
		
		example.createCriteria().andUserNameEqualTo(username).andPasswordEqualTo(md5Pass);
		
		List<UserT> userList = userDao.selectByExample(example); 
		if(userList.size()>0) {
			return userList.get(0);
		}
		return null;
	}
	
}
