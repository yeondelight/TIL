import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1124() throws Exception {
		
		int MAX = 100000;
		boolean[] prime = new boolean[MAX+1];
		int[] primeCnt = new int[MAX+1];
		
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		
		for (int i = 2; i <= MAX; i++) {
			if (!prime[i]) {
				continue;
			}
			for (int j = i * 2; j <= MAX; j += i) {
				int tempVal = j;
				prime[j] = false;
				while (tempVal % i == 0) {
					primeCnt[j]++;
					tempVal /= i;
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		for (int i = A; i <= B; i++) {
			if (prime[primeCnt[i]])	cnt++;
		}
		
		System.out.println(cnt);
	}

	public static void main(String[] args) throws Exception {
		new Main().sol_1124();
	}
	
}
