import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	class Point {
		int x; 
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public void sol_7576() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M+1];
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[][] check = new int[N+1][M+1];
		Queue<Point> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)	q.add(new Point(i, j));
			}
		}

		// BFS
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if (x >= 1 && x <= N && y >= 1 && y <= M && map[x][y] == 0) {
					q.add(new Point(x, y));
					map[x][y] = 1;
					check[x][y] = check[p.x][p.y] + 1;
				}
			}
		}
		
		// check
		int max = -1;
		
		Check:
		for(int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0) {
					max = -1;
					break Check;
				}
				max = Math.max(max, check[i][j]);
			}
		}
		
		System.out.println(max);
	}
	
	public static void main (String[] args) throws Exception {
		new Main().sol_7576();
	}
}
