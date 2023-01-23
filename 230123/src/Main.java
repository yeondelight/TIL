import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_15312() throws Exception {
		int[] alpha = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		
		int size = A.length() * 2;
		int[] dp = new int[size];
		for (int i = 0; i < size; i+=2) {
			dp[i] = alpha[A.charAt(i/2) - 'A'];
		}
		for (int i = 1; i < size; i+=2) {
			dp[i] = alpha[B.charAt(i/2) - 'A'];
		}
		
		while (size > 2) {
			for (int i = 0; i < size-1; i++) {
				dp[i] = dp[i] + dp[i+1];
				dp[i] %= 10;
			}
			size--;
		}
		
		
		System.out.print(dp[0]);
		System.out.print(dp[1]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_15312();
	}
}
