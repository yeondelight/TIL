import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class SOL25644 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N;
	public int ans;
	
	public int[] A;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		
		A = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	public void solution() {
		int maxCost = 0;
		for (int i = N; i > 0; i--) {
			maxCost = Math.max(maxCost, A[i]);
			ans = Math.max(ans, maxCost - A[i]);
		}
	}
	
	public void print() {
		System.out.println(ans);
	}
}