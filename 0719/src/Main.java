import java.io.*;
import java.util.*;

public class Main {
	
	class Point implements Comparable<Point>{
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
		
		@Override
		public int compareTo(Point p) {
			if (x == p.x) {
				return y - p.y;
			} else {
				return x - p.x;
			}
		}
	}
	
	public void sol_16236() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] check = new int[N][N];
		Point now = new Point(0, 0);
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) now = new Point(i, j);
			}
		}

		int res = 0;
		int ate = 0;
		int size = 2;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		while (true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					check[i][j] = -1;
				}
			}
			check[now.x][now.y] = 0;
			map[now.x][now.y] = 0;
			Queue<Point> q = new LinkedList<>();
			Vector<Point> fish = new Vector<>();
			if (ate >= size) {	// 먹은 물고기 양이 아기상어의 사이즈보다 크다면
				ate -= size;	// 사이즈만큼의 먹은 물고기 양을 빼주고
				size++;			// 아기상어의 사이즈를 키운다.
			}
			q.offer(now);			
			
			// BFS
			while(!q.isEmpty()) {
				Point p = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (0 > nx || nx >= N || 0 > ny || ny >= N || check[nx][ny] != -1)	continue;
					if (map[nx][ny] > size)	continue;
					else if (map[nx][ny] == size || map[nx][ny] == 0) {	// 지나갈 수 있다
						check[nx][ny] = check[p.x][p.y] + 1;
						q.offer(new Point(nx, ny));
					}
					else if (map[nx][ny] < size && map[nx][ny] >= 1) {	// 먹을 수 있다
						check[nx][ny] = check[p.x][p.y] + 1;
						fish.add(new Point(nx, ny));
						q.offer(new Point(nx, ny));
					}
				}
			}
			
			// 먹을 수 있는 물고기 출력
			if (fish.isEmpty()) {			// 없으면 탐색 종료
				System.out.println(res);
				return;
			}
			else if (fish.size() == 1) {	// 하나 있으면 걔 먹으러 가기
				Point f = fish.get(0);
				now.x = f.x;
				now.y = f.y;
				map[now.x][now.y] = 0;
				res += check[now.x][now.y];
				ate++;
			}
			else {							// 여러개 있으면 거리 짧은거 먹기
				int minDist = Integer.MAX_VALUE;
				for (Point p : fish) {
					minDist = Math.min(minDist, check[p.x][p.y]);
				}
				Vector<Point> minFish = new Vector<>();
				for (Point p : fish) {
					if (minDist == check[p.x][p.y]) {
						minFish.add(new Point(p.x, p.y));
					}
				}
				
				// 위, 좌 순서대로
				if (minFish.size() > 1)	Collections.sort(minFish);
				Point f = minFish.get(0);
				now.x = f.x;
				now.y = f.y;
				map[now.x][now.y] = 0;
				res += check[now.x][now.y];
				ate++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_16236();
	}
}
