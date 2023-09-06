import java.io.*;
import java.util.*;

class SOL2268 {
    
    public static BufferedReader br;
    public static StringBuilder sb;
    
    public SOL2268() {
        if (br == null) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        if (sb == null) {
            sb = new StringBuilder();
        }
    }
    
    public int N, M;
    public long[] tree;
    public String[] cmd;
    
    public void run() throws Exception {
        getInput();
        calculation();
        print();
    }
    
    public void getInput() throws Exception {
        // get N, M;
        StringTokenizer stNM = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stNM.nextToken());
        M = Integer.parseInt(stNM.nextToken());
        
        // get cmd
        cmd = new String[M];
        for (int i = 0; i < M; i++) {
            cmd[i] = br.readLine();
        }
    }
    
    public void calculation() {
    	
        // init tree
        tree = new long[4*N+1];
        
        // cal logic
        for (String str : cmd) {
            StringTokenizer stCmd = new StringTokenizer(str);
            int cmdFlag = Integer.parseInt(stCmd.nextToken());
            
            if (cmdFlag == 0) {    // Sum func.
                int i1 = Integer.parseInt(stCmd.nextToken());
                int i2 = Integer.parseInt(stCmd.nextToken());
                int i = Math.min(i1, i2);
                int j = Math.max(i1, i2);
                long sum = getTreeSum(1, 1, N, i, j);
                sb.append(sum).append('\n');
            } else if (cmdFlag == 1) {    // update
                int i = Integer.parseInt(stCmd.nextToken());
                int k = Integer.parseInt(stCmd.nextToken());
                updateTree(1, 1, N, i, k);
            }
        }
    }
    
    public long updateTree(int nodeIdx, int start, int end, int i, int v) {
        if (i < start || end < i) {
            return tree[nodeIdx];
        }
        if (start == end) {
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