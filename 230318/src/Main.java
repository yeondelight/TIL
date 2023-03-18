import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public int getGCD(int a, int b) {
		if ( a < b )	return getGCD(b, a);
		if ( b == 0 )	return a;
		return getGCD(b, a%b);
	}
	
	public void sol_3036() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int firstCircle = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			int nextCircle = Integer.parseInt(st.nextToken());
			int gcd = getGCD(firstCircle, nextCircle);
			
			int num = firstCircle / gcd;
			int den = nextCircle / gcd;
			sb.append(num).append('/').append(den).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_3036();
	}
	
}