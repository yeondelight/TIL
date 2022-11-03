import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_2075() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int curr = Integer.parseInt(st.nextToken());
				pq.offer(curr);
				if (pq.size() > N) {
					pq.poll();
				}
			}
		}
		
		System.out.println(pq.poll());
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2075();
	}
}
