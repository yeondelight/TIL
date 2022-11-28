import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_11497() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] L = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				L[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(L);
			
			// 1, 3, 5, 7, ... , 6, 4, 2			
			int[] sortL = new int[N];
			for (int j = 0, idx = 0; j < N; j += 2, idx++) {
				sortL[idx] = L[j];
			}
			for (int j = 1, idx = N-1; j < N; j += 2, idx--) {
				sortL[idx] = L[j];
			}
			
			// cal dist
			int dist = Math.abs(sortL[0] - sortL[N-1]);
			for (int j = 0; j < N-1; j++) {
				dist = Math.max(dist, Math.abs(sortL[j] - sortL[j+1]));
			}
			
			sb.append(dist).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11497();
	}
}
