import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_15903() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}
		
		for (int i = 0; i < M; i++) {
			long x = pq.poll();
			long y = pq.poll();
			long val = x + y;
			pq.offer(val);
			pq.offer(val);
		}

		long sum = 0;
		while(!pq.isEmpty()) {
			sum += pq.poll();
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_15903();
	}
}
