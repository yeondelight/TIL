import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	public void sol_2960() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int count = 0;
		boolean[] isPrime = new boolean[N+1];
		
		GetPrime:
		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j+=i) {
				if (isPrime[j]) {
					continue;
				}
				isPrime[j] = true;
				count++;
				if (count == K) {
					System.out.println(j);
					break GetPrime;
				}
			}
		}
	}
	
	public void sol_1644() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// get prime
		boolean[] isPrime = new boolean[N+1];
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (isPrime[i]) {
				continue;
			}
			for (int j = i*i; j <= N; j+=i) {
				isPrime[j] = true;
			}
		}

		// store sums
		int sum = 0;
		Vector<Integer> primeSum = new Vector<>();
		primeSum.add(0);
		for (int i = 2; i <= N; i++) {
			if (!isPrime[i]) {
				sum += i;
				primeSum.add(sum);
			}
		}
		
		// two pointer.
		int count = 0;
		int l = 0, r = 0;
		while (l <= r && r < primeSum.size()) {
			int diff = primeSum.get(r) - primeSum.get(l);
			if (diff > N) {
				l++;
			} else if (diff < N) {
				r++;
			} else {
				count++;
				r++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1644();
	}
}
