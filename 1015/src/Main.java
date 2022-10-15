import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1325() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			g.get(B).add(A);
		}
		
		
		int max = 0;
		int[] hacked = new int[N+1];
		for (int i = 1; i <= N; i++) {
			int cnt = 1;
			boolean[] visited = new boolean[N+1];
			Queue<Integer> q = new LinkedList<>();
			visited[i] = true;
			q.add(i);
			
			while (!q.isEmpty()) {
				ArrayList<Integer> nodes = g.get(q.poll());
				for (int n : nodes) {
					if (!visited[n]) {
						visited[n] = true;
						q.add(n);
						cnt++;
					}
				}
			}
			
			hacked[i] = cnt;
			max = Math.max(max, cnt);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= N; i++) {
			if (hacked[i] == max) {
				sb.append(i).append(' ');
			}
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1325();
	}
}
