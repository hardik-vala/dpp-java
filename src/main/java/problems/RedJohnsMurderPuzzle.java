package problems;


/**
 * The description and specifications of the <i>Red John's Murder Puzzle</i> problem are provided
 * here:
 * 
 * https://www.hackerrank.com/challenges/red-john-is-back
 * 
 * @author Hardik Vala
 */
public class RedJohnsMurderPuzzle {
	
	/** Width of the wall (The wall is of size 4 x N in the victim's house). */
	private int N;
	/** The value at index i represents the # of ways of arranging bricks on a wall of size
      * 4 x i. */
	private int[] numBrickArrangements;

	/**
	 * Constructor.
	 *
	 * @param N - Width of the wall.
	 */
	public RedJohnsMurderPuzzle(int N) {
		this.N = N;

		this.numBrickArrangements = new int[N + 1];
	}

    // Count the # of brick arrangements for the wall.
    private int countBrickArrangements() {
        if (this.N < 4) return 1;

        // For walls with width less than 4, bricks can only be arranged in one
        // way using bricks of size 4 x 1.
        this.numBrickArrangements[0] = 1;
        this.numBrickArrangements[1] = 1;
        this.numBrickArrangements[2] = 1;
        this.numBrickArrangements[3] = 1;

        for (int i = 4; i <= this.N; i++)
            this.numBrickArrangements[i] = this.numBrickArrangements[i - 1] +
                this.numBrickArrangements[i - 4];
        
        return this.numBrickArrangements[this.N];
    }

    // Count the # of primes <= M using a simple imlementation of the Sieve of Eratosthenes.
    private static int countPrimes(int M) {
        boolean[] isPrime = new boolean[M - 1];
        
        for (int i = 0; i < M - 1; i++) isPrime[i] = true;
        
        for (int n = 2; n <= M; n++) {
            if (isPrime[n - 2]) {
                for (int i = 2 * n - 2; i < M - 1; i += n) isPrime[i] = false;
            }
        }
        
        int numPrimes = 0;
        for (int i = 0; i < M - 1; i++) {
            if (isPrime[i]) numPrimes++;
        }
        
        return numPrimes;
    }

	/**
	 * Solve Red John's Murder Puzzle.
	 *
	 * @return # of primes <= M, where M is the # of ways of arranging bricks on the wall.
	 */
	public long solve() {
		return countPrimes(this.countBrickArrangements());
	}

}
