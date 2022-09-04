import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1766() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			g.get(A).add(B);
		}
		
		
		// 1. 초기 진입차수 계산
		int[] inDegree = new int[N+1];
		for (int i = 1; i <= N; i++) {
			ArrayList<Integer> nodes = g.get(i);
			for (int n : nodes) {
				inDegree[n]++;
			}
		}
		
		
		// 2. inDegree[i] == 0인 요소를 우선순위 큐에 삽입
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				pq.offer(i);
			}
		}
		
		
		// 3. Queue에서 요소를 하나씩 빼면서 정렬
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int p = pq.poll();
			sb.append(p).append(' ');
			ArrayList<Integer> nodes = g.get(p);
			for (int n : nodes) {
				inDegree[n]--;
				if (inDegree[n] == 0) {
					pq.offer(n);
				}
			}
		}
		
		
		// 4. print
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1766();
	}
}
