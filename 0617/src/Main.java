import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_9655() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if (N % 2 == 0)	System.out.println("CY");
		else			System.out.println("SK");
	}
	
	public void sol_2693() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		int[] nums;
		for(int i = 0; i < N; i++) {
			nums = new int[10];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			
			sb.append(nums[7]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception{
		new Main().sol_2693();
	}
}
