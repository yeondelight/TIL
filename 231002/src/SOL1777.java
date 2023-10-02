import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL1777 {

	private static BufferedReader br;
	private static StringBuilder sb;
	
	public SOL1777() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	private static int N;
	private static int[] IS;
	private static int[] res;
	private static int[] tree;
	
	public void run() throws Exception {
		getInput();
		initTree();
		calculate();
		print();
	}
	
	private void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		IS = new int[N+1];
		StringTokenizer stIS = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			IS[i] = Integer.parseInt(stIS.nextToken());
		}
	}
	
	private void initTree() {
		tree = new int[4*N+1];
		initCntTree(1, 1, N);
	}
	
	private int initCntTree(int nIdx, int s, int e) {
		if (s == e) {
			return tree[nIdx] = 1;
		}
		int mid = (s + e) / 2;
		int left = initCntTree(nIdx * 2, s, mid);
		int right = initCntTree(nIdx * 2 + 1, mid + 1, e);
		return tree[nIdx] = left + right;
	}
	
	private void calculate() {
		res = new int[N+1];
		for (int i = N; i > 0; i--) {
			int idx = searchCntTree(1, 1, N, i - IS[i]);
			updateCntTree(1, 1, N, idx, -1);
			res[idx] = i;
		}
	}
	
	private void print() {
		for (int i = 1; i <= N; i++) {
			sb.append(res[i]).append(' ');
		}
		System.out.println(sb);
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
	
	private int searchCntTree(int nIdx, int s, int e, int cnt) {
		if (s == e) {
			return s;
		}
		int mid = (s + e) / 2;
		if (tree[nIdx * 2] >= cnt) {
			return searchCntTree(nIdx * 2, s, mid, cnt);
		} else {
			return searchCntTree(nIdx * 2 + 1, mid + 1, e, cnt - tree[nIdx * 2]);
		}
	}
}
