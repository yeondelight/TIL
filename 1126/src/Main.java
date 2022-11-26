import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1049() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 6개 set와 낱개의 최소가격만 저장
		int min6 = 1001;
		int min1 = 1001;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			min6 = Math.min(min6, Integer.parseInt(st.nextToken()));
			min1 = Math.min(min1, Integer.parseInt(st.nextToken()));
		}
		
		// 모두 세트일때부터 세트를 하나씩 줄여가면서 가격 계산
		int ans = Integer.MAX_VALUE;
		int start = ( N % 6 == 0 ) ? N / 6 : N / 6 + 1; 
		for (int i = start; i >= 0; i--) {
			int single = ( N - i*6 ) < 0 ? 0 : N - i*6;
			int val = i * min6 + single * min1;
			ans = Math.min(ans, val);
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1049();
	}
}
