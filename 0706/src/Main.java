import java.io.*;
import java.util.*;

public class Main {
	
	private static int res;
	private static int[][] map;
	private static boolean[][] check;
	
	public void DFS_14500(int x, int y, int N, int M, int sum, int len) {
		if (len >= 4) {
			res = Math.max(res, sum);
			return;
		}
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && !check[nx][ny]) {
				check[nx][ny] = true;
				DFS_14500(nx, ny, N, M, sum + map[nx][ny], len+1);
				check[nx][ny] = false;
			}
		}
	}
	
	public void checkShape_14500(int x, int y, int N, int M) {
		int[][]dx = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
		int[][]dy = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};
		for (int i = 0; i < 4; i++) {
			boolean checkShape = true;
			int sum = 0;
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[i][j];
				int ny = y + dy[i][j];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					sum += map[nx][ny];
				} else {
					checkShape = false;
					break;
				}
			}
			if (checkShape)	res = Math.max(res, sum);
		}
	}
	
	public void sol_14500() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 길이가 4인 DFS 수행
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M ; j++) {
				check[i][j] = true;
				DFS_14500(i, j, N, M, map[i][j], 1);
				check[i][j] = false;
				checkShape_14500(i, j, N, M);
			}
		}
		
		System.out.println(res);
	}
	
	class Way {
		int curr;
		int move;
		Way(int c, int m){
			this.curr = c;
			this.move = m;
		}
	}
	
	public void sol_16928() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> shortcut = new HashMap<>();
		
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			shortcut.put(x, y);
		}
		
		int board[] = new int[101];
		Arrays.fill(board, Integer.MAX_VALUE);
		Queue<Way> q = new LinkedList<>();
		q.add(new Way(1, 0));
		board[1] = 0;
		
		while(!q.isEmpty()) {
			Way w = q.poll();
			if (w.curr == 100)	break;
			int moves = w.move + 1;
			for (int i = 6; i > 0; i--) {
				int next = w.curr + i;
				if (next > 100)
					continue;
				if (shortcut.containsKey(next))
					next = shortcut.get(next);
				if (board[next] > moves) {
					board[next] = moves;
					q.add(new Way(next, moves));
				}
			}
		}
		
		System.out.println(board[100]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_16928();
	}
}
