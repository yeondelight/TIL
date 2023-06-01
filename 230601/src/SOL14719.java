import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL14719 {

	public static BufferedReader br;
	
	public int H, W;
	public int[] heights;
	public int ans;
	
	public SOL14719() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stHW = new StringTokenizer(br.readLine());
		H = Integer.parseInt(stHW.nextToken());
		W = Integer.parseInt(stHW.nextToken());
		
		heights = new int[W];
		StringTokenizer stHeights = new StringTokenizer(br.readLine());
		for (int w = 0; w < W; w++) {
			heights[w] = Integer.parseInt(stHeights.nextToken());
		}
	}
	
	public void solution() {
		ans = 0;
		for (int w = 0; w < W; w++) {
			int leftMax = getMax(0, w-1);
			int rightMax = getMax(w+1, W-1);
			int val = Math.min(leftMax, rightMax) - heights[w];
			if (val < 0) {
				val = 0;
			}
			ans += val;
		}
	}
	
	public void print() {
		System.out.println(ans);
	}
	
	public int getMax(int s, int e) {
		
		if (s > e) {
			return 0;
		}
		
		int max = 0;
		for (int i = s; i <= e; i++) {
			max = Math.max(max, heights[i]);
		}
		
		return max;
	}
}
