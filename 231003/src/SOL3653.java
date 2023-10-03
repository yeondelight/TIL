import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL3653 {

	private static BufferedReader br;
	private static StringBuilder sb;
	
	public SOL3653() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	private static int n, m;
	private static int[] idx;
	private static int[] res;
	private static int[] tree;
	
	public void run() throws Exception {
		int T = Integer.parseInt(br.readLine());	// TC
		for (int t = 0; t < T; t++) {
			initInput();
			initTree();
			calculate();
			print();
		}
		System.out.println(sb);
	}
	
	private void initInput() throws Exception {
		StringTokenizer stnm = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stnm.nextToken());
		m = Integer.parseInt(stnm.nextToken());
		
		idx = new int[n+1];
		for (int i = 1; i <= n; i++) {
			idx[i] = i+m;
		}
	}
	
	private void initTree() {
		tree = new int[4 * (n+m) + 1];
		for (int i = 1; i <= n; i++) {
			updateCntTree(1, 1, n+m, i+m, 1);
		}
	}
	
	private void calculate() throws Exception {
		res = new int[m];
		int nextMoveIdx = m;
		StringTokenizer stM = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int curr = Integer.parseInt(stM.nextToken());
			int ans = searchCntTree(1, 1, n+m, 1, idx[curr] - 1);
			
			updateCntTree(1, 1, n+m, idx[curr], -1);
			updateCntTree(1, 1, n+m, nextMoveIdx, 1);
			
			idx[curr] = nextMoveIdx--;
			res[i] = ans;
		}
	}
	
	private void print() {
		for (int val : res) {
			sb.append(val).append(' ');
		}
		sb.append('\n');
	}
	
	private int updateCntTree(int nIdx, int s, int e, int i, int v) {
		if (i < s || e < i) {
			return tree[nIdx];
		}
		if (s == e) {
			return tree[nIdx] += v;
		}
		int mid = (s + e) / 2;
		int left = updateCntTree(nIdx * 2, s, mid, i, v);
		int right = updateCntTree(nIdx * 2 + 1, mid + 1, e, i, v);
		return tree[nIdx] = left + right;
	}
	
	private int searchCntTree(int nIdx, int s, int e, int l, int r) {
		if (r < s || e < l) {
			return 0;
		}
		if (l <= s && e <= r) {
			return tree[nIdx];
		}
		int mid = (s + e) / 2;
		int left = searchCntTree(nIdx * 2, s, mid, l, r);
		int right = searchCntTree(nIdx * 2 + 1, mid + 1, e, l, r);
		return left + right;
	}
}
