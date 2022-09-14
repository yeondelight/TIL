import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public void sol_1958() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();
	
		int max = 0;
		int[][][] dp = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1];
		
		int len1 = str1.length();
		int len2 = str2.length();
		int len3 = str3.length();
		
		for (int i = 1; i <= len1; i++) {
			char c1 = str1.charAt(i-1);
			for (int j = 1; j <= len2; j++) {
				char c2 = str2.charAt(j-1);
				for (int k = 1; k <= len3; k++) {
					char c3 = str3.charAt(k-1);
					if (c1 == c2 && c2 == c3) {		// 세 문자가 같은 경우 직전 값에서 1 더하기
						dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
					}
					else {				// 두 문자가 다른 경우 근처 값중 큰 값 받기
						dp[i][j][k] = Math.max(dp[i][j][k-1], Math.max(dp[i][j-1][k], dp[i-1][j][k]));
					}
					max = Math.max(max, dp[i][j][k]);
				}
			}
		}
		
		
		// print MAX
		System.out.println(max);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1958();
	}
}