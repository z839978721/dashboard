package com.cloud.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping(value = {"/"})
    public String index(){
        
        return "login";
    }
	
	@RequestMapping(value = {"/login"})
    public String login(){
		
        return "login";
    }
	
	@RequestMapping(value = {"/hello"})
    public String hello(){
		
        return "hello";
    }
	
}
