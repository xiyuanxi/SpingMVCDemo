package league.dao;

import java.util.List;
import league.model.TransDevice;
import league.model.TransDeviceExample;
import org.apache.ibatis.annotations.Param;

public interface TransDeviceMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_device
	 * @mbggenerated
	 */
	int countByExample(TransDeviceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_device
	 * @mbggenerated
	 */
	int deleteByExample(TransDeviceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_device
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_device
	 * @mbggenerated
	 */
	int insert(TransDevice record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_device
	 * @mbggenerated
	 */
	int insertSelective(TransDevice record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_device
	 * @mbggenerated
	 */
	List<TransDevice> selectByExample(TransDeviceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_device
	 * @mbggenerated
	 */
	TransDevice selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_device
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") TransDevice record, @Param("example") TransDeviceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_device
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") TransDevice record, @Param("example") TransDeviceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_device
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(TransDevice record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trans_device
	 * @mbggenerated
	 */
	int updateByPrimaryKey(TransDevice record);
}