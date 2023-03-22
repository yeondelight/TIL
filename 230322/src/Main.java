import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public void sol_15965() throws Exception {
		
		int MAX = 10000000;
		
		boolean[] isPrime = new boolean[MAX];
		Arrays.fill(isPrime, true);
		
		for (int i = 2; i < Math.sqrt(MAX); i++) {
			if (!isPrime[i]) {
				continue;
			}
			for (int j = i * i; j < MAX; j += i) {
				isPrime[j] = false;
			}
		}
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for (int i = 2; i < MAX; i++) {
			if (isPrime[i]) {
				cnt++;
				if (cnt == K) {
					System.out.println(i);
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_15965();
	}
}
