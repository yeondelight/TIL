import java.io.*;
import java.util.*;

class SOL5676 {
    
    public static BufferedReader br;
    public static StringBuilder sb;
    
    public SOL5676() {
        if (br == null) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        if (sb == null) {
            sb = new StringBuilder();
        }
    }
    
    public int N, K;
    public int[] X;
    public int[] tree;
    
    public String[] cmd;
    
    public void run() throws Exception {
        while (true) {
            if(getInput()) {
                makeTree();
                calculation();
                sb.append('\n');
            } else {
                break;
            }
        }
        print();
    }
    
    public boolean getInput() throws Exception {
        
        // check more inputs
        String firstStr = br.readLine();
        if (firstStr == null || firstStr.equals("")) {
            return false;
        }
        
        // get N, K
        StringTokenizer stNK = new StringTokenizer(firstStr);
        N = Integer.parseInt(stNK.nextToken());
        K = Integer.parseInt(stNK.nextToken());
        
        // get X
        X = new int[N+1];
        StringTokenizer stX = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            X[i] = Integer.parseInt(stX.nextToken());
        }
        
        // get cmd
        cmd = new String[K];
        for (int i = 0; i < K; i++) {
            cmd[i] = br.readLine();
        }
        
        return true;
    }
    
    public void makeTree() {
        tree = new int[4*N+1];
        initTree(1, 1, N);
    }
    
    public int initTree(int nodeIdx, int start, int end) {
        if (start == end) {
        	if (X[start] > 0)		return tree[nodeIdx] = 1;
        	else if (X[start] < 0)	return tree[nodeIdx] = -1;
        	else					return tree[nodeIdx] = 0;
        }
        
        int mid = (start + end) / 2;
        int left = initTree(nodeIdx * 2, start, mid);
        int right = initTree(nodeIdx * 2 + 1, mid + 1, end);
        return tree[nodeIdx] = left * right;
    }
    
    public void calculation() {
        for (String str : cmd) {
            StringTokenizer stCmd = new StringTokenizer(str);
            char cmdFlag = stCmd.nextToken().charAt(0);
            
            if (cmdFlag == 'C') {            // update
                int i = Integer.parseInt(stCmd.nextToken());
                int V = Integer.parseInt(stCmd.nextToken());
                updateTree(1, 1, N, i, V);
            } else if (cmdFlag == 'P') {    // getSum
                int i = Integer.parseInt(stCmd.nextToken());
                int j = Integer.parseInt(stCmd.nextToken());
                int mul = getTreeMul(1, 1, N, i, j);
                if (mul > 0) {
                    sb.append('+');
                } else if (mul < 0) {
                    sb.append('-');
                } else {
                    sb.append('0');
                }
            }
        }
    }
    
    public int updateTree(int nodeIdx, int start, int end, int i, int V) {
        if (i < start || end < i) {
            return tree[nodeIdx];
        }
        if (start == end) {
            X[i] = V;
        	if (X[start] > 0)		return tree[nodeIdx] = 1;
        	else if (X[start] < 0)	return tree[nodeIdx] = -1;
        	else					return tree[nodeIdx] = 0;
        }
        
        int mid = (start + end) / 2;
        int left = updateTree(nodeIdx * 2, start, mid, i, V);
        int right = updateTree(nodeIdx * 2 + 1, mid + 1, end, i, V);
        return tree[nodeIdx] = left * right;
    }
    
    public int getTreeMul(int nodeIdx, int start, int end, int l, int r) {
        if (l > end || r < start) {
            return 1;
        }
        if (l <= start && end <= r) {
            return tree[nodeIdx];
        }
        
        int mid = (start + end) / 2;
        int left = getTreeMul(nodeIdx * 2, start, mid, l, r);
        int right = getTreeMul(nodeIdx * 2 + 1, mid + 1, end, l, r);
        return left * right;
    }
    
    public void print() {
        System.out.println(sb);
    }
}