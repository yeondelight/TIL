import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL1275 {
	
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public SOL1275() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	public int N;
	public int Q;
	public long[] arr;
	public long[] tree;
	public int[][] cmd;
	
	public void run() throws Exception {
		getInput();
		makeTree();
		calculation();
		print();
	}

	public void getInput() throws IOException {
		
		// get N, Q
		StringTokenizer stNQ = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNQ.nextToken());
		Q = Integer.parseInt(stNQ.nextToken());
		
		// get arr
		arr = new long[N+1];
		StringTokenizer stArr = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(stArr.nextToken());
		}
		
		// get cmd
		cmd = new int[Q][4];
		for (int q = 0; q < Q; q++) {
			StringTokenizer stCmd = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cmd[q][i] = Integer.parseInt(stCmd.nextToken());
			}
		}
	}
	
	public void makeTree() {
		tree = new long[4*N+1];
		initTree(1, 1, N);
	}
	
	public long initTree(int nodeIdx, int start, int end) {
		if (start == end) {
			return tree[nodeIdx] = arr[start];
		}
		
		int mid = (start + end) / 2;
		long left = initTree(nodeIdx * 2, start, mid);
		long right = initTree(nodeIdx * 2 + 1, mid + 1, end);
		return tree[nodeIdx] = left + right;
	}
	
	public void calculation() {
		for (int[] range : cmd) {
			// x와 y가 바뀔 수 있음에 유의한다.
			int x = Math.min(range[0], range[1]);
			int y = Math.max(range[0], range[1]);
			int a = range[2];
			int b = range[3];
			
			long sum = getTreeSum(1, 1, N, x, y);
			updateTree(1, 1, N, a, b);
			
			sb.append(sum).append('\n');
		}
	}
	
	public long getTreeSum(int nodeIdx, int start, int end, int l, int r) {
		if (l > end || r < start) {
			return 0;	// 합을 구하는 범위가 아니므로 영향이 없는 0 반환
		}
		if (l <= start && end <= r) {
			return tree[nodeIdx];	// 구하고자 하는 범위에 완전 포함이므로 바로 반환
		}
		
		int mid = (start + end) / 2;
		long left = getTreeSum(nodeIdx * 2, start, mid, l, r);
		long right = getTreeSum(nodeIdx * 2 + 1, mid + 1, end, l, r);
		return left + right;
	}
	
	public long updateTree(int nodeIdx, int start, int end, int i, int v) {
		if (i < start || i > end) {
			return tree[nodeIdx];	// 변경할 필요가 없음
		}
		if (start == end) {	// == i 조건이 생략됨
			arr[i] = v;
			return tree[nodeIdx] = arr[start];
		}
		
		int mid = (start + end) / 2;
		long left = updateTree(nodeIdx * 2, start, mid, i, v);
		long right = updateTree(nodeIdx * 2 + 1, mid + 1, end, i, v);
		return tree[nodeIdx] = left + right;
	}
	
	public void print() {
		System.out.println(sb);
	}
}
