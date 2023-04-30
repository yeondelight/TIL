import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	int i;
	int j;
	public Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

class SOL15684 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N, M, H;
	public boolean[][] map;
	public ArrayList<Point> ladders;
	
	public int ans;
	public boolean flag;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stNMH = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNMH.nextToken());
		M = Integer.parseInt(stNMH.nextToken());
		H = Integer.parseInt(stNMH.nextToken());
		
		map = new boolean[H+1][N+1];
		for (int i = 0; i < M; i++) {
			StringTokenizer stab = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stab.nextToken());
			int b = Integer.parseInt(stab.nextToken());
			map[a][b] = true;
		}
	}
	
	public void solution() {
		flag = true;
		ans = Integer.MAX_VALUE;
		ladders = new ArrayList<>();
		getAvailLadders();
		putLadders(-1, 0);
	}
	
	public void print() {
		if (ans > 3 || !flag)	System.out.println(-1);
		else					System.out.println(ans);
	}

	// 사다리를 놓을 수 있는 모든 지점을 저장한다.
	public void getAvailLadders() {
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j]) {
					continue;
				}
				if (canPutLadder(i, j)) {
					ladders.add(new Point(i, j));
				}
			}
		}
	}	
	
	// [a][b] - [a][b+1]에 사다리를 놓을 수 있는가?
	public boolean canPutLadder(int a, int b) {
		if (b < N && !map[a][b-1] && !map[a][b] && !map[a][b+1]) {
			return true;
		}
		return false;
	}
	
	// ladders.get(idx)의 위치부터 사다리를 놓아본다.
	public void putLadders(int idx, int res) {
		
		// res 3 초과면 의미 없다
		if (res > 3) {
			return;
		}

		// 만약 I2I가 된다면 ans 갱신
		if (ghostLag()) {
			flag = true;
			ans = Math.min(ans, res);
		}
		
		// 그게 아니면 또 돌아봐야한다.
		for (int i = idx + 1; i < ladders.size(); i++) {
			Point p = ladders.get(i);
			if (canPutLadder(p.i, p.j)) {
				map[p.i][p.j] = true;
				putLadders(i+1, res+1);
				map[p.i][p.j] = false;
			}
		}
	}

	// 사다리타기가 I2I 결과가 나오는가?
	public boolean ghostLag() {
		for (int start = 1; start <= N; start++) {
			int i = 1, j = start;
			while (i <= H) {
				if (map[i][j]) {
					j++;
				}
				else if (j > 0 && map[i][j-1]) {
					j--;
				}
				i++;
			}
			if (j != start) {
				return false;
			}
		}
		
		return true;
	}
}
