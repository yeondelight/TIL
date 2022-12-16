import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_17203() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[] a = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		// diff[i]는 a[i+1] - a[i]
		int[] diff = new int[N+1];
		for (int i = 1; i < N; i++) {
			diff[i] = Math.abs(a[i+1] - a[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long sum = 0;
			for (int j = start; j < end; j++) {
				sum += diff[j];
			}
			sb.append(sum).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_1448() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] straw = new int[N];
		for (int i = 0; i < N; i++) {
			straw[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(straw);
		
		int ans = -1;
		for (int i = N-1; i > 1; i--) {
			if (straw[i] < (straw[i-1] + straw[i-2])) {
				ans = straw[i] + straw[i-1] + straw[i-2];
				break;
			}
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1448();
	}
}
