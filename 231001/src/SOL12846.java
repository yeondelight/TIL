import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL12846 {
	
	private static BufferedReader br;
	
	public SOL12846() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	private static int n;
	private static int ans;
	private static int[] T;
	private static int[] tree;
	
	public void run() throws Exception {
		initInput();
		initMinTree(1, 1, n);
		ans = findSalary(1, n);
		System.out.println(ans);
	}
	
	private void initInput() throws Exception {
		n = Integer.parseInt(br.readLine());
		T = new int[n + 1];
		StringTokenizer stT = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			T[i] = Integer.parseInt(stT.nextToken());
		}
		
		tree = new int[4 * n + 1];
	}
	
	private int initMinTree(int nIdx, int s, int e) {
		if (s == e) {
			return tree[nIdx] = s;
		}
		int mid = (s + e) / 2;
		int left = initMinTree(nIdx * 2, s, mid);
		int right = initMinTree(nIdx * 2 + 1, mid + 1, e);
		return tree[nIdx] = getMinIdx(left, right);
	}
	
	private int getMinIdx(int l, int r) {
		if (l == -1)	return r;
		if (r == -1)	return l;
		if (T[l] < T[r])		return l;
		else if (T[l] > T[r])	return r;
		else					return Math.max(l, r);
	}
	
	private int searchMinTree(int nIdx, int s, int e, int l, int r) {
		if (r < s || e < l) {
			return -1;
		}
		if (l <= s && e <= r) {
			return tree[nIdx];
		}
		int mid = (s + e) / 2;
		int left = searchMinTree(nIdx * 2, s, mid, l, r);
		int right = searchMinTree(nIdx * 2 + 1, mid + 1, e, l, r);
		return getMinIdx(left, right);
	}
	
	private int findSalary(int l, int r) {
		int minIdx = searchMinTree(1, 1, n, l, r);
		int val = (r - l + 1) * T[minIdx];
		
		if (minIdx - 1 >= l)	val = Math.max(val, findSalary(l, minIdx - 1));
		if (minIdx + 1 <= r)	val = Math.max(val, findSalary(minIdx + 1, r));
		
		return val;
	}
}
