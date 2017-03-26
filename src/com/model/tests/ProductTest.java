package com.model.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.model.Product;

public class ProductTest {

	Product product1;
	Product product2;

	@Before
	public void setup() {
		product1 = new Product();
		product2 = new Product();
	}

	@Test
	public void testEqualFields() {
		product1.setName("Product1");
		product1.setCode(123);
		product1.setPrice((long) 32.0);

		product2.setName("Product1");
		product2.setCode(123);
		product2.setPrice((long) 32.0);

		assertTrue(product1.equals(product2));
	}

	@Test
	public void testDiferrentFields() {
		product1.setName("Product1");
		product1.setCode(123);
		product1.setPrice((long) 32.0);

		product2.setName("NoName");
		product2.setCode(123);
		product2.setPrice((long) 0.0);

		assertTrue(product1.equals(product2));
	}

	@Test
	public void testDifferentCode() {
		product1.setName("Product1");
		product1.setCode(123);
		product1.setPrice((long) 32.0);

		product2.setName("Product1");
		product2.setCode(543);
		product2.setPrice((long) 32.0);

		assertFalse(product1.equals(product2));
	}

}
