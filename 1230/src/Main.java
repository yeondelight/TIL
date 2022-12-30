import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	class Line implements Comparable{
		int start;
		int end;
		
		public Line(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Object o) {
			Line l = (Line) o;
			return this.start - l.start;
		}
	}
	
	public void sol_2565() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Line[] lines = new Line[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lines[i] = new Line(start, end);
		}
		Arrays.sort(lines);
		
		// 11053 : 가장 긴 증가하는 부분수열
		int max = 0;
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			int idx = i;
			for (int j = 0; j < i; j++) {			// 직전 값들을 탐색하며
				if (lines[j].end < lines[i].end) {	// 현재 기준값보다 작은 값을 찾으면
					if (dp[idx] < dp[j]) {			// 증가량이 더 큰지 판단하여
						idx = j;					// 증가량이 더 많은 쪽을 저장한다.
					}
				}
			}
			dp[i] = dp[idx] + 1;
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		
		// 빼야하는 전깃줄 : 전체 - 가장 긴 증가하는 부분수열
		System.out.println(N - max);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2565();
	}
}
