import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

class SOL21608 {
	
	public int N;
	public int[][] seat;			// 자리표
	public boolean[][] likeStu;		// i가 j를 좋아하면 true
	
	public static int neighborCnt = 4;
	public static int likeStudents = 4;
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		seat = new int[N+1][N+1];				// 자리 index는 1부터 시작
		likeStu = new boolean[N*N+1][N*N+1];	// 학생수는 N*N
	}
	
	public void solution() throws IOException {
		for (int n = 0; n < N*N; n++) {
			
			// get inputs
			StringTokenizer st = new StringTokenizer(br.readLine());
			int stuNo = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < likeStudents; i++) {
				likeStu[stuNo][Integer.parseInt(st.nextToken())] = true;
			}
			
			// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
			ArrayList<Point> mostLikeStuSeats = getMostLikeStuSeats(stuNo);
			
			// 2. 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
			if (mostLikeStuSeats != null) {
				Point p = getEmptySeat(mostLikeStuSeats);
				
				// 3. 행과 열의 번호가 가장 작은 칸으로 자리를 정한다.
				// - 탐색을 행-열 순서대로 하므로 3번 조건은 자동충족됨
				if (p != null) {
					seat[p.y][p.x] = stuNo;
				} else {
					// TODO : error
					System.out.println("ERROR in #2");
					return;
				}
			} else {
				// TODO : error	
				System.out.println("ERROR in #1");
				return;
			}
		}
	}
	
	public void printSeat() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(seat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void print() {
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int likeStuCnt = countLikeStu(i, j, seat[i][j]);
				switch(likeStuCnt) {
				case 1:	ans += 1;		break;
				case 2:	ans += 10;		break;
				case 3:	ans += 100;		break;
				case 4:	ans += 1000;	break;
				}
			}
		}
		System.out.println(ans);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}

	// 해당 자리와 인접한 stuNo의 좋아하는 학생 수를 센다.
	public int countLikeStu(int y, int x, int stuNo) {
		int cnt = 0;
		for (int k = 0; k < neighborCnt; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (0 < ny && ny <= N && 0 < nx && nx <= N) {	// 범위 확인
				if (likeStu[stuNo][seat[ny][nx]]) {			// 그 자리의 학생이 좋아하는 학생인가?
					cnt++;
				}
			}
		}
		return cnt;
	}

	// 빈 자리들에 대해서 인접 칸에 좋아하는 학생 수를 세고,
	// 그를 학생수에 따라 리스트에 정렬해서 넣는다.
	public ArrayList<Point> getMostLikeStuSeats(int stuNo) {
		
		// graph init
		ArrayList<ArrayList<Point>> cntStu = new ArrayList<>();
		for (int i = 0; i <= likeStudents; i++) {
			cntStu.add(new ArrayList<Point>());
		}
		
		// get EmptySeats with like Students
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (seat[i][j] == 0) {
					int likeStuCnt = countLikeStu(i, j, stuNo);
					cntStu.get(likeStuCnt).add(new Point(i, j));
				}
			}
		}
		
		// 그 중 인접 학생수가 가장 많은 리스트를 반환한다.
		for (int i = 4; i >= 0; i--) {
			if (cntStu.get(i).size() > 0) {
				return cntStu.get(i);
			}
		}
		
		return null;
	}
	
	// 해당 자리와 인접한 빈 칸의 수를 센다.
	public int countEmptySeats(int y, int x) {
		int cnt = 0;
		for (int k = 0; k < neighborCnt; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (0 < ny && ny <= N && 0 < nx && nx <= N) {	// 범위 확인
				if (seat[ny][nx] == 0) {			// 그 자리가 비어있는가?
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	// arr에 있는 좌석 리스트 중, 인접 칸에 빈자리가 가장 많은 자리를 반환한다.
	public Point getEmptySeat(ArrayList<Point> arr) {
		
		// graph init
		ArrayList<ArrayList<Point>> cntEmpty = new ArrayList<>();
		for (int i = 0; i <= neighborCnt; i++) {
			cntEmpty.add(new ArrayList<Point>());
		}
				
		for (Point p : arr) {
			if (seat[p.y][p.x] == 0) {
				int val = countEmptySeats(p.y, p.x);
				cntEmpty.get(val).add(new Point(p.y, p.x));
			}
		}
		
		// 그 중 인접 칸이 가장 많이 빈 리스트의 첫번째 값을 반환한다.
		// - 3번 조건 충족 위함
		for (int i = 4; i >= 0; i--) {
			if (cntEmpty.get(i).size() > 0) {
				return cntEmpty.get(i).get(0);
			}
		}
		return null;
	}
}