package problems;

import java.util.List;


/**
 * The description and specifications of the <i>Decode Ways</i> problem are outlined
 * <a href="http://www.programcreek.com/2014/06/leetcode-decode-ways-java">here</a>.
 * 
 * @author Hardik Vala
 */
public class DecodeWays {

	/** Message sequence of digits. */
	private List<Short> message;
	/** Array storing the number of ways of decoding the message ending at index i. */
	int[] counts;

	/**
	 * Constructor.
	 *
	 * @param message - Input message, as a sequence of digits.
	 * @precondition Message elements are digits.
	 */
	public DecodeWays(List<Short> message) {
		this.message = message;
	}

	/**
	 * Counts all ways of decoding the input message.
	 *
	 * @return # of such ways.
	 */
	public int count() {
		// Size of the message (i.e. number of digits).
		int size = this.message.size();

		// If the message is empty, then there are 0 ways to decode it.
		if (size == 0) return 0;

		this.counts = new int[size];
		// There is only one way of decoding the first digit of the message.
		this.counts[0] = 1;

		// Iterate through the digits of the message, one digit at a time.
		for (int i = 1; i < size; i++) {
			// If the last two digits correspond to a decodable, then the number of ways to decode
			// is equal to the number of ways up to the last digit plus the number of ways to the
			// second last digit. 
			if (message.get(i - 1) * 10 + message.get(i) <= 26) {
				if (i >= 2)
					this.counts[i] = this.counts[i - 1] + this.counts[i - 2];
				else
					// If the first two digits correspond to a decodable, then there are two ways to
					// decode the message so far.
					this.counts[i] = this.counts[i - 1] + 1;
			// Otherwise, it's equal to the number of ways to decode up to the second last digit.
			} else
				this.counts[i] = this.counts[i - 1];
		}

		return this.counts[size - 1];
	}

}
