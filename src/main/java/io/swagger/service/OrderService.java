package io.swagger.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import io.swagger.api.NotFoundException;
import io.swagger.model.Order;

public interface OrderService {

	ResponseEntity<Order> orderDetailsOrderIdGet(Long orderId) throws NotFoundException;

	ResponseEntity<List<Order>> orderDetailsUserNameGet(String userName)throws NotFoundException;

}
