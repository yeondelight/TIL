import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public void sol_2638() throws Exception {
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
		
		int time = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int OUTAIR = 9;				// 바깥 공기를 나타내는 숫자
		while (true) {
			// 1. count cheeze, check outside
			int cheeze = N*M - 1;
			boolean[][] visited = new boolean[N][M];
			Queue<Point> q = new LinkedList<>();
			q.offer(new Point(0, 0));
			map[0][0] = OUTAIR;
			visited[0][0] = true;
			while(!q.isEmpty()) {
				Point p = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && map[nx][ny] != 1) {
						cheeze--;
						map[nx][ny] = OUTAIR;
						visited[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
			}
			if (cheeze == 0) {	// 치즈가 없으면 탈출
				break;
			}
			
			// 2. check melting cheeze
			Vector<Point> melting = new Vector<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						int count = 0;
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if (map[nx][ny] == 9) {
								count++;
							}
						}
						if (count > 1) {
							melting.add(new Point(i, j));
						}
					}
				}
			}
			
			// 3. melt cheeze
			for (Point p : melting) {
				map[p.x][p.y] = OUTAIR;
			}
			
			time++;
		}
		
		System.out.println(time);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2638();
	}
}
