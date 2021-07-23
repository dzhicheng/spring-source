package com.dongzhic;

import com.dongzhic.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author dongzhic
 * @Date 7/19/21 11:00 AM
 */
public class Controller {


    @Autowired
    private AreaService areaService;

    public String query1 () {
        return areaService.queryAreaFromRedisOne(null);
    }

    public String query2 () {
        return areaService.queryAreaFromRedisTow(null);
    }
}
