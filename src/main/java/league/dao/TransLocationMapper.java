package league.dao;

import java.util.List;
import league.model.TransLocation;
import league.model.TransLocationExample;
import org.apache.ibatis.annotations.Param;

public interface TransLocationMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_location
	 * @mbggenerated
	 */
	int countByExample(TransLocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_location
	 * @mbggenerated
	 */
	int deleteByExample(TransLocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_location
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_location
	 * @mbggenerated
	 */
	int insert(TransLocation record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_location
	 * @mbggenerated
	 */
	int insertSelective(TransLocation record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_location
	 * @mbggenerated
	 */
	List<TransLocation> selectByExample(TransLocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_location
	 * @mbggenerated
	 */
	TransLocation selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_location
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") TransLocation record, @Param("example") TransLocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_location
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") TransLocation record, @Param("example") TransLocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_location
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(TransLocation record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_location
	 * @mbggenerated
	 */
	int updateByPrimaryKey(TransLocation record);
}