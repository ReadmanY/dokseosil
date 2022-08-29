package com.acon.dokseo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.acon.dokseo.dto.DuplicateCheckAjaxRes;
import com.acon.dokseo.dto.User;
import com.acon.dokseo.mapper.UserMapper;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/login")
	public void login() {};
	@PostMapping("/login.do")
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
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		if(session.getAttribute("loginUser")!=null) {
			session.invalidate();
		}
		return "redirect:/";
		
	}
	
	@GetMapping("/signUp")
	public void signUp() {};
	
	@PostMapping("/signUp.do")
	public String signUp(@ModelAttribute User user,HttpSession session) {
		int insert=0;
		try {
			insert=userMapper.insertOne(user);
		} catch (Exception e) {e.printStackTrace();}
		if(insert>0) {
			session.setAttribute("msg", "회원가입에 성공했습니다. 로그인 해주세요.");
			return "redirect:/";
		}else {
			return "redirect:/user/signUp";
		}
	}
	
	
	
	//-------------------Ajax--------------------
	
	@GetMapping("/idAjax/{userId}")
	public @ResponseBody DuplicateCheckAjaxRes idAjax(@PathVariable String userId) {
		DuplicateCheckAjaxRes duplicateCheckAjaxRes=new DuplicateCheckAjaxRes();
		User user=userMapper.selectOneById(userId);
		if(user==null) {
			duplicateCheckAjaxRes.setCanIUse(true);
		}
		return duplicateCheckAjaxRes;
	}
	
	@GetMapping("/emailAjax/{userEmail}")
	public @ResponseBody DuplicateCheckAjaxRes emailAjax(@PathVariable String userEmail) {
		DuplicateCheckAjaxRes duplicateCheckAjaxRes=new DuplicateCheckAjaxRes();
		User user=userMapper.selectOneByEmail(userEmail);
		if(user==null) {
			duplicateCheckAjaxRes.setCanIUse(true);
		}
		return duplicateCheckAjaxRes;
	}
	
	//-------------------Ajax--------------------
}
