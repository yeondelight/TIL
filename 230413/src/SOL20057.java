import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL20057 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	// 왼 - 아 - 오 - 위
	public static int[] dy = {0, 1, 0, -1};
	public static int[] dx = {-1, 0, 1, 0};
	
	public int N;
	public int[][] A;
	
	public int ans;
	public int Y, X, D;			// 이동 대상 좌표, 이동 방향
	public boolean[][] visited;	// 방문 표시

	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		A = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// set start Point
		Y = X = N/2 + 1;
		D = 0;
		
		// visited 배열 초기화
		visited = new boolean[N+1][N+1];
	}
	
	public void solution() {
		
		while (true) {	// 최종 도착지점 전에 도달할 때 까지
			
			visited[Y][X] = true;	// 현 위치 방문 표시
			if (X == 1 && Y == 1) {	// 도착하면 break;
				break;
			}
			
			Y += dy[D];	X += dx[D];	// 토네이도가 진행 방향으로 한 칸 이동한다.

			if (A[Y][X] != 0) {		// (Y, X)에 있는 모래를 날린다.
				
				int originSand = A[Y][X];	// 현 위치에 있는 모래의 양
				A[Y][X] = 0;				// 날리고 나면 현 위치의 모래는 없어진다.
				
				// 이하 변수 생성 규칙 : ny/x_N_A/B
				// - y(혹은 x)의 N% 흩날리는 지점
				// - A와 B는 진행방향의 왼쪽인지 / 오른쪽인지
				
				// 1% 지점 : 역방향 / 수직
				int below_1 = (int)(originSand * 0.01);
				int ny_1_A = Y + dy[(D+2)%4] + dy[(D+1)%4];
				int nx_1_A = X + dx[(D+2)%4] + dx[(D+1)%4];
				int ny_1_B = Y + dy[(D+2)%4] + dy[(D+3)%4];
				int nx_1_B = X + dx[(D+2)%4] + dx[(D+3)%4];
				if (inArea(ny_1_A, nx_1_A))	A[ny_1_A][nx_1_A] += below_1;
				else						ans += below_1;
				if (inArea(ny_1_B, nx_1_B))	A[ny_1_B][nx_1_B] += below_1;
				else						ans += below_1;

				// 10% 지점 : 순방향 / 수직
				int below_10 = (int)(originSand * 0.1);
				int ny_10_A = Y + dy[D] + dy[(D+1)%4];
				int nx_10_A = X + dx[D] + dx[(D+1)%4];
				int ny_10_B = Y + dy[D] + dy[(D+3)%4];
				int nx_10_B = X + dx[D] + dx[(D+3)%4];
				if (inArea(ny_10_A, nx_10_A))	A[ny_10_A][nx_10_A] += below_10;
				else							ans += below_10;
				if (inArea(ny_10_B, nx_10_B))	A[ny_10_B][nx_10_B] += below_10;
				else							ans += below_10;

				// 7% 지점 : 수직 1칸
				int below_7 = (int)(originSand * 0.07);
				int ny_7_A = Y + dy[(D+1)%4];
				int nx_7_A = X + dx[(D+1)%4];
				int ny_7_B = Y + dy[(D+3)%4];
				int nx_7_B = X + dx[(D+3)%4];
				if (inArea(ny_7_A, nx_7_A))	A[ny_7_A][nx_7_A] += below_7;
				else						ans += below_7;
				if (inArea(ny_7_B, nx_7_B))	A[ny_7_B][nx_7_B] += below_7;
				else						ans += below_7;
				
				// 2% 지점 : 수직 2칸
				int below_2 = (int)(originSand * 0.02);
				int ny_2_A = Y + dy[(D+1)%4] * 2;
				int nx_2_A = X + dx[(D+1)%4] * 2;
				int ny_2_B = Y + dy[(D+3)%4] * 2;
				int nx_2_B = X + dx[(D+3)%4] * 2;
				if (inArea(ny_2_A, nx_2_A))	A[ny_2_A][nx_2_A] += below_2;
				else						ans += below_2;
				if (inArea(ny_2_B, nx_2_B))	A[ny_2_B][nx_2_B] += below_2;
				else						ans += below_2;

				// 5% 지점 : 순방향 2칸
				int below_5 = (int)(originSand * 0.05);
				int ny_5 = Y + dy[D] * 2;
				int nx_5 = X + dx[D] * 2;
				if (inArea(ny_5, nx_5))	A[ny_5][nx_5] += below_5;
				else					ans += below_5;
				
				// a 지점 : 순방향 1칸
				int below_a = originSand - ((below_1 + below_2 + below_7 + below_10) * 2 + below_5);
				int ny_a = Y + dy[D];
				int nx_a = X + dx[D];
				if (inArea(ny_a, nx_a))	A[ny_a][nx_a] += below_a;
				else					ans += below_a;
			}
			
			// 방향을 재설정한다.
			int tempD = (D+1) % 4;	// 일단 방향 꺾어봄
			int ny = Y + dy[tempD];	// 그 때의 좌표 계산
			int nx = X + dx[tempD];
			if (inArea(ny, nx) && !visited[ny][nx]) {
				D = tempD;
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

	// (y, x)가 범위 내에 있는가?
	public boolean inArea(int y, int x) {
		return 0 < y && y <= N && 0 < x && x <= N;
	}
}
