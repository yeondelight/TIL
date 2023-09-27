import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL1306 {
	
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public SOL1306() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
		
	public static int N, M;
	public static int[] A;
	public static int[] tree;
	
	public void run() throws Exception {
		getInput();
		initTree();
		calculation();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		
		A = new int[N+1];
		StringTokenizer stA = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(stA.nextToken());
		}
	}
	
	public void initTree() {
		tree = new int[4*N+1];
		initMaxTree(1, 1, N);
	}
	
	public void calculation() {
		int end = N - 2 * M + 2;
		for (int i = 1; i <= end; i++) {
			int s = i;
			int e = i + 2 * M - 2;
			int val = searchMaxTree(1, 1, N, s, e);
			sb.append(val).append(' ');
		}
	}
	
	public void print() {
		System.out.println(sb);
	}
	
	public int initMaxTree(int nIdx, int s, int e) {
		if (s == e) {
			return tree[nIdx] = A[s];
		}
		int mid = (s + e) / 2;
		int left = initMaxTree(nIdx * 2, s, mid);
		int right = initMaxTree(nIdx * 2 + 1, mid + 1, e);
		return tree[nIdx] = Math.max(left, right);
	}
	
	public int searchMaxTree(int nIdx, int s, int e, int l, int r) {
		if ( r < s || e < l ) {
			return 0;
		}
		if ( l <= s && e <= r ) {
			return tree[nIdx];
		}
		int mid = (s + e) / 2;
		int left = searchMaxTree(nIdx * 2, s, mid, l, r);
		int right = searchMaxTree(nIdx * 2 + 1, mid + 1, e, l, r);
		return Math.max(left, right);
	}
}