import static org.junit.Assert.*;

import problems.StockMaximize;

import org.junit.Test;


public class StockMaximizeTest {

	private int[] monotonicallyDecreasingPrices = {5, 3, 2};
	private int[] monotonicallyIncreasingPrices = {1, 2, 100};
	private int[] oscillatingPrices = {1, 3, 1, 2};

	@Test
	public void testMonotonicallyDecreasingPricesForDPSol() {
		StockMaximize sm = new StockMaximize(this.monotonicallyDecreasingPrices);
		assertEquals(sm.calculateDP(), 0);
	}

	@Test
	public void testMonotonicallyDecreasingPricesForNonDPSol() {
		StockMaximize sm = new StockMaximize(this.monotonicallyDecreasingPrices);
		assertEquals(sm.calculateNonDP(), 0);
	}

	@Test
	public void testMonotonicallyIncreasingPricesForDPSol() {
		StockMaximize sm = new StockMaximize(this.monotonicallyIncreasingPrices);
		assertEquals(sm.calculateDP(), 197);
	}

	@Test
	public void testMonotonicallyIncreasingPricesForNonDPSol() {
		StockMaximize sm = new StockMaximize(this.monotonicallyIncreasingPrices);
		assertEquals(sm.calculateNonDP(), 197);
	}

	@Test
	public void testOscillatingPricesForDPSol() {
		StockMaximize sm = new StockMaximize(this.oscillatingPrices);
		assertEquals(sm.calculateDP(), 3);
	}

	@Test
	public void testOscillatingPricesForNonDPSol() {
		StockMaximize sm = new StockMaximize(this.oscillatingPrices);
		assertEquals(sm.calculateNonDP(), 3);
	}

}
