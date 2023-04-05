import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SOL1303 {
	
	public static int N, M;
	
	public static int[][] map;
	public static boolean[][] visited;
	
	public static int[] ans;
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
		
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) == 'W' ? 0 : 1;
			}
		}
	}
	
	public void solution() {
		ans = new int[2];		// 0 : W, 1 : B
		visited = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					ans[map[i][j]] += bfs(i, j);
				}
			}
		}
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append(ans[0]).append(' ').append(ans[1]);
		System.out.println(sb);
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
		int flag = map[y][x];
		
		while(!q.isEmpty()) {
			area++;
			Point curr = q.poll();
			for (int k = 0; k < 4; k++) {
				int ny = curr.y + dy[k];
				int nx = curr.x + dx[k];
				if (0 <= ny && ny < M && 0 <= nx && nx < N) {		// 범위 확인
					if (!visited[ny][nx] && map[ny][nx] == flag) {	// 방문 가능 확인
						visited[ny][nx] = true;
						q.offer(new Point(ny, nx));
					}
				}
			}
		}
		
		return area*area;
	}
}