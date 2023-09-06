import java.io.*;
import java.util.*;

class SOL11505 {
    
    public static BufferedReader br;
    public static StringBuilder sb;
    
    public SOL11505() {
        if (br == null) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        if (sb == null) {
            sb = new StringBuilder();
        }
    }
    
    public static int mod = 1000000007;
    
    public int N, M, K;
    public int[] A;
    public long[] tree;
    
    public String[] cmd;
    
    public void run() throws Exception {
        getInput();
        makeTree();
        calculation();
        print();
    }
    
    public void getInput() throws Exception {
        // get N, M, K
        StringTokenizer stNK = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stNK.nextToken());
        M = Integer.parseInt(stNK.nextToken());
        K = Integer.parseInt(stNK.nextToken());
        
        // get A
        A = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        
        // get cmd
        cmd = new String[M+K];
        for (int i = 0; i < M+K; i++) {
            cmd[i] = br.readLine();
        }
    }
    
    public void makeTree() {
        tree = new long[4*N+1];
        initTree(1, 1, N);
    }
    
    public long initTree(int nodeIdx, int start, int end) {
        if (start == end) {
            return tree[nodeIdx] = A[start];
        }
        
        int mid = (start + end) / 2;
        long left = initTree(nodeIdx * 2, start, mid);
        long right = initTree(nodeIdx * 2 + 1, mid + 1, end);
        return tree[nodeIdx] = left * right % mod;
    }
    
    public void calculation() {
        for (String str : cmd) {
            StringTokenizer stCmd = new StringTokenizer(str);
            int a = Integer.parseInt(stCmd.nextToken());
            int b = Integer.parseInt(stCmd.nextToken());
            int c = Integer.parseInt(stCmd.nextToken());
            
            if (a == 1) {        // update
                updateTree(1, 1, N, b, c);
            } else if (a == 2) {    // getMul
                long mul = getTreeMul(1, 1, N, b, c);
                sb.append(mul).append('\n');
            }
        }
    }
    
    public long updateTree(int nodeIdx, int start, int end, int i, int V) {
        if (i < start || end < i) {
            return tree[nodeIdx];
        }
        if (start == end) {
            A[i] = V;
            return tree[nodeIdx] = A[start];
        }
        
        int mid = (start + end) / 2;
        long left = updateTree(nodeIdx * 2, start, mid, i, V);
        long right = updateTree(nodeIdx * 2 + 1, mid + 1, end, i, V);
        return tree[nodeIdx] = left * right % mod;
    }
    
    public long getTreeMul(int nodeIdx, int start, int end, int l, int r) {
        if (l > end || r < start) {
            return 1;
        }
        if (l <= start && end <= r) {
            return tree[nodeIdx];
        }
        
        int mid = (start + end) / 2;
        long left = getTreeMul(nodeIdx * 2, start, mid, l, r);
        long right = getTreeMul(nodeIdx * 2 + 1, mid + 1, end, l, r);
        return left * right % mod;
    }
    
    public void print() {
        System.out.println(sb);
    }
}