import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_9237() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] tree = new Integer[N]; 
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(tree, Collections.reverseOrder());
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, tree[i] + i);
		}
		
		System.out.println(ans + 2);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_9237();
	}
}
