import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main { 
	
	class Node {
		int cnt;
		int previous;
		Node(int cnt, int previous){
			this.cnt = cnt;
			this.previous = previous;
		}
	}
	
	public void sol_12852() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		int[] last = new int[N+1];

		for (int i = 2; i <= N; i++) {
			if (i < 4) {
				dp[i] = 1;
				continue;
			}
			PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.cnt, n2.cnt));
			if (i % 3 == 0)	q.add(new Node(1+dp[i/3], i/3));
			if (i % 2 == 0)	q.add(new Node(1+dp[i/2], i/2));
			q.add(new Node(1+dp[i-1], i-1));
			Node n = q.poll();
			dp[i] = n.cnt;
			last[i] = n.previous;
		}
		
		sb.append(dp[N]).append('\n');
		
		// route trace
		int trace = N;
		while(trace > 1) {
			sb.append(trace).append(' ');
			trace = last[trace];
		}
		sb.append(1).append(' ');
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_12852();
	}
}
