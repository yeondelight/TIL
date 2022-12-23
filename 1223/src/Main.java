import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int hashCode() {
			return this.x + this.y;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o instanceof Point) {
				Point cmp = (Point) o;
				return this.x == cmp.x && this.y == cmp.y;
			}
			return false;
		}
		
		@Override
		public String toString() {
			return "(" + this.x + ", " + this.y + ")";
		}
	}
	
	public void sol_17822() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int NONE = Integer.MIN_VALUE;
		
		// T번 회전
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int xi = Integer.parseInt(st.nextToken());
			int di = Integer.parseInt(st.nextToken());
			int ki = Integer.parseInt(st.nextToken());
			
			// 1. 번호가 xi의 배수인 원판을 di 방향으로 ki칸 회전
			if (di == 0) {	// 시계방향
				for (int i = 0; i < N; i++) {
					if ((i+1) % xi == 0) {	// 회전해야하는 원판임
						for (int k = 0; k < ki; k++) {
							int remain = board[i][M-1];
							for (int j = M-1; j > 0; j--) {
								board[i][j] = board[i][j-1];
							}
							board[i][0] = remain;							
						}
					}
				}
			} else {		// 반시계방향
				for (int i = 0; i < N; i++) {
					if ((i+1) % xi == 0) {	// 회전해야하는 원판임
						for (int k = 0; k < ki; k++) {
							int remain = board[i][0];
							for (int j = 0; j < M-1; j++) {
								board[i][j] = board[i][j+1];
							}
							board[i][M-1] = remain;							
						}
					}
				}
				
			}
			
			// 2. 원판에 수가 남아있으면 인접하면서 수가 같은걸 모두 찾는다
			HashSet<Point> set = new HashSet<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == NONE) {
						continue;
					}
					int left = (j+M-1) % M;
					int right = (j+1) % M;
					int top = i + 1;
					int down = i - 1;
					boolean flag = false;
					if (board[i][j] == board[i][left]) {
						flag = true;
						set.add(new Point(i, left));
					}
					if (board[i][j] == board[i][right]) {
						flag = true;
						set.add(new Point(i, right));
					}
					if (top < N && board[i][j] == board[top][j]) {
						flag = true;
						set.add(new Point(top, j));
					}
					if (down > 0 && board[i][j] == board[down][j]) {
						flag = true;
						set.add(new Point(down, j));
					}
					if (flag) {
						set.add(new Point(i, j));
					}
				}
			}

			if (set.size() > 0) {			// 2-1. 그러한 수가 있으면
				for (Point p : set) {
					board[p.x][p.y] = NONE;	// 같은 수를 모두 지운다
				}
			}
			else {							// 2-2. 그러한 수가 없으면
				int sum = 0;				// 평균을 구하고
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (board[i][j] != NONE) {
							sum += board[i][j];
							cnt++;
						}
					}
				}
				double avg = (double)sum / cnt;		// 평균에 가깝게 연산한다
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (board[i][j] != NONE) {
							if (board[i][j] > avg)		board[i][j]--;
							else if (board[i][j] < avg)	board[i][j]++;
						}
					}
				}
			}
		}
		
		// 합 구하기
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] != NONE) {
					sum += board[i][j];
				}
			}
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_17822();
	}
}
