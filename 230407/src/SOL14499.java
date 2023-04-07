import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SOL14499 {
	
	public int N, M, x, y, K;
	public int[][] map;
	public int[] cmd;
	
	public int[][] dice;
	public Queue<Integer> ansQ = new LinkedList<>();
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	// 동, 서, 북, 남 순서
	public static int moveSize = 4;
	public static int[] dr = {0, 0, 0, -1, 1};
	public static int[] dc = {0, 1, -1, 0, 0};
	
	public void getInput() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer stMap = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stMap.nextToken());
			}
		}
		
		cmd = new int[K];
		StringTokenizer stCmd = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			cmd[i] = Integer.parseInt(stCmd.nextToken());
		}
		
		dice = new int[4][3];
	}
	
	public void solution() throws IOException {
		for (int c : cmd) {
			
			// 1. 해당 방향으로 이동 가능한지 확인한다.
			if (!checkMove(x, y, c)) {
				continue;
			} else {
				x += dr[c];
				y += dc[c];
			}
			
			// 2. 해당 방향으로 주사위를 굴린다.
			dice = rollDice(c);
			
			// 3. 해당 칸의 값에 따라 복사한다.
			if (map[x][y] == 0) {		// 만약 칸의 수가 0이면
				map[x][y] = dice[3][1];	// - 주사위 바닥면이 칸에 복사된다.
			} else {					// 칸의 수가 0이 아니라면
				dice[3][1] = map[x][y];	// - 칸의 수가 주사위 바닥면으로 복사되며
				map[x][y] = 0;			// - 칸의 수는 0이 된다.
			}
			
			// 4. 주사위 윗면에 써있는 값을 출력한다.
			ansQ.offer(dice[1][1]);
		}
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		while(!ansQ.isEmpty()) {
			sb.append(ansQ.poll()).append('\n');
		}
		System.out.println(sb);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}

	// (r, c)가 cmd대로 이동했을 때, map의 범위 안에 있는가?
	public boolean checkMove(int r, int c, int cmd) {
		int nr = r + dr[cmd];
		int nc = c + dc[cmd];
		return 0 <= nr && nr < N && 0 <= nc && nc < M;
		
	}

	// cmd 방향으로 주사위를 굴린다.
	public int[][] rollDice(int cmd) {
		int[][] diceCopy = new int[4][3];
		if (cmd == 1) {			// 동
			diceCopy[0][1] = dice[0][1];	// dice A -> diceCopy A
			diceCopy[1][2] = dice[1][1];	// dice B -> diceCopy F
			diceCopy[2][1] = dice[2][1];	// dice C -> diceCopy C
			diceCopy[1][0] = dice[3][1];	// dice D -> diceCopy E
			diceCopy[1][1] = dice[1][0];	// dice E -> diceCopy B
			diceCopy[3][1] = dice[1][2];	// dice F -> diceCopy D
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
		if (cmd == 4) {	// 남
			diceCopy[1][0] = dice[1][0];	// dice E -> diceCopy E
			diceCopy[1][2] = dice[1][2];	// dice F -> diceCopy F
			for (int i = 0; i < 4; i++) {	// 나머지는 밑으로 한칸씩 내린다.
				diceCopy[(i+1)%4][1] = dice[i][1];
			}
		}
		return diceCopy;
	}
}
