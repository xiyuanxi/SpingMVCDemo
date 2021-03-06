package league.dao;

import java.util.List;
import league.model.UserT;
import league.model.UserTExample;
import org.apache.ibatis.annotations.Param;

public interface UserTMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_t
	 * @mbggenerated
	 */
	int countByExample(UserTExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_t
	 * @mbggenerated
	 */
	int deleteByExample(UserTExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_t
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_t
	 * @mbggenerated
	 */
	int insert(UserT record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_t
	 * @mbggenerated
	 */
	int insertSelective(UserT record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_t
	 * @mbggenerated
	 */
	List<UserT> selectByExample(UserTExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_t
	 * @mbggenerated
	 */
	UserT selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_t
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") UserT record, @Param("example") UserTExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_t
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") UserT record, @Param("example") UserTExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_t
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(UserT record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_t
	 * @mbggenerated
	 */
	int updateByPrimaryKey(UserT record);
}