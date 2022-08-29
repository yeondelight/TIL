import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] parent;
	
	public int unionFind(int num) {
		if (parent[num] == num)	return num;
		return parent[num] = unionFind(parent[num]);
	}
	
	public void sol_1976() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int sig = Integer.parseInt(st.nextToken());
				if (sig == 1) {
					int r1 = unionFind(i);
					int r2 = unionFind(j);
					if (r1 > r2)	parent[parent[i]] = parent[j];
					else			parent[parent[j]] = parent[i];
				}
			}
		}
		
		boolean check = true;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int city1 = Integer.parseInt(st.nextToken());
		while(st.hasMoreTokens()) {
			int city2 = Integer.parseInt(st.nextToken());
			int r1 = unionFind(city1);
			int r2 = unionFind(city2);
			if (r1 != r2) {
				check = false;
				break;
			}
			city1 = city2;
		}
		
		if (check)	System.out.println("YES");
		else		System.out.println("NO");
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1976();
	}
}
