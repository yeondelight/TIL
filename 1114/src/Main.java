import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public void sol_2012() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(score);
		
		long ans = 0;
		for (int i = 1; i <= N; i++) {
			ans += Math.abs(score[i] - i);
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2012();
	}
}
