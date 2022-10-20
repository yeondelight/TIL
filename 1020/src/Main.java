import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_4948() throws Exception {
		// check primes
		int MAX = 123456*2;
		boolean[] isPrime = new boolean[MAX+1];
		
		for (int i = 2; i < Math.sqrt(MAX); i++) {
			if (isPrime[i]) {
				continue;
			}
			for (int j = i * i; j <= MAX; j += i) {
				isPrime[j] = true;
			}
		}
		
		// get input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			int ans = 0;
			for (int i = n+1; i <= n*2; i++) {
				if (!isPrime[i]) {
					ans++;
				}
			}
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_4948();
	}
}
