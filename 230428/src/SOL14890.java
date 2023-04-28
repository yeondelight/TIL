import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL14890 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N, L;
	public int[][] map;
	
	public boolean[][] runway;
	public int ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stNL = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNL.nextToken());
		L = Integer.parseInt(stNL.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer stMap = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stMap.nextToken());
			}
		}
	}
	
	public void solution() {
		
		for (int i = 0; i < N; i++) {	// 행
			
			boolean flag = true;
			runway = new boolean[N][N];
			
			for (int j = 0; j < N-1; j++) {
				
				int curr = map[i][j];
				int next = map[i][j+1];
				
				// 같으면 경사로를 놓을 필요가 없다.
				if (curr == next) {
					continue;
				}
				
				// 이하 경사로를 놓아야 하는 경우
				if (curr - next == 1) {			// 하강 경사로
					if (isInArea(j + L)
							&& isSameVal(i, j+1, i, j+L)
							&& noneRunway(i, j+1, i, j+L)) {
						
						for (int k = j+1; k <= j+L; k++) {
							runway[i][k] = true;
						}
						
						continue;
					}
				}
				else if (curr - next == -1) {	// 상승 경사로
					if (isInArea(j + 1 - L)
							&& isSameVal(i, j+1-L, i, j)
							&& noneRunway(i, j+1-L, i, j)) {
						
						for (int k = j+1-L; k <= j; k++) {
							runway[i][k] = true;
						}
						
						continue;
					}
				}
				
				// 그 외 경우는 경사로를 놓을 수 없다.
				// - 높이차가 1 이상
				// - 경사로의 범위가 map을 벗어난 경우
				// - 이미 경사로가 있는 구역인 경우
				flag = false;
				break;
				
			}
			
			if (flag) {
				ans++;
			}
		}
		
		for (int j = 0; j < N; j++) {	// 열
			
			boolean flag = true;
			runway = new boolean[N][N];
			
			for (int i = 0; i < N-1; i++) {
				
				int curr = map[i][j];
				int next = map[i+1][j];
				
				// 같으면 경사로를 놓을 필요가 없다.
				if (curr == next) {
					continue;
				}
				
				// 이하 경사로를 놓아야 하는 경우
				if (curr - next == 1) {			// 하강 경사로
					if (isInArea(i + L)
							&& isSameVal(i+1, j, i+L, j)
							&& noneRunway(i+1, j, i+L, j)) {
						
						for (int k = i+1; k <= i+L; k++) {
							runway[k][j] = true;
						}
						
						continue;
					}
				}
				else if (curr - next == -1) {	// 상승 경사로
					if (isInArea(i + 1 - L)
							&& isSameVal(i+1-L, j, i, j)
							&& noneRunway(i+1-L, j, i, j)) {
						
						for (int k = i+1-L; k <= i; k++) {
							runway[k][j] = true;
						}
						
						continue;
					}
				}
				
				// 그 외 경우는 경사로를 놓을 수 없다.
				// - 높이차가 1 이상
				// - 경사로의 범위가 map을 벗어난 경우
				// - 이미 경사로가 있는 구역인 경우
				flag = false;
				break;
				
			}
			
			if (flag) {
				ans++;
			}
		}
	}
	
	public void print() {
		System.out.println(ans);
	}
	
	// val이 map의 범위 안에 들어오는가?
	public boolean isInArea(int val) {
		return 0 <= val && val < N;
	}
	
	// (y1, x1) ~ (y2, x2)의 값이 모두 동일한가?
	public boolean isSameVal(int y1, int x1, int y2, int x2) {
		
		int compVal = map[y1][x1];
		
		for (int i = y1; i <= y2; i++) {
			for (int j = x1; j <= x2; j++) {
				if (map[i][j] != compVal) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// (y1, x1) ~ (y2, x2)에 경사로가 없는가?
	public boolean noneRunway(int y1, int x1, int y2, int x2) {
		for (int i = y1; i <= y2; i++) {
			for (int j = x1; j <= x2; j++) {
				if (runway[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
