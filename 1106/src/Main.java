import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_2437() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] weight = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(weight);
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (weight[i] > sum + 1) {;
				break;
			}
			sum += weight[i];
		}
		
		System.out.println(sum+1);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2437();
	}
}
