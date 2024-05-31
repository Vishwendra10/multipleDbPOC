package com.dualdb.dualdbdemo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dualdb.dualdbdemo.mysqlrepo.MySqlRepository;
import com.dualdb.dualdbdemo.postgresrepo.PostgressRepository;
import com.dualdb.dualdbdemo.productmodel.Product;
import com.dualdb.dualdbdemo.service.UserService;
import com.dualdb.dualdbdemo.usermodel.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private MySqlRepository mySqlRepository;
	
	@Autowired
	private PostgressRepository postgressRepository;
	
	@Override
	public List<User> getAllUsers() {
		List<User> userList= mySqlRepository.findAll();
		return userList;
	}

	@Override
	public User saveUser(User user) {
		User userResponse = mySqlRepository.save(user);
		return userResponse;
	}

	@Override
	public User getProductsByUser(int userId) {
		User user= mySqlRepository.findById(userId).get();
		List<Product> productListByUser=  postgressRepository.findAllByUserId(userId);
		
		user.setProduct(productListByUser);
		
		return user;
	}

}
