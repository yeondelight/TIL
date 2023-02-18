import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static int N;
	public static char[][] map;
	
	public static int max;
	
	public void changeCandy(int i1, int j1, int i2, int j2) {
		char temp = map[i1][j1];
		map[i1][j1] = map[i2][j2];
		map[i2][j2] = temp;
	}
	
	public void getMaxCandy() {
		// 행 판단
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 1; j < N; j++) {
				if (map[i][j-1] == map[i][j]) {
					cnt++;
				}
				else {
					max = Math.max(max, cnt);
					cnt = 1;
				}
			}
			max = Math.max(max, cnt);
		}

		// 열 판단
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 1; j < N; j++) {
				if (map[j-1][i] == map[j][i]) {
					cnt++;
				}
				else {
					max = Math.max(max, cnt);
					cnt = 1;
				}
			}
			max = Math.max(max, cnt);
		}
	}
	
	public void sol_3085() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// scan map
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 답 저장 값
		max = 0;
		
		// 행 바꾸기
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j-1] != map[i][j]) {
					changeCandy(i, j-1, i, j);	// 교환해보고
					getMaxCandy();				// 계산하고
					changeCandy(i, j-1, i, j);	// 원위치
				}
			}
		}
		
		// 열 바꾸기
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (map[j-1][i] != map[j][i]) {
					changeCandy(j-1, i, j, i);	// 교환해보고
					getMaxCandy();				// 계산하고
					changeCandy(j-1, i, j, i);	// 원위치
				}
			}
		}
		
		// print
		System.out.println(max);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_3085();
	}
} 
