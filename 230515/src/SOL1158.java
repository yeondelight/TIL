import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SOL1158 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int N, K;
	public Queue<Integer> ansQ;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stNK = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNK.nextToken());
		K = Integer.parseInt(stNK.nextToken());
	}
	
	public void solution() {
		
		// init
		Queue<Integer> originQ = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			originQ.offer(i);
		}
		
		// solution logic
		ansQ = new LinkedList<>();
		while(!originQ.isEmpty()) {
			for (int i = 0; i < K-1; i++) {
				originQ.offer(originQ.poll());
			}
			ansQ.offer(originQ.poll());
		}
		
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		
		sb.append('<');
		
		while(ansQ.size() > 1) {
			sb.append(ansQ.poll());
			sb.append(", ");
		}
		
		sb.append(ansQ.poll() + ">");
		
		System.out.println(sb);
	}
}
