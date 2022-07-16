import java.io.*;
import java.util.*;

public class Main {
	
	private static int R, C;
	private static int max = 0;
	private static int[][] map;
	private static boolean[] check;
	
	public void dfs(int x, int y, int count) {
		if (check[map[x][y]]) {
			max = Math.max(max, count);
			return;
		}
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		check[map[x][y]] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (0 <= nx && nx < R && 0 <= ny && ny < C) {
				dfs(nx, ny, count+1);
			}
		}
		check[map[x][y]] = false;
	}
	
	public void sol_1987() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		check = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}
		
		dfs(0, 0, 0);
		System.out.println(max);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1987();
	}
}
