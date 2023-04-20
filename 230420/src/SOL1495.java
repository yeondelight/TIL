import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class SOL1495 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N, S, M;
	public int[] V;
	
	public boolean[][] dp;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stNSM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNSM.nextToken());
		S = Integer.parseInt(stNSM.nextToken());
		M = Integer.parseInt(stNSM.nextToken());
		
		V = new int[N+1];
		StringTokenizer stV = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			V[i] = Integer.parseInt(stV.nextToken());
		}
	}

	public void solution() {
		
		dp = new boolean[N+1][M+1];
		dp[0][S] = true;
		

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (dp[i-1][j]) {
					if (inArea(j + V[i]))	dp[i][j+V[i]] = true;
					if (inArea(j - V[i]))	dp[i][j-V[i]] = true;
				}
			}
		}
		
	}
	
	public void print() {
		for (int i = M; i >= 0; i--) {
			if (dp[N][i]) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
	
	public boolean inArea(int val) {
		return 0 <= val && val <= M;
	}
}
