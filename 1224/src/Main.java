import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static ArrayList<ArrayList<Integer>> g;
	
	public static boolean flag;
	public static boolean[] visited;
	
	public void dfs(int idx, int depth) {
		if (depth == 5) {
			flag = true;
			System.out.println(1);
			System.exit(0);
		}
		ArrayList<Integer> child = g.get(idx);
		for (int i : child) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i, depth+1);
				visited[i] = false;
			}
		}
	}
	
	public void sol_13023() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		g = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			g.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			g.get(A).add(B);
			g.get(B).add(A);
		}
		
		flag = false;
		for (int i = 0; i < N; i++) {
			visited = new boolean[N+1];
			visited[i] = true;
			dfs(i, 1);
		}
		
		if (flag)	System.out.println(1);
		else		System.out.println(0);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_13023();
	}
}
