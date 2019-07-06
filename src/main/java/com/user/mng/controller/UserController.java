package com.user.mng.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.mng.dto.UserDTO;
import com.user.mng.service.UserService;

@Controller
public class UserController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "docreate.html", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("userDTO") UserDTO userDTO, Model model, HttpSession session) {
		try {			
				userService.createUser(userDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "index.jsp";
	}

	@RequestMapping(value = "doupdate.html", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("userDTO") UserDTO userDTO, Model model, HttpSession session) {
		try {
			if (userDTO.getId() == null) {
				userService.createUser(userDTO);
			} else {
				userService.updateUser(userDTO);
			}
			UserDTO userDTOBlank = new UserDTO();
			model.addAttribute("userDTO",userDTOBlank);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			showUserList(model, session);
		}
		return "dashboard.jsp";
	}

	@RequestMapping(value = "dodelete.html")
	public String deleteUser(@RequestParam("id") Integer id, Model model, HttpSession session) {
		userService.deleteUserById(id);
		showUserList(model, session);
		UserDTO userDTO = new UserDTO();
		model.addAttribute("userDTO", userDTO);
		return "dashboard.jsp";
	}

	@RequestMapping(value = "dodisplay.html")
	public String displayUser(@RequestParam("id") Integer id, Model model, HttpSession session) {
		UserDTO userDTO = new UserDTO();
		userDTO = userService.getUserById(id);
		model.addAttribute("userDTO", userDTO);
		showUserList(model, session);
		return "dashboard.jsp";
	}
	
	@RequestMapping(value = "logout.html")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		return "index.jsp";
	}

	public void showUserList(Model model, HttpSession session) {
		List<UserDTO> userList = userService.selectAll();
		model.addAttribute("userList", userList);
	}

}
