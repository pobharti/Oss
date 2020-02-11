/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.14).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Product;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-21T11:51:13.410Z[GMT]")
@Api(value = "products", description = "the products API")
public interface ProductsApi {

	@ApiOperation(value = "", nickname = "productsGet", notes = "Obtain information about products from the database", response = Product.class, responseContainer = "List", tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Succesful pull of products info", response = Product.class, responseContainer = "List") })
	@RequestMapping(value = "/products", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<Product>> productsGet(
			@Min(10) @Max(20) @ApiParam(value = "The amount of products returned", allowableValues = "") @Valid @RequestParam(value = "bodyLimit", required = false) Integer bodyLimit,
			@Min(1) @Max(5) @ApiParam(value = "The pages to return products info", allowableValues = "") @Valid @RequestParam(value = "pageLimit", required = false) Integer pageLimit)
			throws NotFoundException;

	@ApiOperation(value = "", nickname = "productsPost", notes = "Create a new product in the database", tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created a new object.") })
	@RequestMapping(value = "/products", consumes = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Product> productsPost(@ApiParam(value = "", required = true) @Valid @RequestBody Product body)
			throws NotFoundException;

	@ApiOperation(value = "", nickname = "productsProductIdGet", notes = "Obtain information about specific product.", response = Product.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Product.class) })
	@RequestMapping(value = "/products/{ProductId}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Product> productsProductIdGet(
			@ApiParam(value = "", required = true) @PathVariable("ProductId") Integer productId)
			throws NotFoundException;

	@ApiOperation(value = "", nickname = "productsProductNameGet", notes = "Obtain information about specific product.", response = Product.class, responseContainer = "List", tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = Product.class, responseContainer = "List") })
	@RequestMapping(value = "/products/{ProductName}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<Product>> productsProductNameGet(
			@ApiParam(value = "", required = true) @PathVariable("ProductName") String productName)
			throws NotFoundException;

}
