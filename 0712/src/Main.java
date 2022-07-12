import java.io.*;
import java.util.*;

public class Main {
	
	public void sol_2644() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			g.get(x).add(y);
			g.get(y).add(x);
		}
		
		// BFS : 촌수계산
		int count = -1;
		int[] dist = new int[N+1];
		boolean[] check = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		
		
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[X] = 0;
		q.add(X);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			ArrayList<Integer> node = g.get(curr);
			for (int n : node) {
				if (!check[n]) {
					q.add(n);
					check[n] = true;
					dist[n] = Math.min(dist[n], dist[curr] + 1);
				}
			}
		}
		
		System.out.println(dist[Y] == Integer.MAX_VALUE ? -1 : dist[Y]);
	}

	
	public static void main(String[] args) throws Exception {
		new Main().sol_2644();
	}
}
