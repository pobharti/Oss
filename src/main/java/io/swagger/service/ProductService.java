package io.swagger.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import io.swagger.api.NotFoundException;
import io.swagger.model.Product;

public interface ProductService {

	ResponseEntity<List<Product>> productsGet(Integer bodyLimit, Integer pageLimit) throws NotFoundException;

	ResponseEntity<Product> productsPost(Product body) throws NotFoundException;

	ResponseEntity<Product> productsProductIdGet(Integer productId) throws NotFoundException;

	ResponseEntity<List<Product>> productsProductNameGet(String productName) throws NotFoundException;


}
