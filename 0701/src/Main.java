import java.io.*;
import java.util.*;

public class Main {
	
	public void sol_1927() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (minHeap.isEmpty())	sb.append(0).append('\n');
				else					sb.append(minHeap.poll()).append('\n');
			} else {
				minHeap.add(x);
			}
		}
		
		System.out.println(sb);
	}
	
	public void sol_11279() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (minHeap.isEmpty())	sb.append(0).append('\n');
				else					sb.append(minHeap.poll()).append('\n');
			} else {
				minHeap.add(x);
			}
		}
		
		System.out.println(sb);
	}
	
	class Graph11724 {
		private ArrayList<ArrayList<Integer>> g;
		
		Graph11724(int size){
			g = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i <= size; i++) {
				g.add(new ArrayList<Integer>());
			}
		}
		
		public void addEdge(int x, int y) {
			g.get(x).add(y);
			g.get(y).add(x);
		}
		
		public int BFS() {
			int count = 0;
			int size = g.size();
			Queue<Integer> q = new LinkedList<Integer>();
			Vector<Integer> visited = new Vector<Integer>();
			visited.add(0);
			while(visited.size() != size) {
				count++;
				int rand;
				do {
					rand = (int)(Math.random() * (size - 1))  + 1;
				} while (visited.contains(rand));
				q.add(rand);
				visited.add(rand);
				while(!q.isEmpty()) {
					ArrayList<Integer> arr = g.get(q.poll());
					for (int a : arr) {
						if (!visited.contains(a)) {
							visited.add(a);
							q.add(a);
						}
					}
				}
			}
			
			return count;
		}
	}
	
	public void sol_11724() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Graph11724 g = new Graph11724(N);
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			g.addEdge(x, y);
		}
		
		System.out.println(g.BFS());
	}

	public void sol_1697() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (N == K) {
			System.out.println(0);
			return;
		}
		
		
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		q.add(N);
		visited[N] = true;
		
		BFS:
		while (true) {
			count++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int v = q.poll();
				visited[v] = true;
				if (v-1 == K || v+1 == K || v*2 == K)	break BFS;
				if (v-1 >= 0 && !visited[v-1]) {
					visited[v-1] = true;
					q.add(v-1);
				}
				if (v+1 <= 100000 && !visited[v+1]) {
					visited[v+1] = true;
					q.add(v+1);
				}
				if (v*2 <= 100000 && !visited[v*2]) {
					visited[v*2] = true;
					q.add(v*2);
				}
			}
		}
		
		System.out.println(count);
	}
	
	class Point {
		int x; 
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public void sol_2178() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				if (str.charAt(j-1) == '1')	map[i][j] = true;
				else						map[i][j] = false;
			}
		}

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[][] check = new int[N+1][M+1];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(1, 1));
		check[1][1] = 1;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if (x >= 1 && x <= N && y >= 1 && y <= M && map[x][y]) {
					q.add(new Point(x, y));
					map[x][y] = false;
					check[x][y] = check[p.x][p.y] + 1;
				}
			}
		}
		
		System.out.println(check[N][M]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2178();
	}
}
