import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	
	int y;
	int x;
	
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	@Override
	public String toString() {
		return "(" + y + ", " + x + ")";
	}
}

class SOL17142 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	
	public int N, M;
	public int[][] map;
	
	public int[] enable;
	public ArrayList<Point> virus;
	
	public Queue<Point> q;
	public boolean[][] visited;
	
	public int time;
	public boolean flag;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		
		map = new int[N][N];
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer stMap = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stMap.nextToken());
				if (map[i][j] == 2) {
					virus.add(new Point(i, j));
				}
			}
		}
	}

	public void solution() {
		
		time = Integer.MAX_VALUE;
		flag = false;
		
		for (int i = 0; i < virus.size() - M + 1; i++) {
			enable = new int[M];
			enable[0] = i;
			enableVirus(i, 1);
		}
	}
	
	public void print() {
		if (flag)	System.out.println(time);
		else		System.out.println(-1);
	}

	// 바이러스 중 M개를 활성화한다.
	public void enableVirus(int idx, int cnt) {
		
		if (cnt == M) {	// M개를 모두 선택한 경우, BFS로 시간 찾기
			
			q = new LinkedList<>();
			visited = new boolean[N][N];
			
			for (int i = 0; i < M; i++) {
				Point p = virus.get(enable[i]);
				q.offer(p);
				visited[p.y][p.x] = true;
			}
			
			int spreadTime = bfs();
			boolean checkAll = isAllSearched();
			
			if (checkAll) {
				flag = true;
				time = Math.min(time, spreadTime);
			}
			
			return;
		}
		
		for (int i = idx+1; i < virus.size(); i++) {
			enable[cnt] = i;
			enableVirus(i, cnt+1);
		}
	}
	
	// BFS로 모든 지점을 탐색한다.
	public int bfs() {
		int t;
		
		for (t = 0; !q.isEmpty(); t++) {
			
			if (isAllSearched()) {
				break;
			}
			
			int currQSize = q.size();
			
			for (int s = 0; s < currQSize; s++) {
				
				Point p = q.poll();
				
				for (int k = 0; k < 4; k++) {
					int ny = p.y + dy[k];
					int nx = p.x + dx[k];
					if (0 <= ny && ny < N && 0 <= nx && nx < N) {	// 범위확인
						if (!visited[ny][nx] && map[ny][nx] != 1) {	// 방문 가능 확인
							q.offer(new Point(ny, nx));
							visited[ny][nx] = true;
						}
					}
				}
				
			}
			
		}
		
		return t;
	}
	
	// 모든 지점이 탐색되었는지 확인한다.
	public boolean isAllSearched() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 방문도 안했는데 빈칸임
				if (!visited[i][j] && map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
