import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	public void sol_5567() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			g.add(new ArrayList<Integer>());
		}
		
		int m = Integer.parseInt(br.readLine());
		Vector<Integer> friend = new Vector<>();
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == 1) {
				friend.add(b);
			}
			g.get(a).add(b);
			g.get(b).add(a);
		}
		
		// find friend-friend
		int cnt = friend.size();
		boolean[] visited = new boolean[n+1];
		visited[1] = true;
		
		for (int f : friend) {
			visited[f] = true;
		}

		for (int f : friend) {
			ArrayList<Integer> nodes = g.get(f);
			for (int i : nodes) {
				if (!visited[i]) {
					visited[i] = true;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_5567();
	}
}
