package com.accenture.lkm.terminal;

import java.util.stream.Stream;

import com.accenture.lkm.sampleclasses.Product;
import com.accenture.lkm.sampleclasses.ProductUtility;

/**
 * Conversion of Stream to Array
 * @author deepali.shende
 *
 */
public class Tester1002ToArray {
	public static void main(String[] args) {
		Stream<Product> products = ProductUtility.getProductList().stream();
		// toArray converts to array of objects, not to specific type. Type casting would give ClassCaseException
		Object[] allProducts = products.toArray();
		System.out.println("No of products = " + allProducts.length);
		
		// A function passed to toArray() takes an integer, which is the size of the desired array, 
		// and produces an array of the desired size. 
		Product[] myProducts = products.toArray(size -> new Product[size]);
		System.out.println("No of products = " + myProducts.length);
		
		//This can expressed with an array constructor reference:
		Product[] myProducts1 = products.toArray(Product[]::new);
		System.out.println("No of products = " + myProducts1.length);
	}
}
