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
	
	public void sol_1388() throws Exception {
		// scan
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean ROW = true;
		boolean COL = false;
		
		boolean[][] map = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) == '-' ? ROW : COL;
			}
		}
		
		
		// search
		int tile = 0;
		int[] delta = {-1, 1};
		boolean[][] visited = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j]) {
					continue;
				}
				tile++;
				visited[i][j] = true;
				q.offer(new Point(i, j));
				boolean curr = map[i][j];
				
				while(!q.isEmpty()) {
					Point p = q.poll();
					for (int k = 0; k < delta.length; k++) {
						int nx = p.x;
						int ny = p.y;
						if (curr == ROW) {
							ny += delta[k];
						} else {
							nx += delta[k];
						}
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] == curr && !visited[nx][ny]) {
								visited[nx][ny] = true;
								q.offer(new Point(nx, ny));
							}
						}
					}
				}
			}
		}
		
		// print
		System.out.println(tile);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1388();
	}
}
