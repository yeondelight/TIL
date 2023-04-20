import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Way {
	int end;
	int dis;
	
	public Way(int e, int d) {
		this.end = e;
		this.dis = d;
	}
}

class SOL1446 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N, D;
	
	public int[] dp;
	public ArrayList<ArrayList<Way>> g;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stND = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stND.nextToken());
		D = Integer.parseInt(stND.nextToken());
		
		g = new ArrayList<>();
		for (int i = 0; i <= D; i++)	g.add(new ArrayList<Way>());
		for (int i = 0; i < D; i++)		g.get(i+1).add(new Way(i, 1));
		
		for (int i = 0; i < N; i++) {
			StringTokenizer stWay = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(stWay.nextToken());
			int e = Integer.parseInt(stWay.nextToken());
			int d = Integer.parseInt(stWay.nextToken());
			if (e <= D) {
				g.get(s).add(new Way(e, d));
			}
		}
	}

	public void solution() {
		dp = new int[D+1];
		for (int i = 0; i <= D; i++)	dp[i] = i;
		
		for (int i = 0; i <= D; i++) {
			if (i > 0) {
				dp[i] = Math.min(dp[i], dp[i-1] + 1);
			}
			
			for (Way w : g.get(i)) {
				if (dp[i] + w.dis < dp[w.end]) {
					dp[w.end] = dp[i] + w.dis;
				}
			}
		}
	}
	
	public void print() {
		System.out.print(dp[D]);
	}
}
