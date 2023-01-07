import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public void sol_12018() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] lec = new int[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			Integer[] mil = new Integer[P];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < P; j++) {
				mil[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(mil, Collections.reverseOrder());
			
			if (P >= L)	lec[i] = mil[L-1];	// 같아도 성준이가 먼저 들어간다.
			else		lec[i] = 1;			// 적어도 1마일리지는 넣어야함
		}
		
		
		int cnt = 0;
		int sum = 0;

		Arrays.sort(lec);
		for (int i = 0; i < n; i++) {
			sum += lec[i];
			if (sum <= m)	cnt++;
			else			break;
		}
		
		System.out.println(cnt);
	}
	
	public void sol_13417() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			Deque<Character> card = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			card.offer(st.nextToken().charAt(0));	// 첫 카드를 내 앞에 놓는다.
			
			for (int j = 0; j < N-1; j++) {
				char curr = st.nextToken().charAt(0);
				if (card.peekFirst() >= curr) {
					card.offerFirst(curr);
				} else {
					card.offerLast(curr);
				}
			}
			
			while(!card.isEmpty()) {
				sb.append(card.pollFirst());
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_13417();
	}
}
