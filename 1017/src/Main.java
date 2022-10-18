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
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	class Node {
		Point p;
		int val;
		public Node(Point p, int val) {
			this.p = p;
			this.val = val;
		}
	}
	
	public void sol_2589() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N][M];
		Vector<Point> lands = new Vector<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char val = str.charAt(j);
				if (val == 'W')	map[i][j] = false;
				else {
					map[i][j] = true;
					lands.add(new Point(i, j));
				}
			}
		}

		int max = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for (Point start : lands) {
			boolean[][] visit = new boolean[N][M];
			visit[start.x][start.y] = true;
			
			Queue<Node> q = new LinkedList<>();
			q.offer(new Node(start, 0));
				
			int time = 0;
				
			while(!q.isEmpty()) {
				Node curr = q.poll();
				Point p = curr.p;
				
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (0 <= nx && nx < N && 0 <= ny && ny < M) {	// valid points
						if (!visit[nx][ny] && map[nx][ny]) {		// is Land
							visit[nx][ny] = true;
							Node next = new Node(new Point(nx, ny), curr.val + 1);
							q.offer(next);
							time = curr.val + 1;
						}
					}
				}

			}
				
			max = Math.max(max, time);
		}
		
		System.out.println(max);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2589();
	}
}
