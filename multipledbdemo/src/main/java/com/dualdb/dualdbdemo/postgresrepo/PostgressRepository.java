package com.dualdb.dualdbdemo.postgresrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dualdb.dualdbdemo.productmodel.Product;

public interface PostgressRepository extends JpaRepository<Product, Integer>{
	
	public List<Product> findAllByUserId(int userId);

}
