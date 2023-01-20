import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main { 
	
	public void sol_2312() throws Exception {
		
		// 100,000까지의 소수 판정
		int MAX = 200000;
		boolean[] notPrime = new boolean[MAX];
		for (int i = 2; i < Math.sqrt(MAX); i++) {
			for (int j = i * i; j < MAX; j+=i) {
				notPrime[j] = true;
			}
		}
		
		// scan
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> fac = new TreeMap<>();
			
			// 소인수분해
			while (N > 1) {
				for (int j = 2; j <= N; j++) {
					if (notPrime[j])	continue;
					if (N % j == 0) {
						if (!fac.containsKey(j)) {
							fac.put(j, 1);
						} else {
							fac.put(j, fac.get(j) + 1);
						}
						N /= j;
						break;
					}
				}
			}
			
			for (int key : fac.keySet()) {
				sb.append(key).append(' ').append(fac.get(key)).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2312();
	}
}
