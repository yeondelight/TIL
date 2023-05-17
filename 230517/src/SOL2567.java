import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL2567 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int[] dy = {-1, 1, 0, 0};
	public int[] dx = {0, 0, -1, 1};
	public int LANDSIZE = 100;
	public int PAPERSIZE = 10;

	public boolean[][] map;
	public int ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		int N = Integer.parseInt(br.readLine());
		map = new boolean[LANDSIZE+1][LANDSIZE+1];
		
		for (int n = 0; n < N; n++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = y; i < y + PAPERSIZE; i++) {
				for (int j = x; j < x + PAPERSIZE; j++) {
					map[i][j] = true;
				}
			}
		}
	}
	
	public void solution() {
		
		ans = 0;
		
		for (int i = 0; i < LANDSIZE; i++) {
			for (int j = 0; j < LANDSIZE; j++) {
				
				if (!map[i][j]) {
					continue;
				}
				
				int edgeCnt = 0;
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					if (!inArea(ny, nx) || !map[ny][nx]) {
						edgeCnt++;
					}
				}
				
				ans += edgeCnt;
			}
		}
	}
	
	public void print() {
		System.out.println(ans);
	}
	
	public boolean inArea(int y, int x) {
		return 0 <= y && y <= LANDSIZE && 0 <= x && x <= LANDSIZE;
	}
}
