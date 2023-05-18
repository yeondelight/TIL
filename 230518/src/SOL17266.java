import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL17266 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N, M;
	public int[] x;
	
	public int ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		x = new int[M+2];
		StringTokenizer stX = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			x[i] = Integer.parseInt(stX.nextToken());
		}
		x[M+1] = N;
	}
	
	public void solution() {
		
		int maxDistance = Math.max(x[1]-x[0], x[M+1] - x[M]);
		
		for (int i = 1; i <= M; i++) {
			int val = (x[i+1] - x[i] + 1) / 2;
			maxDistance = Math.max(maxDistance, val);
		}
		ans = maxDistance;
	}
	
	public void print() {
		System.out.println(ans);
	}
}
