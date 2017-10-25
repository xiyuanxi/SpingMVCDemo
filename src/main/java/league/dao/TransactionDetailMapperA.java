package league.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import league.model.AssociatedAccountsInfo;
import league.model.AssociatedDevicesInfo;
import league.model.TransactionDetail;
import league.model.TransactionExample;

public interface TransactionDetailMapperA {
 
    
    /**
     * Search 'Transaction Detail' List, starting from specified position
     * 
     * @param example
     * @param offset
     * @param limit
     * @return
     */
    List<TransactionDetail> selectDetailList(@Param("example") TransactionExample example, @Param("offset") int offset, @Param("limit") int limit);
   
    /**
     * Search 'Transaction Detail' count
     * 
     * @param example
     * @return
     */
    int selectDetailListCount(@Param("example") TransactionExample example,  @Param("maxCount") int maxCount );
    
    /**
     * Get 'Associated Accounts' list by account_name
     * 
     * @param account_name
     * @param account_id
     * @return
     */
    List<AssociatedDevicesInfo> selectAssociatedAccountsByAccountName(@Param("account_name") String account_name, @Param("group_id") int group_id);
    
    
    /**
     * Get AssociatedAccountsInfo List by Device Id list
     * 
     * @param device_ids
     * @param group_id
     * @return
     */
    List<AssociatedAccountsInfo>  selectAllAssociatedAccountsByDeviceIds(@Param("device_ids") List<Integer> device_ids, @Param("group_id") int group_id);
}