import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1456() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		// 최대치 까지의 소수 판정
		int MAX = (int) Math.ceil(Math.sqrt(B));
		
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
		
		// A부터 B까지의 소수 세기
		long cnt = 0;
		
		for (int i = 2; i <= MAX; i++) {
			if (isPrime[i]) {
				long val = i;
				while ((double) i <= (double) B / val) {
					if ((double) i >= (double) A / val) {
						cnt++;
					}
					val *= i;
				}
			}
		}
		
		// 결과 출력
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1456();
	}

}
