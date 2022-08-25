import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_17404() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3];
		int[][] color = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			color[i][0] = Integer.parseInt(st.nextToken());
			color[i][1] = Integer.parseInt(st.nextToken());
			color[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// 첫 집을 고정하고 최소값 구하기
		int res = 1000001;
		for (int i = 0; i < 3; i++) {	// 첫 집을 i로 고정
			// color init
			dp[1][0] = dp[1][1] = dp[1][2] = 1000001;
			dp[1][i] = color[1][i];
			
			// N까지의 나머지 집에 대해 최소값 구하기
			for (int j = 2; j <= N; j++) {
				dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + color[j][0];
				dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + color[j][1];
				dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + color[j][2];
			}
			
			// i를 제외한 dp[N][*]값에 대해 최소 res 계산
			for (int j = 0; j < 3; j++) {
				if (i != j) {
					res = Math.min(res, dp[N][j]);
				}
			}
			
		}
				
		// print
		System.out.println(res);
	}

	public void sol_9252() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str1 = br.readLine();
		String str2 = br.readLine();
	
		int max = 0;
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		for (int i = 1; i <= len1; i++) {
			char c1 = str1.charAt(i-1);
			for (int j = 1; j <= len2; j++) {
				char c2 = str2.charAt(j-1);
				if (c1 == c2) {		// 두 문자가 같은 경우 직전 값에서 1 더하기
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {				// 두 문자가 다른 경우 근처 값중 큰 값 받기
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		
		
		// print MAX
		sb.append(max).append('\n');
		
		// print LCS
		if (max != 0) {
			
			int x = len1;
			int y = len2;
			
			// trace route
			Stack<Character> s = new Stack<>();
			while (x > 0 && y > 0) {
				if (dp[x][y] == dp[x-1][y])			x -= 1;
				else if (dp[x][y] == dp[x][y-1])	y -= 1;
				else {
					x -= 1;
					y -= 1;
					if (str1.charAt(x) == str2.charAt(y)) {
						s.push(str1.charAt(x));
					}
				}
			}
			
			while (!s.isEmpty()) {
				sb.append(s.pop());
			}
			
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_9252();
	}
}
