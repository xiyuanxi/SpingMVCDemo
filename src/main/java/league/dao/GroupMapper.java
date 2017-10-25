package league.dao;

import java.util.List;
import league.model.Group;
import league.model.GroupExample;
import org.apache.ibatis.annotations.Param;

public interface GroupMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group
	 * @mbggenerated
	 */
	int countByExample(GroupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group
	 * @mbggenerated
	 */
	int deleteByExample(GroupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group
	 * @mbggenerated
	 */
	int insert(Group record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group
	 * @mbggenerated
	 */
	int insertSelective(Group record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group
	 * @mbggenerated
	 */
	List<Group> selectByExample(GroupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group
	 * @mbggenerated
	 */
	Group selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Group record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Group record);
}