import static org.junit.Assert.*;

import problems.Fibonacci;

import org.junit.Test;


public class FibonacciTest {

	@Test
	public void testFirstFib() {
		Fibonacci f = new Fibonacci(1);
		assertEquals(0, f.compute());
	}

	@Test
	public void test8thFib() {
		Fibonacci f = new Fibonacci(8);
		assertEquals(13, f.compute());
	}

}
