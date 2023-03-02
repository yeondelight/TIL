import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	private int[][] map;
	private int ans;
	
	public void pooling(int size) {
		if (size == 1) {
			ans = map[0][0];
			return;
		}
		
		for (int i = 0; i < size; i += 2) {
			for (int j = 0; j < size; j += 2) {
				// start from map[i][j]
				int[] cmpArr = { map[i][j], map[i][j+1], map[i+1][j], map[i+1][j+1] };
				Arrays.sort(cmpArr);		// 오름차순 정렬
				map[i/2][j/2] = cmpArr[2];	// 두 번째로 큰 값 저장
			}
		}
		
		pooling(size/2);
	}
	
	public void sol_17829() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pooling(N);
		System.out.println(ans);
	}
	
	class Time implements Comparable{
		
		private int hh;
		private int mm;
		
		public Time(int hh, int mm) {
			this.hh = hh;
			this.mm = mm;
		}
		
		public int getHH() { return hh; }
		public int getMM() { return mm; }
		
		@Override
		public int compareTo(Object o) {
			Time t = (Time) o;
			if (t.getHH() == this.hh) {
					return this.mm - t.getMM();
			}
			else {
				return this.hh - t.getHH();
			}
		}
	}
	
	public void sol_19583() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ": ");
		
		Time S = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Time E = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Time Q = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		HashSet<String> member = new HashSet<>();
	
		int ans = 0;
		String str;
		while (true) {
			
			str = br.readLine();
			if (str == "" || str == null) {
				break;
			}
			
			StringTokenizer stChat = new StringTokenizer(str, ": ");
			Time curr = new Time(Integer.parseInt(stChat.nextToken()), Integer.parseInt(stChat.nextToken()));
			String name = stChat.nextToken();
			
			// 시작 전에 작성된 채팅
			if (curr.compareTo(S) <= 0) {
				member.add(name);
				continue;
			}
			
			// 끝나고 작성된 채팅
			if (curr.compareTo(E) >= 0 && curr.compareTo(Q) <= 0) {
				if (member.contains(name)) {
					ans++;
					member.remove(name);
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_19583();
	}
}
