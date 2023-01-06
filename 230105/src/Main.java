import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_19939() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int standard = K*(K+1)/2;
		
		if (standard > N) {
			System.out.println(-1);
		} else {
			if ((N - standard) % K == 0) {
				System.out.println(K-1);
			} else {
				System.out.println(K);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_19939();
	}
}
