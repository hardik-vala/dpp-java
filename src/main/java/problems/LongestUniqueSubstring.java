package problems;

import java.lang.Math;
import java.util.HashMap;
import java.util.Map;


/**
 * The description and specifications of the <i>Longest Unique Substring/i> problem are outlined
 * <a href="http://codercareer.blogspot.ca/2013/11/no-49-longest-substring-without.html">here</a>.
 * 
 * @author Hardik Vala
 */
public class LongestUniqueSubstring {
	
	/** Input string. */
	private String S;

	/**
	 * Constructor.
	 *
	 * @param S - Input string.
	 */
	public LongestUniqueSubstring(String S) {
		this.S = S;
	}

	/**
	 * Finds the length of the longest unique substring using DP, using a solution with O(N)
     * running-time and O(N) space (where N is the length of the input string).
	 *
	 * @return Length of the longest unique substring.
	 */
	public int findDP() {
        if (this.S.length() == 0) return 0;

        // Index i stores the length of the longest unique substring of S ending at the character at
        // index i of S (inclusive).
        int[] longestUniqueSubstringLens = new int[this.S.length()];
        longestUniqueSubstringLens[0] = 1;

        // Stores the last index for each character in S seen so far.
        Map<Character, Integer> lastIndexOfCharsSoFar = new HashMap<Character, Integer>() {{
            put(S.charAt(0), 0);
        }};

        // Tracks the length of the longest unique substring seen so far so that there's no need to
        // iterate longestUniqueSubstringLens afterwards, this variable can be directly returned.
        int longestUniqueSubstringLen = 1;
        for (int i = 1; i < this.S.length(); i++) {
            char currChar = this.S.charAt(i);

            // The current character has been seen before.
            if (lastIndexOfCharsSoFar.containsKey(currChar)) {
                int lastIndexOfCurrChar = lastIndexOfCharsSoFar.get(currChar);
                int distToLastIndexOfCurrChar = i - lastIndexOfCurrChar;
                // If this distance to the most recent duplicate of the current character is beyond
                // the longest unique substring for the previous character, then we safely add the
                // current character.
                if (distToLastIndexOfCurrChar > longestUniqueSubstringLens[i - 1])
                    longestUniqueSubstringLens[i] = longestUniqueSubstringLens[i - 1] + 1;
                // Otherwise a new unique subtring must be started just after that duplicate.
                else
                    longestUniqueSubstringLens[i] = distToLastIndexOfCurrChar;
            // This is the first time this character has been encountered.
            } else
                longestUniqueSubstringLens[i] = longestUniqueSubstringLens[i - 1] + 1;

            lastIndexOfCharsSoFar.put(currChar, i);
            longestUniqueSubstringLen = Math.max(longestUniqueSubstringLen,
                longestUniqueSubstringLens[i]);
        }

        return longestUniqueSubstringLen;
	}

    /**
     * Finds the length of the longest unique substring using DP without the unnecessary memoization
     * of all the solutions to subproblems (i.e. the lengths of the longest unique substring ending
     * at each character of the input string), resulting in a solution with O(N) running-time and
     * O(N) space (where N is the length of the input string).
     *
     * @return Length of the longest unique substring.
     */
    public int findDPWithNoMemo() {
        if (this.S.length() == 0) return 0;

        // Stores the last index for each character in S seen so far.
        Map<Character, Integer> lastIndexOfCharsSoFar = new HashMap<Character, Integer>() {{
            put(S.charAt(0), 0);
        }};

        // Tracks the length of the longest unique substring ending at the current character of S.
        int currlongestUniqueSubstringLen = 1;
        // Tracks the length of the longest unique substring seen so far.
        int longestUniqueSubstringLen = currlongestUniqueSubstringLen;
        for (int i = 1; i < this.S.length(); i++) {
            char currChar = this.S.charAt(i);

            // The current character has been seen before.
            if (lastIndexOfCharsSoFar.containsKey(currChar)) {
                int lastIndexOfCurrChar = lastIndexOfCharsSoFar.get(currChar);
                int distToLastIndexOfCurrChar = i - lastIndexOfCurrChar;
                // If this distance to the most recent duplicate of the current character is beyond
                // the longest unique substring for the previous character, then we safely add the
                // current character.
                if (distToLastIndexOfCurrChar > currlongestUniqueSubstringLen)
                    currlongestUniqueSubstringLen++;
                // Otherwise a new unique subtring must be started just after that duplicate.
                else
                    currlongestUniqueSubstringLen = distToLastIndexOfCurrChar;
            // This is the first time this character has been encountered.
            } else
                currlongestUniqueSubstringLen++;

            lastIndexOfCharsSoFar.put(currChar, i);
            longestUniqueSubstringLen = Math.max(longestUniqueSubstringLen,
                currlongestUniqueSubstringLen);
        }

        return longestUniqueSubstringLen;
    }

    /**
     * Finds the length of the longest unique substring using Non-DP, sliding window approach,
     * resulting in a solution with O(N) running-time and O(N) space (where N is the length of the
     * input string).
     *
     * @return Length of the longest unique substring.
     */
    public int findNonDP() {
        // Stores the last index for each character in S seen so far.
        Map<Character, Integer> lastIndexOfCharsSoFar = new HashMap<>();

        // Delimit a sliding window across S consisting of only unique characters.
        int behindIdx = 0;
        int aheadIdx = 0;
        // Tracks the length of the longest unique substring seen so far.
        int longestUniqueSubstringLen = 0;
        while (behindIdx < this.S.length() && aheadIdx < this.S.length()) {
            char aheadChar = this.S.charAt(aheadIdx);
            if (lastIndexOfCharsSoFar.containsKey(aheadChar))
                behindIdx = lastIndexOfCharsSoFar.get(aheadChar) + 1;

            lastIndexOfCharsSoFar.put(aheadChar, aheadIdx);
            longestUniqueSubstringLen = Math.max(longestUniqueSubstringLen, (++aheadIdx) - behindIdx);
        }

        return longestUniqueSubstringLen;
    }

}
