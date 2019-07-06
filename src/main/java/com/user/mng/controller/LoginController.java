package com.user.mng.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.mng.dto.UserDTO;
import com.user.mng.service.LoginService;
import com.user.mng.service.UserService;

@Controller
public class LoginController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "login.html")
	public String goToLoginPage() {
		return "index.jsp";
	}

	@RequestMapping(value = "validateUser.html", method = RequestMethod.POST)
	public String validateUser(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpSession session) throws Exception {
		UserDTO userDTO = loginService.validateUser(username, password);
		if (userDTO == null) {
			return "index.jsp";
		} else {
			showUserList(model, session);
			UserDTO blankUserDTO = new UserDTO();
			model.addAttribute("userDTO", blankUserDTO);
			session.setAttribute("isLogin", "true");
			return "dashboard.jsp";
		}
	}

	public void showUserList(Model model, HttpSession session) {
		List<UserDTO> userList = new ArrayList<UserDTO>();
		userList = userService.selectAll();
		model.addAttribute("userList", userList);
	}
}
