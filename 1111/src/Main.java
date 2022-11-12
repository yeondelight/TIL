import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_2847() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N];
		
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 0;
		for (int i = N-1; i > 0; i--) {
			if (score[i] > score[i-1]) {
				continue;
			} else {
				ans += (score[i-1] - score[i] + 1);
				score[i-1] = score[i] - 1;
			}
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2847();
	}
}
