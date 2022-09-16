import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_3078() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue[] rank = new Queue[21];
		for (int i = 2; i < 21; i++) {
			rank[i] = new LinkedList<Integer>();
		}
		
		long count = 0;
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			Queue<Integer> q = rank[name.length()];
			while (!q.isEmpty() && i - q.peek() > K) {
				q.poll();
			}
			count += q.size();
			q.offer(i);
		}
		
		System.out.println(count);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_3078();
	}
}
