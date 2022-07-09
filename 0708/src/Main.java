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
	}
	
	public int[][] deepCopy(int[][] map) {
		int[][] res = new int [map.length][map[0].length];
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, res[i], 0, map[i].length);
		}
		return res;
	}
	
	public void sol_14052() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int init0 = 0;
		
		Queue<Point> virus = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)			virus.add(new Point(i, j));
				else if (map[i][j] == 0)	init0++;
			}
		}
		
		// create 3 walls
		// virus BFS
		// Math.max(safeArea)
		int safeArea = 0;
		int[][] tempMap;
		int tempInit0 = init0;
		Queue<Point> q;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		for (int i = 0; i < N * M; i++) {
			if (map[i / M][i % M] == 1)	continue;
			for (int j = i + 1; j < N * M; j++) {
				if (map[j / M][j % M] == 1)	continue;
				for (int k = j + 1; k < N * M; k++) {
					if (map[k / M][k % M] == 1)	continue;
					
					q = new LinkedList<>();
					q.addAll(virus);
					tempMap = new int[N][M];
					tempMap = deepCopy(map);
					tempInit0 = init0;
					tempMap[i / M][i % M] = 1;
					tempMap[j / M][j % M] = 1;
					tempMap[k / M][k % M] = 1;
					
					while(!q.isEmpty()) {
						Point p = q.poll();
						for (int l = 0; l < 4; l++) {
							int nx = p.x + dx[l];
							int ny = p.y + dy[l];
							if (nx >= 0 && nx < N && ny >= 0 && ny < M && tempMap[nx][ny] == 0) {
								q.add(new Point(nx, ny));
								tempMap[nx][ny] = 2;
								tempInit0--;
							}
						}
					} // end of BFS
					safeArea = Math.max(safeArea, tempInit0-3);
				} // end of for(k)	
			} // end of for(j)
		} // end of for(i)
		
		System.out.println(safeArea);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_14052();
	}
}
