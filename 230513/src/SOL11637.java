import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Candidate implements Comparable {
	
	int id;
	int val;
	
	public Candidate(int id, int val) {
		this.id = id;
		this.val = val;
	}
	
	@Override
	public int compareTo(Object o) {
		Candidate c = (Candidate) o;
		return c.val - this.val;
	}
}

class SOL11637 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	
	public int n;
	public int sum;
	public PriorityQueue<Candidate> pq;
	
	public String ans;
	
	public void run() throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			getInput();
			solution();
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	public void getInput() throws Exception {
		n = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<Candidate>();
		sum = 0;
		for (int i = 1; i <= n; i++) {
			int curr = Integer.parseInt(br.readLine());
			sum += curr;
			pq.offer(new Candidate(i, curr));
		}
	}
	
	public void solution() {
		double halfVal = sum / 2.0;
		Candidate max = pq.poll();
		
		if (max.val == pq.peek().val) {
			ans = "no winner";
		}
		else if (max.val > halfVal) {
			ans = "majority winner " + max.id;
		}
		else {
			ans = "minority winner " + max.id;
		}
	}
}
