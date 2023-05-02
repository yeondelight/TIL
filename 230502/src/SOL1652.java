import java.io.BufferedReader;
import java.io.InputStreamReader;

class SOL1652 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N;
	public boolean[][] map;
	
	public int ansR, ansC;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		
		map = new boolean[N+1][N+1];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) == '.' ? true : false;
			}
		}
	}
	
	public void solution() {
		
		// 가로 확인
		ansR = 0;
		for (int i = 0; i < N; i++) {
			int emptySeats = 0;
			for (int j = 0; j <= N; j++) {
				// 누울 수 있는 자리면 연속된 칸의 수 증가
				if (map[i][j]) {
					emptySeats++;
					continue;
				}
				// 짐이 있는 곳이면 현재까지 집계된 연속 칸 수 파악 후
				// 누울 수 있는 공간인지 확인한다.
				if (emptySeats >= 2) {
					ansR++;
				}
				// 벽을 만나면 연속된 칸의 개수는 리셋
				emptySeats = 0;
			}
		}
		
		// 세로 확인
		ansC = 0;
		for (int j = 0; j < N; j++) {
			int emptySeats = 0;
			for (int i = 0; i <= N; i++) {
				// 누울 수 있는 자리면 연속된 칸의 수 증가
				if (map[i][j]) {
					emptySeats++;
					continue;
				}
				// 짐이 있는 곳이면 현재까지 집계된 연속 칸 수 파악 후
				// 누울 수 있는 공간인지 확인한다.
				if (emptySeats >= 2) {
					ansC++;
				}
				// 벽을 만나면 연속된 칸의 개수는 리셋
				emptySeats = 0;
			}
		}
	}
	
	public void print() {
		System.out.println(ansR + " " + ansC);
	}

}