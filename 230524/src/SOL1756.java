import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SOL1756 {

	public static BufferedReader br;
	
	public SOL1756() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	public int lastIdx;				// 가장 최근 피자가 들어가 있는 위치
	public int[] ovenDepth;			// 오븐의 깊이
	public Queue<Integer> pizza;	// 피자의 크기
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stDN = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(stDN.nextToken());
		int N = Integer.parseInt(stDN.nextToken());
		
		lastIdx = D+1;
		
		ovenDepth = new int[D+1];
		ovenDepth[0] = Integer.MAX_VALUE;
		StringTokenizer stOven = new StringTokenizer(br.readLine());
		for (int d = 1; d <= D; d++) {
			int curr = Integer.parseInt(stOven.nextToken());
			ovenDepth[d] = Math.min(ovenDepth[d-1], curr);
		}
		
		pizza = new LinkedList<Integer>();
		StringTokenizer stPizza = new StringTokenizer(br.readLine());
		while (stPizza.hasMoreTokens()) {
			pizza.add(Integer.parseInt(stPizza.nextToken()));
		}
	}
	
	public void solution() {
		
		while (!pizza.isEmpty()) {
			
			int currPizza = pizza.poll();
			boolean canPut = false;
			
			for (int d = lastIdx-1; d > 0; d--) {
				if (ovenDepth[d] >= currPizza) {
					lastIdx = d;
					canPut = true;
					break;
				}
			}
			
			if (!canPut) {
				lastIdx = 0;
				break;
			}
		}
	}
	
	public void print() {
		System.out.println(lastIdx);
	}
}
