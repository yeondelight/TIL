import java.io.*;
import java.util.*;

public class Main {
	
	public void sol_11725() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			g.get(x).add(y);
			g.get(y).add(x);
		}
		
		int[] parent = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		visited[1] = true;
		q.add(1);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			ArrayList<Integer> node = g.get(curr);
			for (int n : node) {
				if (!visited[n]) {
					parent[n] = curr;
					visited[n] = true;
					q.add(n);
				}
			}
		}
		
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11725();
	}
}
