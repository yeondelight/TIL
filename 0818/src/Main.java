import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_2473() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		long[] liq = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liq[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(liq);
		
		long[] res = new long[3];							// 3개의 답을 저장한다.
		for (int i = 0; i < 3; i++) {
			res[i] = liq[i];
		}
		long val = Math.abs(liq[0] + liq[1] + liq[2]);	// 비교를 위한 초기 값
		
		for (int i = 0; i < N-2; i++) {					// i번째 요소를 고정
			int start = i+1;
			int end = N-1;
			while (start < end) {
				long tempVal = liq[i] + liq[start] + liq[end];
				if (Math.abs(tempVal) < val) {
					val = Math.abs(tempVal);
					res[0] = liq[i];
					res[1] = liq[start];
					res[2] = liq[end];
				}
				if (tempVal < 0)	start++;
				else				end--;
			}
			
		}
		
		// print
		for (int i = 0; i < 3; i++) {
			sb.append(res[i] + " ");
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2473();
	}
}
