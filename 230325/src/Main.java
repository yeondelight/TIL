import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static long MAX = 1000000;

	public long removeZero(long n) {
		while (n % 10 == 0) {
			n /= 10;
		}
		return n % MAX;
	}
	
	public void sol_2553() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long ans = 1;
		for (int i = 2; i <= N; i++) {
			long curr = removeZero(i);
			long fact = ans * curr;
			ans = removeZero(fact);
		}
		
		System.out.println(ans % 10);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2553();
	}
}
