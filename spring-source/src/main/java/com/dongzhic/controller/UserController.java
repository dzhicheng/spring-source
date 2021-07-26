package com.dongzhic.controller;

import com.alibaba.fastjson.JSONObject;
import com.dongzhic.pojo.ConsultConfigArea;
import com.dongzhic.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author dongzhic
 * @Date 7/21/21 3:37 PM
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("/queryUser")
    public String queryUser(@RequestParam(required = false) String language, HttpSession session) {
        session.setAttribute("language",language);
        return "ok";
    }

    @RequestMapping("/exceptionTest")
    public @ResponseBody String exceptionTest(String param) {
        param.equalsIgnoreCase("xx");
        return "Ok";
    }

    /**
     *  解决跨域方式三： @CrossOrigin注解
     * @param areaCode
     * @return
     */
//    @CrossOrigin(origins = "*"
//        ,allowedHeaders = "x-requested-with"
//        ,allowCredentials = "true"
//        ,maxAge = 3600
//        ,methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.DELETE})
    @RequestMapping("/queryArea")
    public @ResponseBody
    List<ConsultConfigArea> queryArea(@RequestParam(required = false) String areaCode) {
        Map map = new HashMap<>();
        map.put("areaCode",areaCode);
        return areaService.queryAreaFromDB(map);
    }


    @RequestMapping("/queryAreaJs")
    public @ResponseBody String queryAreaJs(@RequestParam(required = false) String areaCode,@RequestParam String callback) {
        Map map = new HashMap<>();
        map.put("areaCode",areaCode);

        List<ConsultConfigArea> areas = areaService.queryAreaFromDB(map);
        return callback + "(" + JSONObject.toJSONString(areas) + ");";
    }
}
