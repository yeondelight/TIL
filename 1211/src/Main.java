import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	class Point {
		int x;
		int y;
		int knight;

		public Point(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.knight = k;
		}
	}
	
	public void sol_1600() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 0 ? true : false;
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0, 0));
		
		boolean[][][] visited = new boolean[H][W][K+1];
		visited[0][0][0] = true;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[] kx = {-2, -2, -1, -1, 1, 1, 2, 2};
		int[] ky = {1, -1, 2, -2, 2, -2, 1, -1};
		
		int time = -1;
		boolean flag = false;
		
		while(!q.isEmpty()) {
			time++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point curr = q.poll();
				if (curr.x == H-1 && curr.y == W-1) {
					flag = true;
					q.clear();
					break;
				}
				
				int currK = curr.knight;
				
				// move knight
				if (currK < K) {
					for (int k = 0; k < 8; k++) {
						int nx = curr.x + kx[k];
						int ny = curr.y + ky[k];
						if (0 <= nx && nx < H && 0 <= ny && ny < W) {
							if (map[nx][ny] && !visited[nx][ny][currK+1]) {
								visited[nx][ny][currK+1] = true;
								q.offer(new Point(nx, ny, currK+1));
							}
						}
					}
				}
				
				// move near
				for (int k = 0; k < 4; k++) {
					int nx = curr.x + dx[k];
					int ny = curr.y + dy[k];
					if (0 <= nx && nx < H && 0 <= ny && ny < W) {
						if (map[nx][ny] && !visited[nx][ny][currK]) {
							visited[nx][ny][currK] = true;
							q.offer(new Point(nx, ny, currK));
						}
					}					
				}
			}
		}
		
		if (flag)	System.out.println(time);
		else		System.out.println("-1");
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1600();
	}
}
