import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_1347() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());		
		
		int[] start = {N, N};
		int[] end = {N, N};
		
		int size = 2 * N + 1;
		boolean[][] map = new boolean[size][size];
		map[N][N] = true;
		
		int[] curr = {N, N};
		
		// 회전 순서는 L : 아래(남) - 오른(동) - 위(북) - 왼(서) 
		int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; 
		int turn = 0;
		
		// move
		String cmds = br.readLine();
		for (int i = 0; i < N; i++) {
			char cmd = cmds.charAt(i);
			if (cmd == 'R') {
				turn += 3;
				turn %= 4;
			} else if (cmd == 'L') {
				turn++;
				turn %= 4;
			} else {	// cmd == 'F'
				curr[0] += delta[turn][0];
				curr[1] += delta[turn][1];
				map[curr[0]][curr[1]] = true;
				start[0] = Math.min(start[0], curr[0]);
				start[1] = Math.min(start[1], curr[1]);
				end[0] = Math.max(end[0], curr[0]);
				end[1] = Math.max(end[1], curr[1]);
			}
		}
		
		// print
		StringBuilder sb = new StringBuilder();
		for (int i = start[0]; i <= end[0]; i++) {
			for (int j = start[1]; j <= end[1]; j++) {
				if (map[i][j])	sb.append('.');
				else			sb.append('#');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1347();
	}
}
