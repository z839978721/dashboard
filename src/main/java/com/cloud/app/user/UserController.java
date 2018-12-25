package com.cloud.app.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.aspect.result.Result;
import com.cloud.aspect.result.ResultHandle;
import com.cloud.aspect.result.ResultUtil;

@Controller
@RequestMapping(value = {"/user"})
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ResultHandle resultHandle;

    @Autowired
    private IUserService userService;
    
    @RequestMapping("/whoim")
    @ResponseBody
    public Object whoIm(){
    	return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    
    @RequestMapping(value = {"/findAll"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public Result getAllUsers(){
        Result result = ResultUtil.success();
        List list =  userService.findAllUser();
        result = ResultUtil.success(list);
        return result;
    }
    
}
