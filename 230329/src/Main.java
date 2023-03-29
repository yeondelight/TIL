import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public int getGCD(int a, int b) {
		if ( a < b )	return getGCD(b, a);
		if ( b == 0 )	return a;
		return getGCD(b, a % b);
	}
	
	public void sol_10166() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D1 = Integer.parseInt(st.nextToken());
		int D2 = Integer.parseInt(st.nextToken());
		
		// 두 수가 같은 경우 모든 좌석이 사용된다.
		if (D1 == D2) {
			System.out.println(D1);
			return;
		}
		
		int cnt = 1;	// 0도에 무조건 하나는 놓인다.
		int MAX = 2000;
		boolean[][] angle = new boolean[MAX+1][MAX+1];
		
		for (int i = D1; i <= D2; i++) {
			for (int j = 1; j < i; j++) {
				int gcd = getGCD(j, i);
				if (!angle[j/gcd][i/gcd]) {
					angle[j/gcd][i/gcd] = true;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_10166();
	}
}
