import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL1989 {

	private static BufferedReader br;
	private static StringBuilder sb;
	
	public SOL1989() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	private int N;
	private int[] A;
	
	private long[] ans;
	
	private int[] minTree;
	private long[] sumTree;
	
	public void run() throws Exception {
		getInput();
		initTree();
		ans = new long[3];
		ans = calculate(1, N);
		print();
	}
	
	private void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		StringTokenizer stA = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(stA.nextToken());
		}
	}
	
	private long[] calculate(int l, int r) {		
		int minIdx = searchMinTree(1, 1, N, l, r);
		long currSum = searchSumTree(1, 1, N, l, r);
		long[] score = new long[3];
		score[0] = A[minIdx] * currSum;
		score[1] = l;
		score[2] = r;
		
		
		if (minIdx - 1 >= l) {
			long[] val = calculate(l, minIdx - 1);
			if (val[0] >= score[0]) {
				score = val;
			}
		}
		if (minIdx + 1 <= r) {
			long[] val = calculate(minIdx + 1, r);
			if (val[0] >= score[0]) {
				score = val;
			}
		}
		
		return score;
	}
	
	private void print() {
		sb.append(ans[0]).append('\n');
		sb.append(ans[1]).append(' ').append(ans[2]);
		System.out.println(sb);
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
