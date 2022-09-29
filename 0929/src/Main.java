import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_6588() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// check prime
		int MAX = 1000001;
		boolean[] isPrime = new boolean[MAX];
		
		for (int i = 2; i < MAX; i++) {
			isPrime[i] = true;	
		}
		for (int i = 2; i < Math.sqrt(MAX); i++) {
			if (!isPrime[i]) {
				continue;
			}
			for (int j = i * i; j < MAX; j += i) {
				isPrime[j] = false;
			}
		}
		
		// get input
		int num;
		while ((num = Integer.parseInt(br.readLine())) != 0) {
			boolean flag = false;
			int l = 3;
			int r = num - 3;
			while (l <= r) {	// two pointer.
				if (isPrime[l] && isPrime[r]) {
					flag = true;
					break;
				} else {
					l++;
					r--;
				}
			}
			
			if (flag) {
				sb.append(num).append(" = ").append(l).append(" + ").append(r);
			} else {
				sb.append("Goldbach's conjecture is wrong.");
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_6588();
	}

}
