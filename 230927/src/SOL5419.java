import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

class Point implements Comparable {

	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Object o) {
		Point p = (Point) o;
		if (this.x == p.x) {
			return this.y - p.y;
		} else {
			return this.x - p.x;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}

class SOL5419 {

	private static BufferedReader br;
	private static StringBuilder sb;
	
	public SOL5419() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	private static int n;
	private static long ans;
	
	private static long[] tree;
	private static int[][] inputXY;
	
	private static TreeMap<Integer, Integer> yMap;
	private static TreeSet<Point> treeSet;
	
	public void run() throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			getInput();
			compress();
			calculation();
			sb.append(ans).append('\n');
		}
		print();
	}
	
	public void getInput() throws Exception {
		
		yMap = new TreeMap<Integer, Integer>();
		
		n = Integer.parseInt(br.readLine());
		inputXY = new int[n+1][2];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer stPoint = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stPoint.nextToken());
			int y = Integer.parseInt(stPoint.nextToken());
			inputXY[i][0] = x;
			inputXY[i][1] = y;
			yMap.put(y, 0);
		}
		
	}
	
	public void compress() {
		
		// 각 y값에 압축 좌표 부여
		int idx = yMap.size();
		for (int key : yMap.keySet()) {
			yMap.put(key, idx--);
		}
		
		// 해당 y값 적용
		treeSet = new TreeSet<Point>();
		for (int i = 1; i <= n; i++) {
			int comY = yMap.get(inputXY[i][1]);
			Point kPoint = new Point(inputXY[i][0], comY);
			treeSet.add(kPoint);
		}
	}
	
	public void calculation() {
		ans = 0;
		tree = new long[4 * n + 1];
		
		for (Point kPoint : treeSet) {
			ans += searchTree(1, 1, n, 1, kPoint.y);
			updateTree(1, 1, n, kPoint.y, 1);
		}
	}
	
	public long updateTree(int nIdx, int s, int e, int i, int v) {
		if (i < s || e < i) {
			return tree[nIdx];
		}
		if (s == e) {
			return tree[nIdx] += v;
		}
		
		int mid = (s + e) / 2;
		long left = updateTree(nIdx * 2, s, mid, i, v);
		long right = updateTree(nIdx * 2 + 1, mid + 1, e, i, v);
		return tree[nIdx] = left + right;
	}
	
	public long searchTree(int nIdx, int s, int e, int l, int r) {
		if (r < s || e < l) {
			return 0;
		}
		if (l <= s && e <= r) {
			return tree[nIdx];
		}

		int mid = (s + e) / 2;
		long left = searchTree(nIdx * 2, s, mid, l, r);
		long right = searchTree(nIdx * 2 + 1, mid + 1, e, l, r);
		return left + right;
	}
	
	
	public void print() {
		System.out.println(sb);
	}
}