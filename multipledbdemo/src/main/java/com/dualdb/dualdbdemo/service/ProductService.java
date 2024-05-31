package com.dualdb.dualdbdemo.service;

import java.util.List;

import com.dualdb.dualdbdemo.productmodel.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product saveProduct(Product product);

}
