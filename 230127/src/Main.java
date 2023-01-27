import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public void sol_17175() throws Exception {
		long DIV = 1000000007;
		long[] call = new long[51];
		
		Arrays.fill(call, 1);	// 일단 자기자신은 다 호출하니까
		
		for (int i = 2; i < 51; i++) {
			call[i] += call[i-1] + call[i-2];
			call[i] %= DIV;
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		System.out.println(call[N]);
	}
	
	public void sol_8394() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int DIV = 10;
		int[] hand = new int[N+1 < 4 ? 4 : N+1];
		
		hand[0] = hand[1] = 0;
		hand[2] = 2;
		hand[3] = 3;
		
		for(int i = 4; i <= N; i++) {
			hand[i] = hand[i-1] + hand[i-2];
			hand[i] %= DIV;
		}
		
		System.out.println(hand[N]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_8394();
	}
}
