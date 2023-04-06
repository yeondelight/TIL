import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class SOL21610 {
	
	public int N, M;
	public int[][] A;			// 물의 양
	public boolean[][] cloud;	// 구름
	public boolean[][] cloudCopy;
	
	public static int neighborCnt = 8;	// 인접 몇칸인지
	public static int crossCnt = 4;		// 대각선 인접 몇칸인지
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	public static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] cy = {-1, -1, 1, 1};
	public static int[] cx = {-1, 1, 1, -1};
	
	public void getInput() throws Exception {
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		
		A = new int[N+1][N+1];				// 자리 index는 1부터 시작
		for (int i = 1; i <= N; i++) {
			StringTokenizer stA = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(stA.nextToken());
			}
		}
	}
	
	public void solution() throws IOException {
		// 구름 init
		cloud = new boolean[N+1][N+1];
		cloud[N][1] = cloud[N][2] = cloud[N-1][1] = cloud[N-1][2] = true;
		
		for (int m = 0; m < M; m++) {
			StringTokenizer stCmd = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(stCmd.nextToken());
			int s = Integer.parseInt(stCmd.nextToken()) % N;
			
			// 1. 모든 구름이 d 방향으로 s칸 이동한다.
			cloudCopy = moveCloud(d, s);
			
			// 2. 구름이 있는 바구니에 저장된 물의 양이 1 증가한다
			addWaterinAllCloud(cloudCopy);
			
			// 3. 구름이 모두 사라진다.
			clearCloud(cloud);
			
			// 4. 물복사 버그를 시전한다.
			A = waterCopyBug(cloudCopy);
			
			// 5. 바구니에 저장된 물의 양이 2 이상인 칸에 모든 칸에 구름이 생긴다.
			// - 물의 양이 2 줄어든다.
			// - 3에서 사라진 구름 칸에는 못만든다.
			makeCloud(cloudCopy);
		}
	}
	
	public void print() {
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ans += A[i][j];
			}
		}
		System.out.println(ans);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}

	// 구름을 d방향으로 s만큼 이동한다.
	public boolean[][] moveCloud(int d, int s){
		boolean[][] resCloud = new boolean[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if (cloud[i][j]) {
					int ny = (i + dy[d] * s) % N;
					int nx = (j + dx[d] * s) % N;
					
					if (ny <= 0)	ny += N;
					if (nx <= 0)	nx += N;
					
					resCloud[ny][nx] = true;
				}
			}
		}
		return resCloud;
	}

	// arr를 기준으로, 구름이 있는 바구니의 물 양을 1 증가한다.
	public void addWaterinAllCloud(boolean[][] arr) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (arr[i][j]) {
					A[i][j]++;
				}
			}
		}
	}

	// 구름을 모두 지운다.
	public void clearCloud(boolean[][] arr) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = false;
			}
		}
	}
	
	// 물복사 버그
	// - 물이 증가한 전적이 있는 칸에 : arr기준
	// - 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니 수 만큼 현재 물의 양이 증가한다.
	// - mod 아니고 그냥 N까지로 끝임
	public int[][] waterCopyBug(boolean[][] arr) {
		int[][] ACopy = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ACopy[i][j] = A[i][j];
				if (arr[i][j]) {
					int waterCnt = 0;
					for (int k = 0; k < crossCnt; k++) {
						int ny = i + cy[k];
						int nx = j + cx[k];
						if (0 < ny && ny <= N && 0 < nx && nx <= N) {	// 범위 확인 : 경계 안넘음
							if (A[ny][nx] > 0)	waterCnt++;				// 물의 양 누적
						}
					}
					ACopy[i][j] += waterCnt;
				}
			}
		}
		return ACopy;
	}

	// 구름을 생성한다.
	// - 이 전에 삭제된 구름 값 기준은 arr에 있다.
	public void makeCloud(boolean[][] arr) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (A[i][j] >= 2 && !arr[i][j]) {
					A[i][j] -= 2;
					cloud[i][j] = true;
				}
			}
		}
	}
}