import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	public void sol_1484() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> ans = new PriorityQueue<>();
		
		for(int i = 1; i <= Math.sqrt(G); i++) {
			
			if (G % i == 0) {	// i가 G의 약수일때만
				
				// G = (A+B)(A-B)
				// A는 성원이의 현재 몸무게
				// B는 성원이가 기억하고 있던 몸무게
				int diff = i;
				int sum = G / i;
				
				// 두포인터
				// 합과 차가 일치하는 값을 찾는다.
				int start = 1;
				int end = sum - 1;
				
				while (start <= end) {
					int val = end - start;
					if (val == diff) {		// 합과 차가 모두 일치하면
						ans.offer(end);		// 큰 쪽이 성원이의 현재 몸무게
						break;				// 합*차에 대해 답은 하나만 나올 수 있다.
					}
					else {			// 그 외 경우는 항상 차가 더 큰 경우다.
						start++;
						end--;
					}
				}
			}
		}
		
		// print
		if (ans.isEmpty()) {
			System.out.println(-1);
		}
		else {
			StringBuilder sb = new StringBuilder();
			
			while(!ans.isEmpty()) {
				sb.append(ans.poll());
				sb.append('\n');
			}
			
			System.out.println(sb);
		}
	}

	public static void main(String[] args) throws Exception {
		new Main().sol_1484();
	}
	
}
