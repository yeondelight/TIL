import java.io.*;
import java.util.*;

public class Main {

	public void sol_1541() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");
		
		int ans = 0;
		boolean isFirst = true;
		while(st1.hasMoreTokens()) {
			int temp = 0;
			StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");
			while (st2.hasMoreTokens()) {
				temp += Integer.parseInt(st2.nextToken());
			}
			if (isFirst) {
				ans = temp;
				isFirst = false;
			} else {
				ans -= temp;
			}
		}
		
		System.out.println(ans);
	}
	
	private char[][] map;
	private boolean[][] check;

	class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public void BFS_10026(int a, int b, char color) {
		int size = map.length;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(a, b));
		check[a][b] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if (0 <= x && x < size && 0 <= y && y < size) {
					if (!check[x][y] && map[x][y] == color) {
						check[x][y] = true;
						q.add(new Point(x, y));
					}
				}
			}
		}
	}
	
	public void sol_10026() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		check = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// can see
		int can = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					can++;
					BFS_10026(i, j, map[i][j]);
				}
			}
		}
		
		// can not see
		int cannot = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				check[i][j] = false;
				if (map[i][j] == 'G')	map[i][j] = 'R';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					cannot++;
					BFS_10026(i, j, map[i][j]);
				}
			}
		}
		
		System.out.println(can + " " + cannot);
	}
	
	class Point3D{
		int x;
		int y;
		int z;
		Point3D(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public void sol_7569() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] map = new int[N][M][H];
		
		int[] dx = {-1, 1, 0, 0, 0, 0};
		int[] dy = {0, 0, -1, 1, 0, 0};
		int[] dz = {0, 0, 0, 0, -1, 1};
		int[][][] check = new int[N][M][H];
		Queue<Point3D> q = new LinkedList<>();
		
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 1)	q.add(new Point3D(i, j, k));
				}
			}
		}

		// BFS
		while(!q.isEmpty()) {
			Point3D p = q.poll();
			for (int i = 0; i < 6; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				int z = p.z + dz[i];
				if (x >= 0 && x < N && y >= 0 && y < M && z >= 0 && z < H && map[x][y][z] == 0) {
					q.add(new Point3D(x, y, z));
					map[x][y][z] = 1;
					check[x][y][z] = check[p.x][p.y][p.z] + 1;
				}
			}
		}
		
		// check
		int max = -1;
		
		Check:
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j][k] == 0) {
						max = -1;
						break Check;
					}
					max = Math.max(max, check[i][j][k]);
				}
			}
		}
		
		System.out.println(max);
	}
	
	public boolean colorCheck(int[][] map, int row, int col, int size) {
		int flag = map[row][col];
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (map[i][j] != flag)
					return false;
			}
		}
		return true;
	}
	
	public void partition_1992(int[][] map, int row, int col, int size) {
		if (colorCheck(map, row, col, size)) {
			if (map[row][col] == 0)	System.out.print(0);
			else					System.out.print(1);
			return;
		}
		size /= 2;
		System.out.print("(");
		partition_1992(map, row, col, size);
		partition_1992(map, row, col + size, size);
		partition_1992(map, row + size, col, size);
		partition_1992(map, row + size, col + size, size);
		System.out.print(")");
	}
	
	public void sol_1992() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		
		partition_1992(map, 0, 0, N);
	}

	public void sol_11403() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int MAX = N * N + 1;
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (st.nextToken().equals("1"))	dist[i][j] = 1;
				else							dist[i][j] = MAX;
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dist[i][j] >= MAX)	sb.append(0).append(' ');
				else					sb.append(1).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_5430() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String P = br.readLine();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[|,|]");

			boolean flag = true;
			boolean increase = true;
			Deque<Integer> d = new ArrayDeque<>();
			
			for (int j = 0; j < N; j++) {
				d.add(Integer.parseInt(st.nextToken()));
			}
			
			for (int j = 0; j < P.length(); j++) {
				if (P.charAt(j) == 'R') {
					if (increase)	increase = false;
					else			increase = true;
				} else {
					if (d.size() == 0) {
						flag = false;
						break;
					} else {
						if (increase)	d.pollFirst();
						else			d.pollLast();
					}
				}
			}
			if (flag) {
				int size = d.size() - 1;
				if (size < 0) {
					sb.append("[]\n");
				}
				else {
					if (increase) {
						sb.append("[");
						for (int j = 0; j < size; j++) sb.append(d.pollFirst()).append(',');
						sb.append(d.pollFirst()).append("]\n");
					} else {
						sb.append("[");
						for (int j = size; j > 0; j--) sb.append(d.pollLast()).append(',');
						sb.append(d.pollLast()).append("]\n");
					}
				}
			}
			else {
				sb.append("error\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public void sol_11286() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		Map<Integer, PriorityQueue<Integer>> absMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(br.readLine());
			if (X == 0) {
				if (q.isEmpty())	sb.append(0).append('\n');
				else {
					int key = q.poll();
					PriorityQueue<Integer> val = absMap.get(key);
					sb.append(val.poll()).append('\n');
					absMap.put(key, val);
				}
			} else {
				int key = Math.abs(X);
				q.add(key);
				PriorityQueue<Integer> val;
				if (absMap.containsKey(key))	val = absMap.get(key);
				else 							val = new PriorityQueue<>();
				val.add(X);
				absMap.put(key, val);
			}
		}
		
		System.out.println(sb);
	}
	
	public void sol_1107() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		// broken을 포함하지 않으면서 N에 가장 가까운 수 찾기
		int res = Math.abs(N - 100);
		for (int i = 0; i <= 999999; i++) {
			boolean flag = true;
			String str = String.valueOf(i);
			for (int j = 0; j < str.length(); j++) {
				if (broken[str.charAt(j)-'0']) {
					flag = false;
					break;
				}
			}
			if (flag) {
				int count = str.length() + Math.abs(N - i);
				res = Math.min(count, res);
			}
		}
		
		System.out.println(res);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1107();
	}
}
