package league.dao;

import java.util.List;
import league.model.UserT;
import league.model.UserTExample;

public interface UserTMapperA {
 
    List<UserT> selectByAge(UserTExample example);

   
}