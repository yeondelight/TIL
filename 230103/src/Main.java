import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public void sol_11508() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] milk = new long[N];
		long sum = 0;
		
		for (int i = 0; i < N; i++) {
			milk[i] = Long.parseLong(br.readLine());
			sum += milk[i];
		}
		Arrays.sort(milk);
		
		long free = 0;
		long cnt = N/3;
		int i = N-3;
		
		// 무료 유제품의 합 구하기
		while(cnt > 0) {
			free += milk[i];
			cnt--;
			i-=3;
		}
		
		System.out.println(sum - free);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11508();
	}
}
