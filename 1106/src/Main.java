import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_2437() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] weight = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(weight);
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (weight[i] > sum + 1) {;
				break;
			}
			sum += weight[i];
		}
		
		System.out.println(sum+1);
	}
	
	public void sol_1789() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		
		// 1부터 n까지의 누적합은 n(n+1)/2.
		// 즉, 2*누적합 = n(n+1).
		// n(n+1)의 값이 2*S보다 처음으로 작아지는 때가 답.
		long cmp = 2*S;
		long n = (long)Math.sqrt(cmp);
		
		long val = n*(n+1);
		while (val > cmp) {
			n -= 1;
			val = n*(n+1);
		}
		
		System.out.println(n);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1789();
	}
}
