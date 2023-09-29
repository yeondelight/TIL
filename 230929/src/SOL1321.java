import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL1321 {

	private static BufferedReader br;
	private static StringBuilder sb;
	
	public SOL1321() {
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
	
	public void run() throws Exception {
		init();
		getCmd();
		print();
	}
	
	private void init() throws Exception {
		
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		StringTokenizer stA = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(stA.nextToken());
		}
		
		tree = new int[4*N+1];
		initCntTree(1, 1, N);
	}
	
	private void getCmd() throws Exception {
		int M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			StringTokenizer stCmd = new StringTokenizer(br.readLine());
			int flag = Integer.parseInt(stCmd.nextToken());
			int i = Integer.parseInt(stCmd.nextToken());
			
			switch(flag) {
			case 1:
				int a = Integer.parseInt(stCmd.nextToken());
				updateCntTree(1, 1, N, i, a);
				break;
			case 2:
				int val = searchCntTree(1, 1, N, i);
				sb.append(val).append('\n');
				break;
			}
		}
	}
	
	private void print() {
		System.out.println(sb);
	}
	
	private int initCntTree(int nIdx, int s, int e) {
		if (s == e) {
			return tree[nIdx] = A[s];
		}
		int mid = (s + e) / 2;
		int left = initCntTree(nIdx * 2, s, mid);
		int right = initCntTree(nIdx * 2 + 1, mid + 1, e);
		return tree[nIdx] = left + right;
	}
	
	private int updateCntTree(int nIdx, int s, int e, int i, int v) {
		if (i < s || e < i) {
			return tree[nIdx];
		}
		if (s == e) {
			A[i] += v;
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
