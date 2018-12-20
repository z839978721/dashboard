package com.cloud.app.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.aspect.Result;
import com.cloud.aspect.ResultHandle;
import com.cloud.aspect.ResultUtil;

@RestController
@RequestMapping(value = {"/user"})
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ResultHandle resultHandle;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/findAll"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public Result getAllUsers(){
        Result result = ResultUtil.success();
        List list =  userService.findAllUser();
        result = ResultUtil.success(list);
        return result;
    }
    
}
