import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	
	public void sol_2502() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] f1 = new int[D+1];
		int[] f2 = new int[D+1];
		f1[1] = 1;
		f2[2] = 1;
		for (int i = 3; i <= D; i++) {
			f1[i] = f1[i-1] + f1[i-2];
			f2[i] = f2[i-1] + f2[i-2];
		}
		
		// K = f1 * A + f2 * B;
		for (int A = 1; ; A++) {
			for (int B = A; ; B++) {
				int val = A * f1[D] + B * f2[D];
				if (val == K) {
					System.out.println(A);
					System.out.println(B);
					return;
				}
				if (val > K) {
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2502();
	}
}
