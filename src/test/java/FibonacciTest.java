import static org.junit.Assert.*;

import problems.Fibonacci;

import org.junit.Test;


public class FibonacciTest {

	@Test
	public void testFirstFib() {
		Fibonacci f = new Fibonacci(1);
		assertEquals(f.compute(), 0);
	}

	@Test
	public void test8thFib() {
		Fibonacci f = new Fibonacci(8);
		assertEquals(f.compute(), 13);
	}

}
