import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	
	int y;
	int x;
	
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}

}

class Cctv {
	
	int typeNo;
	Point p;
	
	// moveDirection[i][j][k]
	// - i번 cctv를 j방향 회전 했을 때, k 방향으로의 이동이 있는가?
	// - 0 : 동, 1 : 남, 2 : 서, 3 : 북
	public static boolean[][][] moveDirection = {
		{},	// 번호맞추기용. 아래부터 순서대로 1-5번 cctv의 각 방향에 대한 이동 여부
		{{true, false, false, false}, {false, true, false, false}, {false, false, true, false}, {false, false, false, true}},
		{{true, false, true, false}, {false, true, false, true}, {true, false, true, false}, {false, true, false, true}},
		{{true, true, false, false}, {false, true, true, false}, {false, false, true, true}, {true, false, false, true}},
		{{true, true, true, false}, {false, true, true, true}, {true, false, true, true}, {true, true, false, true}},
		{{true, true, true, true}, {true, true, true, true}, {true, true, true, true}, {true, true, true, true}}
	};
	
	public Cctv(int t, Point p) {
		this.typeNo = t;
		this.p = p;
	}

}

class SOL15683 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// - 0 : 동, 1 : 남, 2 : 서, 3 : 북
	public static int[] dy = {0, 1, 0, -1};
	public static int[] dx = {1, 0, -1, 0};
	
	public int N, M;
	public int[][] map;
	public ArrayList<Cctv> cctv;
	
	public int ans;
	public boolean[][] visited;

	public void getInput() throws Exception {
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		
		map = new int[N][M];
		cctv = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer stMap = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stMap.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv.add(new Cctv(map[i][j], new Point(i, j)));
				}
			}
		}
	}
	
	public void solution(){
		ans = N*M;
		visited = new boolean[N][M];
		backtracking(0);
	}
	
	public void print() {
		System.out.println(ans);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	// 모든 cctv에 대해서 방향을 바꿔본다.
	public void backtracking(int idx) {
		if (idx == cctv.size()) {
			int val = getDarkArea();
			ans = Math.min(ans, val);
			return;
		}
		
		Cctv c = cctv.get(idx);	// cctv를 얻는다.
		
		// 4방위로 방향을 바꿔본다.
		for (int d = 0; d < 4; d++) {
			ArrayList<Point> visitedPoints = checkVisited(c, d);
			backtracking(idx+1);
			uncheckVisited(visitedPoints);
		}
	}
	
	// 사각지대의 크기를 구한다.
	public int getDarkArea() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 0) {	// 탐색도 되지 않았고, 방문 가능 칸이어야 함
					cnt++;
				}
			}
		}
		return cnt;
	}

	// cctv의 감시 영역을 true로 바꾼다.
	public ArrayList<Point> checkVisited(Cctv c, int direction) {
		
		ArrayList<Point> visitedPoints = new ArrayList<>();
		
		for (int k = 0; k < 4; k++) {
			if (Cctv.moveDirection[c.typeNo][direction][k]) {
				int ny = c.p.y;
				int nx = c.p.x;
				while(inMapArea(ny, nx) && map[ny][nx] != 6) {
					if (!visited[ny][nx]) {
						visitedPoints.add(new Point(ny, nx));
					}
					visited[ny][nx] = true;
					ny += dy[k];
					nx += dx[k];
				}
			}
		}
		
		return visitedPoints;
	}
	
	// cctv의 감시 영역을 false로 바꾼다.
	public void uncheckVisited(ArrayList<Point> visitedPoints) {
		for (Point p : visitedPoints) {
			visited[p.y][p.x] = false;
		}
	}	
	
	// y, x가 Map의 영역에 있는지 판단한다.
	public boolean inMapArea(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M;
	}

}
