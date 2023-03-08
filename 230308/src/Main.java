import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int R, C;
	private static char[][] map;
	private static char LAND, BOMB;
	private Queue<Bomb> q;
	
	class Bomb {
		
		private int x;
		private int y;
		
		public Bomb (int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		public int getX() { return x; }
		public int getY() { return y; }
	}
	
	// 폭탄이 설치되지 않은 곳에 모두 설치한다.
	public void installBomb() {
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == LAND) {
					map[i][j] = BOMB;
				}
			}
		}
	}
	
	// 3초가 된 폭탄을 폭발시킨다.
	public void explodeBomb() {

		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};
		
		while (!q.isEmpty()) {
			Bomb b = q.poll();
			map[b.getY()][b.getX()] = LAND;
			for (int k = 0; k < 4; k++) {
				int ny = b.getY() + dy[k];
				int nx = b.getX() + dx[k];
				if (0 <= ny && ny < R && 0 <= nx && nx < C) {
					map[ny][nx] = LAND;
				}
			}
		}
		
		// 남은 폭탄은 다음번에 폭발
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == BOMB) {
					q.offer(new Bomb(i, j));
				}
			}
		}
	}
	
	public StringBuilder printMap() {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		
		return sb;
	}
	
	public void sol_16918() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		LAND = '.';
		BOMB = 'O';

		q = new LinkedList<>();
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == BOMB) {
					q.offer(new Bomb(i, j));
				}
			}
		}
		
		boolean isInstall = true;	// 3번과 4번 구분
		
		for (int t = 0; t < N-1; t++) {
			if (isInstall)	installBomb();
			else			explodeBomb();
			
			// 상태 변경
			isInstall = !isInstall;
		}

		
		// 상태 출력
		System.out.println(printMap());
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_16918();
	}
}
