import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

class SOL14428 {
	
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public int N;
	public int[] A;
	public int[] tree;
	
	public Vector<String> cmd;
	
	public SOL14428() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	public void run() throws Exception {
		getInput();
		makeTree();
		calculation();
		print();
	}
	
	public void getInput() throws IOException {
		
		// get N, A[]
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		A[0] = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// get cmds
		int M = Integer.parseInt(br.readLine());
		cmd = new Vector<String>(M);
		for (int i = 0; i < M; i++) {
			cmd.add(br.readLine());
		}
	}
	
	public void makeTree() {
		tree = new int[4*N];
		tree[0] = Integer.MAX_VALUE;
		initTree(1, 1, N);
	}
	
	public void calculation() {
		
		for (String str : cmd) {
			
			StringTokenizer st = new StringTokenizer(str);
			int cmdFlag = Integer.parseInt(st.nextToken());
			
			if (cmdFlag == 2) {	
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int val = getMinValue(1, 1, N, i, j);
				sb.append(val).append('\n');
				continue;
			}
			
			if (cmdFlag == 1) {
				int i = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				updateTree(1, 1, N, i, v);
			}
		}
	}
	
	public void print() {
		System.out.println(sb);
	}
	
	public int initTree(int nodeIdx, int start, int end) {
		
		if (start == end) {
			return tree[nodeIdx] = start;
		}
		
		int mid = (start+end)/2;
		int left = initTree(nodeIdx * 2, start, mid);
		int right = initTree(nodeIdx * 2 + 1, mid+ 1, end);
		
		return tree[nodeIdx] = getIndex(left, right);
	}

	public int updateTree(int nodeIdx, int start, int end, int i, int v) {
		
		if (start > i || end < i) {
			return tree[nodeIdx];
		}
		
		if (start == end) {
		    A[i] = v;
			return tree[nodeIdx] = i;
		}
		
		int mid = (start+end)/2;
		int left = updateTree(nodeIdx * 2, start, mid, i, v);
		int right = updateTree(nodeIdx * 2 + 1, mid + 1, end, i, v);
		
		return tree[nodeIdx] = getIndex(left, right);
	}
	
	public int getIndex(int left, int right) {
	    if (left == -1)  return right;
	    if (right == -1) return left;
	    
		if (A[left] == A[right]) {
			return Math.min(left, right);
		} else if (A[left] < A[right]) {
			return left;
		} else {
			return right;
		}
	}

	public int getMinValue(int nodeIdx, int start, int end, int i, int j) {
	
		if (i > end || j < start) {
			return -1;
		}
		
		if (i <= start && end <= j) {
			return tree[nodeIdx];
		}
		
		int mid = (start + end)/2;
		int left = getMinValue(nodeIdx * 2, start, mid, i, j);
		int right = getMinValue(nodeIdx * 2 + 1, mid + 1, end, i, j);
		return getIndex(left, right);
	}
}