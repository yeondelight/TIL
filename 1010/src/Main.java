import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public void sol_9020() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// get prime num
		int MAX = 10001;
		boolean[] isPrime = new boolean[MAX];
		for (int i = 2; i < Math.sqrt(MAX); i++) {
			if (isPrime[i]) {
				continue;
			}
			for (int j = i * i; j < MAX; j+=i) {
				isPrime[j] = true;
			}
		}
		
		// get TC
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int l = n/2;
			int r = n/2;
			while (l > 0 && r < n) {
				if (!isPrime[l] && !isPrime[r]) {
					sb.append(l).append(' ').append(r).append('\n');
					break;
				}
				else {
					l--;
					r++;
				}
			}
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_9020();
	}
}
