package io.swagger.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Product;
import io.swagger.service.ProductService;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-21T11:51:13.410Z[GMT]")
@Controller
public class ProductsApiController implements ProductsApi {

	@Autowired
	private ProductService productService;

	public ResponseEntity<List<Product>> productsGet(
			@Min(10) @Max(20) @ApiParam(value = "The amount of products returned", allowableValues = "") @Valid @RequestParam(value = "bodyLimit", required = false) Integer bodyLimit,
			@Min(1) @Max(5) @ApiParam(value = "The pages to return products info", allowableValues = "") @Valid @RequestParam(value = "pageLimit", required = false) Integer pageLimit)
			throws NotFoundException {
		return productService.productsGet(bodyLimit, pageLimit);
	}

	public ResponseEntity<Product> productsPost(@ApiParam(value = "", required = true) @Valid @RequestBody Product body)
			throws NotFoundException {
		return productService.productsPost(body);
	}

	@GetMapping("/product/{ProductId}")
	public ResponseEntity<Product> productsProductIdGet(
			@ApiParam(value = "", required = true) @PathVariable("ProductId") Integer productId)
			throws NotFoundException {
		return productService.productsProductIdGet(productId);
	}

	public ResponseEntity<List<Product>> productsProductNameGet(
			@ApiParam(value = "", required = true) @PathVariable("ProductName") String productName)
			throws NotFoundException {
		return productService.productsProductNameGet(productName);

	}

}
