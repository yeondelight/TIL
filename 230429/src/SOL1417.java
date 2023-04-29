import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class SOL1417 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public PriorityQueue<Integer> pq;
	public int dasom;
	public int ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		int N = Integer.parseInt(br.readLine());
		dasom = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
		for (int i = 0; i < N-1; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
	}
	
	public void solution() {
		if (pq.isEmpty()) {
			ans = 0;
			return;
		}
		while (pq.peek() >= dasom) {
			pq.offer(pq.poll()-1);
			dasom++;
			ans++;
		}
	}
	
	public void print() {
		System.out.println(ans);
	}
}
