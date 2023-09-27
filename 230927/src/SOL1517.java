import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.StringTokenizer;

class SOL1517 {
	
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public SOL1517() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	public static int N;
	
	public static long sum;
	public static long[] tree;
	
	public static TreeMap<Integer, Integer> A;
	
	public void run() throws Exception {
		getInput();
		calculation();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		
		A = new TreeMap<Integer, Integer>();
		StringTokenizer stA = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int curr = Integer.parseInt(stA.nextToken());
			A.put(curr, i);		// curr의 tree idx가 i이다.
		}
	}
	
	public void calculation() {
		
		sum = 0;
		tree = new long[4 * N + 1];
		
		for (int key : A.keySet()) {	// value 오름차순 정렬
			int idx = A.get(key);
			sum += searchTree(1, 1, N, idx, N);
			updateTree(1, 1, N, idx, 1);
		}
	}
	
	public void print() {
		System.out.println(sum);
	}
	
	public long updateTree(int nIdx, int s, int e, int i, int v) {
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
	
	public long searchTree(int nIdx, int s, int e, int l, int r) {
		if ( r < s || e < l ) {
			return 0;
		}
		if ( l <= s && e <= r ) {
			return tree[nIdx];
		}
		
		int mid = (s + e) / 2;
		long left = searchTree(nIdx * 2, s, mid, l, r);
		long right = searchTree(nIdx * 2 + 1, mid + 1, e, l, r);
		return left + right;
	}
	
}