package league.dao;

import java.util.List;
import league.model.History;
import league.model.HistoryExample;
import org.apache.ibatis.annotations.Param;

public interface HistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbggenerated
     */
    int countByExample(HistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbggenerated
     */
    int deleteByExample(HistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbggenerated
     */
    int insert(History record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbggenerated
     */
    int insertSelective(History record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbggenerated
     */
    List<History> selectByExample(HistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbggenerated
     */
    History selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") History record, @Param("example") HistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") History record, @Param("example") HistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(History record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(History record);
}