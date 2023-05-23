import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

class SOL11068 {

	public static BufferedReader br;
	public static StringBuilder sb;
	
	public SOL11068() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	public void run() throws Exception {
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int curr = Integer.parseInt(br.readLine());
			boolean flag = solution(curr);
			if (flag)	sb.append(1);
			else		sb.append(0);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public boolean solution(int num) {
		
		for (int B = 2; B <= 64; B++) {
			Deque<Integer> dq = changeNum(num, B);
			if (isPalindrome(dq)) {				
				return true;
			}
		}
		
		return false;
	}
	
	public Deque<Integer> changeNum(int num, int B) {
		Deque<Integer> dq = new LinkedList<>();
		
		while (num > 0) {
			dq.addLast(num % B);
			num /= B;
		}
		
		return dq;
	}
	
	public boolean isPalindrome(Deque<Integer> dq) {
		while (dq.size() > 1) {
			int front = dq.pollFirst();
			int back = dq.pollLast();
			if (front != back) {
				return false;
			}
		}
		return true;
	}
}
