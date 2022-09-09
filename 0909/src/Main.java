import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] parent;
	
	class Element {
		int u;
		int v;
		int weight;
		Element(int u, int v, int weight){
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
	}
	
	public int findUnion(int num) {
		if (num == parent[num])	return num;
		return parent[num] = findUnion(parent[num]);
	}
	
	public void sol_1922() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		// get Costs
		PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> (e1.weight - e2.weight));
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a != b) {
				pq.offer(new Element(a, b, c));
			}
		}
		
		int minCost = 0;
		int edgeAccepted = 0;
		while (edgeAccepted < N-1) {
			Element e = pq.poll();
			int r1 = findUnion(e.u);
			int r2 = findUnion(e.v);
			if (r1 != r2) {
				minCost += e.weight;
				edgeAccepted++;
				if (r1 > r2)	parent[r1] = r2;
				else			parent[r2] = r1;
			}
		}
		
		System.out.println(minCost);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1922();
	}
}
