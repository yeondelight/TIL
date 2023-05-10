import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL2669 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int MAPSIZE = 100;
	public static int PAPERCNT = 4;

	public boolean[][] map;
	public int ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		
		map = new boolean[MAPSIZE+1][MAPSIZE+1];
		
		for (int n = 0; n < PAPERCNT; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					map[i][j] = true;
				}
			}
		}
	}
	
	public void solution() {
		for (int i = 0; i <= MAPSIZE; i++) {
			for (int j = 0; j <= MAPSIZE; j++) {
				if (map[i][j]) {
					ans++;
				}
			}
		}
	}
	
	public void print() {
		System.out.print(ans);
	}
}
