import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL2243 {
	
	private static BufferedReader br;
	private static StringBuilder sb;
	
	public SOL2243() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	private static final int MAX = 1000001;
	private static int[] tree;
	
	public void run() throws Exception {
		
		tree = new int[4 * MAX + 1];
		
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			
			StringTokenizer stCmd = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(stCmd.nextToken());
			int B = Integer.parseInt(stCmd.nextToken());
			int C;
			
			switch(A) {
				case 1:
					int candy = searchTree(1, 1, MAX, B);
					updateTree(1, 1, MAX, candy, -1);
					sb.append(candy).append('\n');
					break;
				case 2:
					C = Integer.parseInt(stCmd.nextToken());
					updateTree(1, 1, MAX, B, C);
					break;
			}
		}
		
		System.out.println(sb);
	}
	
	private int updateTree(int nIdx, int s, int e, int i, int v) {
		if (i < s || e < i) {
			return tree[nIdx];
		}
		if (s == e) {
			return tree[nIdx] += v;
		}
		int mid = (s + e) / 2;
		int left = updateTree(nIdx * 2, s, mid, i, v);
		int right = updateTree(nIdx * 2 + 1, mid + 1, e, i, v);
		return tree[nIdx] = left + right;
	}
	
	private int searchTree(int nIdx, int s, int e, int cnt) {
		if (s == e) {
			return s;
		}
		int mid = (s + e) / 2;
		if (tree[nIdx * 2] >= cnt) {
			return searchTree(nIdx * 2, s, mid, cnt);
		} else {
			return searchTree(nIdx * 2 + 1, mid + 1, e, cnt - tree[nIdx * 2]);
		}
	}
}
