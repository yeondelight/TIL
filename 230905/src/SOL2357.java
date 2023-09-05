import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class SOL2357 {
	
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public int N, M;
	public int[][] cmd;
	
	public int[] A;
	public int[] minTree, maxTree;
	
	public SOL2357() {
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
		
		// get N, M, A[]
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		
		A = new int[N+1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		// get cmds
		cmd = new int[M][2];
		for (int i = 0; i < M; i++) {
			StringTokenizer stCmd = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stCmd.nextToken());
			int b = Integer.parseInt(stCmd.nextToken());
			cmd[i][0] = a;
			cmd[i][1] = b;
		}
	}

    public void makeTree() {
        minTree = new int[4*N+1];
        maxTree = new int[4*N+1];
        initMinTree(1, 1, N);
        initMaxTree(1, 1, N);
    }
    
    public int initMinTree(int nodeIdx, int start, int end) {
        if (start == end) {
            return minTree[nodeIdx] = start;
        }
        
        int mid = (start + end) / 2;
        int left = initMinTree(nodeIdx * 2, start, mid);
        int right = initMinTree(nodeIdx * 2 + 1, mid + 1, end);
        return minTree[nodeIdx] = getMinIndex(left, right);
    }
    
    public int initMaxTree(int nodeIdx, int start, int end) {
        if (start == end) {
            return maxTree[nodeIdx] = start;
        }
        
        int mid = (start + end) / 2;
        int left = initMaxTree(nodeIdx * 2, start, mid);
        int right = initMaxTree(nodeIdx * 2 + 1, mid + 1, end);
        return maxTree[nodeIdx] = getMaxIndex(left, right);
    }

    public void calculation() {
        
        for (int[] range : cmd) {
            int a = range[0];
            int b = range[1];
            
            int min = searchMinTree(1, 1, N, a, b);
            int max = searchMaxTree(1, 1, N, a, b);
            
            sb.append(A[min]).append(' ').append(A[max]).append('\n');
        }
    }
    
    public int searchMinTree(int nodeIdx, int start, int end, int l, int r) {
        
        if (l > end || r < start) {
            return -1;
        }
        
        if (l <= start && end <= r) {
            return minTree[nodeIdx];
        }
        
        int mid = (start + end) / 2;
        int left = searchMinTree(nodeIdx * 2, start, mid, l, r);
        int right = searchMinTree(nodeIdx * 2 + 1, mid + 1, end, l, r);
        return getMinIndex(left, right);
    }
    
    public int searchMaxTree(int nodeIdx, int start, int end, int l, int r) {
        
        if (l > end || r < start) {
            return -1;
        }
        
        if (l <= start && end <= r) {
            return maxTree[nodeIdx];
        }
        
        int mid = (start + end) / 2;
        int left = searchMaxTree(nodeIdx * 2, start, mid, l, r);
        int right = searchMaxTree(nodeIdx * 2 + 1, mid + 1, end, l, r);
        return getMaxIndex(left, right);
    }
    
    public int getMinIndex(int left, int right) {
        if (left == -1)     return right;
        if (right == -1)    return left;
        
        if (A[left] == A[right]) {
            return Math.min(left, right);
        } else if (A[left] < A[right]) {
            return left;
        } else {
            return right;
        }
    } 
    
    public int getMaxIndex(int left, int right) {
        if (left == -1)     return right;
        if (right == -1)    return left;
        
        if (A[left] == A[right]) {
            return Math.min(left, right);
        } else if (A[left] > A[right]) {
            return left;
        } else {
            return right;
        }
    }
    
    public void print() {
        System.out.println(sb);
    }
}