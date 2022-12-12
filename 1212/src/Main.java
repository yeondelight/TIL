import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	class Point {
		int x;
		int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public void sol_2636() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int OUTAIR = 9;
		int prevCheeze = 0;
		int currCheeze = 0;
		
		int time = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while (true) {
			// 0. 치즈 개수 파악
			currCheeze = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						currCheeze++;
					}
				}
			}
			
			// 0-A. 모든 치즈가 녹았으면 탈출
			if (currCheeze == 0) {
				break;
			}
			
			// 0-B. 그 외의 경우 이전 치즈값 저장
			prevCheeze = currCheeze;
			
			// 1. 외부 공기 탐색
			currCheeze = N * M - 1;
			Queue<Point> q = new LinkedList<>();
			q.offer(new Point(0, 0));
			boolean[][] visited = new boolean[N][M];
			visited[0][0] = true;
			
			while(!q.isEmpty()) {
				Point p = q.poll();
				for (int k = 0; k < 4; k++) {
					int nx = p.x + dx[k];
					int ny = p.y + dy[k];
					if (0 <= nx && nx < N && 0 <= ny && ny < M) {
						if (map[nx][ny] != 1 && !visited[nx][ny]) {
							q.offer(new Point(nx, ny));
							visited[nx][ny] = true;
							map[nx][ny] = OUTAIR;
						}
					}
				}
			}
			
			// 2. 녹일 치즈 파악
			Vector<Point> melt = new Vector<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 1) {
						continue;
					}
					int outCnt = 0;
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (map[nx][ny] == OUTAIR) {
							outCnt++;
						}
					}
					if (outCnt > 0) {
						melt.add(new Point(i, j));
					}
				}
			}
			
			// 3. 치즈 녹이기
			for (Point p : melt) {
				map[p.x][p.y] = OUTAIR;
			}
			
			// 4. 시간 증가
			time++;
		}
		
		System.out.println(time);
		System.out.println(prevCheeze);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2636();
	}
}
