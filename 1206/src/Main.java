import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_15964() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger A = new BigInteger(st.nextToken());
		BigInteger B = new BigInteger(st.nextToken());
		
		BigInteger expA = A.multiply(A);
		BigInteger expB = B.multiply(B);
		
		BigInteger cal = expA.subtract(expB);
		
		System.out.println(cal);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_15964();
	}
}
