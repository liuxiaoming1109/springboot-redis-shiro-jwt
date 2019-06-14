package com.evan.api.controller;

import com.evan.common.model.ResultModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuxm on 2019/6/14.
 */
@Log
@Api(tags = "测试API")
@RestController
@RequestMapping("test")
public class TestController {

    @ApiOperation(value="测试", notes="测试")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultModel test() {
        Map<String, String> map = new HashMap();
        map.put("1", "11");
        map.put("2", "22");

        return new ResultModel(map);
    }

}
