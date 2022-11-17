import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_11501() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] stock = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				stock[j] = Integer.parseInt(st.nextToken());
			}
			
			// scan
			long MAX = 0;
			long sum = 0;
			for (int j = N-1; j >= 0; j--) {
				if (MAX < stock[j]) {
					MAX = stock[j];
				} else {
					sum += (MAX - stock[j]);
				}
			}
			
			sb.append(sum).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11501();
	}
}
