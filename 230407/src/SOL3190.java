import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL3190 {
	
	public int N;
	public boolean[][] appleMap;
	public boolean[][] snakeMap;
	public char[] timeTranslate;

	public int time;	// 게임 시간
	public int direction = 0;	// 뱀 머리 방향
	public int startY, startX;	// 뱀의 머리 위치
	public int endY, endX;		// 뱀의 꼬리 위치
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int MAX = 10000;	// X의 최댓값
	
	// 오른쪽 - 위쪽 - 왼쪽 - 아래쪽
	public static int[] dy = {0, -1, 0, 1};
	public static int[] dx = {1, 0, -1, 0};
	
	
	public void getInput() throws Exception {		
		N = Integer.parseInt(br.readLine());
		appleMap = new boolean[N+1][N+1];
		snakeMap = new boolean[N+1][N+1];
		
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			StringTokenizer stK = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stK.nextToken());
			int c = Integer.parseInt(stK.nextToken());
			appleMap[r][c] = true;
		}
		
		int L = Integer.parseInt(br.readLine());
		timeTranslate = new char[MAX];
		for (int l = 0; l < L; l++) {
			StringTokenizer stL = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(stL.nextToken());
			char C = stL.nextToken().charAt(0);
			timeTranslate[X] = C;
			
		}
	}
	
	public void solution() {
		startY = startX = endY = endX = 1;
		for (time = 0; time < MAX; time++) {
			
			// 0. 방향 변환 정보를 확인한다.
			if (timeTranslate[time] == 'L') {
				direction = (direction + 1) % 4;
			}
			if (timeTranslate[time] == 'R') {
				direction = (direction + 3) % 4;
			}
			
			// 1. 뱀은 몸길이를 늘려 다음 칸에 위치시킨다.
			if (!strengthSnake()) {
				break;
			}
			
			// 2. 사과에 따라 행동을 달리한다.
			if (appleMap[startY][startX]) {	// 만약 이동한 칸에 사과가 있다면
				appleMap[startY][startX] = false;	// 사과가 없어지고 꼬리는 안움직임
			} else {								// 이동한 칸에 사과가 없다면
				snakeMap[endY][endX] = false;		// 몸 길이를 줄여 꼬리 칸을 비운다.
			}
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
	
	// 머리를 다음 칸에 위치시킨다.
	public boolean strengthSnake() {
		int ny = startY + dy[direction];
		int nx = startX + dx[direction];
		
		if (0 < ny && ny <= N && 0 < nx && nx <= N) {	// 범위 확인
			if (!snakeMap[ny][nx]) {					// 나 자신과 부딪히는지 확인
				snakeMap[ny][nx] = true;
				startY = ny;
				startX = nx;
				return true;
			}
		}
		
		return false;
	}
}
