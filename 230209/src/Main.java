import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1748() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int len = 1;
		int cnt = 9;
		int ans = 0;
		
		while (N >= cnt) {
			ans += (cnt * len);
			N -= cnt;
			cnt *= 10;
			len++;
		}
		
		ans += (N * len);
		
		System.out.println(ans);
	}
	
	public int getD(int val, int P) {
		int ans = 0;
		while (val > 0) {
			ans += Math.pow(val % 10, P);
			val /= 10;
		}
		return ans;
	}
	
	public void sol_2331() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> D = new HashSet<>();
		int prev = A;
		D.add(A);
		
		// 반복되는 요소가 나오기 전까지 일단 넣기
		while(true) {
			int curr = getD(prev, P);
			if (D.contains(curr)) {
				break;
			} else {
				D.add(curr);
			}
			prev = curr;
		};
		
		while(true) {
			int curr = getD(prev, P);
			if (!D.contains(curr)) {
				break;
			} else {
				D.remove(curr);
			}
			prev = curr;
		}
		
		System.out.println(D.size());
	}
	
	class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static Point[] location = new Point[26];
	public static boolean[][] map = new boolean[5][5];
	
	public boolean checkBingo() {
		int bingo = 0;
		
		// 가로줄 체크
		for (int i = 0; i < 5; i++) {
			boolean clear = true;
			for (int j = 0; j < 5; j++) {
				if (!map[i][j]) {
					clear = false;
					break;
				}
			}
			if (clear)	bingo++;
		}
		
		// 가로줄 체크
		for (int i = 0; i < 5; i++) {
			boolean clear = true;
			for (int j = 0; j < 5; j++) {
				if (!map[j][i]) {
					clear = false;
					break;
				}
			}
			if (clear)	bingo++;
		}
		
		// 대각선 체크
		Point[][] cross = { 
				{new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 4)},
				{new Point(0, 4), new Point(1, 3), new Point(2, 2), new Point(3, 1), new Point(4, 0)}
		};
		
		for (int i = 0; i < 2; i++) {
			boolean clear = true;
			for (int j = 0; j < 5; j++) {
				Point p = cross[i][j];
				if (!map[p.x][p.y]) {
					clear = false;
					break;
				}
			}
			if (clear)	bingo++;
		}
				
		if (bingo >= 3)	return true;
		else			return false;
	}
	
	public void sol_2578() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 철수의 빙고판 scan
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				location[num] = new Point(i, j);
				map[i][j] = false;
			}
		}
		
		// 사회자의 번호 scan
		Queue<Integer> callQ = new LinkedList<>();
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				callQ.offer(Integer.parseInt(st.nextToken()));
			}
		}
		
		// 번호 하나씩 지우기
		int cnt = 0;
		while (!callQ.isEmpty()) {
			cnt++;
			int currCall = callQ.poll();
			Point currLoc = location[currCall];
			map[currLoc.x][currLoc.y] = true;
			if (checkBingo()) {
				break;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2578();
	}
}
