import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;	

// 좌표를 나타내기 위한 Point class
class Point {
	int y;
	int x;
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

class SOL16234 {

	public int N, L, R;
	
	public int[][] map;
	public int[][] mapCopy;
	public int[][] visited;
	
	public static int NOTVISITED = 0;
	public static int VISITED = 1;
	public static int UPDATED = 2;
	
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	
	public int time;

	public void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer stMap = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stMap.nextToken());
			}
		}
	}
	
	public void solution() {
		for (time = 0; ; time++) {
			
			// init
			mapCopy = copyMap(map);
			visited = new int[N][N];
			
			// find areas
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] != UPDATED) {
						int avg = bfs(i, j);
						updatePeople(avg);
					}
				}
			}
			
			// break check
			if (isArrEqual(map, mapCopy)) {
				break;
			}
			
			// update map
			map = copyMap(mapCopy);
		}
	}
	
	public void print() {
		System.out.println(time);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	// 원본 배열을 Deep Copy 하는 copyMap()
	public int[][] copyMap(int[][] origin) {
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}
	
	// 두 배열이 같은지 검사하는 isArrEqual()
	public boolean isArrEqual(int[][] A, int[][] B) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i][j] != B[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	// 영역을 탐색해 인구를 이동하는 BFS
	public int bfs(int y, int x) {
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(y, x));
		
		visited[y][x] = VISITED;
		
		int totalPeople = 0;
		int countryCnt = 0;
		
		while(!q.isEmpty()) {
			
			Point curr = q.poll();
			
			totalPeople += map[curr.y][curr.x];
			countryCnt++;
			
			for (int k = 0; k < 4; k++) {
				int ny = curr.y + dy[k];
				int nx = curr.x + dx[k];
				if (0 <= ny && ny < N && 0 <= nx && nx < N) {	// 범위 확인
					if (visited[ny][nx] == NOTVISITED) {		// 중복 방문 여부 확인
						int diff = Math.abs(map[curr.y][curr.x] - map[ny][nx]);
						if (L <= diff && diff <= R) {			// 방문 조건 충족 확인
							visited[ny][nx] = VISITED;
							q.offer(new Point(ny, nx));
						}
					}
				}
			}
		}
		
		return totalPeople/countryCnt;
	}

	// 영역만큼을 변경된 인구수로 채우는 함수
	public void updatePeople(int val) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == VISITED) {
					visited[i][j] = UPDATED;
					mapCopy[i][j] = val;
				}
			}
		}
	}
}
