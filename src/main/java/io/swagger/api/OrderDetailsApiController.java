package io.swagger.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Order;
import io.swagger.model.Product;
import io.swagger.service.OrderService;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-21T11:51:13.410Z[GMT]")
@Controller
public class OrderDetailsApiController implements OrderDetailsApi {

	@Autowired
	private OrderService orderService;

	public ResponseEntity<Order> orderDetailsOrderIdGet(
			@ApiParam(value = "", required = true) @PathVariable("OrderId") Long orderId) throws NotFoundException {
		return orderService.orderDetailsOrderIdGet(orderId);
	}

	@GetMapping("/order/{UserName}")
	public ResponseEntity<List<Order>> orderDetailsUserNameGet(
			@ApiParam(value = "", required = true) @PathVariable("UserName") String userName) throws NotFoundException {
		return orderService.orderDetailsUserNameGet(userName);
	}

	/*
	 * @Override public ResponseEntity<Product> productsPost(Order body) throws
	 * NotFoundException {
	 * 
	 * }
	 */

}
