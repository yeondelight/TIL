import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	class Point{
		double x;
		double y;
		Point(double x, double y){
			this.x = x;
			this.y = y;
		}
	}
	
	class Element implements Comparable<Element> {
		int u;
		int v;
		double weight;
		Element(int u, int v, double weight){
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Element e) {
			double diff = this.weight - e.weight;
			if (diff > 0)		return 1;
			else if (diff < 0)	return -1;
			else				return 0;
		}
	}
	
	public int setFind(int curr, int[] parent) {
		if (parent[curr] == curr)	return curr;
		else						return setFind(parent[curr], parent);
	}
	
	public void setUnion(int a, int b, int[] parent) {
		parent[a] = b;
	}
	
	public void sol_4386() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Point[] points = new Point[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			points[i] = new Point(x, y);
		}
		
		
		// add Edges to Priority Queue
		PriorityQueue<Element> q = new PriorityQueue<>();
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				double dx = points[i].x - points[j].x;
				double dy = points[i].y - points[j].y;
				double dist = Math.sqrt(dx * dx + dy * dy);
				q.offer(new Element(i, j, dist));
			}
		}
		
		
		// Kruskal
		double val = 0;
		int edgeAccepted = 0;
		
		int[] parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		while (edgeAccepted < N-1) {
			Element e = q.poll();
			int p1 = setFind(e.u, parent);
			int p2 = setFind(e.v, parent);
			if (p1 != p2) {
				edgeAccepted++;
				setUnion(p1, p2, parent);
				val += e.weight;
			}
		}
		
		System.out.println(Math.round(val*100)/100.0);
	}
	
	public int findRoot(int curr, int[] parent) {
		if (parent[curr] == curr)	return curr;
		return parent[curr] = findRoot(parent[curr], parent);
	}
	
	public void sol_20040() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int cycleNum = 0;
		int[] parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = findRoot(Integer.parseInt(st.nextToken()), parent);
			int p2 = findRoot(Integer.parseInt(st.nextToken()), parent);
			if (p1 == p2) {
				cycleNum = i+1;
				break;
			}
			else {
				parent[p1] = p2;
			}
		}
		
		System.out.println(cycleNum);
	}
	
	public void sol_2623() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int[] lines = new int[S];
			for (int j = 0; j < S; j++) {
				lines[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < S-1; j++) {
				g.get(lines[j]).add(lines[j+1]);
			}
		}
		
		
		// 1. 진입차수 계산
		int[] inDegree = new int[N+1];
		for (int i = 1; i <= N; i++) {
			ArrayList<Integer> nodes = g.get(i);
			for (int n : nodes) {
				inDegree[n]++;
			}
		}
		
		// 2. 진입차수가 0인 정점을 Stack에 push
		Stack<Integer> s = new Stack<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				s.push(i);
			}
		}
		
		// 3. Stack에서 빼서 정렬한다.
		int edgeAccepted = 0;
		while(!s.isEmpty()) {
			int w = s.pop();
			sb.append(w).append('\n');
			edgeAccepted++;
			
			// 진입차수 변경
			ArrayList<Integer> nodes = g.get(w);
			for (int n : nodes) {
				inDegree[n]--;
				if (inDegree[n] == 0) {
					s.push(n);
				}
			}
		}
		
		if (edgeAccepted == N)	System.out.println(sb);
		else					System.out.println(0);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2623();
	}
}
