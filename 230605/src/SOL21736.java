import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SOL21736 {
	
	class Point {
		int x;
		int y;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static BufferedReader br;
	public static int[] dy = {0, -1, 0, 1};
	public static int[] dx = {-1, 0, 1, 0};
	
	public int N, M;
	public char[][] map;
	
	public Point start;
	public int ans;
	
	public SOL21736() {
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
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String mapStr = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = mapStr.charAt(j);
				if (map[i][j] == 'I') {
					start = new Point(i, j);
				}
			}
		}
	}
	
	public void solution() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		q.offer(start);
		visited[start.y][start.x] = true;
		
		while(!q.isEmpty()) {
			Point curr = q.poll();
			if (map[curr.y][curr.x] == 'P') {
				ans++;
			}
			for (int k = 0; k < 4; k++) {
				int nx = curr.x + dx[k];
				int ny = curr.y + dy[k];
				if (inArea(ny, nx) && !visited[ny][nx] && map[ny][nx] != 'X') {
					q.offer(new Point(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}
	}
	
	public void print() {
		if (ans == 0) {
			System.out.println("TT");
		} else {
			System.out.println(ans);
		}
	}
	
	public boolean inArea(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M;
	}
}
