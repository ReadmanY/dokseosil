package com.acon.dokseo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acon.dokseo.dto.User;
import com.acon.dokseo.mapper.UserMapper;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/login")
	public void login() {};
	@PostMapping("/login")
	public String login(@ModelAttribute User user,HttpSession session) {
		User loginUser=userMapper.selectOneForLogin(user.getUser_id(), user.getUser_pw());
		if(loginUser!=null) {
			session.setAttribute("loginUser", loginUser);
			return "redirect:/";
		}else {
			session.setAttribute("msg", "로그인 실패! 해당하는 ID가 없거나 패스워드가 잘못되었습니다.");
			return "redirect:/";
		}
	}
	
	@GetMapping("/signUp")
	public void signUp() {};
}
