import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static long[] P;
	public static long[] Total;
	
	public long getPatty(int n, long x) {
		if (n == 0) {
			if (x == 0)		return 0;
			else			return 1;
		}
		if (x == 1) {							// B
			return 0;
		}
		else if (x <= (1 + Total[n-1])) {		// L-1 버거
			return getPatty(n-1, x-1);
		}
		else if (x == (1 + Total[n-1]) + 1) {	// P
			return P[n-1] + 1;
		}
		else if (x <= (1 + Total[n-1]) * 2) {	// L-1 버거
			long newX = x - 1 - Total[n-1] - 1;
			return P[n-1] + 1 + getPatty(n-1, newX);
		}
		else {									// B
			return 2 * P[n-1] + 1;
		}
	}
	
	public void sol_16974() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long X = Long.parseLong(st.nextToken());
		
		P = new long[N+1];
		Total = new long[N+1];
		
		P[0] = 1;
		Total[0] = 1;
		for (int i = 1; i <= N; i++) {
			Total[i] = 2 * Total[i-1] + 3;
			P[i] = 2 * P[i-1] + 1;
		}
		
		System.out.println(getPatty(N, X));
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_16974();
	}

}
