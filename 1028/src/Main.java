import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static int N;
	public static char[] ans;
	public static char[] op = {' ', '+', '-'};
	public static StringBuilder sb = new StringBuilder();
	
	public void backtracking(int idx) {
		if (idx == N-1) {
			// check is 0
			int sum = 1;
			int prevNum = 1;
			char prevOp = '+';
			for (int i = 0; i < N-1; i++) {
				int currNum = i+2;
				switch(ans[i]) {
				case '+':
					sum += currNum;
					prevNum = currNum;
					prevOp = ans[i];
					break;
				case '-':
					sum -= currNum;
					prevNum = currNum;
					prevOp = ans[i];
					break;
				case ' ':
					// update currNum
					currNum += prevNum * 10;
					
					// update cal
					if (prevOp == '+')	sum = sum - prevNum + currNum;
					else				sum = sum + prevNum - currNum;
					
					prevNum = currNum;
					break;
				}
			}

			
			// print
			if (sum == 0) {
				sb.append(1);
				for (int i = 0; i < N-1; i++) {
					sb.append(ans[i]).append(i+2);
				}
				sb.append('\n');
			}
			
			return;
		}
		
		for (int j = 0; j < 3; j++) {
			ans[idx] = op[j];
			backtracking(idx + 1);
		}
	}
	
	public void sol_7490() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			ans = new char[N-1];

			backtracking(0);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_7490();
	}
}
