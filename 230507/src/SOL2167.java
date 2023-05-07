import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int i;
	int j;
	int x;
	int y;
	public Point(int i, int j, int x, int y) {
		this.i = i;
		this.j = j;
		this.x = x;
		this.y = y;
	}
}

class SOL2167 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N, M, K;
	public int[][] map;
	public Point[] points;
	
	public int[][] sum;
	public Queue<Integer> ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		
		map = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer stMap = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(stMap.nextToken());
			}
		}
		
		K = Integer.parseInt(br.readLine());
		points = new Point[K];
		for (int k = 0; k < K; k++) {
			StringTokenizer stPP = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(stPP.nextToken());
			int j = Integer.parseInt(stPP.nextToken());
			int x = Integer.parseInt(stPP.nextToken());
			int y = Integer.parseInt(stPP.nextToken());
			points[k] = new Point(i, j, x, y);
		}
	}
	
	public void solution() {
		
		// 1. 모든 합을 저장하기
		sum = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + map[i][j];
			}
		}
		
		// 2. 돌아가면서 값 확인하기
		ans = new LinkedList<>();
		for (int k = 0; k < K; k++) {
			int i = points[k].i - 1;
			int j = points[k].j - 1;
			int x = points[k].x;
			int y = points[k].y;
			int val = sum[x][y] + sum[i][j] - sum[i][y] - sum[x][j];
			ans.offer(val);
		}
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		while(!ans.isEmpty()) {
			sb.append(ans.poll());
			sb.append('\n');
		}
		System.out.println(sb);
	}

}