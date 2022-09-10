import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	public void sol_1715() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		// N == 1인 경우 비교할 필요가 없으므로 0 출력
		if (N == 1) {
			System.out.println(0);
			return;
		}
		
		// N > 1인 경우 두 수를 비교
		int count = 0;
		while (pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			pq.offer(a+b);
			count += (a+b);
		}
		
		System.out.println(count);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1715();
	}
}
