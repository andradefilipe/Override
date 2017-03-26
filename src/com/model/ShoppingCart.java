package com.model;

import java.util.HashMap;

public class ShoppingCart {

	HashMap<Product, Integer> products = new HashMap<>();

	public void addProduct(Product product, Integer amount) {
		if (products.containsKey(product)) {
			int count = products.get(product);
			products.put(product, ++count);

		} else {
			products.put(product, amount);
		}
	}

	public void removeProduct(Product product, Integer amount) {
		int count = products.get(product);
		if (count - amount < 0) {

			System.out.println("You cant remove this amount of products");
		} else if (count - amount == 0) {
			products.remove(product);
		} else if (count - amount > 0) {

			if (products.containsKey(product)) {
				products.put(product, count - amount);

			} else {
				products.put(product, 1);
			}
		}
	}

	public Long calculatePrice() {
		Long price = (long) 0.0;
		for (Product product : products.keySet()) {
			Integer amount = products.get(product);
			price += amount * product.getPrice();
		}
		return price;
	}
}
