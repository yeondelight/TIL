import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_5585() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int val = 1000 - N;
		
		int ans = 0;
		
		ans += (val/500);
		val %= 500;
		
		ans += (val/100);
		val %= 100;
		
		ans += (val/50);
		val %= 50;
		
		ans += (val/10);
		val %= 10;
		
		ans += (val/5);
		val %= 5;
		
		ans += val;
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_5585();
	}
}
