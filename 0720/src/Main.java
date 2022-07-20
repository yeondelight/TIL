import java.io.*;
import java.util.*;

public class Main {

	public void sol_2252() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// create Graph(Vertex)
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<Integer>());
		}
		
		// scan Edges
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			g.get(A).add(B);
		}
		
		// topo sort
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
		while (!s.isEmpty()) {
			// pop하여 정렬
			int w = s.pop();
			sb.append(w).append(' ');
			
			// 진입차수 변경
			ArrayList<Integer> nodes = g.get(w);
			for (int n : nodes) {
				inDegree[n]--;
				if (inDegree[n] == 0) {
					s.push(n);
				}
			}
		}
		
		// 4. Result print
		System.out.println(sb);
	}
	
	private static int N, M;
	private static int[][] dp;
	private static int[][] map;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	public int dfs(int x, int y) {
		if (x == N-1 && y == M-1) {	// 도착지점이면 경로의 수 추가
			return 1;
		}
		if (dp[x][y] != -1) {		// 이미 방문한 곳이면 방문 결과값 반환
			return dp[x][y];
		}
		
		dp[x][y] = 0;				// x, y에 도달하는 방법이 하나는 있다. (check=true 역할)
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (map[x][y] > map[nx][ny]) {
					dp[x][y] += dfs(nx, ny);
				}
			}
		}

		return dp[x][y];
	}
	
	public void sol_1520() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N][M];
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));
	}
	
	public static StringBuilder sb;
	public static ArrayList<ArrayList<TreeNode>> tree;
	
	class TreeNode {
		int left;
		int right;
			
		TreeNode(int left, int right){
			this.left = left;
			this.right = right;
		}
	}
	
	public void preorder(int node) {
		for (TreeNode tn : tree.get(node)) {
			int l = tn.left;
			int r = tn.right;
			sb.append((char)(node + 'A' - 1));
			if (l > 0)	preorder(l);
			if (r > 0)	preorder(r);
		}
	}
	
	public void inorder(int node) {
		for (TreeNode tn : tree.get(node)) {
			int l = tn.left;
			int r = tn.right;
			if (l > 0)	inorder(l);
			sb.append((char)(node + 'A' - 1));
			if (r > 0)	inorder(r);
		}
	}
	
	public void postorder(int node) {
		for (TreeNode tn : tree.get(node)) {
			int l = tn.left;
			int r = tn.right;
			if (l > 0)	postorder(l);
			if (r > 0)	postorder(r);
			sb.append((char)(node + 'A' - 1));
		}
	}
	
	public void sol_1991() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<TreeNode>());
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int root = st.nextToken().charAt(0) - 'A' + 1;
			int left = st.nextToken().charAt(0) - 'A' + 1;
			int right = st.nextToken().charAt(0) - 'A' + 1;
			tree.get(root).add(new TreeNode(left, right));
		}
		
		preorder(1);
		sb.append('\n');
		inorder(1);
		sb.append('\n');
		postorder(1);
		sb.append('\n');
		
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1991();
	}
}
