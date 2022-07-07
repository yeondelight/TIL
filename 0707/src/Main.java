import java.io.*;
import java.util.*;

public class Main {
	
	public void sol_1389() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int MAX = N * N + 1;
		int[][] board = new int[N+1][N+1];
		
		// init board
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				board[i][j] = MAX;
			}
		}
		
		// scan
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][y] = 1;
			board[y][x] = 1;
		}
		
		// Floyd
		int[] KB = new int[N+1];
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= N; j++) {
					if (i == j)	continue;
					else {					// i -> k + k -> j
						board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
						sum += board[i][j];
					}
				}
				KB[i] = sum;
			}
		}
		
		// test
		KB[0] = MAX;
		int min = 0;
		for (int i = 1; i <= N; i++) {
			if (KB[i] < KB[min])	min = i;
		}
		
		System.out.println(min);
	}

	int gcd(int a, int b) {
	    while (b != 0) {
	        int r = a % b;
	        a = b;
	        b = r;
	    }
	    return a;
	}
	
	public void sol_6064() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			// get GCD - M과 N을 서로소로 만들기
			int GCD = gcd(M, N);
			
			// get LCD - 최대 반복값 지정
			int LCM = M * N / GCD;
			
			boolean isValid = false;
			for (int j = X; j <= LCM; j += M) {
				int temp = (j % N == 0) ? N : j % N;
				if (temp == Y) {
					sb.append(j).append('\n');
					isValid = true;
					break;
				}
			}
			if (!isValid) {
				sb.append(-1).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public void sol_4963() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0)	break;
			
			boolean[][] map = new boolean[H+1][W+1];
			boolean[][] visited = new boolean[H+1][W+1];
			for (int i = 1; i <= H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= W; j++) {
					if (st.nextToken().equals("1"))	map[i][j] = true;
					else							map[i][j] = false;
					visited[i][j] = !map[i][j];
				}
			}
			
			int count = 0;
			int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
			int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};
			for (int i = 1; i <= H; i++) {
				for (int j = 1; j <= W; j++) {
					Queue<Point> q = new LinkedList<>();
					if (map[i][j] && !visited[i][j]) {
						count++;
						visited[i][j] = true;
						q.add(new Point(i, j));
						while (!q.isEmpty()) {
							Point p = q.poll();
							for (int k = 0; k < 8; k++) {
								int nx = p.x + dx[k];
								int ny = p.y + dy[k];
								if (0 < nx && nx <= H && 0 < ny && ny <= W && map[nx][ny] && !visited[nx][ny]) {
									q.add(new Point(nx, ny));
									visited[nx][ny] = true;
								}
							}
						}
					}
				}
			}
			

			sb.append(count).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_14052() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		Vector<Point> virus = new Vector<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)	virus.add(new Point(i, j));
			}
		}
		
		// create 3 walls
		// virus BFS
		// Math.max(safeArea)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0)	continue;
				
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_14052();
	}
}
