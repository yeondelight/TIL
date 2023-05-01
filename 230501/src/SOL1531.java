import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class PairPoint {
	Point p1;
	Point p2;
	
	public PairPoint(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
}

class SOL1531 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int mapSize = 100;
	
	public int M;
	public int[][] map;
	public ArrayList<PairPoint> papers;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		
		papers = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer stPaper = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(stPaper.nextToken());
			int y1 = Integer.parseInt(stPaper.nextToken());
			int x2 = Integer.parseInt(stPaper.nextToken());
			int y2 = Integer.parseInt(stPaper.nextToken());
			papers.add(new PairPoint(new Point(x1, y1), new Point(x2, y2)));
		}
	}
	
	public void solution() {
		
		map = new int[mapSize+1][mapSize+1];
		
		for (PairPoint pp : papers) {
			for (int i = pp.p1.x; i <= pp.p2.x; i++) {
				for (int j = pp.p1.y; j <= pp.p2.y; j++) {
					map[i][j]++;
				}
			}
		}
	}
	
	public void print() {
		int ans = 0;
		for (int i = 1; i <= mapSize; i++) {
			for (int j = 1; j <= mapSize; j++) {
				if (map[i][j] > M) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

}