import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_18310() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// scan
		int N = Integer.parseInt(br.readLine());
		int[] home = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(home);
		
		
		// cal dist
		if (N % 2 == 0) {
			System.out.println(home[N/2-1]);
		} else {
			System.out.println(home[N/2]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_18310();
	}
}
