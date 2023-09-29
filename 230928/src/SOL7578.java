import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class SOL7578 {
	
	private static BufferedReader br;
	private static StringBuilder sb;
	
	public SOL7578() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	private static int N;
	private static long ans;
	
	private static int[] B;
	private static long[] tree;
	
	public void run() throws Exception {
		getInput();
		calculate();
		System.out.println(ans);
	}
	
	private void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> comPoint = new HashMap<>();
		StringTokenizer stA = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int curr = Integer.parseInt(stA.nextToken());
			comPoint.put(curr, i);
		}
		
		B = new int[N+1];
		StringTokenizer stB = new StringTokenizer(br.readLine());
		for (int i = N; i > 0; i--) {
			int curr = Integer.parseInt(stB.nextToken());
			B[i] = comPoint.get(curr);
		}
	}
	
	private void calculate() {
		ans = 0L;
		tree = new long[4 * N + 1];
		for (int i = 1; i <= N; i++) {
			ans += searchTree(1, 1, N, 1, B[i]);
			updateTree(1, 1, N, B[i], 1);
		}
	}
	
	private long updateTree(int nIdx, int s, int e, int i, int v) {
		if (i < s || e < i) {
			return tree[nIdx];
		}
		if (s == e) {
			return tree[nIdx] += v;
		}
		int mid = (s + e) / 2;
		long left = updateTree(nIdx * 2, s, mid, i, v);
		long right = updateTree(nIdx * 2 + 1, mid + 1, e, i, v);
		return tree[nIdx] = left + right;
	}
	
	private long searchTree(int nIdx, int s, int e, int l, int r) {
		if (r < s || e < l) {
			return 0;
		}
		if (l <= s && e <= r) {
			return tree[nIdx];
		}
		int mid = (s + e) / 2;
		long left = searchTree(nIdx * 2, s, mid, l, r);
		long right = searchTree(nIdx * 2 + 1, mid + 1, e, l, r);
		return left + right;
	}
}
