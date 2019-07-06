package com.user.mng.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.mng.dao.UserDAO;
import com.user.mng.dto.UserDTO;
import com.user.mng.pojo.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;

	public UserDTO getUserById(Integer id) {
		UserDTO userDTO = new UserDTO();
		User user = userDAO.getUserById(id);
		BeanUtils.copyProperties(user, userDTO);
		return userDTO;
	}

	public void deleteUserById(Integer id) {
		userDAO.deleteUserById(id);
	}

	public void updateUser(UserDTO userDTO) {
		try {
			User user = new User();
			BeanUtils.copyProperties(userDTO, user);
			userDAO.updateUser(user);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createUser(UserDTO userDTO) {
		try {
			User user = new User();
			BeanUtils.copyProperties(userDTO, user);
			userDAO.createUser(user);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<UserDTO> selectAll() {
		List<User> userList = userDAO.selectAll();
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		for (int i = 0; i < userList.size(); i++) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(userList.get(i), userDTO);
			userDTOList.add(userDTO);
		}
		return userDTOList;
	}
}
