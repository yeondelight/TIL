import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static boolean[][] map;
	
	public boolean check() {
		int cnt;
		for (int i = 0; i < N; i++) {
			// 행
			cnt = 0;
			for (int j = 0; j < N; j++) {
				if (map[i][j]) {
					cnt++;
				}
			}
			if (cnt > N/2) {
				for (int j = 0; j < N; j++) {
					if (!map[i][j]) {
						map[i][j] = true;
					}
				}
			}
			
			// 열
			cnt = 0;
			for (int j = 0; j < N; j++) {
				if (map[j][i]) {
					cnt++;
				}
			}
			if (cnt > N/2) {
				for (int j = 0; j < N; j++) {
					if (!map[j][i]) {
						map[j][i] = true;
					}
				}
			}
		}
		
		// 모두 바뀌지 않았다면 false
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public void sol_15925() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		boolean flag = Integer.parseInt(st.nextToken()) == 1 ? true : false;
		
		map = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				boolean curr = Integer.parseInt(st.nextToken()) == 1 ? true : false;
				if (flag)	map[i][j] = curr;
				else		map[i][j] = !curr;
			}
		}
		
		check();
		boolean val = check();
		
		if (val)	System.out.println(1);
		else		System.out.println(0);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_15925();
	}
}
