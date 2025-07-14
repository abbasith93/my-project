package com.accenture.lkm.shortcircuit;

import java.util.stream.Stream;

/**
 * Parallel Stream - Will be discussed in detailed in Demo10017_ParallelStream.
 * @author deepali.shende
 *
 */
public class Tester1000ParallelStream {
	public static void main(String[] args) {
		//Req 1 : print parallel stream. Can print in any order.
		//req1();

		//Req 2 : findFirst() with parallel stream. 
		//req2();
		
		//Req 3 : findAny() with parallel stream. 
		req3();
	}

	
	//-------------------------------------------------------------------------------------------------
	// Print parallel stream. Can print in any order.
	//-------------------------------------------------------------------------------------------------
	private static void req1() {
		Stream<Integer> productIds = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		productIds.parallel().forEach(System.out::println);
	}
	
	
	//-------------------------------------------------------------------------------------------------
	// findFirst() with parallel stream.
	//-------------------------------------------------------------------------------------------------
	private static void req2() {
		Stream<Integer> productIds = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer firstId = productIds.parallel().findFirst().get();
		System.out.println(firstId);
	}
	
	
	//-------------------------------------------------------------------------------------------------
	// findAny() with parallel stream.
	//-------------------------------------------------------------------------------------------------
	private static void req3() {
		Stream<Integer> productIds = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer anyId = productIds.parallel().findAny().get();
		System.out.println(anyId);
	}
}
