import java.io.*;
import java.util.*;

public class Main {

	public static int[] inOrder;
	public static int[] inOrderIndex;
	public static int[] postOrder;
	public static StringBuilder sb;
	
	// 전위 : root - left - right
	public void getPreOrder(int iStart, int iEnd, int pStart, int pEnd) {
		if (iStart > iEnd || pStart > pEnd)	return;		// 잘못된 범위인 경우 return
		
		int root = postOrder[pEnd];				// 후위 : left - right - root
		sb.append(root).append(' ');
		
		int rootIndex = inOrderIndex[root];		// 중위 : left - root - right
		int left = rootIndex - iStart;			// root의 인덱스를 기준으로 left, right 구분
		
		getPreOrder(iStart, rootIndex-1, pStart, pStart+left-1);	// get left child
		getPreOrder(rootIndex+1, iEnd, pStart+left, pEnd-1);		// get left child
	}
	
	public void sol_2263() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		inOrder = new int[N+1];
		inOrderIndex = new int[N+1];
		postOrder = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
			inOrderIndex[inOrder[i]] = i;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		getPreOrder(0, N-1, 0, N-1);
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2263();
	}

}
