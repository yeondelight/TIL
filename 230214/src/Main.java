import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, K;
	public static int[] A;
	public static int[] temp;
	
	public static int cnt;
	
	public void merge_sort(int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(p, q);
			merge_sort(q+1, r);
			merge(p, q, r);
		}
	}
	
	public void merge(int p, int q, int r) {
		int i = p;
		int j = q+1;
		int t = p;
		while (i <= q && j <= r) {
			if (A[i] <= A[j])	temp[t++] = A[i++];
			else				temp[t++] = A[j++];
		}
		while (i <= q)	temp[t++] = A[i++];
		while (j <= r)	temp[t++] = A[j++];
		i = p;
		while (i <= r) {
			A[i] = temp[i++];
			if (++cnt == K) {
				System.out.println(A[i-1]);
				System.exit(0);
			}
		}
	}
	
	public void sol_24060() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		temp = new int[N];
		
		StringTokenizer stArr = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(stArr.nextToken());
		}
		
		cnt = 0;
		merge_sort(0, N-1);
		
		System.out.println(-1);
	}
	
	class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			char cx = (char) x;
			char cy = (char) y;
			return cx + "" + cy;
		}
	}
	
	public boolean canMove(int x, int y) {
		int calX = x - 'A' + 1;
		int calY = y - '1' + 1;
		return 0 < calX && calX <= 8 && 0 < calY && calY <= 8;
	}
	
	public void sol_1063() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// get king (kx, ky)
		String kStr = st.nextToken();
		int ky = kStr.charAt(1);
		int kx = kStr.charAt(0);
		Point king = new Point(kx, ky);		
		
		// get stone (sx, sy)
		String sStr = st.nextToken();
		int sy = sStr.charAt(1);
		int sx = sStr.charAt(0);
		Point stone = new Point(sx, sy);

		
		// init cmd val
		HashMap<String, Integer> cmds = new HashMap<>();
		cmds.put("R", 0);
		cmds.put("L", 1);
		cmds.put("B", 2);
		cmds.put("T", 3);
		cmds.put("RT", 4);
		cmds.put("LT", 5);
		cmds.put("RB", 6);
		cmds.put("LB", 7);
		
		int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
		int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
		
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();
			int cmdVal = cmds.get(cmd);
			int nx = king.x + dx[cmdVal];
			int ny = king.y + dy[cmdVal];
			
			// 내가 가야하는 곳에 돌이 있는 경우
			if (stone.x == nx && stone.y == ny) {
				int nsx = nx + dx[cmdVal];
				int nsy = ny + dy[cmdVal];
				boolean flag = canMove(nsx, nsy);
				if (flag) {
					stone.x = nsx;
					stone.y = nsy;
					king.x = nx;
					king.y = ny;
				}
			}
			// 가야하는 방향에 돌이 없으면 그냥 움직임
			else {
				boolean flag = canMove(nx, ny);
				if (flag) {
					king.x = nx;
					king.y = ny;
				}
			}
		}
		
		// 움직인 뒤 왕의 좌표 출력
		System.out.println(king);
		System.out.println(stone);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1063();
	}
}
