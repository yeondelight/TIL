import java.io.*;
import java.util.*;

public class Main {
	
	public static int N;
	public static int ans;
	public static boolean[][] map;
	public static int[] dx = {0, 1, 1};
	public static int[] dy = {1, 0, 1};
	
	
	public void dfs_17070(int x, int y, int dir) {
		if (x == N && y == N) {
			ans++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 가로 -> 세로, 세로 -> 가로 방지
			if ((dir == 0 && i == 1) || (dir == 1 && i == 0))
				continue;
			
			// 범위나 벽 확인
			if (0 > nx || nx > N || 0 > ny || ny > N || !map[nx][ny])
				continue;
			
			// 대각선 벽 확인
			if (i == 2 && (!map[x+1][y] || !map[x][y+1]))
				continue;
			
			dfs_17070(nx, ny, i);
		}
	}
	
	public void sol_17070() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[N+1][N+1];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i+1][j+1] = Integer.parseInt(st.nextToken()) == 0 ? true : false;
			}
		}
		
		dfs_17070(1, 2, 0);
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_17070();
	}
}
