package com.model.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.model.ProductWithSize;

public class ProductWithSizeTest {

	ProductWithSize product1;
	ProductWithSize product2;

	@Before
	public void setup() {
		product1 = new ProductWithSize();
		product2 = new ProductWithSize();
	}

	@Test
	public void testEqualFields() {
		product1.setName("Product1");
		product1.setCode(123);
		product1.setPrice((long) 32.0);
		product1.setSize(3);

		product2.setName("Product1");
		product2.setCode(123);
		product2.setPrice((long) 32.0);
		product2.setSize(3);

		assertTrue(product1.equals(product2));
	}

	@Test
	public void testDiferrentFields() {
		product1.setName("Product1");
		product1.setCode(123);
		product1.setPrice((long) 32.0);
		product1.setSize(3);


		product2.setName("NoName");
		product2.setCode(123);
		product2.setPrice((long) 0.0);
		product2.setSize(3);

		assertTrue(product1.equals(product2));
	}

	@Test
	public void testDifferentCode() {
		product1.setName("Product1");
		product1.setCode(123);
		product1.setPrice((long) 32.0);
		product1.setSize(3);


		product2.setName("Product1");
		product2.setCode(543);
		product2.setPrice((long) 32.0);
		product2.setSize(3);

		assertFalse(product1.equals(product2));
	}

}
