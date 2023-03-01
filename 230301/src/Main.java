import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	class Point {
		private int y;
		private int x;
		public Point (int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public void sol_5212() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) == 'X' ? true : false;
			}
		}
		
		// find sink island
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};
		Vector<Point> sink = new Vector<>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				
				// 현재 값이 바다면 검사 안함
				if (!map[i][j])	continue;
				
				// 4방위 검사
				int sea = 0;
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					
					if ( 0 > ny || ny >= R || 0 > nx || nx >= C ) {
						sea++;
						continue;
					}
					if (!map[ny][nx]) {
						sea++;
					}
				}
				
				if (sea >= 3) {		// 3면 이상 바다면
					sink.add(new Point(i, j));
				}
			}
		}
		
		
		
		// island sink
		for (Point p : sink) {
			map[p.y][p.x] = false;
		}
		
		
		// compress map
		int minY = R, minX = C;
		int maxY = 0, maxX = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j]) {
					minY = Math.min(minY, i);
					minX = Math.min(minX, j);
					maxY = Math.max(maxY, i);
					maxX = Math.max(maxX, j);
				}
			}
		}
		
		
		// print
		StringBuilder sb = new StringBuilder();
		for (int i = minY; i <= maxY; i++) {
			for (int j = minX; j <= maxX; j++) {
				if (map[i][j])	sb.append('X');
				else			sb.append('.');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_5212();
	}
}
