import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1072() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long Z = (long) (Y * 100 / X);
		
		double val = (double) ((Z + 1) * X - 100 * Y) / (99 - Z);
		long ans = (long) Math.ceil(val);
		
		if (ans <= 0 || Z == 99)	System.out.println(-1);
		else						System.out.print(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1072();
	}
}
