package CarPool.carpool;

import junit.framework.TestCase;

public class RPNCalculatorTest extends TestCase {
	
	public RPNCalculator rpnCalculator = new RPNCalculator();
	
	public void testAdd() {
		int result = rpnCalculator.calculateRPN("2,3,+");
		assertEquals(5,result);
	}

	public void testDifference() {
		int result = rpnCalculator.calculateRPN("2,3,-");
		assertEquals(-1,result);
	}
	
	public void testDivision() {
		int result = rpnCalculator.calculateRPN("21,3,/");
		assertEquals(7,result);
	}
	
	public void testMultiplication() {
		int result = rpnCalculator.calculateRPN("21,3,*");
		assertEquals(63,result);
	}
	
	public void testCase1() {
		int result = rpnCalculator.calculateRPN("1,2,3,+,-");
		assertEquals(-4,result);
	}
	public void testCase2() {
		int result = rpnCalculator.calculateRPN("6,2,*,3,/");
		assertEquals(4,result);
	}
	public void testCase3() {
		int result = rpnCalculator.calculateRPN("5,1,2,+,4,*,+,3,-");
		assertEquals(14,result);
	}
	
	public void testError() {
		try {
		int result = rpnCalculator.calculateRPN("");
		fail();
		}catch(Exception exp) {
			assertTrue(true);
		}
	}
}
