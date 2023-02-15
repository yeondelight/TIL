import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_1913() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		// 회전 순서는 아래(남) - 오른(동) - 위(북) - 왼(서) 
		int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		
		int i = 0, j = 0;	// 좌표 표시
		int turn = 0;		// 현재 회전 방향
		int num = N * N;	// 몇번까지 배정했는지 확인용
		map[0][0] = num;	// 초기화
		
		while (num > 1){
			int dx = i + delta[turn][0];
			int dy = j + delta[turn][1];
			if (0 <= dx && dx < N && 0 <= dy && dy < N && map[dx][dy] == 0) {
				i = dx;
				j = dy;
				map[dx][dy] = --num;
			} else {
				turn = (turn + 1) % 4;
			}
		}
		
		
		// get K's point
		// and print map
		int kx = 0;
		int ky = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for (int a = 0; a < N; a++) {
			for (int b = 0; b < N; b++) {
				sb.append(map[a][b]).append(' ');
				if (map[a][b] == K) {
					kx = a + 1;
					ky = b + 1;
				}
			}
			sb.append('\n');
		}
		
		sb.append(kx).append(' ').append(ky);
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1913();
	}
}
