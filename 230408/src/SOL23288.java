import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int r;
	int c;
	public Point (int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class SOL23288 {
	
	public int N, M, K;
	public int[][] map;

	public int score;
	public int[][] dice;
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 동, 남, 서, 북 순서
	public static int moveSize = 4;
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
	
	public void getInput() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer stMap = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(stMap.nextToken());
			}
		}
	}
	
	public void solution() throws IOException {
		
		int c = 0;		// 초기에는 동쪽으로 이동한다.
		int x = 1; int y = 1;	// 초기 좌표는 (1, 1)이다.
		initDice();
		
		for (int k = 0; k < K; k++) {
			
			// 1. 이동 가능한지 확인한다.
			if (!checkMove(x, y, c)) {	// 만약 갈 수 없다면
				c = (c + 2) % moveSize;	// 방향을 반대로 바꾼다.
			}
			x += dr[c];			// 해당 칸으로 이동한다.
			y += dc[c];
			dice = rollDice(c);	// 실제로 주사위를 굴린다.
			
			// 2. 주사위가 도착한 칸에 대한 점수를 획득한다.
			score += bfs(x, y, map[x][y]) * map[x][y];
			
			// 3. 이동 방향을 결정한다.
			if (dice[3][1] > map[x][y]) {	// A > B
				c = (c+1) % moveSize;		// 시계방향 회전
			}
			if (dice[3][1] < map[x][y]) {	// A < B
				c = (c+3) % moveSize;		// 반시계방향 회전
			}
		}
	}
	
	public void print() {
		System.out.println(score);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}

	// dice를 초기 상태로 만든다.
	public void initDice() {
		// {{0, 2, 0}, {4, 1, 3}, {0, 5, 0}, {0, 6, 0}}
		dice = new int[4][3];
		dice[0][1] = 2;
		dice[1][0] = 4;
		dice[1][1] = 1;
		dice[1][2] = 3;
		dice[2][1] = 5;
		dice[3][1] = 6;
	}
	
	// (r, c)가 cmd대로 이동했을 때, map의 범위 안에 있는가?
	public boolean checkMove(int r, int c, int cmd) {
		int nr = r + dr[cmd];
		int nc = c + dc[cmd];
		return 0 < nr && nr <= N && 0 < nc && nc <= M;
		
	}

	// cmd 방향으로 주사위를 굴린다.
	public int[][] rollDice(int cmd) {
		int[][] diceCopy = new int[4][3];
		if (cmd == 0) {			// 동
			diceCopy[0][1] = dice[0][1];	// dice A -> diceCopy A
			diceCopy[1][2] = dice[1][1];	// dice B -> diceCopy F
			diceCopy[2][1] = dice[2][1];	// dice C -> diceCopy C
			diceCopy[1][0] = dice[3][1];	// dice D -> diceCopy E
			diceCopy[1][1] = dice[1][0];	// dice E -> diceCopy B
			diceCopy[3][1] = dice[1][2];	// dice F -> diceCopy D
		}
		if (cmd == 1) {	// 남
			diceCopy[1][0] = dice[1][0];	// dice E -> diceCopy E
			diceCopy[1][2] = dice[1][2];	// dice F -> diceCopy F
			for (int i = 0; i < 4; i++) {	// 나머지는 밑으로 한칸씩 내린다.
				diceCopy[(i+1)%4][1] = dice[i][1];
			}
		}
		if (cmd == 2) {	// 서
			diceCopy[0][1] = dice[0][1];	// dice A -> diceCopy A
			diceCopy[1][0] = dice[1][1];	// dice B -> diceCopy E
			diceCopy[2][1] = dice[2][1];	// dice C -> diceCopy C
			diceCopy[1][2] = dice[3][1];	// dice D -> diceCopy F
			diceCopy[3][1] = dice[1][0];	// dice E -> diceCopy D
			diceCopy[1][1] = dice[1][2];	// dice F -> diceCopy B
			
		}
		if (cmd == 3) {	// 북
			diceCopy[1][0] = dice[1][0];	// dice E -> diceCopy E
			diceCopy[1][2] = dice[1][2];	// dice F -> diceCopy F
			for (int i = 0; i < 4; i++) {	// 나머지는 위로 한칸씩 올린다.
				diceCopy[i][1] = dice[(i+1)%4][1];
			}
		}
		return diceCopy;
	}

	// bfs로 flag와 같은 값을 가지는 영역을 탐색한다.
	// 시작점은 (r, c)
	public int bfs(int r, int c, int flag) {
		int areaCnt = 0;
		
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N+1][M+1];
		
		q.offer(new Point(r, c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			areaCnt++;
			Point curr = q.poll();
			for (int k = 0; k < moveSize; k++) {
				int nr = curr.r + dr[k];
				int nc = curr.c + dc[k];
				if (0 < nr && nr <= N && 0 < nc && nc <= M) {		// 범위확인
					if (!visited[nr][nc] && map[nr][nc] == flag) {	// 방문 조건 확인
						q.offer(new Point(nr, nc));
						visited[nr][nc] = true;
					}
					
				}
			}
		}
		
		return areaCnt;
	}
}
