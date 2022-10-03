import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int ans;
	public static int[][] S;
	public static boolean[] team;
	public static boolean[] check;
	
	public void backtracking(int idx, int cnt) {
		if (cnt == N/2) {
			// cal team's energy.
			int start = 0;
			int link = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = i + 1; j <= N; j++) {
					if (team[i] && team[j]) {
						start += (S[i][j] + S[j][i]);
					}
					else if (!team[i] && !team[j]) {
						link += (S[i][j] + S[j][i]);
					}
				}
			}
			ans = Math.min(ans, Math.abs(start - link));
			return;
		}
		for (int i = idx; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				team[i+1] = true;
				backtracking(i+1, cnt+1);
				team[i+1] = false;
				check[i] = false;
			}
		}
	}
	
	public void sol_14889() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		S = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		team = new boolean[N+1];
		check = new boolean[N+1];
		backtracking(0, 0);
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_14889();
	}
}
