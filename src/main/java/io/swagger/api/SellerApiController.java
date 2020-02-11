package io.swagger.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Seller;
import io.swagger.service.SellerService;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-21T11:51:13.410Z[GMT]")
@Controller
public class SellerApiController implements SellerApi {

	@Autowired
	private SellerService sellerService;

	public ResponseEntity<Seller> sellersPost(@ApiParam(value = "", required = true) @Valid @RequestBody Seller body)
			throws NotFoundException {
		return sellerService.sellersPost(body);
	}

	@GetMapping("/seller/{UserName}")
	public ResponseEntity<Seller> sellersSellerNameGet(
			@ApiParam(value = "", required = true) @PathVariable("UserName") String sellerName)
			throws NotFoundException {
		return sellerService.sellersSellerNameGet(sellerName);
	}

	public ResponseEntity<Seller> sellersSellerIdGet(
			@ApiParam(value = "", required = true) @PathVariable("SellerId") Long sellerId) throws NotFoundException {
		return sellerService.sellersSellerIdGet(sellerId);
	}

}
