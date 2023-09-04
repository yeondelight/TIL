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
	
	// SW역량시험 권장 - input 한번에 받기
	public void getInput() throws IOException {
		
		// get N, A[]
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];			// 1번부터 시작하기 위함
		A[0] = Integer.MAX_VALUE;	// 최솟값을 구하므로 빈 idx에는 최댓값을 넣음
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
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int val = getMinValue(1, 1, N, i, j);
				sb.append(val).append('\n');
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

	public int getMinValue(int nodeIdx, int start, int end, int i, int j) {
	
		// 구하고자 하는 범위[i-j]가 현재 범위[s-e]를 포함하지 않는 경우
		// 빈 idx(0) return
		if (i > end || j < start) {
			return 0;
		}
		
		// 구하고자 하는 범위[i-j]가 현재 범위[s-e]를 포함한 경우
		// 저장된 최소idx return
		if (i <= start && end <= j) {
			return tree[nodeIdx];
		}
		
		// 그 외의 경우
		// left와 right의 idx를 비교하여 최소값을 가진 idx 반환
		int mid = (start + end)/2;
		int left = getMinValue(nodeIdx*2, start, mid, i, j);
		int right = getMinValue(nodeIdx*2+1, mid+1, end, i, j);
		return tree[nodeIdx] = getIndex(left, right);
	}
}
