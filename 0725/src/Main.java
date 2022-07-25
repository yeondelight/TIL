import java.io.*;
import java.util.*;

public class Main {

	public void sol_13549() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dist = new int[100001];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		int res = -1;
		Deque<Integer> d = new LinkedList<Integer>();
		d.offerFirst(N);
		dist[N] = 0;
		while(!d.isEmpty()) {
			int n = d.pollFirst();
			if (n == K) {
				res = dist[K];
				break;
			}
			
			// 0초 후에 2*X의 위치로 이동
			int dou = n * 2;
			if (dou <= 100000 && dist[dou] > dist[n]) {
				dist[dou] = dist[n];
				d.offerFirst(dou);
			}

			// 1초 후에 X-1의 위치로 이동
			int left = n - 1;
			if (left >= 0 && dist[left] > dist[n] + 1) {
				dist[left] = dist[n] + 1;
				d.offerLast(left);
			}
			

			// 1초 후에 X+1의 위치로 이동
			int right = n + 1;
			if (right <= 100000 && dist[right] > dist[n] + 1) {
				dist[right] = dist[n] + 1;
				d.offerLast(right);
			}
		}
		
		System.out.println(res);
	}
	
	public static int res;
	
	public int dfsTree(int num) {
		ArrayList<Node> nodes = g.get(num);
		int size = nodes.size();
		
		if (size == 0) {
			return 0;
		}
		
		Vector<Integer> max = new Vector<>();
		for(Node n : nodes) {
			int val = n.w + dfsTree(n.v);
			max.add(val);
		}
		Collections.sort(max);
		Collections.reverse(max);
		
		if (size == 1 && max.get(0) > res) {
			res = max.get(0);
		}
		if (size > 1 && max.get(0) + max.get(1) > res) {
			res = max.get(0) + max.get(1);
		}
		
		return max.get(0);
	}
	
	public void sol_1967() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<Node>());
		}
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			g.get(A).add(new Node(B, W));
		}
		
		dfsTree(1);
		System.out.println(res);
	}

	class Node {
		int v;
		int w;
		Node(int v, int w){
			this.v = v;
			this.w = w;
		}
	}
	
	public static int maxDist, maxNode;
	public static boolean[] check;
	public static ArrayList<ArrayList<Node>> g;
	
	public void dfsTree2(int num, int dist) {
		if (check[num]) {
			return;
		}
		if (maxDist < dist) {
			maxDist = dist;
			maxNode = num;
		}
		check[num] = true;
		ArrayList<Node> nodes = g.get(num);
		for(Node n : nodes) {
			dfsTree2(n.v, n.w + dist);
		}
	}
	
	public void sol_1167() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		g = new ArrayList<>();
		check = new boolean[V+1];
		for (int i = 0; i <= V; i++) {
			g.add(new ArrayList<Node>());
		}
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			while(true) {
				int B = Integer.parseInt(st.nextToken());
				if (B == -1)
					break;
				int W = Integer.parseInt(st.nextToken());
				g.get(A).add(new Node(B, W));
				g.get(B).add(new Node(A, W));
			}
		}
		
		dfsTree2(1, 0);
		Arrays.fill(check, false);
		maxDist = 0;
		dfsTree2(maxNode, 0);
		System.out.println(maxDist);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1167();
	}
}
