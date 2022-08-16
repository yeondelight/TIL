import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1005() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			// scan Times
			int[] time = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				time[j] = Integer.parseInt(st.nextToken());
			}
			
			// create Graph(Vertex)
			ArrayList<ArrayList<Integer>> g = new ArrayList<>();
			for (int j = 0; j <= N; j++) {
				g.add(new ArrayList<Integer>());
			}
			
			// scan Edges
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				g.get(X).add(Y);
			}
			
			// scan W
			int W = Integer.parseInt(br.readLine());
			
			// topo sort
			
			// 1. 진입차수 계산
			int[] inDegree = new int[N+1];
			for (int j = 1; j <= N; j++) {
				ArrayList<Integer> nodes = g.get(j);
				for (int n : nodes) {
					inDegree[n]++;
				}
			}
			
			// 2. 진입차수가 0인 정점을 Stack에 push
			int[] totalTime = new int[N+1];
			Stack<Integer> s = new Stack<>();
			for (int j = 1; j <= N; j++) {
				if (inDegree[j] == 0) {
					s.push(j);
					totalTime[j] = time[j];
				}
			}
			
			// 3. Stack에서 빼서 정렬한다.
			while (!s.isEmpty()) {
				// pop하여 정렬
				int w = s.pop();
				
				// 진입차수 변경
				ArrayList<Integer> nodes = g.get(w);
				for (int n : nodes) {
					inDegree[n]--;
					if (inDegree[n] == 0) {
						s.push(n);
					}
					totalTime[n] = Math.max(totalTime[n], totalTime[w] + time[n]);
				}
				
			}
			
			sb.append(totalTime[6]).append('\n');
		}
		
		
		// 4. Result print
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1005();
	}
}
