import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_13015() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int gap = 2 * N - 3;
		
		// 첫줄
		for (int i = 0; i < N; i++)			sb.append('*');
		for (int i = 0; i < gap; i++)	sb.append(' ');
		for (int i = 0; i < N; i++)			sb.append('*');
		sb.append('\n');
		
		// 중간줄 구성 요소
		StringBuilder sbMiddle = new StringBuilder();
		sbMiddle.append('*');
		for (int i = 0; i < N-2; i++)	sbMiddle.append(' ');
		sbMiddle.append('*');
		
		// 중간줄 - Down
		for (int i = 1; i < N-1; i++) {	// i는 처음 빈칸의 수
			for (int j = 0; j < i; j++)	sb.append(' ');				// 시작 빈칸
			sb.append(sbMiddle);
			for (int j = 0; j < gap - 2 * i; j++)	sb.append(' ');	// 중간 빈칸
			sb.append(sbMiddle);
			sb.append('\n');
		}
		
		// 중간줄 - 정 가운데
		for (int i = 0; i < N-1; i++)	sb.append(' ');
		sb.append(sbMiddle);
		for (int i = 0; i < N-2; i++)	sb.append(' ');
		sb.append('*').append('\n');
		
		// 중간줄 - Up
		for (int i = N-2; i > 0; i--) {	// i는 처음 빈칸의 수
			for (int j = 0; j < i; j++)	sb.append(' ');				// 시작 빈칸
			sb.append(sbMiddle);
			for (int j = 0; j < gap - 2 * i; j++)	sb.append(' ');	// 중간 빈칸
			sb.append(sbMiddle);
			sb.append('\n');
		}
		
		// 마지막줄
		for (int i = 0; i < N; i++)			sb.append('*');
		for (int i = 0; i < gap; i++)	sb.append(' ');
		for (int i = 0; i < N; i++)			sb.append('*');
		
		// 출력
		System.out.println(sb);
	}
	
	class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public void sol_16173() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		q.offer(new Point(0, 0));
		visited[0][0] = true;
		
		int[] dx = {1, 0};
		int[] dy = {0, 1};
		
		boolean haru = false;
		
		while(!q.isEmpty()) {
			Point curr = q.poll();
			int val = map[curr.x][curr.y];
			
			if (val == -1) {
				haru = true;
				break;
			}
			
			for (int k = 0; k < 2; k++) {
				int nx = curr.x + dx[k] * val;
				int ny = curr.y + dy[k] * val;

				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
			}
		}
		
		if (haru)	System.out.println("HaruHaru");
		else 		System.out.println("Hing");
	}

	public static void main(String[] args) throws Exception {
		new Main().sol_16173();
	}
}
