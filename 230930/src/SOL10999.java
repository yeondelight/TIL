import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL10999 {

	private static BufferedReader br;
	private static StringBuilder sb;
	
	public SOL10999() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	private static int N, M, K;
	private static long[] A;
	private static long[] tree;
	private static long[] lazy;
	
	public void run() throws Exception {
		initInput();
		initSumTree(1, 1, N);
		calculate();
		System.out.println(sb);
	}
	
	private void initInput() throws Exception{
		StringTokenizer stNMK = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNMK.nextToken());
		M = Integer.parseInt(stNMK.nextToken());
		K = Integer.parseInt(stNMK.nextToken());
		
		A = new long[N+1];
		tree = new long[4*N+1];
		lazy = new long[4*N+1];
		
		for (int i = 1; i <= N; i++) {
			A[i] = Long.parseLong(br.readLine());
		}
	}
	
	private long initSumTree(int nIdx, int s, int e) {
		if (s == e) {
			return tree[nIdx] = A[s];
		}
		int mid = (s + e) / 2;
		long left = initSumTree(nIdx * 2, s, mid);
		long right = initSumTree(nIdx * 2 + 1, mid + 1, e);
		return tree[nIdx] = left + right;
	}
	
	private void calculate() throws Exception {
		int T = M + K;
		for (int t = 0; t < T; t++) {
			
			StringTokenizer stCmd = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stCmd.nextToken());
			int b = Integer.parseInt(stCmd.nextToken());
			int c = Integer.parseInt(stCmd.nextToken());
			long d;
			
			switch(a) {
			case 1:
				d = Long.parseLong(stCmd.nextToken());
				updateSumTree(1, 1, N, b, c, d);
				break;
			case 2:
				long val = searchSumTree(1, 1, N, b, c);
				sb.append(val).append('\n');
				break;
			}
		}
	}
	
	private long updateSumTree(int nIdx, int s, int e, int l, int r, long v) {
		updateLazy(nIdx, s, e);
		if (r < s || e < l) {
			return tree[nIdx];
		}
		if (l <= s && e <= r) {
			if (s != e) {
				lazy[nIdx * 2] += v;
				lazy[nIdx * 2 + 1] += v;
			}
			return tree[nIdx] += (e - s + 1) * v;
		}
		int mid = (s + e) / 2;
		long left = updateSumTree(nIdx * 2, s, mid, l, r, v);
		long right = updateSumTree(nIdx * 2 + 1, mid + 1, e, l, r, v);
		return tree[nIdx] = left + right;
	}
	
	private void updateLazy(int nIdx, int s, int e) {
		if (lazy[nIdx] != 0) {
			tree[nIdx] += (e - s + 1) * lazy[nIdx];
			if (s != e) {
				lazy[nIdx * 2] += lazy[nIdx];
				lazy[nIdx * 2 + 1] += lazy[nIdx];
			}
			lazy[nIdx] = 0;
		}
	}
	
	private long searchSumTree(int nIdx, int s, int e, int l, int r) {
		updateLazy(nIdx, s, e);
		if (r < s || e < l) {
			return 0;
		}
		if (l <= s && e <= r) {
			return tree[nIdx];
		}
		int mid = (s + e) / 2;
		long left = searchSumTree(nIdx * 2, s, mid, l, r);
		long right = searchSumTree(nIdx * 2 + 1, mid + 1, e, l, r);
		return left + right;
	}
}