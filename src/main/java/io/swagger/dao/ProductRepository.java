package io.swagger.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	/* Product findById(Integer productId); */

	
	 // @Query("select productId,productName,sellerId,price,quantity,ratings from Product where productName=?1")
	  List<Product> findByProductName(String productName);
	 
}
