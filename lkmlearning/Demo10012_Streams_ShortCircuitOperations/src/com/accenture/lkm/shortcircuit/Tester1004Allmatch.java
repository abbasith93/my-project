package com.accenture.lkm.shortcircuit;

import java.util.stream.Stream;

import com.accenture.lkm.sampleclasses.Product;
import com.accenture.lkm.sampleclasses.ProductUtility;

/**
 * Short circuit operations in Stream
 * @author deepali.shende
 *
 */
public class Tester1004Allmatch {
	public static void main(String[] args) {
		//Req 1 : Check if all products are having price >= 30000. 
		//		  Comment line no.s 11, 13, 14, 17, 19, 20, 22, 23, 24 in ProductUtility.java.
		//        Traverses the entire stream as all products need to be checked for price.
		//        Returns true because all products match the given predicate i.e. all products are having 
		//        price >= 30000. 
		//        Normal flow
		//req1();
		
		//Req 2 : Check if all products are having price >= 30000. 
		//		  Uncomment line no.s 11, 13, 14, 17, 19, 20, 22, 23, 24 in ProductUtility.java.
		//        Does not traverse entire stream and short circuits as it finds a product having price below 30000.
		//        Returns false because all products are not matching the given predicate.
		//        Short circuit flow
		//req2();
		
		// Req3 : Empty stream. Returns true if stream is empty.
		req3();
	}

	
	//-------------------------------------------------------------------------------------------------
	// Check if all products are having price >= 30000. 
	// Comment line no.s 11, 13, 14, 17, 19, 20, 22, 23, 24 in ProductUtility.java.
	// Traverse entire stream as all products need to be checked for price.
	// Returns true because all products match the given predicate i.e all products are having price >= 30000. 
	// Normal flow
	//-------------------------------------------------------------------------------------------------
	private static void req1() {
		// using lambda
		boolean found1 = ProductUtility.getProductList()
								  	   .stream()
								  	   .peek(product -> System.out.println(product))		// just for debug purpose
								  	   .allMatch(product -> product.getProductPrice()>=30000);
		if(found1) {
			System.out.println("All products are having price >= 30000");
		}
		else {
			System.out.println("Not every product has price >= 30000");
		}
		
		// using method reference
		boolean found2 = ProductUtility.getProductList()
										.stream()
										.peek(System.out::println)
										.allMatch(Tester1004Allmatch::checkProductPrice);
		if(found2) {
			System.out.println("All products are having price >= 30000");
		}
		else {
			System.out.println("Not every product has price >= 30000");
		}
	}
	
	public static boolean checkProductPrice(Product product) {
		return product.getProductPrice()>=30000;
	}
	
	//-------------------------------------------------------------------------------------------------
	//  Check if all products are having price >= 30000. 
	//	Uncomment line no.s 11, 13, 14, 17, 19, 20, 22, 23, 24 in ProductUtility.java.
	//  Does not traverse entire stream and short circuits as it finds a product having price below 30000.
	//  Returns false because all products are not matching the given predicate.
	//  Short circuit flow.
	//-------------------------------------------------------------------------------------------------
	private static void req2() {
		// using lambda
		boolean found1 = ProductUtility.getProductList()
								  	   .stream()
								  	   .peek(product -> System.out.println(product))		// just for debug purpose
								  	   .allMatch(product -> product.getProductPrice()>=30000);
		if(found1) {
			System.out.println("All products are having price >= 30000");
		}
		else {
			System.out.println("Not every product has price >= 30000");
		}
				
		// using method reference
		boolean found2 = ProductUtility.getProductList()
									   .stream()
									   .peek(System.out::println)
									   .allMatch(Tester1004Allmatch::checkProductPrice);
		if(found2) {
			System.out.println("All products are having price >= 30000");
		}
		else {
			System.out.println("Not every product has price >= 30000");
		}	
	}
	
	//-------------------------------------------------------------------------------------------------
	// Empty stream. Returns true if stream is empty.
	//-------------------------------------------------------------------------------------------------
	private static void req3() {
		// using lambda
		Stream<Product> products1 = Stream.empty();
		boolean found1 = products1.allMatch(product -> product.getProductPrice()>=30000);
		System.out.println(found1);
		
		// using method reference
		Stream<Product> products2 = Stream.empty();
		boolean found2 = products2.allMatch(Tester1004Allmatch::checkProductPrice);
		System.out.println(found2);	
	}
}
