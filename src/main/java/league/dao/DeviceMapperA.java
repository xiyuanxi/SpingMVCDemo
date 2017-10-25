package league.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import league.model.AssociatedDevicesInfo;
import league.model.Device;

public interface DeviceMapperA {
 
    /**
     * Get AssociatedDevicesInfo list by account name and group id
     * 
     * @param group_id
     * @param account_name
     * @return
     */
    List<AssociatedDevicesInfo> selectDeviceListByTransactionAccountName(@Param(value = "group_id") int group_id, @Param(value = "account_names") List<String> account_names);
   
}