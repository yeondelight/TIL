import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_14002() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			
		}
		
		// 11053 : 가장 긴 증가하는 부분수열
		int max = 0;
		int stIdx = 0;
		int[] dp = new int[N];
		int[] prev = new int[N];
		
		for (int i = 0; i < N; i++) {
			int idx = i;
			for (int j = 0; j < i; j++) {	// 직전 값들을 탐색하며
				if (num[j] < num[i]) {		// 현재 기준값보다 작은 값을 찾으면
					if (dp[idx] < dp[j]) {	// 증가량이 더 큰지 판단하여
						idx = j;			// 증가량이 더 많은 쪽을 저장한다.
					}
				}
			}
			
			dp[i] = dp[idx] + 1;
			if (i != idx) {
				prev[i] = idx;
			}
			
			if (dp[i] > max) {
				max = dp[i];
				stIdx = i;
			}
		}
		
		// print
		StringBuilder sb = new StringBuilder();
		sb.append(max).append('\n');
		
		// route trace
		Stack<Integer> s = new Stack<>();
		while(max > 0) {
			s.push(num[stIdx]);
			stIdx = prev[stIdx];
			max--;
		}
		
		while(!s.isEmpty()) {
			sb.append(s.pop()).append(' ');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_14002();
	}
}
