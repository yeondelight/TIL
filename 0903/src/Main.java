import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static int N, M, k;
	public static int[] parent;
	
	public int findUnion(int num) {
		if (num == parent[num])	return num;
		return parent[num] = findUnion(parent[num]);
	}
	
	public void sol_16562() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		// init parent
		parent = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		// scan Ai
		int[] A = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// scan friend relationships
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int r1 = findUnion(v);
			int r2 = findUnion(w);
			if (A[r1] > A[r2])	parent[r1] = r2;	// 친구비가 작은 쪽이 부모
			else				parent[r2] = r1;
		}
		
		
		// get min cost of groups
		int cost = 0;
		for (int i = 1; i <= N; i++) {
			int p = findUnion(i);
			if (p != findUnion(0)) {
				cost += A[p];
				int r1 = findUnion(0);
				int r2 = findUnion(p);
				if (A[r1] > A[r2])	parent[r1] = r2;	// 친구비가 작은 쪽이 부모
				else				parent[r2] = r1;
			}
		}
		
		if (cost > k)	System.out.println("Oh no");
		else			System.out.println(cost);
		
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_16562();
	}
}
