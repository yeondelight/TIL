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
	
	public void sol_2468() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] size = new int[101];		// i이하의 비가 왔을 때 살아남는 칸
		int[][] map = new int[N][N];
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				for (int k = 0; k < map[i][j]; k++)	size[k]++;
			}
		}
		
		int safeArea = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		for (int i = 0; i < max; i++) {		// i이하는 모두 잠긴다.
			int count = 0;
			int tempSize = 0;
			boolean[][] check = new boolean[N][N];
			Queue<Point> q = new LinkedList<>();
			while(tempSize < size[i]) {
				count++;
				int x, y;
				do {
					x = (int)(Math.random() * N);
					y = (int)(Math.random() * N);
				} while((map[x][y] <= i) || check[x][y]);
				tempSize++;
				check[x][y] = true;
				q.add(new Point(x, y));
				
				while(!q.isEmpty()){
					Point p = q.poll();
					for (int j = 0; j < 4; j++) {
						int nx = p.x + dx[j];
						int ny = p.y + dy[j];
						if (0 <= nx && nx < N && 0 <= ny && ny < N && !check[nx][ny] && map[nx][ny] > i) {
							tempSize++;
							check[nx][ny] = true;
							q.add(new Point(nx, ny));
						}
					} // end of for(dx, dy)
				} // end of while(!q.isEmpty())
			} // end of while(visited.size() != size[i]) 
			
			safeArea = Math.max(safeArea, count);
		}
		
		System.out.println(safeArea);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2468();
	}
}
