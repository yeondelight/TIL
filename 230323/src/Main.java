import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public int getGCD(int a, int b) {
		if ( a < b )	return getGCD(b, a);
		if ( b == 0 )	return a;
		return getGCD(b, a % b);
	}
	
	public void sol_2725() throws Exception {
		
		// 미리 개수 저장하기
		int MAX = 1000;
		int[] dp = new int[MAX+1];

		dp[1] = 3;	// N은 최소 1이므로 1일때의 경우의 수 3 고정
		
		int sum = 3;
		for (int i = 2; i <= MAX; i++) {	// 고정되는 y좌표
			int tempCnt = 0;
			for (int j = 1; j < i; j++) {	// 1 ~ i-1까지의 x좌표
				if (getGCD(i, j) == 1) {
					tempCnt++;
				}
			}
			sum += tempCnt * 2;
			dp[i] = sum;
		}
		
		// get input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(br.readLine());
		
		for (int c = 0; c < C; c++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2725();
	}
}
