import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, S;
	public static int count;
	public static int[] num;
	public static boolean[] check;
	
	public void backtracking(int idx, int sum) {
		if (sum == S && idx != 0) {
			count++;
		}
		for (int i = idx; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				backtracking(i+1, sum + num[i]);
				check[i] = false;
			}
		}
	}

	public void sol_1182() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		num = new int[N];
		check = new boolean[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			check[i] = false;
		}
		
		backtracking(0, 0);
		System.out.println(count);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1182();
	}
}
