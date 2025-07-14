package com.accenture.lkm.shortcircuit;

import java.util.stream.Stream;

import com.accenture.lkm.sampleclasses.Product;
import com.accenture.lkm.sampleclasses.ProductUtility;

/**
 * Short circuit operations in Stream
 * @author deepali.shende
 *
 */
public class Tester1003AnyMatch {
	public static void main(String[] args) {
		//Req 1 : Check if any product is manufactured in 2015. 
		//        Comment line no.s 16, 17, 18, 21 and 22 in ProductUtility.java.
		//        Traverse entire stream as no any product is manufactured in 2015.
		//		  If no any product matches the given predicate, returns false.
		//        Normal flow.
		//req1();
		
		//Req 2 : Check if any product is manufactured in 2015. 
		//        Uncomment line no.s 16, 17, 18, 21 and 22 in ProductUtility.java.
		//        Does not traverse the entire stream and short circuits as it gets product manufactured in 2015.
		//		  As product matches the given predicate, returns true.
		//        Short circuit flow.
		//req2();
		
		//Req 3 : Check with empty stream
		req3();
	}

	
	//-------------------------------------------------------------------------------------------------
	// Check if any product is manufactured in 2015. 
	// Comment line no.s 16, 17, 18, 21 and 22 in ProductUtility.java.
	// Traverse entire stream as no any product is manufactured in 2015.
	// If no any product matches the given predicate, returns false.
	// Normal flow.
	//-------------------------------------------------------------------------------------------------
	private static void req1() {
		// using lambda
		boolean found1 = ProductUtility.getProductList()
								  	   .stream()
								  	   .peek(product -> System.out.println(product))		// just for debug purpose
								  	   .anyMatch(product -> product.getDateOfManufacture().getYear() == 2015);
		if(found1) {
			System.out.println("Found product manufactured in 2015");
		}
		else {
			System.out.println("No product is manufactured in 2015");
		}
		
		// using method reference
		boolean found2 = ProductUtility.getProductList()
									   .stream()
									   .peek(System.out::println)
									   .anyMatch(Tester1003AnyMatch::checkProductManufacturedYear);
		if(found2) {
			System.out.println("Found product manufactured in 2015");
		}
		else {
			System.out.println("No product is manufactured in 2015");
		}
	}
	
	public static boolean checkProductManufacturedYear(Product product) {
		return product.getDateOfManufacture().getYear() == 2015;
	}
	
	//-------------------------------------------------------------------------------------------------
	// Check if any product is manufactured in 2015. 
	// Uncomment line no.s 16, 17, 18, 21 and 22 in ProductUtility.java.
	// Does not traverse the entire stream and short circuits as it gets product manufactured in 2015.
	// As product matches the given predicate, returns true.
	// Short circuit flow.
	//-------------------------------------------------------------------------------------------------
	private static void req2() {
		// using lambda
		boolean found1 = ProductUtility.getProductList()
								  	   .stream()
								  	  // .peek(product -> System.out.println(product))		// just for debug purpose
								  	   .anyMatch(product -> product.getDateOfManufacture().getYear() == 2015);
		if(found1) {
			System.out.println("Found product manufactured in 2015");
		}
		else {
			System.out.println("No product is manufactured in 2015");
		}
				
		// using method reference
		boolean found2 = ProductUtility.getProductList()
									   .stream()
									  // .peek(System.out::println)
									   .anyMatch(Tester1003AnyMatch::checkProductManufacturedYear);
		if(found2) {
			System.out.println("Found product manufactured in 2015");
		}
		else {
			System.out.println("No product is manufactured in 2015");
		}	
	}
	
	//-------------------------------------------------------------------------------------------------
	//Req 3 : Check with empty stream. Returns false.
	//-------------------------------------------------------------------------------------------------
	private static void req3() {
		// using lambda
		Stream<Product> products1 = Stream.empty();
		boolean found1 = products1.anyMatch(product -> product.getDateOfManufacture().getYear() == 2015);
		System.out.println(found1);
				
		// using method reference
		Stream<Product> products2 = Stream.empty();
		boolean found2 = products2.anyMatch(Tester1003AnyMatch::checkProductManufacturedYear);
		System.out.println(found2);	
	}
}
