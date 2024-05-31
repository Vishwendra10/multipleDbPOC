package com.dualdb.dualdbdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dualdb.dualdbdemo.productmodel.Product;
import com.dualdb.dualdbdemo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/getproducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		
		List<Product> productList = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		
		Product productResponse = productService.saveProduct(product);
		return new ResponseEntity<Product>(productResponse, HttpStatus.OK);
	}

}
