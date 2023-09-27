import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SOL1572 {

	public static BufferedReader br;
	public static StringBuilder sb;
	
	public SOL1572() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	public static int N, K;
	public static int MAX = 65537;
	
	public static long ans;
	public static long[] tree;
	
	public static Queue<Integer> queue;
	
	public void run() throws Exception {
		init();
		calculation();
		print();
	}
	
	public void init() throws Exception {
		StringTokenizer stNK = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNK.nextToken());
		K = Integer.parseInt(stNK.nextToken());
		
		tree = new long[4 * MAX + 1];
		queue = new LinkedList<Integer>();
	}
	
	public void calculation() throws Exception {
		
		ans = 0;
		
		// get K inputs in advance.
		for (int k = 0; k < K; k++) {
			int curr = Integer.parseInt(br.readLine());
			updateTree(1, 0, MAX, curr, 1);
			queue.offer(curr);
		}
		
		// get first midVal
		int midIdx = (K+1)/2;
		ans += searchTree(1, 0, MAX, midIdx);
		
		while(true) {
			
			String str = br.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			
			int curr = Integer.parseInt(str);
			int prev = queue.poll();
			queue.offer(curr);
			
			updateTree(1, 0, MAX, prev, -1);
			updateTree(1, 0, MAX, curr, 1);
			
			ans += searchTree(1, 0, MAX, midIdx);
		}
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
	
	public long searchTree(int nIdx, int s, int e, long cnt) {
		if (s == e) {
			return s;	// 만약 여기까지 내려온거면 값이 하나일테니까
		}
		
		int mid = (s + e) / 2;
		if (tree[nIdx * 2] >= cnt) {
			return searchTree(nIdx * 2, s, mid, cnt);
		} else {
			return searchTree(nIdx * 2 + 1, mid + 1, e, cnt - tree[nIdx * 2]);
		}
	}
	
	public void print() {
		System.out.println(ans);
	}
	
}