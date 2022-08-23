import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int count;
	public static int[] g;
	public static int[] prev;
	public static boolean[] visit;
	public static boolean[] finish;
	
	public void dfs(int curr) {
		visit[curr] = true;
		int next = g[curr];	// 다음 방문 노드
		
		if (!visit[next]) {		// 방문하지 않은 경우 계속 탐색
			prev[next] = curr;	// cycle 탐색을 위한 이전 노드 표시
			dfs(next);
		}
		else {					// 방문한 경우 Cycle인지 확인
			if (!finish[next]) {
				cycle(curr, g[curr]);
			}
		}
		finish[curr] = true;
	}
	
	public void cycle(int curr, int next) {
		count++;
		if (curr == next)	return;
		else				cycle(prev[curr], next);
	}
	
	public void sol_9466() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			// add Vertex
			g = new int[N+1];
			prev = new int[N+1];
			
			// add Edges
			for (int j = 1; j <= N; j++) {
				g[j] = Integer.parseInt(st.nextToken());
			}
			
			// DFS
			count = 0;
			visit = new boolean[N+1];
			finish = new boolean[N+1];
			for (int j = 1; j <= N; j++) {
				if (!finish[j])	dfs(j);
			}
			
			sb.append(N-count).append('\n');
		}
		
		System.out.print(sb);
	}
	
	
	public static int count2;
	public static Point[][] map;
	public static boolean[][] visit2;
	public static boolean[][] finish2;
	
	class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public void dfs(Point curr) {
		visit2[curr.x][curr.y] = true;
		Point next = map[curr.x][curr.y];	// 다음 방문 노드
		
		if (!visit2[next.x][next.y]) {		// 방문하지 않은 경우 계속 탐색
			dfs(next);
		}
		else {								// 방문한 경우 Cycle 표시
			if (!finish2[next.x][next.y]) {
				count2++;
			}
		}
		finish2[curr.x][curr.y] = true;
	}
	
	public void sol_16724() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// get map
		map = new Point[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				switch (str.charAt(j)) {
				case 'U':	map[i][j] = new Point(i-1, j);	break;
				case 'D':	map[i][j] = new Point(i+1, j);	break;
				case 'L':	map[i][j] = new Point(i, j-1);	break;
				case 'R':	map[i][j] = new Point(i, j+1);	break;
				}
			}
		}
		
		
		// get Cycle by DFS
		visit2 = new boolean[N][M];
		finish2 = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!finish2[i][j]) {
					dfs(new Point(i, j));
				}
			}
		}
		
		System.out.println(count2);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_16724();
	}
}
