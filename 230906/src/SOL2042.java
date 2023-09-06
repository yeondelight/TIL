import java.io.*;
import java.util.*;

class SOL2042 {
    
    public static BufferedReader br;
    public static StringBuilder sb;
    
    public SOL2042() {
        if (br == null) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        if (sb == null) {
            sb = new StringBuilder();
        }
    }
    
    public int N, M, K;
    public long[] arr;
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
        StringTokenizer stNMK = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stNMK.nextToken());
        M = Integer.parseInt(stNMK.nextToken());
        K = Integer.parseInt(stNMK.nextToken());
        
        // get arr
        arr = new long[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
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
            return tree[nodeIdx] = arr[start];
        }
        
        int mid = (start + end) / 2;
        long left = initTree(nodeIdx * 2, start, mid);
        long right = initTree(nodeIdx * 2 + 1, mid + 1, end);
        return tree[nodeIdx] = left + right;
    }
    
    public void calculation() {
        for (String str : cmd) {
            StringTokenizer stCmd = new StringTokenizer(str);
            int a = Integer.parseInt(stCmd.nextToken());
            int b = Integer.parseInt(stCmd.nextToken());

            if (a == 1) {    // update
                long c = Long.parseLong(stCmd.nextToken());
                updateTree(1, 1, N, b, c);
            } else {        // get sum
                int c = Integer.parseInt(stCmd.nextToken());
                long sum = getTreeSum(1, 1, N, b, c);
                sb.append(sum).append('\n');
            }
        }
    }
    
    public long updateTree(int nodeIdx, int start, int end, int i, long v) {
        if (i < start || i > end) {
            return tree[nodeIdx];
        }
        
        if (start == end) {
            arr[i] = v;
            return tree[nodeIdx] = v;
        }
        
        int mid = (start + end) / 2;
        long left = updateTree(nodeIdx * 2, start, mid, i, v);
        long right = updateTree(nodeIdx * 2 + 1, mid + 1, end, i, v);
        return tree[nodeIdx] = left + right;
    }
    
    public long getTreeSum(int nodeIdx, int start, int end, int l, int r) {
        if (l > end || r < start) {
            return 0;
        }
        
        if (l <= start && end <= r) {
            return tree[nodeIdx];
        }
        
        int mid = (start + end) / 2;
        long left = getTreeSum(nodeIdx * 2, start, mid, l, r);
        long right = getTreeSum(nodeIdx * 2 + 1, mid + 1, end, l, r);
        return left + right;
    }
    
    public void print() {
        System.out.println(sb);
    }
}