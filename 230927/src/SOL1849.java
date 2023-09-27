import java.io.BufferedReader;
import java.io.InputStreamReader;

class SOL1849 {
	
	private static BufferedReader br;
	private static StringBuilder sb;
	
	public SOL1849() {
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
	
	private static int[] res;

	public void run() throws Exception {
		getInput();
		initTree();
		calculate();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
	}
	
	public void initTree() {
		res = new int[N + 1];		
		tree = new int[4 * N + 1];
		initSumTree(1, 1, N);
	}
	
	public void calculate() {
		for (int i = 1; i <= N; i++) {
			int idx = searchSumTree(1, 1, N, A[i] + 1);
			updateSumTree(1, 1, N, idx, 0);
			res[idx] = i;
		}
	}
	
	public void print() {
		for (int i = 1; i <= N; i++) {
			sb.append(res[i]).append('\n');
		}
		System.out.println(sb);
	}
	
	public int initSumTree(int nIdx, int s, int e) {
		if (s == e) {
			return tree[nIdx] = 1;
		}
		int mid = (s + e) / 2;
		int left = initSumTree(nIdx * 2, s, mid);
		int right = initSumTree(nIdx * 2 + 1, mid + 1, e);
		return tree[nIdx] = left + right;
	}
	
	public int updateSumTree(int nIdx, int s, int e, int i, int v) {
		if (i < s || e < i) {
			return tree[nIdx];
		}
		if (s == e) {
			return tree[nIdx] = v;
		}
		int mid = (s + e) / 2;
		int left = updateSumTree(nIdx * 2, s, mid, i, v);
		int right = updateSumTree(nIdx * 2 + 1, mid + 1, e, i, v);
		return tree[nIdx] = left + right;
	}
	
	public int searchSumTree(int nIdx, int s, int e, int cnt) {
		if (s == e) {
			return s;
		}
		int mid = (s + e) / 2;
		if (tree[nIdx * 2] >= cnt) {
			return searchSumTree(nIdx * 2, s, mid, cnt);
		} else {
			return searchSumTree(nIdx * 2 + 1, mid + 1, e, cnt - tree[nIdx * 2]);
		}
	}
}
