import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class SOL18110 {

	public static BufferedReader br;
	
	public int n;
	public int[] score;
	public int ans;
	
	public SOL18110() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		n = Integer.parseInt(br.readLine());
		score = new int[n];
		for (int i = 0; i < n; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
	}
	
	public void solution() {

		// n이 0인 경우 처리
		if (n == 0) {
			ans = 0;
			return;
		}
		
		
		Arrays.sort(score);
		
		// 15% 계산
		int sum = 0;
		int cnt = 0;
		int exc = (int) Math.round(n * 0.15);
		for (int i = exc; i < n - exc; i++) {
			sum += score[i];
			cnt++;
		}
		
		ans = (int) Math.round((double)sum / cnt);
	}
	
	public void print() {
		System.out.println(ans);
	}
}
