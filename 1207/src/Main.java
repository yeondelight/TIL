import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static int[][] map;
	public static boolean[][] visited;
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static int visitArea;
	
	public void dfs(int x, int y) {
		if (map[x][y] == 0) {
			return;
		}
		
		visitArea++;
		visited[x][y] = true;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (map[nx][ny] != 0 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
	
	public void sol_2573() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		int iceArea = 0;
		int sx = 0, sy = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					if (iceArea == 0) {
						sx = i;
						sy = j;
					}
					iceArea++;
				}
			}
		}
		
		int ans = 0;
		while (true) {
			// A. 빙산이 분리되었는가?
			visitArea = 0;
			visited = new boolean[N][M];
			dfs(sx, sy);
			
			// A-1. 빙산이 두 조각났으면 탈출한다.
			if (visitArea != iceArea) {
				break;
			}
			
			// B. 녹아야 하는 빙산의 값 계산
			int[][] diff = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						continue;
					} else {
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if (0 <= nx && nx < N && 0 <= ny && ny < M) {
								if (map[nx][ny] == 0) {
									diff[i][j]++;
								}
							}
						}
					}
				}
			}
			
			// C. 녹이기
			iceArea = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] -= diff[i][j];
					if (map[i][j] < 0) {
						map[i][j] = 0;
					} else if (map[i][j] > 0) {
						iceArea++;
						sx = i;
						sy = j;
					}
				}
			}
			
			// C-1. 다 녹았으면 0 출력
			if (iceArea == 0) {
				ans = 0;
				break;
			}
			
			// D. 시간+
			ans++;
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2573();
	}

}
