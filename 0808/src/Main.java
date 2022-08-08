import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	class Node {
		int v;
		int w;
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	public void sol_14938() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[] items = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			items[i+1] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<ArrayList<Node>> g = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			g.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			g.get(A).add(new Node(B, L));
			g.get(B).add(new Node(A, L));
		}
		
		
		// Floyd
		int max = 0;
		int[][] dist = new int[N+1][N+1];
		PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.w, n2.w));
		
		for (int i = 1; i <= N; i++) {
			// init
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			q.offer(new Node(i, 0));
			dist[i][i] = 0;
			
			while(!q.isEmpty()) {
				Node cur = q.poll();
				if (dist[i][cur.v] < cur.w)	continue;		// 현 노드 방문이 최선일때만 진행
				for (int j = 0; j < g.get(cur.v).size(); j++) {	// 인접 노드에 대해
					Node next = g.get(cur.v).get(j);			// 인접 노드의 정보를 가져옴
					if (dist[i][next.v] > cur.w + next.w) {		// cur를 거쳐 next로 가는게 최단이면
						dist[i][next.v] = cur.w + next.w;		// 거리 갱신
						q.offer(new Node(next.v, dist[i][next.v]));	// 큐에 넣기 : 최소 가능성이 있으므로
					}
				}
			}
			
			// get max
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				if (dist[i][j] <= M) {
					sum += items[j];
				}
			}
			
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
	
	public void sol_1043() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 사람
		int M = Integer.parseInt(st.nextToken());	// 파티
		
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			g.add(new ArrayList<Integer>());
		}
		
		boolean[] isTruth = new boolean[N+1];
		Vector<Integer> truth = new Vector<>();
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());	// 진실
		for (int i = 0; i < T; i++) {
			int index = Integer.parseInt(st.nextToken());
			truth.add(index);
		}
		
		// 파티 정보 저장
		Vector<Vector<Integer>> party = new Vector<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Vector<Integer> people = new Vector<>();
			int P = Integer.parseInt(st.nextToken());		// 파티 참가 인원
			int start = Integer.parseInt(st.nextToken());	// 첫 사람
			people.add(start);
			for (int j = 0; j < P-1; j++) {
				int index = Integer.parseInt(st.nextToken());
				people.add(index);
				g.get(start).add(index);
				g.get(index).add(start);
			}
			party.add(people);
		}
		
		// true check
		for (int i : truth) {
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			isTruth[i] = true;
			
			while(!q.isEmpty()) {
				int curr = q.poll();
				for (int node : g.get(curr)) {
					if (!isTruth[node]) {
						q.add(node);
						isTruth[node] = true;
					}
				}
			}
		}
		
		// party check
		int count = 0;
		for (Vector<Integer> p : party) {
			boolean check = true;
			for (int i : p) {
				if (isTruth[i]) {
					check = false;
					break;
				}
			}
			if (check) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1043();
	}
}
