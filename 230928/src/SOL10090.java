import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL10090 {
	
	private static BufferedReader br;
	private static StringBuilder sb;
	
	public SOL10090() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	private static int n;
	private static int[] a;
	
	private static long ans;
	private static int[] tree;

	public void run() throws Exception {
		getInput();
		calculate();
		System.out.println(ans);
	}
	
	private void getInput() throws Exception {
		n = Integer.parseInt(br.readLine());
		a = new int[n+1];
		StringTokenizer stA = new StringTokenizer(br.readLine());
		for (int i = n; i > 0; i--) {
			a[i] = Integer.parseInt(stA.nextToken());
		}
	}
	
	private void calculate() {
		ans = 0L;
		tree = new int[4 * n + 1];
		for (int i = 1; i <= n; i++) {
			ans += searchTree(1, 1, n, 1, a[i]);
			updateTree(1, 1, n, a[i], 1);
		}
	}
	
	private int updateTree(int nIdx, int s, int e, int i, int v) {
		if (i < s || e < i) {
			return tree[nIdx];
		}
		if (s == e) {
			return tree[nIdx] += v;
		}
		int mid = (s + e) / 2;
		int left = updateTree(nIdx * 2, s, mid, i, v);
		int right = updateTree(nIdx * 2 + 1, mid + 1, e, i, v);
		return tree[nIdx] = left + right;
	}
	
	private int searchTree(int nIdx, int s, int e, int l, int r) {
		if (r < s || e < l) {
			return 0;
		}
		if (l <= s && e <= r) {
			return tree[nIdx];
		}
		int mid = (s + e) / 2;
		int left = searchTree(nIdx * 2, s, mid, l, r);
		int right = searchTree(nIdx * 2 + 1, mid + 1, e, l, r);
		return left + right;
	}
}
