import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Point {
	int y;
	int x;
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

class SOL3190 {
	
	public int N;
	public boolean[][] appleMap;
	public char[] timeTranslate;
	
	public boolean[][] snakeMap;
	public Deque<Point> snakeDeque;

	public int time;	// 게임 시간
	public int direction = 0;	// 뱀 머리 방향
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int MAX = 10000;	// X의 최댓값
	
	// 오른쪽 - 위쪽 - 왼쪽 - 아래쪽
	public static int[] dy = {0, -1, 0, 1};
	public static int[] dx = {1, 0, -1, 0};
	
	
	public void getInput() throws Exception {		
		N = Integer.parseInt(br.readLine());
		appleMap = new boolean[N+1][N+1];
		snakeMap = new boolean[N+1][N+1];
		snakeDeque = new LinkedList<Point>();
		
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
		// init snake
		snakeDeque.offer(new Point(1, 1));
		snakeMap[1][1] = true;
		
		for (time = 0; time <= MAX; time++) {
			
			// 0. 방향 변환 정보를 확인한다.
			if (timeTranslate[time] == 'L') {
				direction = (direction + 1) % 4;
			}
			if (timeTranslate[time] == 'D') {
				direction = (direction + 3) % 4;
			}
			
			// 1. 뱀은 몸길이를 늘려 다음 칸에 위치시킨다.
			if (!strengthSnake()) {
				break;
			}
			
			Point head = snakeDeque.peekLast();	// 머리 칸 받아오기
			
			// 2. 사과에 따라 행동을 달리한다.
			if (appleMap[head.y][head.x]) {	// 만약 이동한 칸에 사과가 있다면
				appleMap[head.y][head.x] = false;	// 사과가 없어지고 꼬리는 안움직임
			} else {								// 이동한 칸에 사과가 없다면
				Point tail = snakeDeque.pollFirst();// 뱀 꼬리 1 감소
				snakeMap[tail.y][tail.x] = false;	// 꼬리 감소 확인
			}
		}
	}
	
	public void print() {
		System.out.println(time+1);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	// 머리를 다음 칸에 위치시킨다.
	public boolean strengthSnake() {
		Point p = snakeDeque.peekLast();	// 머리 받아오기
		int ny = p.y + dy[direction];
		int nx = p.x + dx[direction];
		
		if (0 < ny && ny <= N && 0 < nx && nx <= N) {	// 범위 확인
			if (!snakeMap[ny][nx]) {					// 나 자신과 부딪히는지 확인
				snakeMap[ny][nx] = true;
				snakeDeque.offerLast(new Point(ny, nx));
				return true;
			}
		}
		
		return false;
	}
}
