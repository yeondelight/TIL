import java.io.*;
import java.util.*;

class SOL18436 {
    
    public static BufferedReader br;
    public static StringBuilder sb;
    
    public SOL18436() {
        if (br == null) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        if (sb == null) {
            sb = new StringBuilder();
        }
    }
    
    public int N;
    public int[] A;
    public int[] oddTree, evenTree;
    
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
        oddTree = new int[4*N+1];
        evenTree = new int[4*N+1];
        initOddTree(1, 1, N);
        initEvenTree(1, 1, N);
    }
    
    public int initOddTree(int nodeIdx, int start, int end) {
        if (start == end) {
        	if (A[start] % 2 != 0)	return oddTree[nodeIdx] = 1;
        	else					return oddTree[nodeIdx] = 0;
        }
        
        int mid = (start + end) / 2;
        int left = initOddTree(nodeIdx * 2, start, mid);
        int right = initOddTree(nodeIdx * 2 + 1, mid + 1, end);
        return oddTree[nodeIdx] = left + right;
    }
    
    public int initEvenTree(int nodeIdx, int start, int end) {
        if (start == end) {
        	if (A[start] % 2 != 0)	return evenTree[nodeIdx] = 0;
        	else					return evenTree[nodeIdx] = 1;
        }
        
        int mid = (start + end) / 2;
        int left = initEvenTree(nodeIdx * 2, start, mid);
        int right = initEvenTree(nodeIdx * 2 + 1, mid + 1, end);
        return evenTree[nodeIdx] = left + right;
    }
    
    public void calculation() {
        for (String str : cmd) {
            StringTokenizer stCmd = new StringTokenizer(str);
            int cmdFlag = Integer.parseInt(stCmd.nextToken());
            
            if (cmdFlag == 1) {            // update
                int i = Integer.parseInt(stCmd.nextToken());
                int x = Integer.parseInt(stCmd.nextToken());
                updateOddTree(1, 1, N, i, x);
                updateEvenTree(1, 1, N, i, x);
                A[i] = x;	// A[i] 손상 방지를 위해 나중에 진행
            } else {    // count
                int l = Integer.parseInt(stCmd.nextToken());
                int r = Integer.parseInt(stCmd.nextToken());
                int ans = 0;
            	if (cmdFlag == 2) {		// even
                    ans = getEvenTreeCnt(1, 1, N, l, r);
            	}
            	if (cmdFlag == 3) {		// odd
                    ans = getOddTreeCnt(1, 1, N, l, r);
            	}
                sb.append(ans).append('\n');
            }
        }
    }
    
    public int updateOddTree(int nodeIdx, int start, int end, int i, int v) {
        if (i < start || end < i) {
            return oddTree[nodeIdx];
        }
        if (start == end) {
        	if (v % 2 != 0)	return oddTree[nodeIdx] = 1;
        	else			return oddTree[nodeIdx] = 0;
        }
        
        int mid = (start + end) / 2;
        int left = updateOddTree(nodeIdx * 2, start, mid, i, v);
        int right = updateOddTree(nodeIdx * 2 + 1, mid + 1, end, i, v);
        return oddTree[nodeIdx] = left + right;
    }

    public int updateEvenTree(int nodeIdx, int start, int end, int i, int v) {
        if (i < start || end < i) {
            return evenTree[nodeIdx];
        }
        if (start == end) {
        	if (v % 2 != 0)	return evenTree[nodeIdx] = 0;
        	else			return evenTree[nodeIdx] = 1;
        }
        
        int mid = (start + end) / 2;
        int left = updateEvenTree(nodeIdx * 2, start, mid, i, v);
        int right = updateEvenTree(nodeIdx * 2 + 1, mid + 1, end, i, v);
        return evenTree[nodeIdx] = left + right;
    }
    
    public int getOddTreeCnt(int nodeIdx, int start, int end, int l, int r) {
        if (l > end || start > r) {
            return 0;
        }
        if (l <= start && end <= r) {
            return oddTree[nodeIdx];
        }
        
        int mid = (start + end) / 2;
        int left = getOddTreeCnt(nodeIdx * 2, start, mid, l, r);
        int right = getOddTreeCnt(nodeIdx * 2 + 1, mid + 1, end, l, r);
        return left + right;
    }

    public int getEvenTreeCnt(int nodeIdx, int start, int end, int l, int r) {
        if (l > end || start > r) {
            return 0;
        }
        if (l <= start && end <= r) {
            return evenTree[nodeIdx];
        }
        
        int mid = (start + end) / 2;
        int left = getEvenTreeCnt(nodeIdx * 2, start, mid, l, r);
        int right = getEvenTreeCnt(nodeIdx * 2 + 1, mid + 1, end, l, r);
        return left + right;
    }
    
    public void print() {
        System.out.println(sb);
    }
}