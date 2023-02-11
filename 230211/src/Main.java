import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	
	public void sol_10157() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		// 해당 대기번호의 관객에게 좌석을 배정할 수 없는 경우
		if (K > C * R) {
			System.out.println(0);
			return;
		}
		
		// 기존 좌표계와 같이 사용하면
		// 회전 순서는 오른(동) - 아래(남) - 왼(서) - 위(북)
		Point[] delta = {new Point(0, 1), new Point(1, 0), new Point(0, -1), new Point(-1, 0)};
		boolean[][] map = new boolean[C+1][R+1];	// 방문 여부 표시
		int i = 1, j = 1;	// 좌표 표시
		int turn = 0;		// 현재 회전 방향
		int cnt = 1;		// 몇번까지 배정했는지 확인용
		while (cnt < K){
			map[i][j] = true;
			int dx = i + delta[turn].x;
			int dy = j + delta[turn].y;
			if (0 < dx && dx <= C && 0 < dy && dy <= R && !map[dx][dy]) {
				i = dx;
				j = dy;
				cnt++;
			} else {
				turn = (turn + 1) % 4;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(i).append(' ').append(j);
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_10157();
	}
}
