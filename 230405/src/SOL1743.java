import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SOL1743 {
	
	public static int N, M, K;
	
	public static boolean[][] map;
	public static boolean[][] visited;
	
	public static int ans;
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	
	class Point {
		int y;
		int x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public void getInput() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			StringTokenizer stK = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stK.nextToken());
			int c = Integer.parseInt(stK.nextToken());
			map[r-1][c-1] = true;
		}
	}
	
	public void solution() {
		ans = 0;
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j]) {
					ans = Math.max(ans, bfs(i, j));
				}
			}
		}
	}
	
	public void print() {
		System.out.println(ans);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public int bfs(int y, int x) {
		int area = 0;		// 넓이를 저장할 값
		
		// init
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(y, x));
		
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			area++;
			Point curr = q.poll();
			for (int k = 0; k < 4; k++) {
				int ny = curr.y + dy[k];
				int nx = curr.x + dx[k];
				if (0 <= ny && ny < N && 0 <= nx && nx < M) {	// 범위 확인
					if (!visited[ny][nx] && map[ny][nx]) {		// 방문 가능 확인
						visited[ny][nx] = true;
						q.offer(new Point(ny, nx));
					}
				}
			}
		}
		
		return area;
	}
}
