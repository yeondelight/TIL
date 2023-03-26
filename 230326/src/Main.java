import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public int howManyKinN(int K, int N) {
		int cnt = 0;
		while (N/K > 0) {
			cnt += N/K;
			N /= K;
		}
		return cnt;
	}
	
	public void sol_2004() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
	
		int nfac2 = howManyKinN(2, n);
		int mfac2 = howManyKinN(2, m);
		int difffac2 = howManyKinN(2, n-m);
	
		int nfac5 = howManyKinN(5, n);
		int mfac5 = howManyKinN(5, m);
		int difffac5 = howManyKinN(5, n-m);
		
		int ans = Math.min(nfac2 - (mfac2 + difffac2), nfac5 - (mfac5 + difffac5));
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2004();
	}

}
