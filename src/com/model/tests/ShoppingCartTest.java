package com.model.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.model.Product;
import com.model.ProductWithSize;
import com.model.ShoppingCart;

public class ShoppingCartTest {

	ShoppingCart shoppingCart;
	Product product1;
	Product product2;
	ProductWithSize productWithSize1;
	ProductWithSize productWithSize2;

	@Before
	public void setup() {
		product1 = new Product();
		product2 = new Product();
		productWithSize1 = new ProductWithSize();
		productWithSize2 = new ProductWithSize();
		shoppingCart = new ShoppingCart();

		product1.setName("Product1");
		product1.setCode(123);
		product1.setPrice((long) 32.0);

		product2.setName("Product2");
		product2.setCode(1231);
		product2.setPrice((long) 32.0);

		productWithSize1.setName("Product1");
		productWithSize1.setCode(123);
		productWithSize1.setPrice((long) 32.0);
		productWithSize1.setSize(3);

		productWithSize2.setName("Product1");
		productWithSize2.setCode(123);
		productWithSize2.setPrice((long) 32.0);
		productWithSize2.setSize(3);

	}

	@Test
	public void testTwoProducts() {
		shoppingCart.addProduct(product1, 2);
		shoppingCart.addProduct(product2, 2);

		assertEquals(Long.valueOf(128), shoppingCart.calculatePrice());
	}

	@Test
	public void testThreeIdentitcalProducts() {
		shoppingCart.addProduct(product1, 2);
		shoppingCart.addProduct(product1, 1);

		assertEquals(Long.valueOf(96), shoppingCart.calculatePrice());
	}

	@Test
	public void testTwoProductsWithSize() {
		shoppingCart.addProduct(productWithSize1, 2);
		shoppingCart.addProduct(productWithSize2, 2);

		assertEquals(Long.valueOf(96), shoppingCart.calculatePrice());
	}

	@Test
	public void testProductsAndProductsWithSize() {
		shoppingCart.addProduct(productWithSize1, 2);
		shoppingCart.addProduct(product1, 1);

		assertEquals(Long.valueOf(96), shoppingCart.calculatePrice());
	}

	@Test
	public void testRemovingProducts() {
		shoppingCart.addProduct(productWithSize1, 2);
		shoppingCart.addProduct(product1, 1);

		shoppingCart.removeProduct(product1, 1);

		assertEquals(Long.valueOf(64), shoppingCart.calculatePrice());
	}

	@Test
	public void testRemovingProductsWithSize1() {
		shoppingCart.addProduct(productWithSize1, 2);
		shoppingCart.addProduct(product1, 1);

		shoppingCart.removeProduct(productWithSize1, 1);

		assertEquals(Long.valueOf(64), shoppingCart.calculatePrice());
	}

}
