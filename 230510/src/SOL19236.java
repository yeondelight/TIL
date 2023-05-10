import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}

class Fish {
	
	Point p;	// 물고기가 위치한 좌표
	int dir;	// 방향 정보
	
	public Fish(Point p, int dir) {
		this.p = p;
		this.dir = dir;
	}
	
	@Override
	public String toString() {
		return "<" + p.toString() + " - " + dir + "> ";
	}
}

class SOL19236 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	
	public static int EMPTY = -1;
	public static int MAPSIZE = 4;
	public static int FISHSIZE = MAPSIZE*MAPSIZE;
	
	public Fish[] fishInfo;			// id별 물고기의 위치와 방향을 저장한다.
	public int[][] mapWithFishID;	// 위치별 물고기의 id를 저장한다.
	public int ans;
	
	public int flag;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		
		// 한 변의 길이가 MAPSIZE인 MAP에서
		// 물고기의 마지막 번호는 MAPSIZE^2+1이다.
		fishInfo = new Fish[FISHSIZE+1];
		
		// 위치로 물고기의 번호를 찾아야 하는 경우를 대비하기 위해
		// 2차원의 map 배열에 물고기 id를 저장해둔다.
		mapWithFishID = new int[MAPSIZE][MAPSIZE];
		
		for (int i = 0; i < MAPSIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < MAPSIZE; j++) {
				// (i, j)에 위치한 물고기의 정보를 받아온다.
				// a : 물고기의 id
				// b : 물고기의 방향 -> 0번부터로 맞추기 위해 -1 해준다.
				// 즉, fishInfo[a] = new Fish((i, j), b)
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken()) - 1;
				fishInfo[a] = new Fish(new Point(i, j), b);	// id를 key로 하여 저장
				mapWithFishID[i][j] = a;					// Point를 key로 하여 저장
			}
		}
	}

	public void solution() {
		
		/* 1. init
		 * -----------------------------------------------
		 * 상어는 (0, 0)에 있는 물고기를 먹고 그 방향을 가진다.
		 * 상어의 id는 0으로 한다.
		 * 
		 * 먹힌 칸은 더이상 존재하지 않는다.
		 * - mapWithFishId[][]에서도 먹힌 위치의 id를 EMPTY(-1)로 처리한다.
		 */
		int initID = mapWithFishID[0][0];
		int initDir = fishInfo[initID].dir;
		fishInfo[0] = new Fish(new Point(0, 0), initDir);
		mapWithFishID[0][0] = 0;
		

		/* 2. backtracking
		 * -----------------------------------------------
		 * 상어가 먹을 수 있는 물고기의 위치가 가변적이므로
		 * backtracking 방식을 이용하여 하나씩 먹어봐야 한다.
		 */
		backtracking(initID, fishInfo, mapWithFishID);
	}
	
	public void print() {
		System.out.println(ans);
	}
	
	
	
	
	public void printMapStatus(Fish[] pFishInfo, int[][] pMapWithFishID) {
		for (int i = 0; i < MAPSIZE; i++) {
			for (int j = 0; j < MAPSIZE; j++) {
				if (pMapWithFishID[i][j] == EMPTY) {
					System.out.print("[ EMPTY ]");
				} else {
					System.out.print("[ " + pMapWithFishID[i][j] + " : " + pFishInfo[pMapWithFishID[i][j]].dir + " ]");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	/* backtracking
	 * -----------------------------------------------
	 * 상어가 먹을 수 있는 물고기의 위치가 가변적이므로
	 * backtracking 방식을 이용하여 하나씩 먹어봐야 한다.
	 * 그 중 원본 배열의 손상을 방지하기 위해, 매개변수로 정보를 넘겨준다.
	 * - fishInfo
	 * - mapWithFishID
	 * - sum : 현재까지 먹은 물고기 id의 합
	 * 
	 * 배열은 완전복사가 아닌 참조복사로 전달되므로 한 번 더 복사해서 써야한다.
	 */
	public void backtracking(int sum, Fish[] pFishInfo, int[][] pMapWithFishID) {
		
		// 원본 배열의 손상을 막기 위해 제일 먼저 map을 그대로 복사해온다.
		// Arrays.copyOf()는 1차원 배열만 가능하므로 pMapWithFishID은 별도의 함수를 쓴다.
		Fish[] newFishInfo = Arrays.copyOf(pFishInfo, FISHSIZE+1);
		int[][] newMapWithFishID = copyMapWithFishID(pMapWithFishID);
		
		// 1번 물고기부터 순차적으로 물고기를 이동시킨다.
		swapFishes(newFishInfo, newMapWithFishID);
		
		printMapStatus(newFishInfo, newMapWithFishID);
		flag++;
		if (flag > 10) {
			return;
		}
		
		// 상어를 움직인다.
		Queue<Point> movePoints = findSharkMovePoints(newFishInfo[0], newMapWithFishID);
		if (movePoints.isEmpty()) {		// 어떤 물고기도 먹을 수 없다면
			ans = Math.max(ans, sum);	// 물고기 번호의 합의 최댓값을 갱신하고
			return;						// 끝낸다.
		}
		else {
			Point currSharkPoint = new Point(newFishInfo[0].p.x, newFishInfo[0].p.y);
			Fish currSharkInfo = new Fish(currSharkPoint, newFishInfo[0].dir);
			while(!movePoints.isEmpty()) {	// 그 외 먹을 수 있는 물고기들에 대해
				
				// 현재 상어 위치 처리
				Point movePoint = movePoints.poll();
				int eatenFishID = newMapWithFishID[movePoint.x][movePoint.y];
				newFishInfo[0] = newFishInfo[eatenFishID];
				newMapWithFishID[movePoint.x][movePoint.y] = 0;
				newMapWithFishID[currSharkPoint.x][currSharkPoint.y] = EMPTY;
				
				backtracking(sum + eatenFishID, newFishInfo, newMapWithFishID);
				
				// 수정한 값 복귀
				newFishInfo[0] = currSharkInfo;
				newMapWithFishID[movePoint.x][movePoint.y] = eatenFishID;
				newMapWithFishID[currSharkPoint.x][currSharkPoint.y] = 0;
			}
		}
	}
	
	// pMapWithFishID를 복사하는 함수
	public int[][] copyMapWithFishID(int[][] pMapWithFishID) {
		int[][] newMapWithFishID = new int[MAPSIZE][MAPSIZE];
		for (int i = 0; i < MAPSIZE; i++) {
			for (int j = 0; j < MAPSIZE; j++) {
				newMapWithFishID[i][j] = pMapWithFishID[i][j];
			}
		}
		return newMapWithFishID;
	}
	
	/* swapFishes
	 * -----------------------------------------------
	 * 모든 물고기들의 위치를 바꾼다.
	 * 
	 * parameters
	 * - Fish[] pFishInfo
	 * - int[][] pMapWithFishID
	 * 
	 * return
	 * 배열은 참조복사이므로 반환하지 않아도 변경사항이 적용된다.
	 */
	public void swapFishes(Fish[] pFishInfo, int[][] pMapWithFishID) {
		
		// pFishInfo를 1번부터 순회하며 물고기를 이동한다.
		for (int i = 1; i <= FISHSIZE; i++) {
			
			// 객체도 참조복사된다(...)
			Point currPoint = new Point(pFishInfo[i].p.x, pFishInfo[i].p.y);
			
			// 내 위치가 상어의 위치면 먹혔다는 의미이므로 바꾸면 안된다.
			if (pMapWithFishID[currPoint.x][currPoint.y] == 0) {
				continue;
			}
			
			Fish f = findFishMovePoint(pFishInfo[i], pMapWithFishID);
			
			// 내가 아닌 다른 칸이었다면 정보를 뒤바꾼다.
			if (!(f.p.x == currPoint.x && f.p.y == currPoint.y)) {
				
				// 바꿀 대상인 물고기의 ID
				int moveFishID = pMapWithFishID[f.p.x][f.p.y];
				
				if (moveFishID == EMPTY) {	// 빈칸과 바꿀 경우
					pFishInfo[i] = f;
					
					pMapWithFishID[currPoint.x][currPoint.y] = EMPTY;
					pMapWithFishID[f.p.x][f.p.y] = i;
					
				}
				else {						// 물고기와 바꿀 경우 
					// fishInfo swap
					Fish temp = pFishInfo[i];	// 현재 나의 정보
					int moveFishDir = pFishInfo[moveFishID].dir;
					pFishInfo[i] = f;
					pFishInfo[moveFishID] = new Fish(currPoint, moveFishDir);
					
					// newMapWithFishID swap
					pMapWithFishID[currPoint.x][currPoint.y] = moveFishID;
					pMapWithFishID[f.p.x][f.p.y] = i;
				}
			}
		}
		
	}
	
	/* findFishMovePoint
	 * -----------------------------------------------
	 * 현 위치를 기준으로 움직일 수 있는 지점을 반환한다.
	 * 
	 * parameters
	 * - Fish curr : 나의 위치, 나의 시작 방향
	 * - mapWithFishID : 이동 가능한 칸인지 확인을 위해 필요하다.
	 * 
	 * return
	 * - Fish next : 다음 이동 위치, 변경된 방향
	 */
	public Fish findFishMovePoint(Fish curr, int[][] mapWithFishID) {
		Fish next = curr;
		
		for (int d = 0; d < 8; d++, next.dir = (next.dir+1) % 8) {
			
			int nx = curr.p.x + dx[next.dir];
			int ny = curr.p.y + dy[next.dir];
			
			// map의 범위 내이며, 상어가 아닌 칸만 방문할 수 있다.
			if (inArea(nx, ny) && mapWithFishID[nx][ny] != 0) {
				next.p.x = nx;
				next.p.y = ny;
				break;
			}
		}
		
		return next;
	}
	
	// (x, y)가 map의 범위 내에 있는지 확인하는 함수
	public boolean inArea(int x, int y) {
		return 0 <= x && x < MAPSIZE && 0 <= y && y < MAPSIZE;
	}

	/* findSharkMovePoints
	 * -----------------------------------------------
	 * 현 상어 위치를 기준으로 먹을 수 있는 물고기의 목록을 반환한다.
	 * 
	 * parameters
	 * - Fish shark : 상어의 위치, 방향
	 * - mapWithFishID : 이동 가능한 칸인지 확인을 위해 필요하다.
	 * 
	 * return
	 * - Queue<Point> movePoints : 다음 이동 위치들
	 */
	public Queue<Point> findSharkMovePoints(Fish shark, int[][] pMapWithFishID) {
		
		Queue<Point> movePoints = new LinkedList<>();
		
		int dir = shark.dir;
		int nx = shark.p.x + dx[dir];
		int ny = shark.p.y + dy[dir];
		while(inArea(nx, ny)) {
			if (pMapWithFishID[nx][ny] != EMPTY) {
				movePoints.offer(new Point(nx, ny));
			}
			nx += dx[dir];
			ny += dy[dir];
		}
		
		return movePoints;
	}
}
