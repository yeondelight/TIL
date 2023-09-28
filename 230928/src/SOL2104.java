import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL2104 {

	private static BufferedReader br;
	
	public SOL2104() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	private int N;
	private int[] A;
	
	private long ans;
	private int[] minTree;
	private long[] sumTree;
	
	public void run() throws Exception {
		getInput();
		initTree();
		ans = 0;
		ans = calculate(1, N);
		System.out.println(ans);
	}
	
	private void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		StringTokenizer stA = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(stA.nextToken());
		}
	}
	
	private long calculate(int l, int r) {		
		int minIdx = searchMinTree(1, 1, N, l, r);
		long currSum = searchSumTree(1, 1, N, l, r);
		long score = A[minIdx] * currSum;
		
		if (minIdx - 1 >= l)	score = Math.max(score, calculate(l, minIdx - 1));
		if (minIdx + 1 <= r)	score = Math.max(score, calculate(minIdx + 1, r));
		
		return score;
	}
	
	private void initTree() {
		minTree = new int[4 * N + 1];
		sumTree = new long[4 * N + 1];
		initMinTree(1, 1, N);
		initSumTree(1, 1, N);
	}
	
	private int getMinIdx(int l, int r) {
		if (l == -1)	return r;
		if (r == -1)	return l;		
		if (A[l] < A[r])		return l;
		else if (A[l] > A[r])	return r;
		else					return Math.min(l, r);
	}
	
	private int initMinTree(int nIdx, int s, int e) {
		if (s == e) {
			return minTree[nIdx] = s;
		}
		int mid = (s + e) / 2;
		int left = initMinTree(nIdx * 2, s, mid);
		int right = initMinTree(nIdx * 2 + 1, mid + 1, e);
		return minTree[nIdx] = getMinIdx(left, right);
	}
	
	private long initSumTree(int nIdx, int s, int e) {
		if (s == e) {
			return sumTree[nIdx] = A[s];
		}
		int mid = (s + e) / 2;
		long left = initSumTree(nIdx * 2, s, mid);
		long right = initSumTree(nIdx * 2 + 1, mid + 1, e);
		return sumTree[nIdx] = left + right;
	}
	
	private int searchMinTree(int nIdx, int s, int e, int l, int r) {
		if (r < s || e < l) {
			return -1;
		}
		if (l <= s && e <= r) {
			return minTree[nIdx];
		}
		int mid = (s + e) / 2;
		int left = searchMinTree(nIdx * 2, s, mid, l, r);
		int right = searchMinTree(nIdx * 2 + 1, mid + 1, e, l, r);
		return getMinIdx(left, right);
	}
	
	private long searchSumTree(int nIdx, int s, int e, int l, int r) {
		if (r < s || e < l) {
			return 0;
		}
		if (l <= s && e <= r) {
			return sumTree[nIdx];
		}
		int mid = (s + e) / 2;
		long left = searchSumTree(nIdx * 2, s, mid, l, r);
		long right = searchSumTree(nIdx * 2 + 1, mid + 1, e, l, r);
		return left + right;
	}
}
