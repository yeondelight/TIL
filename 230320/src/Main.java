import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	
public void sol_4375() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			
			String str = br.readLine();
			if (str == "" || str == null) {
				break;
			}
			
			BigInteger n = new BigInteger(str);
			BigInteger bi = BigInteger.ONE;
			
			int ans;
			for (ans = 1; ; ans++) {
				if (bi.mod(n) == BigInteger.ZERO) {
					break;
				}
				bi = bi.multiply(BigInteger.TEN);
				bi = bi.add(BigInteger.ONE);
			}
			
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_4375();
	}
}