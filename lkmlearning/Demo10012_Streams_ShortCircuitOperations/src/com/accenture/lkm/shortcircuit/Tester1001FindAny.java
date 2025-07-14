package com.accenture.lkm.shortcircuit;

import com.accenture.lkm.sampleclasses.Product;
import com.accenture.lkm.sampleclasses.ProductUtility;

/**
 * Short circuit operations in Stream
 * @author deepali.shende
 *
 */
public class Tester1001FindAny {
	public static void main(String[] args) {
		//Req 1 : find any product manufactured in 2015
		//req1();
		
		//Req 2 : find any product manufactured in 2015 with parallel stream. Dont discuss 
		req2();
	}

	
	//-------------------------------------------------------------------------------------------------
	// Find any product manufactured in 2015 and once product is found, findAny() terminates.
	// findAny() in sequential stream mostly finds first element. But not guaranteed.
	//-------------------------------------------------------------------------------------------------
	private static void req1() {
		// using lambda
		ProductUtility.getProductList()
		              .stream()
		              .filter(product -> product.getDateOfManufacture().getYear()==2015)
		             // .peek(product -> System.out.println(product))			// just for debug purpose
					  .findAny()
					  .ifPresent(product -> System.out.println(product));
				
		// using method reference
		ProductUtility.getProductList()
		              .stream()
					  .filter(Tester1001FindAny::checkProductYear)
					 // .peek(System.out::println)			// just for debug purpose
					  .findAny()
					  .ifPresent(System.out::println);
	}
	
	public static boolean checkProductYear(Product product) {
		return product.getDateOfManufacture().getYear()==2015;
	}

	
	//-------------------------------------------------------------------------------------------------
	// Find any product manufactured in 2015 and once product found, findAny() terminates.
	// findAny() in parallel stream finds any element.
	//-------------------------------------------------------------------------------------------------
	private static void req2() {
	// using lambda
	ProductUtility.getProductList()
	              .stream()
	              .parallel()
	              .filter(product -> product.getDateOfManufacture().getYear()==2015)
	             // .peek(product -> System.out.println(product))			// just for debug purpose
				  .findAny()
				  .ifPresent(product -> System.out.println(product));
				
	// using method reference
	ProductUtility.getProductList()
	              .stream()
	              .parallel()
				  .filter(Tester1001FindAny::checkProductYear)
				//  .peek(System.out::println)			// just for debug purpose
				  .findAny()
				  .ifPresent(System.out::println);
	}
}
