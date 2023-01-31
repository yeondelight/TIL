import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	public void sol_1793() throws Exception {
		BigInteger ONE = BigInteger.ONE;
		BigInteger TWO = BigInteger.TWO;
		
		BigInteger[] dp = new BigInteger[251];
		dp[0] = BigInteger.ONE;
		dp[1] = BigInteger.ONE;
		
		for (int i = 2; i < 251; i++) {
			if (i % 2 == 0)	dp[i] = dp[i-1].multiply(TWO).add(ONE);
			else			dp[i] = dp[i-1].multiply(TWO).subtract(ONE);
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String str = br.readLine();
			if (str == null || str == "") {
				break;
			}
			int n = Integer.parseInt(str);
			sb.append(dp[n]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1793();
	}
}
