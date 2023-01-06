import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_20044() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] w = new int[2*n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2*n; i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(w);
		
		int min = 200000;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, w[i] + w[2*n-i-1]);
		}
		
		System.out.println(min);
	}
	
	public void sol_5545() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] D = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			D[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(D, Collections.reverseOrder());
		
		int kcal = C;	// 초기에는 도우의 열량
		int cost = A;	// 초기에는 도우의 가격
		int perKcal = C/A;
		for (int i = 0; i < N; i++) {
			kcal += D[i];
			cost += B;
			perKcal = Math.max(perKcal, kcal/cost);
		}
		
		System.out.println(perKcal);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_5545();
	}

}
