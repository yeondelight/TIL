import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL2303 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int CARDSIZE = 5;
	public static int CHOOSESIZE = 3;
	
	public int N;
	public int[][] card;
	public int[] value;
	public int ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		
		card = new int[N+1][CARDSIZE];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < CARDSIZE; j++) {
				card[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public void solution() {
		value = new int[N+1];
		for (int i = 1; i <= N; i++) {
			backtracking(i, -1, 0, 0);
		}
		
		for (int i = 1; i <= N; i++) {
			if (value[ans] <= value[i]) {
				ans = i;
			}
		}
	}
	
	public void print() {
		System.out.println(ans);
	}

	// backtracking으로 가장 큰 일의 자리 수를 찾는다.
	public void backtracking(int n, int idx, int sum, int depth) {
		if (depth == CHOOSESIZE) {
			System.out.println(n + " : " + sum);
			value[n] = Math.max(value[n], sum%10);
			return;
		}
		for (int i = idx+1; i < CARDSIZE; i++) {
			backtracking(n, i, sum + card[n][i], depth+1);
		}
	}
}