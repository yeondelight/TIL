import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public int getGCD(int a, int b) {
		if ( a < b )	return getGCD(b, a);
		if ( b == 0 )	return a;
		return getGCD(b, a % b);
	}
	
	public void sol_17087() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] bros = new int[N];
		StringTokenizer stBros = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int curr = Integer.parseInt(stBros.nextToken());
			bros[i] = Math.abs(S - curr);
		}
		
		int D = bros[0];
		for (int i = 1; i < N; i++) {
			D = getGCD(D, bros[i]);
		}
		
		System.out.println(D);
	}
	
	public void sol_17103() throws Exception {
		
		// get primes
		int MAX = 1000000;
		
		boolean[] isPrime = new boolean[MAX+1];
		Arrays.fill(isPrime, true);
	
		isPrime[0] = isPrime[1] = false;
		
		for (int i = 2; i < Math.sqrt(MAX); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= MAX; j += i) {
					isPrime[j] = false;
				}
			}
		}
		
		
		// get input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			for (int i = 2; i <= N/2; i++) {
				if (isPrime[i] && isPrime[N-i]) {
					cnt++;
				}
			}
			sb.append(cnt).append('\n');
		}
		
		// print
		System.out.println(sb);
	}
	
	public void sol_3896() throws Exception {
		// get primes
		int MAX = 1299709;
		
		boolean[] isPrime = new boolean[MAX+1];
		Arrays.fill(isPrime, true);
		
		isPrime[0] = isPrime[1] = false;
				
		for (int i = 2; i < Math.sqrt(MAX); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= MAX; j += i) {
					isPrime[j] = false;
				}
			}
		}
				
				
		// get input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
			
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			
			// 길이가 0인 경우
			// - 나 자신이 소수다
			// - 첫번째 소수인 2보다 작다
			if (isPrime[k] || k < 2) {
				sb.append(0).append('\n');
				continue;
			}
			
			int cnt = 0;
			
			// k에 가까우면서 k보다 작은 소수
			int tempMin = k;
			while (!isPrime[tempMin]) {
				tempMin--;
				cnt++;
			}
			
			// k에 가까우면서 k보다 큰 소수
			int tempMax = k;
			while (!isPrime[tempMax]) {
				tempMax++;
				cnt++;
			}
			
			sb.append(cnt).append('\n');
		}
				
		// print
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_3896();
	}
}
