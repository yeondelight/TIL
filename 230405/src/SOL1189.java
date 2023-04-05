import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL1189 {
	
	public static int R, C, K;
	
	public static boolean[][] map;
	public static boolean[][] visited;
	
	public static int ans;
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	
	public void getInput() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) == '.' ? true : false;
			}
		}
	}
	
	public void solution() {
		visited = new boolean[R][C];
		visited[R-1][0] = true;		// 한수의 현 위치 방문 설정
		dfs(R-1, 0, 0);				// 탐색 함수 호출
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		System.out.println(ans);
	}
	
	public void dfs(int y, int x, int depth) {
		if (depth == K-1) {
			if (y == 0 && x == C-1) {
				ans++;
			}
			return;
		}
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (0 <= ny && ny < R && 0 <= nx && nx < C) {	// 범위 확인
				if (!visited[ny][nx] && map[ny][nx]) {		// 방문 가능 확인
					visited[ny][nx] = true;
					dfs(ny, nx, depth+1);
					visited[ny][nx] = false;
				}
			}
		}
	}
}