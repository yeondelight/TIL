import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1052() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		while (true) {
			
			int copyN = N;
			int remain = 0;
			
			while (copyN > 0) {
				if (copyN % 2 != 0) {
					remain++;
				}
				copyN /= 2;
			}
			
			if (remain <= K) {
				break;
			}
			
			N++;
			ans++;
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1052();
	}
}
