package io.swagger.service;

import org.springframework.http.ResponseEntity;

import io.swagger.api.NotFoundException;
import io.swagger.model.Seller;

public interface SellerService {

	ResponseEntity<Seller> sellersPost(Seller body) throws NotFoundException;

	ResponseEntity<Seller> sellersSellerNameGet(String sellerName) throws NotFoundException;

	ResponseEntity<Seller> sellersSellerIdGet(Long sellerId) throws NotFoundException;

}
