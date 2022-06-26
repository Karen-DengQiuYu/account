package com.cetc10.hjj.task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginCtrl {


	@GetMapping("/set")
	public boolean set(HttpSession session) {
		session.setAttribute("user", "java");
		return true;
	}

	@GetMapping("/get")
	public String get(HttpSession session) {
		return String.valueOf(session.getAttribute("user"));
	}
	
	@GetMapping("/logout")
	public  String  logout(HttpSession session) {
		session.invalidate();
		return "退出登录";
	}
	
	@RequestMapping("/invalid")
	public String invalid() {
	    return "Session 已过期，请重新登录";
	}
}
