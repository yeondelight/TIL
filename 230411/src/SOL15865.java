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


class SOL15685 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 0 : 동, 1 : 북, 2 : 서, 3 : 남
	public static int[] dy = {0, -1, 0, 1};
	public static int[] dx = {1, 0, -1, 0};
	
	public static int MAX_XY = 100;
	
	public int N;
	public boolean[][] map;
	public ArrayList<Point> visited;

	public void getInput() throws Exception {
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
	}
	
	public void solution() throws Exception {
		map = new boolean[MAX_XY+1][MAX_XY+1];
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			visited = new ArrayList<>();
			drawDragonCurve(y, x, d, g);
			applyInMap();
		}
	}
	
	public void print() {
		int ans = 0;
		for (int i = 0; i < MAX_XY; i++) {
			for (int j = 0; j < MAX_XY; j++) {
				if (map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}


	// 드래곤 커브를 map에 표시한다.
	public void drawDragonCurve(int y, int x, int D, int G) {
		if (G == 0) {		// 0세대 : D방향 한 칸 직진
			visited.add(new Point(y, x));
			visited.add(new Point(y + dy[D], x + dx[D]));
			return;
		}
		drawDragonCurve(y, x, D, G-1);	// G-1세대를 먼저 그린다.
		int visitedSize = visited.size() - 1;	// 지금 저장된 사이즈 만큼만 회전붙이기
		Point far = visited.get(visitedSize);	// 가장 먼 거리의 점
		for (int i = visitedSize-1; i >= 0; i--) {
			Point p = visited.get(i);
			int diffY = p.x - far.x;
			int diffX = p.y - far.y;
			visited.add(new Point(far.y + diffY, far.x - diffX));	// 90도 회전한 점
		}
	}
	
	// visited의 내용을 map에 적용한다.
	public void applyInMap() {
		for (Point p : visited) {
			map[p.y][p.x] = true;
		}
	}
}
