import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1253() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);

		int count = 0;
		for (int i = 0; i < N; i++) {
			int start = 0;
			int end = N-1;
			while (start < end) {
				int val = num[start] + num[end];
				if (val > num[i] || end == i)			end--;
				else if (val < num[i] || start == i)	start++;
				else {
					count++;
					break;
				}
			}
		}
		
		
		System.out.println(count);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1253();
	}
}
