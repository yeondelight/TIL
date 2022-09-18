import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N,  M;
	public static int[][] map;
	
	public static int count = 1;
	public static int[] dy = {-1, 0, 1, 0};
	public static int[] dx = {0, 1, 0, -1};
	
	
	public void dfs(int r, int c, int d) {
		map[r][c] = -1;
		for (int i = 0; i < 4; i++) {	// 2. 현재 위치에서 현재 방향을 기준으로 왼쪽부터 차례로 탐색
			d = (d + 3) % 4;			// 왼쪽으로 회전
			int ny = r + dy[d];		
			int nx = c + dx[d];
			
			// 아직 청소하지 않은 공간이 존재한다면 
			if (0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] == 0) {	
				count++;			// 청소하고
				dfs(ny, nx, d);		// 한칸 전진하고 1번 부터
				return;
				
			}
		}
		
		// 네 방향 모두 청소가 되었거나 벽인 경우
		int back = (d + 2) % 4;
		int ny = r + dy[back];
		int nx = c + dx[back];
		if (0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] != 1) {	// 뒤가 벽이 아니면	 
			dfs(ny, nx, d);													// 후진
		}
	}
	
	public void sol_14503() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(r, c, d);		
		System.out.println(count);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_14503();
	}
}
