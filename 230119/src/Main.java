import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1747() throws Exception {
		
		// 1,000,000까지의 소수 판정
		int MAX = 2000000;
		boolean[] notPrime = new boolean[MAX];
		notPrime[1] = true;
		for (int i = 2; i < Math.sqrt(MAX); i++) {
			for (int j = i * i; j < MAX; j+=i) {
				notPrime[j] = true;
			}
		}
		
		
		// scan
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for (int i = N; ; i++) {
			// N보다 크거나 같고, 소수이면
			if (!notPrime[i]) {
				// 팰린드롬을 확인한다.
				boolean isPalin = true;
				String int2Str = Integer.toString(i);
				for (int a = 0, b = int2Str.length() - 1; a < (int2Str.length() / 2); a++, b--) {
					if (int2Str.charAt(a) != int2Str.charAt(b)) {
						isPalin = false;
						break;
					}
				}
				if (isPalin) {
					System.out.println(int2Str);
					return;
				}
			}
		}
	}
	
	// 항상 a >= b일 것이다.
	public long getGcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return getGcd(b, a % b);
	}
	
	public void sol_1850() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseUnsignedLong(st.nextToken());
		long B = Long.parseUnsignedLong(st.nextToken());
		
		long cnt;
		
		if (A > B)	cnt = getGcd(A, B);
		else		cnt = getGcd(B, A);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt; i++) {
			sb.append('1');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1850();
	}
}
