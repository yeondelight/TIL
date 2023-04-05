import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SOL3187 {
	
	public static int R, C;
	
	public static char[][] map;
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
	
	class Animal {
		int wolf;
		int sheep;
		public Animal(int wolf, int sheep) {
			this.wolf = wolf;
			this.sheep = sheep;
		}
	}
	
	public void getInput() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
	}
	
	public void solution() {
		ans = new int[2];
		visited = new boolean[R][C];
		
		// bfs
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] != '#') {
					Animal a;
					if (i == 0 || i == R-1 && j == 0 || j == C-1) {	// boundary 체크
						a = bfs(i, j, false);
					} else {
						a = bfs(i, j, true);
					}
					ans[0] += a.wolf;
					ans[1] += a.sheep;
				}
			}
		}
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append(ans[1]).append(' ').append(ans[0]);
		System.out.println(sb);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	// bfs
	// - flag : 먹히는지 체크 할 건지 여부
	public Animal bfs(int y, int x, boolean flag) {
		Animal res = new Animal(0, 0);
		
		// init
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(y, x));
		
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			Point curr = q.poll();
			
			char val = map[curr.y][curr.x];
			if (val == 'v')	res.wolf++;
			if (val == 'k')	res.sheep++;
			
			
			for (int k = 0; k < 4; k++) {
				int ny = curr.y + dy[k];
				int nx = curr.x + dx[k];
				if (0 <= ny && ny < R && 0 <= nx && nx < C) {		// 범위 확인
					if (!visited[ny][nx] && map[ny][nx] != '#') {	// 방문 가능 확인
						visited[ny][nx] = true;
						q.offer(new Point(ny, nx));
					}
				}
			}
		}
		
		
		if (flag) {
			if (res.sheep > res.wolf)	res.wolf = 0;
			else						res.sheep = 0;
		}
		return res;
	}
}