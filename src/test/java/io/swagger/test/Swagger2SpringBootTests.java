package io.swagger.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import io.swagger.api.NotFoundException;
import io.swagger.dao.ProductRepository;
import io.swagger.dao.UserRepository;
import io.swagger.model.Product;
import io.swagger.model.User;
import io.swagger.service.ProductService;
import io.swagger.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Swagger2SpringBootTests {

	User user = new User("Kunal", "kkb123", "kkb@gmail.com", "patna", 8787879090l, "user", 20000.0);
	// List<User> personDetails = new ArrayList<User>(); // Optional<User> person =
	// Optional.of(personDetails);
	Product product = new Product(12, "Tv", 1211l, 45777.0, 4, 4.5);

	@Autowired
	private UserService service;

	@Autowired
	private ProductService productService;

	@MockBean
	private ProductRepository productRepository;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void getDetails() throws NotFoundException {
		System.out.println("......" + userRepository.findOne("Rahul") + "  ....");
		when(userRepository.findOne("Rahul")).thenReturn(user);
		assertEquals(user, service.getDetails("Rahul"));
	}

	/*
	 * @Test public void productsProductIdGet() throws NotFoundException {
	 * 
	 * when(productRepository.findOne(4)).thenReturn(product);
	 * 
	 * assertEquals(product, productService.productsProductIdGet(4));
	 * 
	 * }
	 */

	@Test
	public void usersUserNameGet() throws NotFoundException {
		// personDetails.add(user);
		System.out.println(userRepository.findOne("Kunal") + "   ....");

		when(userRepository.findOne("Kunal")).thenReturn(user);
		//System.out.println(" servics " + service.usersUserNameGet("Kunal").getBody().getEmail() + " service doc");
		assertEquals(user, service.usersUserNameGet("Kunal").getBody());
	}

}
