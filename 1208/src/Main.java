import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	class Point {
		int x;
		int y;
		int time;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			this.time = -1;
		}
		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
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
	}
	
	public void sol_3055() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		
		Point D = new Point(0, 0);
		Point S = new Point(0, 0);

		Queue<Point> water = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				char curr = s.charAt(j);
				map[i][j] = curr;
				switch(curr) {
				case 'D':
					D = new Point(i, j, 0);
					break;
				case 'S':
					S = new Point(i, j, 0);
					break;
				case '*':
					water.offer(new Point(i, j));
					break;
				}
			}
		}
		
		boolean[][] visited = new boolean[R][C];
		visited[S.x][S.y] = true;
		
		Queue<Point> q = new LinkedList<>();
		q.offer(S);
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int time = 0;
		boolean flag = false;
		
		while(!q.isEmpty()) {			
			// 물 채우기
			int waterSize = water.size();
			for (int i = 0; i < waterSize; i++) {
				Point w = water.poll();
				for (int k = 0; k < 4; k++) {
					int nx = w.x + dx[k];
					int ny = w.y + dy[k];
					if (0 <= nx && nx < R && 0 <= ny && ny < C) {
						if (map[nx][ny] == '.') {
							map[nx][ny] = '*';
							water.offer(new Point(nx, ny));
						}
					}
				}
			}	
			
			// 이동
			int moveSize = q.size();
			for (int i = 0; i < moveSize; i++) {
				Point curr = q.poll();
				if (curr.equals(D)) {
					time = curr.time;
					flag = true;
					break;
				}
				int nextTime = curr.time + 1;
				for (int k = 0; k < 4; k++) {
					int nx = curr.x + dx[k];
					int ny = curr.y + dy[k];
					if (0 <= nx && nx < R && 0 <= ny && ny < C) {
						if (!visited[nx][ny] && map[nx][ny] != '*' && map[nx][ny] != 'X') {
							visited[nx][ny] = true;
							q.offer(new Point(nx, ny, nextTime));
						}
					}
				}
			}
		}
		
		if (flag)	System.out.println(time);
		else		System.out.println("KAKTUS");
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_3055();
	}
}
