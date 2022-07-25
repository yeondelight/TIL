import java.io.*;

public class Main {
	
	public static int N;
	public static int[] map;
	public static int res = 0;
	
	public boolean isValid(int num) {
		for (int i = 0; i < num; i++) {
			// 1. 같은줄에 Queen이 있는지 검사
			if (map[i] == map[num]) {				
				return false;
			}
			// 2. 대각선에 Queen이 있는지 검사
			if (Math.abs(map[num] - map[i]) == Math.abs(num - i)) {	
				return false;
			}
		}
		return true;
	}
	
	public void nqueen(int num) {
		if (num == N) {
			res++;
			return;
		}
		for (int i = 0; i < N; i++) {
			map[num] = i;			// (num, i)에 Queen을 둔다.
			if (isValid(num)) {		// 그 자리에 Queen을 두어도 된다면
				nqueen(num + 1);	// 다음 행으로 넘어간다.
			}
		}
	}
	
	public void sol_9663() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		
		nqueen(0);			// 0번째 줄부터 Queen을 놓아본다.
		System.out.println(res);
	}
	
	public static void main (String[] args) throws Exception {
		new Main().sol_9663();
	}
}
