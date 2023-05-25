import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Point {
	int y;
	int x;
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

class Robot {
	Point p;
	int dir;
	public Robot(Point p, int dir) {
		this.p = p;
		this.dir = dir;
	}
}

class SOL2174 {

	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static HashMap<Character, Integer> dirMap;
	public static int[] dx = {0, 1, 0, -1};	// N, E, W, S
	public static int[] dy = {1, 0, -1, 0};	// N, E, W, S
	
	public int A, B;
	public int N, M;
	
	public int[][] isRobot;
	public Robot[] robots;
	public boolean flag;
	
	public SOL2174() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
		if (dirMap == null) {
			dirMap = new HashMap<>();
			dirMap.put('N', 0);
			dirMap.put('E', 1);
			dirMap.put('S', 2);
			dirMap.put('W', 3);
		}
	} 
	
	public void run() throws Exception {
		init();
		
		for (int m = 0; m < M; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int robotIdx = Integer.parseInt(st.nextToken());
			char cmd = st.nextToken().charAt(0);
			int repeat = Integer.parseInt(st.nextToken());
			if (flag) {
				solution(robotIdx, cmd, repeat);
			}
		}
		
		print();
	}
	
	public void init() throws Exception {
		StringTokenizer stAB = new StringTokenizer(br.readLine());
		A = Integer.parseInt(stAB.nextToken());
		B = Integer.parseInt(stAB.nextToken());
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		
		isRobot = new int[B+1][A+1];
		robots = new Robot[N+1];
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = dirMap.get(st.nextToken().charAt(0));
			isRobot[y][x] = n+1;
			robots[n+1] = new Robot(new Point(y, x), d);
		}
		
		flag = true;
	}
	
	public void solution(int robotIdx, char cmd, int repeat) {
		
		Robot robot = robots[robotIdx];
		
		for (int r = 0; r < repeat; r++) {
			
			switch(cmd) {
			
				case 'L':
					robot.dir = (robot.dir+3) % 4;
					break;
					
				case 'R':
					robot.dir = (robot.dir+1) % 4;
					break;
					
				case 'F':
					int ny = robot.p.y + dy[robot.dir];
					int nx = robot.p.x + dx[robot.dir];
					
					// 주어진 땅의 밖으로 벗어나는 경우
					if (!inArea(ny, nx)) {
						sb.append("Robot ");
						sb.append(robotIdx);
						sb.append(" crashes into the wall");
						flag = false;
						return;
					}
					
					// 움직이다 다른 로봇과 충돌하는 경우
					if (isRobot[ny][nx] > 0) {
						sb.append("Robot ");
						sb.append(robotIdx);
						sb.append(" crashes into robot ");
						sb.append(isRobot[ny][nx]);
						flag = false;
						return;
					}
					
					// 그 외 경우 전진처리
					isRobot[robot.p.y][robot.p.x] = 0;
					isRobot[ny][nx] = robotIdx;
					robot.p.y = ny;
					robot.p.x = nx;
					break;
			}
			
			System.out.println(robot.p.y + " " + robot.p.x);
			printMap();
		}
		
	}
	
	public void print() {
		if (flag)	System.out.println("OK");
		else		System.out.println(sb);
	}
	
	public boolean inArea(int y, int x) {
		return 0 < x && x <= A && 0 < y && y <= B;
	}

	public void printMap() {
		for (int i = B; i > 0; i--) {
			for (int j = 1; j <= A; j++) {
				System.out.print(isRobot[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
