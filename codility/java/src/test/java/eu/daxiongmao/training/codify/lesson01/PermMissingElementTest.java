package eu.daxiongmao.training.codify.lesson01;

import org.junit.Assert;
import org.junit.Test;

public class PermMissingElementTest {

	@Test
	public void testMissingEndElement() {
		// test dataset
		final int[] testArray = new int[6];
		testArray[0] = 1;
		testArray[1] = 2;
		testArray[2] = 5;
		testArray[3] = 4;
		testArray[4] = 3;
		testArray[5] = 6;
		
		// Algo to test
		final PermMissingElement algo = new PermMissingElement();
		final int missingElement = algo.solution(testArray);
		
		// Assertions
		Assert.assertEquals(7, missingElement);
	}

	@Test
	public void testMissingElement() {
		// test dataset
		final int[] testArray = new int[7];
		testArray[0] = 7;
		testArray[1] = 4;
		testArray[2] = 6;
		testArray[3] = 5;
		testArray[4] = 8;
		testArray[5] = 2;
		testArray[6] = 1;
		
		// Algo to test
		final PermMissingElement algo = new PermMissingElement();
		final int missingElement = algo.solution(testArray);
		
		// Assertions
		Assert.assertEquals(3, missingElement);
	}
	
	@Test
	public void testEmptyArray() {
		// test dataset
		final int[] testArray = new int[0];
		
		// Algo to test
		final PermMissingElement algo = new PermMissingElement();
		final int missingElement = algo.solution(testArray);
		
		// Assertions

		// Careful! As per the specifications the first value expected is 1, not 0!!
		Assert.assertEquals(1, missingElement);
	}
	
}
