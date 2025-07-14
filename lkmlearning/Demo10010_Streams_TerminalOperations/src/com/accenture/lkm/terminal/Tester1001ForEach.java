package com.accenture.lkm.terminal;

import java.util.Iterator;
import java.util.List;

import com.accenture.lkm.sampleclasses.Product;
import com.accenture.lkm.sampleclasses.ProductUtility;

/**
 * forEach()
 * @author deepali.shende
 *
 */
public class Tester1001ForEach {
	public static void main(String[] args) {
		List<Product> products = ProductUtility.getProductList();
		
		// makes code lengthy. More lines in byte code. Compilation takes time.
		//displayUsingForLoop(products);
		
		// makes code lengthy. More lines in byte code. Compilation takes time.
		//displayUsingIterator(products);
		
		// makes code lengthy. More lines in byte code. Compilation takes time.
		//displayUsingForEachLoop(products);
				
		// forEach method
		displayUsingForEachMethod(products);
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	// Using for loop, makes code lengthy. More lines in byte code. Compilation takes time. More assembly code.
	// Poor performance
	//-------------------------------------------------------------------------------------------------------
	public static void displayUsingForLoop(List<Product> products) {
		for(int i=0; i<products.size(); i++) {
			Product product = products.get(i);
			product.printDetails();
		}
	}

	
	//-------------------------------------------------------------------------------------------------------
	// Using iterator, makes code lengthy. More lines in byte code. Compilation takes time. More assembly code.
	// Poor performance
	//-------------------------------------------------------------------------------------------------------
	public static void displayUsingIterator(List<Product> products) {
		Iterator<Product> iterator = products.iterator();
		while(iterator.hasNext()) {
			Product product = iterator.next();
			product.printDetails();
		}
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	// Using for each loop, makes code lengthy. More lines in byte code. Compilation takes time. More assembly code.
	// Poor performance
	//-------------------------------------------------------------------------------------------------------
	public static void displayUsingForEachLoop(List<Product> products) {
		for(Product product : products) {
			product.printDetails();
		}
	}

	
	//-------------------------------------------------------------------------------------------------------
	// Using forEach method
	//-------------------------------------------------------------------------------------------------------
	public static void displayUsingForEachMethod(List<Product> products) {
		// using Lambda expression
		//products.forEach(product -> product.printDetails());
		
		// Using method reference
		products.forEach(System.out::println);
	}
}
