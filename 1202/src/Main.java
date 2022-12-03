import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public void sol_9205() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			// scan n, points
			int n = Integer.parseInt(br.readLine());
			ArrayList<Point> points = new ArrayList<>();
			for (int j = 0; j < n+2; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				points.add(new Point(x, y));
			}
			
			// init graph
			ArrayList<ArrayList<Integer>> g = new ArrayList<>();
			for (int j = 0; j < n+2; j++) {
				g.add(new ArrayList<Integer>());
			}
			
			// cal dist, link graph
			for (int a = 0; a < n+2; a++) {
				for (int b = a+1; b < n+2; b++) {
					Point p1 = points.get(a);
					Point p2 = points.get(b);
					int dx = Math.abs(p1.x - p2.x);
					int dy = Math.abs(p1.y - p2.y);
					int dist = dx + dy;
					if (dist <= 1000) {
						g.get(a).add(b);
						g.get(b).add(a);
					}
				}
			}
			
			// BFS
			boolean[] visited = new boolean[n+2];
			Queue<Integer> q = new LinkedList<>();
			visited[0] = true;
			q.add(0);
			
			while(!q.isEmpty()) {
				ArrayList<Integer> nodes = g.get(q.poll());
				for (int node : nodes) {
					if (!visited[node]) {
						visited[node] = true;
						q.add(node);
					}
				}
			}
			
			// 마지막 점에만 도달하면 된다.
			// print
			if (visited[n+1])	sb.append("happy\n");
			else				sb.append("sad\n");
		}
		
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {
		new Main().sol_9205();
	}
}
