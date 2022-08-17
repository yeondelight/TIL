import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	public void sol_17144() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		Vector<Integer> airclean = new Vector<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					airclean.add(i);
				}
			}
		}
		
		// T초 동안 반복
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for (int t = 0; t < T; t++) {
			// 1. 확산
			int[][] add = new int[R][C];
			
			// 1-A. 확산량 계산
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 4) {	// 미세먼지가 확산되는 칸에 대해서만
						int count = 0;
						int val = map[i][j] / 5;
						for (int d = 0; d < 4; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if (0 <= nx && nx < R && 0 <= ny && ny < C) {
								// 공기청정기로의 확산 방지
								if (ny != 0 || !airclean.contains(nx)) {
									count++;
									add[nx][ny] += val;
								}
							}
						}
						add[i][j] += val * count * -1;
					}
				}
			}
			
			// 1-B. 확산량 적용
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] += add[i][j];
				}
			}

			// 2. 공기청정기 작동
			int p;
			
			// 2-A. 상단 회전 : 반시계방향
			p = airclean.get(0);
			for (int i = p; i > 0; i--)		map[i][0] = map[i-1][0];	// 상 -> 하
			for (int i = 0; i < C-1; i++)	map[0][i] = map[0][i+1];	// 우 -> 좌
			for (int i = 0; i < p; i++)		map[i][C-1] = map[i+1][C-1];// 하 -> 상
			for (int i = C-1; i > 0; i--)	map[p][i] = map[p][i-1];	// 좌 -> 우
			map[p][0] = map[p][1] = 0;
			
			// 2-B. 하단 회전 : 시계방향
			p = airclean.get(1);
			for (int i = p; i < R-1; i++) map[i][0] = map[i+1][0];		// 하 -> 상
			for (int i = 0; i < C-1; i++) map[R-1][i] = map[R-1][i+1];	// 우 -> 좌
			for (int i = R-1; i > p; i--) map[i][C-1] = map[i-1][C-1];	// 상 -> 하
			for (int i = C-1; i > 0; i--) map[p][i] = map[p][i-1];		// 좌 -> 우
			map[p][0] = map[p][1] = 0;
		}
		
		
		// sum
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += map[i][j];
			}
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_17144();
	}
}
