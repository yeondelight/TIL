import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

class SOL14427 {
	
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public int N;
	public int[] A;
	public int[] tree;
	
	public Vector<String> cmd;
	
	public SOL14427() {
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
	
	// SW역량시험 권장 - input 한번에 받기
	public void getInput() throws IOException {
		
		// get N, A[]
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];	// 1번부터 시작하기 위함
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
		tree = new int[4*N];	// 1번부터 시작하여 2*N-1개의 노드
		initTree(1, 1, N);		// 1번부터 시작하여 모든 노드의 값을 저장한다.
	}
	
	public void calculation() {
		
		for (String str : cmd) {
			
			StringTokenizer st = new StringTokenizer(str);
			int cmdFlag = Integer.parseInt(st.nextToken());
			
			if (cmdFlag == 2) {	
				sb.append(tree[1]).append('\n');
				continue;
			}
			
			if (cmdFlag == 1) {
				int i = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				A[i] = v;
				updateTree(1, 1, N, i);
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

	public int updateTree(int nodeIdx, int start, int end, int i) {
		
		// invalid한 범위의 경우 현재값 return
		if (start > i || end < i) {
			return tree[nodeIdx];
		}
		
		// leafnode의 경우 갱신 후 return
		if (start == end) {
			return tree[nodeIdx] = i;
		}
		
		int mid = (start+end)/2;
		int left = updateTree(nodeIdx * 2, start, mid, i);
		int right = updateTree(nodeIdx * 2 + 1, mid+ 1, end, i);
		
		return tree[nodeIdx] = getIndex(left, right);
	}
	
	public int getIndex(int left, int right) {
		if (A[left] == A[right]) {
			return Math.min(left, right);
		} else if (A[left] < A[right]) {
			return left;
		} else {
			return right;
		}
	}
}
