import java.io.*;
import java.util.*;

public class Main {
	
	private static int white;
	private static int blue;
	
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
	
	public void partition2630(int[][] map, int row, int col, int size) {
		if (colorCheck(map, row, col, size)) {
			if (map[row][col] == 0)	white++;
			else					blue++;
			return;
		}
		size /= 2;
		partition2630(map, row, col, size);
		partition2630(map, row + size, col, size);
		partition2630(map, row, col + size, size);
		partition2630(map, row + size, col + size, size);
	}
	
	public void sol_2630() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partition2630(map, 0, 0, N);
		sb.append(white).append('\n').append(blue);
		System.out.println(sb);
	}

	public void sol_1074() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int x = (int)Math.pow(2, N) / 2;
		int y = x;
		int res = 0;
		
		while (N-- > 0) {
			int newSize = (int)Math.pow(2, N) / 2;
			int skipSize = (int)Math.pow(4, N);
			
			if (r < y && c < x) {
				y -= newSize;
				x -= newSize;
			} else if (r < y && x <= c) {
				y -= newSize;
				x += newSize;
				res += skipSize;
			} else if (y <= r && c < x) {
				y += newSize;
				x -= newSize;
				res += skipSize * 2;
			} else {
				y += newSize;
				x += newSize;
				res += skipSize * 3;
			}
		}
		
		System.out.println(res);
	}
	
	private static int paper_1;
	private static int paper0;
	private static int paper1;
	
	public boolean mapCheck(int[][] map, int row, int col, int size) {
		int flag = map[row][col];
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (map[i][j] != flag)	return false;
			}
		}
		return true;
	}
	
	public void partition1780(int[][] map, int row, int col, int size) {
		if (mapCheck(map, row, col, size)) {
			int flag = map[row][col];
			if (flag == -1)		paper_1++;
			else if (flag == 0)	paper0++;
			else				paper1++;
			return;
		}
		
		size /= 3;
		partition1780(map, row, col, size);
		partition1780(map, row, col + size, size);
		partition1780(map, row, col + size * 2, size);
		partition1780(map, row + size, col, size);
		partition1780(map, row + size, col + size, size);
		partition1780(map, row + size, col + size * 2, size);
		partition1780(map, row + size * 2, col, size);
		partition1780(map, row + size * 2, col + size, size);
		partition1780(map, row + size * 2, col + size * 2, size);
	}
	
	public void sol_1780() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partition1780(map, 0, 0, N);
		sb.append(paper_1).append('\n').append(paper0).append('\n').append(paper1);
		System.out.println(sb);
	}
	
	class Point {
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public void sol_2667() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[N][N];
		boolean[][] check = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) == '1' ? true : false;
			}
		}
		
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		Vector<Point> q = new Vector<>();
		Vector<Integer> count = new Vector<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] && !check[i][j]) {
					// BFS About map[i][j]
					int len = 1;
					check[i][j] = true;
					q.add(new Point(i, j));
					while(!q.isEmpty()) {
						Point p = q.remove(0);
						for (int k = 0; k < 4; k++) {
							int x = p.x + dx[k];
							int y = p.y + dy[k];
							if (x >= 0 && x < N && y >= 0 && y < N && map[x][y] && !check[x][y]) {
								len++;
								q.add(new Point(x, y));
								check[x][y] = true;
							}
						}
					}
					count.add(len);
				}
			}
		}

		sb.append(count.size()).append('\n');
		Collections.sort(count);
		for (int i = 0; i < count.size(); i++) {
			sb.append(count.get(i)).append('\n');
		}
		System.out.println(sb);
	}
	
	public void sol_5525() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		int i = 0;
		int res = 0;
		int count = 0;
		while (i < M - 2) {
			if (S.substring(i, i + 3).equals("IOI")) {
				i += 2;
				count++;
				if (count == N) {
					res++;
					count--;
				}
			} else {
				i++;
				count = 0;
			}
		}
		
		System.out.println(res);
	}
	
	public static void main (String[] args) throws Exception {
		new Main().sol_5525();
	}
}
