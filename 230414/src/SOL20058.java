import java.io.BufferedReader;
import java.io.InputStreamReader;
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

class SOL20058 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	
	public int N, Q;
	public int[][] A;
	public int[] L;
	
	public void getInput() throws Exception {
		StringTokenizer stNQ = new StringTokenizer(br.readLine());
		N = (int) Math.pow(2, Integer.parseInt(stNQ.nextToken()));
		Q = Integer.parseInt(stNQ.nextToken());
		
		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer stA = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(stA.nextToken());
			}
		}
		
		L = new int [Q];
		StringTokenizer stL = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			L[i] = Integer.parseInt(stL.nextToken());
		}
	}
	
	public void solution() {
		for (int l : L) {
			A = turnA(l);	// 1. L에 따라 격자를 시계방향으로 회전시킨다.
			A = meltIce();	// 2. 3개 이상의 칸과 인접하지 않은 칸은 얼음의 양을 줄인다.
		}
	}
	
	public void print() {
		System.out.println(getAllIce());	// 1. 남아있는 얼음의 합
		System.out.println(getMaxArea());	// 2. 가장 큰 덩어리가 차지하는 칸의 개수
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}

	// l에 따라 격자를 회전시킨다.
	public int[][] turnA(int l) {
		int[][] ACopy = new int[N][N];
		
		int size = (int) Math.pow(2, l);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 나는 몇번째 블럭의 부분격자인가, 그 격자의 왼쪽 최상단 좌표는 뭔가 (minY, minX)
				int minY = i/size * size;
				int minX = j/size * size;
				int ny = minY + (j - minX);
				int nx = (minX - 1 + size) - (i - minY);
				ACopy[ny][nx] = A[i][j];
			}
		}
		
		return ACopy;
	}

	// 모든 칸에 대해 얼음 녹이기를 확인한다.
	public int[][] meltIce() {
		int[][] ACopy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i][j] > 0 && getNeighborIceCnt(i, j) < 3) {
					ACopy[i][j] = A[i][j]-1;
				}
				else {
					ACopy[i][j] = A[i][j];
				}
			}
		}
		return ACopy;
	}
	
	// y, x와 인접한 얼음의 양을 반환한다.
	public int getNeighborIceCnt(int y, int x) {
		int cnt = 0;
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (isInArea(ny, nx) && A[ny][nx] > 0) {
				cnt++;
			}
		}
		return cnt;
	}
	
	// y, x가 영역 안에 있는지 검사한다.
	public boolean isInArea(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

	// 모든 얼음의 양을 계산한다.
	public int getAllIce() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i][j] > 0) {
					sum += A[i][j];
				}
			}
		}
		return sum;
	}

	// 가장 큰 영역의 크기를 계산한다. : BFS
	public int getMaxArea() {
		int maxArea = 0;
		
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i][j] > 0 && !visited[i][j]) {
					
					int currArea = 0;
					
					q.offer(new Point(i, j));
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						currArea++;
						Point curr = q.poll();
						for (int k = 0; k < 4; k++) {
							int ny = curr.y + dy[k];
							int nx = curr.x + dx[k];
							if (isInArea(ny, nx) && A[ny][nx] > 0 && !visited[ny][nx]) {
								q.offer(new Point(ny, nx));
								visited[ny][nx] = true;
							}
						}
					} // End of while
					maxArea = Math.max(maxArea, currArea);
				} // End of if
			}
		}
		
		return maxArea;
	}
}