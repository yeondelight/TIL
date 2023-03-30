import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_15954() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		double[] num = new double[N];
		StringTokenizer stNum = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Double.parseDouble(stNum.nextToken());
		}
		
		
		// 최소 표준편차
		double minS2 = Double.MAX_VALUE;
		
		// k는 고르는 인형의 수
		for (int k = K; k <= N; k++) {
			
			// i는 시작 idx
			for (int i = 0; i <= N-k; i++) {
				
				// 평균 구하기
				double m = 0.0;
				for (int j = i; j < i+k; j++) {
					m += num[j] / k;
				}
				
				// 분산 구하기
				double sum = 0;
				for (int j = i; j < i+k; j++) {
					sum += Math.pow(num[j] - m, 2) / k;
				}
				
				// 표준편차 갱신
				minS2 = Math.min(minS2, Math.sqrt(sum));
			}
		}
		
		// print
		System.out.println(String.format("%.11f", minS2));
	}

	public static void main(String[] args) throws Exception {
		new Main().sol_15954();
	}
	
}
