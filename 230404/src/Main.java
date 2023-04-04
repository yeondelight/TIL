import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1058() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[][] originGraph = new boolean[N][N];
		boolean[][] copyGraph = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				originGraph[i][j] = str.charAt(j) == 'Y' ? true : false;
				copyGraph[i][j] = originGraph[i][j];
			}
		}
		
		// Floyd 활용
		// - 탐색하면서 A와 B의 공통 지인 C를 찾은 경우
		// - A와 B 역시 친구다.
		for (int c = 0; c < N; c++) {
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					if (originGraph[a][c] && originGraph[b][c]) {
						copyGraph[a][b] = true;
						copyGraph[b][a] = true;
					}
				}
			}
		}
		
		// 친구 수 세기
		int maxFriend = 0;
		
		for (int i = 0; i < N; i++) {
			int friendCnt = 0;
			for (int j = 0; j < N; j++) {
				if (i != j && copyGraph[i][j]) {
					friendCnt++;
				}
			}
			maxFriend = Math.max(maxFriend, friendCnt);
		}
		
		System.out.println(maxFriend);
	}

	public static int[][] board;
	public static boolean[] checkNum;
	
	public void dfs_2210(int y, int x, int val, int depth) {
		if (depth == 5) {
			if (!checkNum[val]) {
				checkNum[val] = true;
				System.out.println(val);
			}
			return;
		}
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (0 <= ny && ny < 5 && 0 <= nx && nx < 5) {
				int nextVal = val * 10 + board[ny][nx];
				dfs_2210(ny, nx, nextVal, depth+1);
			}
		}
	}
	
	public void sol_2210() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 5;
		board = new int[N][N];
		
		// scan
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 각 위치에서 dfs 시작
		int MAX = 1000000;
		checkNum = new boolean[MAX];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dfs_2210(i, j, board[i][j], 0);
			}
		}
		
		// 6개의 숫자 세기
		int cnt = 0;
		for (int i = 0; i < MAX; i++) {
			if (checkNum[i]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static int H, W;
	
	public static boolean[][] graph;
	public static boolean[][] visited;
	
	public void dfs_11123(int y, int x) {
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (0 <= ny && ny < H && 0 <= nx && nx < W) {	// 범위확인
				if (!visited[ny][nx] && graph[ny][nx]) {	// 양 확인
					visited[ny][nx] = true;
					dfs_11123(ny, nx);
				}
			}
		}
	}
	
	public void sol_11123() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			// scan
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			graph = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					graph[i][j] = str.charAt(j) == '#' ? true : false;
				}
			}
			
			// bfs
			int ans = 0;
			visited = new boolean[H][W];
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (!visited[i][j] && graph[i][j]) {
						visited[i][j] = true;
						dfs_11123(i, j);
						ans++;
					}
				}
			}
			
			// print
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	
	class Point {
		int y;
		int x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public void sol_13565() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) == '0' ? true : false;
			}
		}
		
		// BFS init
		boolean flag = false;
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[M][N];
		
		// put outer side points
		for (int j = 0; j < N; j++) {
			if (map[0][j]) {
				q.offer(new Point(0, j));
				visited[0][j] = true;
			}
		}
		
		// BFS
		while (!q.isEmpty()) {
			
			Point curr = q.poll();
			
			if (curr.y == M-1) {	// if get to inner side
				flag = true;
				break;
			}
			
			for (int k = 0; k < 4; k++) {
				int ny = curr.y + dy[k];
				int nx = curr.x + dx[k];
				if (0 <= ny && ny < M && 0 <= nx && nx < N) {	// 범위 확인
					if (!visited[ny][nx] && map[ny][nx]) {		// 벽 확인
						visited[ny][nx] = true;
						q.offer(new Point(ny, nx));
					}
				}
			}
		}
		
		// print
		if (flag)	System.out.println("YES");
		else		System.out.println("NO");
	}
	
	public void sol_14496() throws Exception {
		// scan
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stAB = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(stAB.nextToken());
		int b = Integer.parseInt(stAB.nextToken());
		
		// 예외처리
		if (a == b) {
			System.out.println(0);
			return;
		}
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		
		
		// init graph
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<Integer>());
		}
		
		// get graph
		for (int i = 0; i < M; i++) {
			StringTokenizer stPair = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stPair.nextToken());
			int y = Integer.parseInt(stPair.nextToken());
			g.get(x).add(y);
			g.get(y).add(x);
		}
		
		
		// BFS
		boolean[] visited = new boolean[N+1];
		visited[a] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(a);
		
		for (int t = 0; !q.isEmpty(); t++) {	// 시간마다 BFS
			
			int currQSize = q.size();			// 현 시간에 있던 요소만 뽑아 검사할것임
			for (int s = 0; s < currQSize; s++) {
				int curr = q.poll();
				if (curr == b) {			// 만약 치환하여 도달한 경우
					System.out.println(t);
					return;
				}
				for (int n : g.get(curr)) {	// 그 외 경우 치환 가능한 숫자들을 넣는다.
					if (!visited[n]) {
						visited[n] = true;
						q.offer(n);
					}
				}
			}
		}
		
		// if fail
		System.out.println(-1);
	}

	public void sol_17086() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
	
		boolean[][] map = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 0 ? true : false;
			}
		}
		
		int maxDistance = 0;
		int[] dy = {-1, -1, -1, 1, 1, 1, 0, 0};
		int[] dx = {-1, 0, 1, -1, 0, 1, -1, 1};
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]) {
					
					// BFS
					boolean[][] visited = new boolean[N][M];
					visited[i][j] = true;
					
					Queue<Point> q = new LinkedList<>();
					q.offer(new Point(i, j));

					BFS:
					for (int t = 0; !q.isEmpty(); t++) {
						int currQSize = q.size();
						for (int s = 0; s < currQSize; s++) {
							Point curr = q.poll();
							if (!map[curr.y][curr.x]) {
								maxDistance = Math.max(maxDistance, t);
								break BFS;
							}
							for (int k = 0; k < 8; k++) {
								int ny = curr.y + dy[k];
								int nx = curr.x + dx[k];
								if (0 <= ny && ny < N && 0 <= nx && nx < M) {
									if (!visited[ny][nx]) {
										visited[ny][nx] = true;
										q.offer(new Point(ny, nx));
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(maxDistance);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_17086();
	}
}
