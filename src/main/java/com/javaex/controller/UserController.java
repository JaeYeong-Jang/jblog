package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/user/loginForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("[UserController.loginForm()]");
		
		return "user/loginForm";
	}
	
	@RequestMapping(value="/user/joinForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("[UserController.joinForm()]");
		
		return "user/joinForm";
	}
	
	@RequestMapping(value="/user/join", method = {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("[userController.join()]");
		
		int count = userService.join(userVo);
		
		System.out.println(count + "건 아이디 생성 완료");
		
		return "";
	}
	
	//id중복체크
	@ResponseBody
	@RequestMapping(value="/user/chkId", method = {RequestMethod.GET, RequestMethod.POST})
	public boolean chkId(@RequestParam("id")String id) {
		System.out.println("[UserController.chkId()]");

		boolean state = userService.idChk(id);
		
		return state;
	}
	
}
