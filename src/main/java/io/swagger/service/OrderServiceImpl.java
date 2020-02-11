package io.swagger.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.swagger.api.NotFoundException;
import io.swagger.dao.OrderRepository;
import io.swagger.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	private final HttpServletRequest request;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	public OrderServiceImpl(HttpServletRequest request) {
		this.request = request;
	}	
	
	@Override
	public ResponseEntity<Order> orderDetailsOrderIdGet(Long orderId) throws NotFoundException {
		String accept = request.getHeader("Accept");
		Order order = orderRepository.findOne(orderId);
		if (accept != null) {
			if (order == null) {
				throw new NotFoundException(500, "No order found for this orderID.");
			} else
				return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Order>(HttpStatus.NOT_ACCEPTABLE);
	}

	@Override
	public ResponseEntity<List<Order>> orderDetailsUserNameGet(String userName) throws NotFoundException {
		String accept = request.getHeader("Accept");
		List<Order> orders = orderRepository.findByUserName(userName);
		if (accept != null) {
			if (orders.isEmpty()) {
				throw new NotFoundException(500, "No orders found for this username.");
			} else
				return new ResponseEntity<List<Order>>(orders, HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<List<Order>>(HttpStatus.NOT_ACCEPTABLE);
	}

}
