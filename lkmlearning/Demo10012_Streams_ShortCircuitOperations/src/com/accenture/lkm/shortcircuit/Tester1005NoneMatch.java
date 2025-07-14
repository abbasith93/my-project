package com.accenture.lkm.shortcircuit;

import java.util.stream.Stream;

import com.accenture.lkm.sampleclasses.Product;
import com.accenture.lkm.sampleclasses.ProductUtility;

/**
 * Short circuit operations in Stream
 * @author deepali.shende
 *
 */
public class Tester1005NoneMatch {
	public static void main(String[] args) {
		//Req 1 : Check if none of the products is old. 
		//        Comment line no.s 12, 14, 18, 20 in ProductUtility.java
		//        Traverses the entire stream to find mismatch. 
		//        Returns true.
		//        Normal flow.
		//req1();
		
		//Req 2 : Check if none of the products is old. 
		//        Uncomment line no.s 12, 14, 18, 20 in ProductUtility.java
		//        Does not traverse the entire stream and short circuits as it finds a product not matching given
		//        predicate. 
		//        Returns false.
		//        Short circuit flow.
		//req2();
		
		//Req 3 : Empty stream. Returns true if stream is empty.
		req3();
	}

	
	//-------------------------------------------------------------------------------------------------
	// Check if no any product is old. 
	// Comment line no.s 12, 14, 18, 20 in ProductUtility.java
	// Traverse the entire stream to find mismatch. 
	// Returns true.
	// Normal flow.
	//-------------------------------------------------------------------------------------------------
	private static void req1() {
		// using lambda
		boolean found1 = ProductUtility.getProductList()
									   .stream()
									   .noneMatch(product -> product.getProductCategory().equalsIgnoreCase("o"));
					
		if(found1) {
			System.out.println("All products are new");
		}
		else {
			System.out.println("Not all products are new");
		}

		//using method reference
		boolean found2 = ProductUtility.getProductList()
									   .stream()
									   .noneMatch(Tester1005NoneMatch::checkProductCategory);

		if(found2) {
			System.out.println("All products are new");
		}
		else {
			System.out.println("Not all products are new");
		}	
	}

	public static boolean checkProductCategory(Product product) {
		return product.getProductCategory().equalsIgnoreCase("o");
	}
	
	
	//-------------------------------------------------------------------------------------------------
	//  Check if no any product is old. 
	//  Uncomment line no.s 12, 14, 18, 20 in ProductUtility.java
	//  Does not traverse the entire stream and short circuits as it finds a product not matching given predicate. 
	//  Returns false.
	//  Short circuit flow.
	//-------------------------------------------------------------------------------------------------
	private static void req2() {
		// using lambda
		boolean found1 = ProductUtility.getProductList()
									   .stream()
									   .noneMatch(product -> product.getProductCategory().equalsIgnoreCase("o"));
					
		if(found1) {
			System.out.println("All products are new");
		}
		else {
			System.out.println("Not all products are new");
		}

		//using method reference
		boolean found2 = ProductUtility.getProductList()
									   .stream()
									   .noneMatch(Tester1005NoneMatch::checkProductCategory);
		if(found2) {
			System.out.println("All products are new");
		}
		else {
			System.out.println("Not all products are new");
		}	
	}
	
	
	//-------------------------------------------------------------------------------------------------
	// Empty stream. Returns true if stream is empty.
	//-------------------------------------------------------------------------------------------------
	private static void req3() {
		// using lambda
		Stream<Product> products1 = Stream.empty();
		boolean found1 = products1.noneMatch(product -> product.getProductCategory().equalsIgnoreCase("o"));
		System.out.println(found1);

		//using method reference
		Stream<Product> products2 = Stream.empty();
		boolean found2 = products2.noneMatch(product -> product.getProductCategory().equalsIgnoreCase("o"));
		System.out.println(found2);	
	}
}
