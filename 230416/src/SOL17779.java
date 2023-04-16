import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class SOL17779 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public int N;
	public int[][] A;
	public int[][] border;
	
	public int minDiff;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		A = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public void solution() {
		
		minDiff = Integer.MAX_VALUE;
		
		for (int x = 1; x < N; x++) {
			for (int y = 1; y < N; y++) {
				for (int d1 = 1; d1 <= y-1; d1++) {
					for (int d2 = 1; d2 <= N-d1-x && d2 <= N-y; d2++) {
						
						// 각 구역의 경계 그리기
						border = new int[N+1][N+1];
						drawBorder(x, y, d1, d2);
						
						// 각 구역 체크하기
						border[1][1] = 1;	dfs(1, 1, 1);
						border[1][N] = 2;	dfs(1, N, 2);
						border[N][1] = 3;	dfs(N, 1, 3);
						border[N][N] = 4;	dfs(N, N, 4);
						border[x+1][y] = 5;	dfs(x+1, y, 5);
						
						// 구역 별 인구수 구하기
						int[] peopleByArea = getPeopleInArea();
						
						// 최소 인구 차 구하기
						Arrays.sort(peopleByArea);
						int diff = peopleByArea[5] - peopleByArea[1];
						minDiff = Math.min(minDiff, diff);
					}
				}
			}
		}
	}
	
	
	public void print() {
		System.out.println(minDiff);
	}

	public void drawBorder(int x, int y, int d1, int d2) {		
		// 1 - 4구역 경계선 그리기
		for (int i = 1; i < x; i++) border[i][y] = 1;	// 1구역
		for (int j = 1; j <= N-y-d2; j++) border[x+d2][y+d2+j] = 2;	// 2구역
		for (int j = 1; j <= y-d1; j++) border[x+d1][j] = 3;	// 3구역
		for (int i = 1; i <= N-x-d1-d2; i++) border[x+d1+d2+i][y-d1+d2] = 4;	// 4구역
		
		// 5구역 경계선 그리기
		for (int d = 0; d <= d1; d++) border[x+d][y-d] = 5;	// 1번
		for (int d = 0; d <= d2; d++) border[x+d][y+d] = 5;	// 2번
		for (int d = 0; d <= d2; d++) border[x+d1+d][y-d1+d] = 5;	// 3번
		for (int d = 0; d <= d1; d++) border[x+d2+d][y+d2-d] = 5;	// 4번
	}

	public void dfs(int x, int y, int areaNum) {
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (0 < nx && nx <= N && 0 < ny && ny <= N) {
				if (border[nx][ny] == 0) {
					border[nx][ny] = areaNum;
					dfs(nx, ny, areaNum);
				}
			}
		}
	}

	public int[] getPeopleInArea() {
		int[] peopleInArea = new int[6];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (border[i][j] == 0)	peopleInArea[5] += A[i][j];
				else					peopleInArea[border[i][j]] += A[i][j];
			}
		}
		return peopleInArea;
	}
}