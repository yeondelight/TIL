import java.io.*;
import java.util.*;

public class Main {
	
	class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	
	public void sol_7562() throws Exception {
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			// scan
			int L = Integer.parseInt(br.readLine());
			int[][] map = new int[L][L];
			st = new StringTokenizer(br.readLine());
			Point now = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			Point next = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
			// move
			int min = Integer.MAX_VALUE;
			int[][] count = new int[L][L];
			
			int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
			int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
			boolean[][] check = new boolean[L][L];
			Queue<Point> q = new LinkedList<>();
			
			check[now.x][now.y] = true;
			q.add(now);
			
			Loop:
			while(!q.isEmpty()) {
				Point p =  q.poll();
				for (int j = 0; j < 8; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					if (0 <= nx && nx < L && 0 <= ny && ny < L && !check[nx][ny]) {
						count[nx][ny] = count[p.x][p.y] + 1;
						check[nx][ny] = true;
						q.add(new Point(nx, ny));
					}
					if (nx == next.x && ny == next.y) {
						break Loop;
					}
				}
			}
			
			sb.append(count[next.x][next.y]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_7562();
	}
}
