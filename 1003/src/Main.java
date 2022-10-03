import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static StringBuilder sb;
	public static int N;
	public static int[] S;
	public static int[] ans;
	public static boolean[] check;
	
	public void backtracking(int idx, int cnt) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(ans[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = idx; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				ans[cnt] = S[i];
				backtracking(i+1, cnt+1);
				check[i] = false;
			}
		}
	}
	
	public void sol_6603() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		while (true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if (N == 0) {
				break;
			}
			
			S = new int[N];
			for (int i = 0; i < N; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = new int[6];
			check = new boolean[N];
			backtracking(0, 0);
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_6603();
	}
}
