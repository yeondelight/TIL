import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1083() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> num = new ArrayList<>();
		
		int maxMove = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num.add(Integer.parseInt(st.nextToken()));
			maxMove += i;
		}
		
		int S = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		if (S >= maxMove) {
			Collections.sort(num);
			Collections.reverse(num);
			for (int n : num) {
				sb.append(n).append(' ');
			}
		}
		else {
			ArrayList<Integer> sortedNum = new ArrayList<>();
			
			while (S > 0 && !num.isEmpty()) {
				int maxIdx = 0;
				// 현 위치로부터 S만큼 가서
				if (S >= num.size()) {
					// 그 위치까지의 최댓값을 구하고
					for (int i = 0; i < num.size(); i++) {
						if (num.get(maxIdx) < num.get(i)) {
							maxIdx = i;
						}
					}
				} else {
					// 그 위치까지의 최댓값을 구하고
					for (int i = 0; i <= S; i++) {
						if (num.get(maxIdx) < num.get(i)) {
							maxIdx = i;
						}
					}
				}

				// 그 값을 맨 앞으로 땡기고
				sortedNum.add(num.remove(maxIdx));
				
				// S 갱신
				S -= maxIdx;		 
			}
			
			for (int s : sortedNum) {
				sb.append(s).append(' ');
			}
			for (int n : num) {
				sb.append(n).append(' ');
			}
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1083();
	}
}
