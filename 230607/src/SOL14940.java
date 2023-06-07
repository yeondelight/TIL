import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SOL14940 {
	
	class Point {
		int y;
		int x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static BufferedReader br;
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	
	public int n, m;
	public int[][] map;
	public int[][] ans;
	
	public Point start;
	
	public SOL14940() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stnm = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stnm.nextToken());
		m = Integer.parseInt(stnm.nextToken());
		
		map = new int[n][m];
		ans = new int[n][m];
		for (int i = 0; i < n; i++) {
			StringTokenizer stMap = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(stMap.nextToken());
				switch (map[i][j]) {
				case 1:
					ans[i][j] = -1;
					break;
				case 2:
					start = new Point(i, j);
				case 0:
					ans[i][j] = 0;
					break;
				}
			}
		}
	}
	
	public void solution() {
		
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		
		q.offer(start);
		visited[start.y][start.x] = true;
		
		for (int d = 0; !q.isEmpty(); d++) {
			int currQSize = q.size();
			for (int s = 0; s < currQSize; s++) {
				Point curr = q.poll();
				ans[curr.y][curr.x] = d;
				for (int k = 0; k < 4; k++) {
					int ny = curr.y + dy[k];
					int nx = curr.x + dx[k];
					if (inArea(ny, nx) && !visited[ny][nx] && map[ny][nx] != 0) {
						q.offer(new Point(ny, nx));
						visited[ny][nx] = true;
					}
				}
			}
		}
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(ans[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	public boolean inArea(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
	}
}
