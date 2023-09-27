import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL1725 {
	
	private static BufferedReader br;
	private static StringBuilder sb;
	
	public SOL1725() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	private static int N;
	private static int[] height;
	
	private static long ans;
	private static int[] tree;
	
	public void run() throws Exception {
		getInput();
		initTree();
		calculate();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		height = new int[N+1];
		for (int i = 1; i <= N; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
	}
	
	public void initTree() {
		tree = new int[4*N+1];
		initMinTree(1, 1, N);
	}
	
	public void calculate() {
		ans = height[tree[1]] * N;
		ans = getMaxArea(1, N);
	}
	
	public void print() {
		System.out.println(ans);
	}
	
	public int getMinIdx(int left, int right) {
		if (left == -1)		return right;
		if (right == -1)	return left;
		
		if (height[left] < height[right]) {
			return left;
		} else if (height[left] > height[right]) {
			return right;
		} else {
			return Math.min(left, right);
		}
	}
	
	public int initMinTree(int nIdx, int s, int e) {
		if (s == e) {
			return tree[nIdx] = s;
		}
		int mid = (s + e) / 2;
		int left = initMinTree(nIdx * 2, s, mid);
		int right = initMinTree(nIdx * 2 + 1, mid + 1, e);
		return tree[nIdx] = getMinIdx(left, right);
	}
	
	public int searchMinTree(int nIdx, int s, int e, int l, int r) {
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
	
	public long getMaxArea(int l, int r) {
		
		int minIdx = searchMinTree(1, 1, N, l, r);
		long area = (r - l + 1) * height[minIdx];

		if (minIdx - 1 >= l)	area = Math.max(area, getMaxArea(l, minIdx - 1));
		if (minIdx + 1 <= r)	area = Math.max(area, getMaxArea(minIdx + 1, r));
			
		return area;
	}
}