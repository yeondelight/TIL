import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL2303 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int SIZE = 5;
	
	public int N;
	public int[][] card;
	
	public int ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		
		card = new int[N][SIZE];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < SIZE; j++) {
				card[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public void solution() {
		
	}
	
	public void print() {
		System.out.println(ans);
	}

}