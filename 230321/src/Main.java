import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public int getGCD(int a, int b) {
		if ( a < b )	return getGCD(b, a);
		if ( b == 0 )	return a;
		return getGCD(b, a % b);
	}
	
	public void sol_2942() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		
		int gcd = getGCD(R, G);
		

		StringBuilder sb = new StringBuilder();
		
		// gcd의 약수만큼 나눠줌
		for (int i = 1; i <= gcd; i++) {
			if (gcd % i == 0) {
				sb.append(i).append(' ');
				sb.append(R / i).append(' ');
				sb.append(G / i).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2942();
	}
}
