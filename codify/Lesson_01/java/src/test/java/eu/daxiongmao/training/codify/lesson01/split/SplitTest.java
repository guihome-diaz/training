package eu.daxiongmao.training.codify.lesson01.split;

import org.junit.Assert;
import org.junit.Test;

public class SplitTest {

	@Test
	public void testFewElements() {		
		// Dataset 
		int[] arrayToTest = new int[] {3};

		// Function to test
		Split algo = new Split();
		int result1 = algo.badSolution(arrayToTest);
		int result2 = algo.goodSolution(arrayToTest);
		
		// Assertions
		Assert.assertEquals(0, result1);
		Assert.assertEquals(0, result2);
	}
	
	@Test
	public void testNominalCase() {		
		// Dataset 
		int[] arrayToTest = new int[] {3, 1, 2, 4, 3};

		// Function to test
		Split algo = new Split();
		int result1 = algo.badSolution(arrayToTest);
		int result2 = algo.goodSolution(arrayToTest);
		
		// Assertions
		Assert.assertEquals(1, result1);
		Assert.assertEquals(1, result2);
	}
	
	@Test
	public void testEmpty() {		
		// Dataset 
		int[] arrayToTest = new int[] {};

		// Function to test
		Split algo = new Split();
		int result1 = algo.badSolution(arrayToTest);
		int result2 = algo.goodSolution(arrayToTest);
		
		// Assertions
		Assert.assertEquals(0, result1);
		Assert.assertEquals(0, result2);
	}	
	
	@Test
	public void testNull() {
		// Function to test
		Split algo = new Split();
		int result1 = algo.badSolution(null);
		int result2 = algo.goodSolution(null);
		
		// Assertions
		Assert.assertEquals(0, result1);
		Assert.assertEquals(0, result2);
	}	
}
