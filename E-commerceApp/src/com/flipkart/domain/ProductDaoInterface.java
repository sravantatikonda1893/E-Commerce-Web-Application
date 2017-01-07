package com.flipkart.domain;

import java.util.List;

public interface ProductDaoInterface {
	 List<Product> getProducts(String prodType,String prodComp);
	 List<Product> getProductDetails(int product_id);
}
