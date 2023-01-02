import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1246() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Integer[] P = new Integer[M];
		for (int i = 0; i < M; i++) {
			P[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(P, Collections.reverseOrder());
		
		int cost = 0;
		int profit = 0;
		int lastIdx = Math.min(N, M);
		for (int i = 0; i < lastIdx; i++) {
			int val = (i+1) * P[i];
			if (profit < val) {
				profit = val;
				cost = P[i];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cost).append(' ').append(profit);
		System.out.println(sb);
	}
	
	public void sol_1758() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] cus = new Integer[N];
		for (int i = 0; i < N; i++) {
			cus[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(cus, Collections.reverseOrder());
		
		long sum = 0;
		for (int i = 0; i < N; i++) {
			long tip = cus[i] - i;
			if (tip < 0)	break;
			else			sum += tip;
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1758();
	}
}
