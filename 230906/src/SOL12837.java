import java.io.*;
import java.util.*;

class SOL12837 {
    
    public static BufferedReader br;
    public static StringBuilder sb;
    
    public SOL12837() {
        if (br == null) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        if (sb == null) {
            sb = new StringBuilder();
        }
    }
    
    public int N, Q;
    public long[] tree;
    
    public String[] cmd;
    
    public void run() throws Exception {
        getInput();
        calculation();
        print();
    }
    
    public void getInput() throws Exception {
        // get N, Q;
        StringTokenizer stNQ = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stNQ.nextToken());
        Q = Integer.parseInt(stNQ.nextToken());
        
        // get money logs
        cmd = new String[Q];
        for (int i = 0; i < Q; i++) {
            cmd[i] = br.readLine();
        }
    }
    
    public void calculation() {
    	
        tree = new long[4*N+1];
        
        for (String str : cmd) {
            StringTokenizer stCmd = new StringTokenizer(str);
            int cmdFlag = Integer.parseInt(stCmd.nextToken());
            
            if (cmdFlag == 1) {    // update
                int p = Integer.parseInt(stCmd.nextToken());
                int x = Integer.parseInt(stCmd.nextToken());
                updateTree(1, 1, N, p, x);
            } else if (cmdFlag == 2) {
                int p = Integer.parseInt(stCmd.nextToken());
                int q = Integer.parseInt(stCmd.nextToken());
                long diff = getTreeSum(1, 1, N, p, q);
                sb.append(diff).append('\n');
            }
        }
    }
    
    public long updateTree(int nodeIdx, int start, int end, int i, int v) {
        if (i < start || end < i) {
            return tree[nodeIdx];
        }
        if (start == end) {
            return tree[nodeIdx] += v;
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