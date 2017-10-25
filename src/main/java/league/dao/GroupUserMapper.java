package league.dao;

import java.util.List;
import league.model.GroupUser;
import league.model.GroupUserExample;
import org.apache.ibatis.annotations.Param;

public interface GroupUserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_user
	 * @mbggenerated
	 */
	int countByExample(GroupUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_user
	 * @mbggenerated
	 */
	int deleteByExample(GroupUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_user
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_user
	 * @mbggenerated
	 */
	int insert(GroupUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_user
	 * @mbggenerated
	 */
	int insertSelective(GroupUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_user
	 * @mbggenerated
	 */
	List<GroupUser> selectByExample(GroupUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_user
	 * @mbggenerated
	 */
	GroupUser selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_user
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") GroupUser record, @Param("example") GroupUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_user
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") GroupUser record, @Param("example") GroupUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_user
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(GroupUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_user
	 * @mbggenerated
	 */
	int updateByPrimaryKey(GroupUser record);
}