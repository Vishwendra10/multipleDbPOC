package com.dualdb.dualdbdemo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dualdb.dualdbdemo.postgresrepo.PostgressRepository;
import com.dualdb.dualdbdemo.productmodel.Product;
import com.dualdb.dualdbdemo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private PostgressRepository postgressRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return postgressRepository.findAll();
	}
	@Override
	public Product saveProduct(Product product) {
		Product productResponse= postgressRepository.save(product);
		return productResponse;
	}

}
