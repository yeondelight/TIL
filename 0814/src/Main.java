import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_2467() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] liq = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liq[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = N-1;
		int resStart = start;
		int resEnd = end;

		int val = Math.abs(liq[start] + liq[end]);
		while(start < end) {
			int tempVal = liq[start] + liq[end];
			if (Math.abs(tempVal) < val) {
				val = Math.abs(tempVal);
				resStart = start;
				resEnd = end;
			}
			if (tempVal < 0)	start++;
			else				end--;
		}
		
		System.out.println(liq[resStart] + " " + liq[resEnd]);
	}
	
	class Element {
		int u;
		int v;
		int key;
		Element(int u, int v, int key){
			this.u = u;
			this.v = v;
			this.key = key;
		}
	}
	
	public int setFind(int curr, int[] parent) {
		if (parent[curr] == curr)		return curr;
		return parent[curr] = setFind(parent[curr], parent);
	}
	
	public void setUnion(int a, int b, int[] parent) {
		parent[a] = b;
	}
	
	public void sol_1647() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Element> q = new PriorityQueue<>((e1, e2) -> e1.key - e2.key);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			q.offer(new Element(S, E, T));
		}
		
		// Kruskal
		int val = 0;
		int edgeAccepted = 0;
		
		int[] parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		while (edgeAccepted < N-2) {
			Element e = q.poll();
			int p1 = setFind(e.u, parent);
			int p2 = setFind(e.v, parent);
			if (p1 != p2) {
				edgeAccepted++;
				setUnion(p1, p2, parent);
				val += e.key;
			}
		}
		
		System.out.println(val);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1647();
	}
}
