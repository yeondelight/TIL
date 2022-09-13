import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public void sol_5582() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
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
				else {				// 두 문자가 다른 경우 reset
					dp[i][j] = 0;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		
		
		// print MAX
		System.out.println(max);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_5582();
	}
}