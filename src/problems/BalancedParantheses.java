import java.util.ArrayList;
import java.util.LinkedList;

public class BalancedParantheses {

	private static final String EMPTY_PARAN = "";
	private static final char RIGHT_PARAN = '(';
	private static final char LEFT_PARAN = ')';
	
	private static final int N = 5;
	
	private static final boolean DISPLAY_PARANS = false;
	
	public static void main(String[] args) {
		
		if (DISPLAY_PARANS) {
			LinkedList<String> balParans = getBalancedParantheses_DP(N);
			long numBalParans = (N == 0) ? 0 : balParans.size();
			
			System.out.println("Balanced Parantheses of size " + N + " (" + numBalParans + "):\n");
			
			int i = 1;
			for (String p : balParans) {
				System.out.print(p);
				if (i < numBalParans) System.out.print(", ");
				i++;
			}
		} else {
			System.out.print("Number of balanced parantheses of size " + N + ": " + getNumBalancedParantheses_DP(N));
		}
	}

	private static long getNumBalancedParantheses_DP (int n) {
		if (n == 0) return 0;
		
		long[] numBalParans = new long[n + 1];
		numBalParans[0] = 1;
		numBalParans[1] = 1;
		
		for (int i = 2; i <= n ; i++) {
			for (int j = 0; j <= (i - 1); j++) {
				numBalParans[i] += numBalParans[j] * numBalParans[i - 1 - j];
			}
		}
		
		return numBalParans[n];
	}
		
	private static LinkedList<String> getBalancedParantheses_DP (int n) {
		ArrayList<LinkedList<String>> balParans = new ArrayList<LinkedList<String>>(n + 1);
		
		LinkedList<String> emptyParanList = new LinkedList<String>();
		emptyParanList.add(EMPTY_PARAN);
		balParans.add(0, emptyParanList);
		
		for (int i = 1; i <= n; i++) {
			LinkedList<String> balParanForSize = new LinkedList<String>();
			
			for (int j = 0; j <= (i - 1); j++) {
				for (String p1 : balParans.get(j)) {
					for (String p2 : balParans.get(i - 1 - j)) {
						balParanForSize.add(RIGHT_PARAN + p1 + LEFT_PARAN + p2);
					}
				}
			}
			
			balParans.add(i, balParanForSize);
		}
		
		return balParans.get(n);
	}
	
	private static LinkedList<String> getBalancedParantheses_Rec (int n) {
		LinkedList<String> balParans = new LinkedList<String>();
		
		if (n == 0) {
			balParans.add(EMPTY_PARAN);
			return balParans;
		}
		
		for (int i = 0; i <= (n - 1); i++) {
			for (String p1 : getBalancedParantheses_Rec(i)) {
				for (String p2 : getBalancedParantheses_Rec(n - 1 - i)) {
					balParans.add(RIGHT_PARAN + p1 + LEFT_PARAN + p2);
				}
			}
		}
		
		return balParans;
	}
}
