import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_2812() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int count = 0;
		String str = br.readLine();
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < N; i++) {
			int num = str.charAt(i) - '0';
			while (!s.isEmpty() && count < K && s.peek() < num) {
				s.pop();
				count++;
			}
			s.push(num);
		}
		
		// 만약 위의 과정에서 K개를 다 지우지 못한 경우 뒷부분 자르기
		for (; count < K; count++) {
			s.pop();
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int num : s) {
			sb.append(num);
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2812();
	}
}