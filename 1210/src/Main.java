import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1041() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] dice = new long[6];
		for (int i = 0; i < 6; i++) {
			dice[i] = Long.parseLong(st.nextToken());
		}
		
		if (N == 1) {
			long ans = 0;
			Arrays.sort(dice);
			for (int i = 0; i < 5; i++) {
				ans += dice[i];
			}
			System.out.println(ans);
		}
		else {
			// 주사위 작은쪽 설정
			long[] min = new long[3];
			min[0] = Math.min(dice[0], dice[5]);
			min[1] = Math.min(dice[1], dice[4]);
			min[2] = Math.min(dice[2], dice[3]);
			Arrays.sort(min);
			
			long[] show = new long[3];
			show[0] = 4L*(N-2) + 5L*(N-2)*(N-2);
			show[1] = 8L*(N-2) + 4L;
			show[2] = 4L;
			long sum = 0;
			long ans = 0;
			for (int i = 0; i < 3; i++) {
				sum += min[i];
				ans += sum * show[i];
			}
			
			System.out.println(ans);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1041();
	}
}
