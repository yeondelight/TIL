import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	class Score {
		int idx;
		int val;
		public Score(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
	
	public void sol_2822() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Score> pq = new PriorityQueue<Score>((s1, s2) -> s1.val - s2.val);
		for (int i = 1; i <= 8; i++) {
			int val = Integer.parseInt(br.readLine());
			Score curr = new Score(i, val);
			pq.offer(curr);
			if (pq.size() > 5) {
				pq.poll();
			}
		}
		
		int sum = 0;
		PriorityQueue<Integer> pqIdx = new PriorityQueue<>();
		while (!pq.isEmpty()) {
			Score s = pq.poll();
			sum += s.val;
			pqIdx.offer(s.idx);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append('\n');
		while(!pqIdx.isEmpty()) {
			sb.append(pqIdx.poll()).append(' ');
		}
		
		System.out.println(sb);
	}

	
	public static void main(String[] args) throws Exception {
		new Main().sol_2822();
	}
}
