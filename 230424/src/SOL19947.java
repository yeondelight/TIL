import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class SOL19947 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int H, Y;
	public int ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
	}
	
	public void solution() {
		
		int[] dp = new int[Y+1];
		dp[0] = H;
		
		for (int i = 1; i <= Y; i++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
			pq.offer((int) (dp[i-1] * 1.05));
			if (i - 3 >= 0)	pq.offer((int) (dp[i-3] * 1.2));
			if (i - 5 >= 0)	pq.offer((int) (dp[i-5] * 1.35));
			dp[i] = pq.poll();
		}
		
		ans = dp[Y];
	}
	
	public void print() {
		System.out.println(ans);
	}
}