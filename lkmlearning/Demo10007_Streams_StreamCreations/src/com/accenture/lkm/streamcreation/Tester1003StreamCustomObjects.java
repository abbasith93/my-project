package com.accenture.lkm.streamcreation;

import java.util.List;
import java.util.stream.Stream;

import com.accenture.lkm.sampleclasses.Product;
import com.accenture.lkm.sampleclasses.ProductUtility;

/**
 * Stream creation of Custom objects
 * @author deepali.shende
 *
 */
public class Tester1003StreamCustomObjects {
	public static void main(String[] args) {
		List<Product> productList = ProductUtility.getProductList();
		Stream<Product> allProducts = productList.stream();
		
		//allProducts.forEach(p -> p.printDetails());
		
		// what will be output?
		// IllegalStateException: stream has already been operated upon or closed
		//System.out.println("No of products : " + allProducts.count());
		
		// from the list, it will skip 1st two products
		Stream<Product> subProducts = allProducts.skip(2);
		subProducts.forEach(product -> product.printDetails());
	}
}
