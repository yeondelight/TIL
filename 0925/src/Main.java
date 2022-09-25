import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static int count;
	public static StringBuilder sb;
	
	public void hanoi(int n, int from,int temp, int to) {
		count++;
		if (n == 1) {
			sb.append(from).append(' ').append(to).append('\n');
		} else {
			hanoi(n-1, from, to, temp);
			sb.append(from).append(' ').append(to).append('\n');
			hanoi(n-1, temp, from, to);
		}
	}
	
	public void sol_11729() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		count = 0;
		hanoi(N, 1, 2, 3);
		
		System.out.println(count);
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11729();
	}
}
