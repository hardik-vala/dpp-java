package problems;

import java.math.BigInteger;


/**
 * The description and specifications of the <i>Avoid Roads</i> problem are outlined
 * <a href="https://www.hackerrank.com/challenges/fibonacci-modified">here</a>.
 * 
 * @author Hardik Vala
 */
public class FibonacciModified {

    /** First number in the sequence. */
    private int A;
    /** Second number in the sequence. */
    private int B;

    /** n for nth modified Fibonacci number. */
    private int N;

    /** The ith modified Fibonacci number is stored at index i - 1. */
    private BigInteger[] fibs;

    /**
     * Constructor.
     *
     * @param N - N for Nth modified Fibonacci number.
     */
    public FibonacciModified(int A, int B, int N) {
        if (N < 1) throw new IllegalArgumentException("N must be greater than 0");

        this.A = A;
        this.B = B;
        this.N = N;

        this.fibs = new BigInteger[this.N];
    }

    /**
     * Computes the Nth number in the modified Fibonacci sequence using DP.
     *
     * @return Nth Fibonacci number.
     */
    public BigInteger compute() {
        if (this.N == 1) return BigInteger.valueOf(A);
        if (this.N == 2) return BigInteger.valueOf(B);

        this.fibs[0] = BigInteger.valueOf(A);
        this.fibs[1] = BigInteger.valueOf(B);

        for (int i = 2; i < this.N; i++)
            this.fibs[i] = this.fibs[i - 1].multiply(this.fibs[i - 1]).add(this.fibs[i - 2]);

        return this.fibs[this.N - 1];
    }
    
}