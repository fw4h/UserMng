package com.user.mng.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.mng.dao.UserDAO;
import com.user.mng.dto.UserDTO;
import com.user.mng.pojo.User;

@Service
public class LoginService {

	@Autowired
	private UserDAO userDAO;

	public UserDTO validateUser(String username, String password) {
		User user = new User();
		user = userDAO.getUserByUsernameAndPassword(username, password);

		if (user == null) {
			return null;
		} else {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(user, userDTO);
			return userDTO;
		}
	}

}
