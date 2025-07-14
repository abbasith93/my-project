package com.accenture.lkm.terminal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.accenture.lkm.sampleclasses.Product;
import com.accenture.lkm.sampleclasses.ProductUtility;

/**
 * collect() of Stream
 * @author deepali.shende
 *
 */
public class Tester1003Collect {
	public static void main(String[] args) {
		convertStreamToList();
		
		//convertStreamToSet();
		
		//convertStreamToCollection();
		
		//stringJoining();
		
		//streamCounting();
		
		//streamCalculation1();
		
		//streamCalculation2();
		
		
	}

	// -----------------------------------------------------------------------------------------------
	// Convert stream to List. 
	// -----------------------------------------------------------------------------------------------
	private static void convertStreamToList() {
		Stream<Product> streamOfProducts = ProductUtility.getProductList().stream();
		List<Product> listOfProducts = streamOfProducts.collect(Collectors.toList());
		
        //Using lambda
		//listOfProducts.forEach(product -> System.out.println(product));
		
		//Using method reference
		listOfProducts.forEach(System.out::println);
	}
	
	
	// -----------------------------------------------------------------------------------------------
	// Convert stream to Set.
	// -----------------------------------------------------------------------------------------------
	private static void convertStreamToSet() {
		Stream<Integer> streamOfOrderIds = Stream.of(101, 201,301, 401, 501);
		Set<Integer> setOfOrderIds = streamOfOrderIds.collect(Collectors.toSet());
		
		//Using lambda
		//setOfOrderIds.forEach(orderId -> System.out.println(orderId));
		
		//Using method reference
		setOfOrderIds.forEach(System.out::println);
	}
	
	
	// -----------------------------------------------------------------------------------------------
	// Convert stream to different Collection objects.
	// -----------------------------------------------------------------------------------------------
	private static void convertStreamToCollection() {
		LinkedList<Product> products = ProductUtility.getProductList().stream()
				  .collect(Collectors.toCollection(LinkedList::new));
	
		Stack<Product> newProducts = ProductUtility.getProductList().stream()
				  .collect(Collectors.toCollection(Stack::new));
		
		Deque<Product> allProducts = ProductUtility.getProductList().stream()
				  .collect(Collectors.toCollection(ArrayDeque::new));
	}
	
	
	// -----------------------------------------------------------------------------------------------
	// Join stream objects by some delimeter.
	// -----------------------------------------------------------------------------------------------
	private static void stringJoining() {
		List<String> productNames = List.of("TV", "IPad", "IPhone", "Headphone");
        String allProductNames = productNames.stream().collect(Collectors.joining(","));

        System.out.printf("Joined productNames: " + allProductNames);
	}
	
	
	//-----------------------------------------------------------------------------------------------
	// Count stream contents
	//-----------------------------------------------------------------------------------------------
	private static void streamCounting() {
		long noOfProducts = ProductUtility.getProductList().stream().collect(Collectors.counting());
		System.out.println("No of products : " + noOfProducts);
	}
	
	//-----------------------------------------------------------------------------------------------
	// Calculate average of product prices
	//-----------------------------------------------------------------------------------------------
	private static void streamCalculation1() {
		Stream<Product> streamOfProducts = ProductUtility.getProductList().stream();
		
		//Using lambda
		//Double averagePriceOfTheProducts = streamOfProducts.collect(Collectors.averagingDouble(product -> product.getProductPrice()));
		
		//Using method reference
		Double averagePriceOfTheProducts = streamOfProducts.collect(Collectors.averagingDouble(Product::getProductPrice));
		System.out.println("Average price of the products : Rs " + averagePriceOfTheProducts);
	}

		
	// -----------------------------------------------------------------------------------------------
	// Calculate sum of product prices.
	// -----------------------------------------------------------------------------------------------
	private static void streamCalculation2() {
		Stream<Product> streamOfProducts = ProductUtility.getProductList().stream();
		
		//Using lambda
		Double totalProductPrice = streamOfProducts.collect(Collectors.summingDouble(product -> product.getProductPrice()));
		
		//Using method reference
		//Double totalProductPrice = streamOfProducts.collect(Collectors.summingDouble(Product::getProductPrice));
		System.out.println("Total of the product's prices: Rs " + totalProductPrice);
	}
}
