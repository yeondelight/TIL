import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	class Photo implements Comparable{
		
		private int id;
		private int time;
		private int recommend;
		
		public Photo (int id, int time, int recommend) {
			this.id = id;
			this.time = time;
			this.recommend = recommend;
		}
		
		@Override
		public int compareTo(Object o) {
			Photo p = (Photo) o;
			if (this.recommend == p.recommend) {
				return this.time - p.time;
			}
			return this.recommend - p.recommend;
		}
		
		public int getID() {
			return id;
		}
		
		public int getRecommend() {
			return recommend;
		}
		
		public void setRecommend(int r) {
			this.recommend = r;
		}
	}
	
	public void sol_1713() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());	// 총 사진 수
		int R = Integer.parseInt(br.readLine());	// 총 추천 수 : Recommend
		
		PriorityQueue<Photo> pq = new PriorityQueue<>(N);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			// 현재 요소가 지금 걸린 사진중에 있나요?
			boolean contains = false;
			int curr = Integer.parseInt(st.nextToken());
			Photo updateP = new Photo(0, 0, 0);
			for (Photo p : pq) {
				if (p.getID() == curr) {
					contains = true;
					updateP = p;
					break;
				}
			}
			if (contains) {
				updateP.setRecommend(updateP.getRecommend() + 1);
				pq.remove(updateP);
				pq.offer(updateP);
			}
			// 없으면 현재 빈공간이 있는지 파악하고
			// 빈공간 없으면 하나 날려야함
			else {
				if (pq.size() == N) {
					pq.poll();
				}
				pq.offer(new Photo(curr, i, 1));
			}
		}
		
		// print
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pqId = new PriorityQueue<Integer>(N);
		for (Photo p : pq) {
			pqId.offer(p.getID());
		}
		
		while(!pqId.isEmpty()) {
			sb.append(pqId.poll()).append(' ');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1713();
	}
}
