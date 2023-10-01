import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

class SOL2517 {

	private static BufferedReader br;
	private static StringBuilder sb;
	
	public SOL2517() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	private static int N;
	
	private static int[] A;
	private static int[] tree;
	private static int[] bestRank;
	private static TreeMap<Integer, Integer> compressedA;
	
	public void run() throws Exception {
		initByInput();
		applyCompressedA();
		getBestRank();
		print();
	}
	
	private void initByInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		compressedA = new TreeMap<Integer, Integer> ();
		for (int idx = 1; idx <= N; idx++) {
			int val = Integer.parseInt(br.readLine());
			A[idx] = val;
			compressedA.put(val, idx);
		}
	}
	
	private void applyCompressedA() {
		int compressVal = 1;
		for (int val : compressedA.keySet()) {
			int idx = compressedA.get(val);
			A[idx] = compressVal++;
		}
	}
	
	private void getBestRank() {
		// init tree, answer arr
		tree = new int[4*N+1];
		bestRank = new int[N+1];
		
		// cnt forward players : smaller nums
		for (int i = 1; i <= N; i++) {
			int smallCnt = searchCntTree(1, 1, N, 1, A[i]);
			bestRank[i] = i - smallCnt;
			updateCntTree(1, 1, N, A[i], 1);
		}
	}
	
	private void print() {
		for (int i = 1; i <= N; i++) {
			sb.append(bestRank[i]).append('\n');
		}
		System.out.println(sb);
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
}
