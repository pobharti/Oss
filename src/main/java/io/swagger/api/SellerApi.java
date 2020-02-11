package io.swagger.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Seller;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-21T11:51:13.410Z[GMT]")
@Api(value = "sellers", description = "the seller API")
public interface SellerApi {

	
	@ApiOperation(value = "", nickname = "sellersPost", notes = "Creates a new user in the database.", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully created a new object.") })
    @RequestMapping(value = "/sellers",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Seller> sellersPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Seller body) throws NotFoundException;


    @ApiOperation(value = "", nickname = "sellerssSellerNameGet", notes = "Obtain information about specific product.", response = Seller.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Seller.class) })
    @RequestMapping(value = "/sellers/{SellerName}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Seller> sellersSellerNameGet(@ApiParam(value = "",required=true) @PathVariable("SellerName") String sellerName) throws NotFoundException;

    
    @ApiOperation(value = "", nickname = "sellerssSellerIdGet", notes = "Obtain information about specific product.", response = Seller.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Seller.class) })
    @RequestMapping(value = "/sellers/{SellerId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Seller> sellersSellerIdGet(@ApiParam(value = "",required=true) @PathVariable("SellerId") Long sellerId) throws NotFoundException;

}
