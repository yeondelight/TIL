import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public boolean isPalindrome(int n) {
		String s = n+"";
		int sLen = s.length();
		
		for (int i = 0; i < sLen/2; i++) {
			if (s.charAt(i) != s.charAt(sLen-i-1)) {
				return false;
			}
		}
		
		return true;
	}
	
	public void sol_1990() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		// get primes
		int MAX = b;
		boolean[] isPrime = new boolean[MAX+1];
		
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		for (int i = 2; i <= Math.sqrt(MAX); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= MAX; j += i) {
					isPrime[j] = false;
				}
			}
		}
		
		// isPalindrome
		StringBuilder sb = new StringBuilder();
		for (int i = a; i <= b; i++) {
			if (!isPrime[i])		continue;
			if (isPalindrome(i))	sb.append(i).append('\n');
		}
		
		// print
		sb.append(-1);
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1990();
	}
	
}
