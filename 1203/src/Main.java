import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public void sol_1926() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = st.nextToken().charAt(0) == '1' ? true : false;
			}
		}
		
		int cnt = 0;
		int area = 0;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!map[i][j] || visited[i][j]) {
					continue;
				}
				else {
					cnt++;
					int tempArea = 0;
					Queue<Point> q = new LinkedList<>();
					q.offer(new Point(i, j));
					visited[i][j] = true;
					while (!q.isEmpty()) {
						Point curr = q.poll();
						tempArea++;
						for (int k = 0; k < 4; k++) {
							int nx = curr.x + dx[k];
							int ny = curr.y + dy[k];
							if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny]) {
								if (!visited[nx][ny]) {
									visited[nx][ny] = true;
									q.offer(new Point(nx, ny));
								}
							}
						}
					}
					area = Math.max(area, tempArea);
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(area);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1926();
	}
}
