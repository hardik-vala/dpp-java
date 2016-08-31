import static org.junit.Assert.*;
import org.junit.Test;

import problems.LongestUniqueSubstring;


public class LongestUniqueSubstringTest {

	@Test
	public void testDPSolOnSingleCharString() {
		LongestUniqueSubstring lus = new LongestUniqueSubstring("aaa");
		assertEquals(1, lus.findDP());
	}

	@Test
	public void testDPSolWithNoMemoOnSingleCharString() {
		LongestUniqueSubstring lus = new LongestUniqueSubstring("aaa");
		assertEquals(1, lus.findDPWithNoMemo());
	}

	@Test
	public void testNonDPSolOnSingleCharString() {
		LongestUniqueSubstring lus = new LongestUniqueSubstring("aaa");
		assertEquals(1, lus.findNonDP());
	}

	@Test
	public void testDPSolOnUniqueString() {
		LongestUniqueSubstring lus = new LongestUniqueSubstring("abcde");
		assertEquals(5, lus.findDP());
	}

	@Test
	public void testDPSolWithNoMemoOnUniqueString() {
		LongestUniqueSubstring lus = new LongestUniqueSubstring("abcde");
		assertEquals(5, lus.findDPWithNoMemo());
	}

	@Test
	public void testNonDPSolOnUniqueString() {
		LongestUniqueSubstring lus = new LongestUniqueSubstring("abcde");
		assertEquals(5, lus.findNonDP());
	}

	@Test
	public void testDPSolOnSmallStringWithDuplicates() {
		LongestUniqueSubstring lus = new LongestUniqueSubstring("abcabcbb");
		assertEquals(3, lus.findDP());
	}

	@Test
	public void testDPSolWithNoMemoOnSmallStringWithDuplicates() {
		LongestUniqueSubstring lus = new LongestUniqueSubstring("abcabcbb");
		assertEquals(3, lus.findDPWithNoMemo());
	}

	@Test
	public void testNonDPSolOnSmallStringWithDuplicates() {
		LongestUniqueSubstring lus = new LongestUniqueSubstring("abcabcbb");
		assertEquals(3, lus.findNonDP());
	}

	@Test
	public void testDPSolOnAnotherSmallStringWithDuplicates() {
		LongestUniqueSubstring lus = new LongestUniqueSubstring("pwwkew");
		assertEquals(3, lus.findDP());
	}

	@Test
	public void testDPSolWithNoMemoOnAnotherSmallStringWithDuplicates() {
		LongestUniqueSubstring lus = new LongestUniqueSubstring("pwwkew");
		assertEquals(3, lus.findDPWithNoMemo());
	}

	@Test
	public void testNonDPSolOnAnotherSmallStringWithDuplicates() {
		LongestUniqueSubstring lus = new LongestUniqueSubstring("pwwkew");
		assertEquals(3, lus.findNonDP());
	}

}
