import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_13305() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dist = new int[N];
		int[] cost = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		// 최저비용 계산
		long sum = 0;
		long way = 0;
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < N-1; i++) {
			if (!q.isEmpty() && q.peek() > cost[i]) {
				long val = way * q.poll();
				sum += val;
				q.clear();
				way = 0;
			}
			q.offer(cost[i]);
			way += dist[i];
		}
		
		long val = way * q.poll();
		sum += val;
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_13305();
	}
}
