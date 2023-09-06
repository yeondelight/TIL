import java.io.*;
import java.util.*;

class SOL14438 {
    
    public static BufferedReader br;
    public static StringBuilder sb;
    
    public SOL14438() {
        if (br == null) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        if (sb == null) {
            sb = new StringBuilder();
        }
    }
    
    public int N;
    public int[] A;
    public int[] tree;
    
    public String[] cmd;
    
    public void run() throws Exception {
        getInput();
        makeTree();
        calculation();
        print();
    }
    
    public void getInput() throws Exception {
        
        // get N, A
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        StringTokenizer stA = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(stA.nextToken());
        }
        
        // get cmd
        int M = Integer.parseInt(br.readLine());
        cmd = new String[M];
        for (int i = 0; i < M; i++) {
            cmd[i] = br.readLine();
        }
    }
    
    public void makeTree() {
        tree = new int[4*N+1];
        initTree(1, 1, N);
    }
    
    public int initTree(int nodeIdx, int start, int end) {
        if (start == end) {
            return tree[nodeIdx] = start;
        }
        
        int mid = (start + end) / 2;
        int left = initTree(nodeIdx * 2, start, mid);
        int right = initTree(nodeIdx * 2 + 1, mid + 1, end);
        return tree[nodeIdx] = getMinIdx(left, right);
    }
    
    public int getMinIdx(int left, int right) {
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        
        if (A[left] < A[right]) {
            return left;
        } else if (A[left] > A[right]) {
            return right;
        } else {
            return Math.min(left, right);
        }
    }
    
    public void calculation() {
        for (String str : cmd) {
            StringTokenizer stCmd = new StringTokenizer(str);
            int cmdFlag = Integer.parseInt(stCmd.nextToken());
            
            if (cmdFlag == 1) {            // update
                int i = Integer.parseInt(stCmd.nextToken());
                int v = Integer.parseInt(stCmd.nextToken());
                updateTree(1, 1, N, i, v);
            } else if (cmdFlag == 2) {    // print minval
                int i = Integer.parseInt(stCmd.nextToken());
                int j = Integer.parseInt(stCmd.nextToken());
                int minIdx = getTreeMin(1, 1, N, i, j);
                sb.append(A[minIdx]).append('\n');
            }
        }
    }
    
    public int updateTree(int nodeIdx, int start, int end, int i, int v) {
        if (i < start || end < i) {
            return tree[nodeIdx];
        }
        if (start == end) {
            A[i] = v;
            return tree[nodeIdx] = start;
        }
        
        int mid = (start + end) / 2;
        int left = updateTree(nodeIdx * 2, start, mid, i, v);
        int right = updateTree(nodeIdx * 2 + 1, mid + 1, end, i, v);
        return tree[nodeIdx] = getMinIdx(left, right);
    }
    
    public int getTreeMin(int nodeIdx, int start, int end, int l, int r) {
        if (l > end || start > r) {
            return -1;
        }
        if (l <= start && end <= r) {
            return tree[nodeIdx];
        }
        
        int mid = (start + end) / 2;
        int left = getTreeMin(nodeIdx * 2, start, mid, l, r);
        int right = getTreeMin(nodeIdx * 2 + 1, mid + 1, end, l, r);
        return getMinIdx(left, right);
    }
    
    public void print() {
        System.out.println(sb);
    }
}