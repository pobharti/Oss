package io.swagger.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.swagger.api.NotFoundException;
import io.swagger.dao.ProductRepository;
import io.swagger.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private final HttpServletRequest request;

	@Autowired
	private ProductRepository productRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public ProductServiceImpl(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public ResponseEntity<List<Product>> productsGet(Integer bodyLimit, Integer pageLimit) throws NotFoundException {
		String accept = request.getHeader("Accept");
		List<Product> products = productRepository.findAll();

		if (accept != null) {
			if (products == null) {
				throw new NotFoundException(500, "No product found with this product name.");
			} else
				return new ResponseEntity<List<Product>>(products, HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Product> productsPost(Product body) throws NotFoundException {
		String accept = request.getHeader("Accept");
		if (accept != null) {
			Product product = productRepository.findOne(body.getProductId());
			if (product != null) {
				throw new NotFoundException(500, "Product already exist with this productId.");
			} else {
				product = productRepository.save(body);
				return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
			}
		} else

			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Product> productsProductIdGet(Integer productId) throws NotFoundException {
		String accept = request.getHeader("Accept");
		Product product = productRepository.findOne(productId);
		/* if (accept != null) { */
			if (product == null) {
				throw new NotFoundException(500, "No product found with this productId.");
			} else
				return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
		/*} else

			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);*/
	}

	@Override
	public ResponseEntity<List<Product>> productsProductNameGet(String productName) throws NotFoundException {
		String accept = request.getHeader("Accept");

		List<Product> products = productRepository.findByProductName(productName);
		System.out.println(products);
		if (accept != null) {
			if (products.isEmpty()) {
				throw new NotFoundException(500, "No product found with this product name.");
			} else
				return new ResponseEntity<List<Product>>(products, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<List<Product>>(HttpStatus.NOT_ACCEPTABLE);
	}
}
