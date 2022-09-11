import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] parent;
	public static boolean[] check;
	
	public int findUnion(int num) {
		if (num == parent[num])	return num;
		return parent[num] = findUnion(parent[num]);
	}
	
	public void setUnion(int a, int b) {
		int r1 = findUnion(a);
		int r2 = findUnion(b);
		
		if (r1 > r2)		parent[r1] = r2;
		else if (r1 < r2)	parent[r2] = r1;
		else {
			parent[r1] = 0;
			check[r1] = false;
		}
	}
	
	public void sol_4803() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = 1;
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			// set EOF
			if (n == 0 && m == 0) {
				break;
			}

			// init arr
			parent = new int[n+1];
			check = new boolean[n+1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
				check[i] = true;
			}
			
			// scan edges
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				setUnion(a, b);
			}
			
			// cal trees : check[]
			Set<Integer> tree = new HashSet<>();
			for (int i = 1; i <= n; i++) {
				int root = findUnion(parent[i]);
				if (check[root]) {
					tree.add(root);
				}
			}
			
			// print
			if (tree.size() == 0)		sb.append("Case " + TC + ": No trees.\n");
			else if (tree.size() == 1)	sb.append("Case " + TC + ": There is one tree.\n");
			else						sb.append("Case " + TC + ": A forest of " + tree.size() + " trees.\n");
			
			TC++;
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_4803();
	}
}
