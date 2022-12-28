import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public void sol_11931() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		
		StringBuilder sb = new StringBuilder();
		for (int i = N-1; i >= 0; i--) {
			sb.append(num[i]).append('\n');
		}
		
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {
		new Main().sol_11931();
	}
}
