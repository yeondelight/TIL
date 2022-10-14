import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int[] ans;
	public static char[] comp;
	public static boolean[] check;
	public static String max, min;
	
	
	public void backtracking(int curr, int len) {
		if (len == N) {
			// compare
			String sum = "";
			for (int i = 0; i <= N; i++) {
				sum += ans[i];
			}
			if (max.compareTo(sum) < 0)	max = sum;
			if (min.compareTo(sum) > 0)	min = sum;
			return;
		}
		if (comp[len] == '<') {
			for (int i = curr+1; i < 10; i++) {
				if (!check[i]) {
					check[i] = true;
					ans[len+1] = i;
					backtracking(i, len+1);
					check[i] = false;
				}
			}
		}
		else {
			for (int i = curr-1; i >= 0; i--) {
				if (!check[i]) {
					check[i] = true;
					ans[len+1] = i;
					backtracking(i, len+1);
					check[i] = false;
				}
			}
		}
	}
	
	public void sol_2529() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		comp = new char[N];
		ans = new int [N+1];
		max = "";
		min = "";
		check = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			comp[i] = st.nextToken().charAt(0);
			max += '0';
			min += '9';
		}
		
		for (int i = 0; i < 10; i++) {
			check[i] = true;
			ans[0] = i;
			backtracking(i, 0);
			check[i] = false;
		}
		

		System.out.println(max);
		System.out.println(min);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2529();
	}
}
