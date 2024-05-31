package com.dualdb.dualdbdemo.service;

import java.util.List;

import com.dualdb.dualdbdemo.usermodel.User;

public interface UserService {

	List<User> getAllUsers();

	User saveUser(User user);

	User getProductsByUser(int userId);

}
