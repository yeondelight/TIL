import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	class Truck {
		private int weight;
		private int time;
		
		public Truck(int weight, int time) {
			this.weight = weight;
			this.time = time;
		}
		
		public int getWeight() { return weight; }
		public int getTime() { return time; }
		
		public void reduceTime() {
			this.time--;
		}
	}
	
	public void sol_13335() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] a = new int[n];
		StringTokenizer stA = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(stA.nextToken());
		}

		int time = 0;
		int nextInIdx = 0;
		int totalWeight = 0;
		
		Queue<Truck> q = new LinkedList<>();
		
		do {
			
			// 1. out 확인
			int pollCnt = 0;
			for (Truck t : q) {
				if (t.getTime() == 0) {
					pollCnt++;
				} else {
					t.reduceTime();
				}
			}
			
			for (int i = 0; i < pollCnt; i++) {
				Truck t = q.poll();
				totalWeight -= t.weight;
			}
			
			// 2. in 확인
			if (nextInIdx < n && totalWeight + a[nextInIdx] <= L) {
				q.offer(new Truck(a[nextInIdx], w-1));
				totalWeight += a[nextInIdx];
				nextInIdx++;
			}
			
			// 3. 시간 증가
			time++;
			
		} while (!q.isEmpty());
		
		
		
		// 결과 출력
		System.out.println(time);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_13335();
	}
}
