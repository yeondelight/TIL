import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public void sol_2089() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if (N == 0) {
			System.out.println(0);
			return;
		}
		
		Stack<Integer> s = new Stack<>();
		while (N != 0) {
			if (N > 0) {	// 양수인 경우 기존 2진수와 동일
				s.push(N % (-2));
				N /= -2;
			} else {		// 음수인 경우 나머지가 있다면 몫+1 해야함
				int mod = N % (-2) * (-1);
				s.push(mod);
				if (mod != 0)	N = N/-2 + 1;
				else			N /= -2;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!s.isEmpty()) {
			sb.append(s.pop());
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2089();
	}
}
