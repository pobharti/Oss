package io.swagger.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.swagger.api.NotFoundException;
import io.swagger.dao.SellerRepository;
import io.swagger.model.Seller;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public SellerServiceImpl(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public ResponseEntity<Seller> sellersPost(Seller body) throws NotFoundException {
		String accept = request.getHeader("Accept");
		if (accept != null) {
			Seller seller = sellerRepository.findOne(body.getSellerId());
			if (seller != null) {
				throw new NotFoundException(500, "Seller already exist with this sellerId.");
			} else {
				seller = sellerRepository.save(body);
				return new ResponseEntity<Seller>(seller, HttpStatus.ACCEPTED);
			}
		} else

			return new ResponseEntity<Seller>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Seller> sellersSellerNameGet(String sellerName) throws NotFoundException {
		String accept = request.getHeader("Accept");
		Seller seller = sellerRepository.findBySellerName(sellerName);
		if (accept != null) {
			if (seller == null) {
				throw new NotFoundException(500, "No seller found with this seller name.");
			} else
				return new ResponseEntity<Seller>(seller, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Seller>(HttpStatus.NOT_ACCEPTABLE);
	}

	@Override
	public ResponseEntity<Seller> sellersSellerIdGet(Long sellerId) throws NotFoundException {
		String accept = request.getHeader("Accept");
		Seller seller = sellerRepository.findOne(sellerId);
		if (accept != null) {
			if (seller == null) {
				throw new NotFoundException(500, "No Seller found with this sellerId.");
			} else
				return new ResponseEntity<Seller>(seller, HttpStatus.ACCEPTED);
		} else
			return new ResponseEntity<Seller>(HttpStatus.NOT_FOUND);
	}
}
