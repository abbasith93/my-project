package com.accenture.lkm.terminal;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.accenture.lkm.sampleclasses.Customer;
import com.accenture.lkm.sampleclasses.CustomerUtility;
import com.accenture.lkm.sampleclasses.Product;
import com.accenture.lkm.sampleclasses.ProductUtility;

/**
 * Summarizing info in Stream
 * @author deepali.shende
 *
 */
public class Tester1005Summarizing {
	public static void main(String[] args) {
		//summarizingInt();
		
		summarizingDouble();
	}
	
	//------------------------------------------------------------------------------------------------------------
	// Getting summary functions like min, max, average, count on customer age
	//------------------------------------------------------------------------------------------------------------
	private static void summarizingInt() {
		Stream<Customer> customers = CustomerUtility.getCustomerList().stream();
		
		//Using lambda
		IntSummaryStatistics intSummaryStatistics = customers.collect(Collectors.summarizingInt(customer -> customer.getAge()));
		
		//Using method reference
		//IntSummaryStatistics intSummaryStatistics = customers.collect(Collectors.summarizingInt(Customer::getAge));
		
		// Gives summary in total count, min, max, average values
		System.out.println(intSummaryStatistics);
	}
	
	
	//------------------------------------------------------------------------------------------------------------
	// Getting summary functions like min, max, average, count on product price
	//------------------------------------------------------------------------------------------------------------
	private static void summarizingDouble() {
		Stream<Product> products = ProductUtility.getProductList().stream();
		
		//Using lambda
		//DoubleSummaryStatistics doubleSummaryStatistics = products.collect(Collectors.summarizingDouble(product -> product.getProductPrice()));
		
		//Using method reference
		DoubleSummaryStatistics doubleSummaryStatistics = products.collect(Collectors.summarizingDouble(Product :: getProductPrice));
		
		System.out.println(doubleSummaryStatistics);
	}
}
