import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public int ans;
	
	public void getSatisfy(int val) {
		if (val == 1) {
			return;
		}
		if (val % 2 == 0) {
			ans += (val/2) * (val/2);
			getSatisfy(val/2);
			getSatisfy(val/2);
		} else {
			ans += (val/2) * (val/2 + 1);
			getSatisfy(val/2);
			getSatisfy(val/2 + 1);
		}
	}
	
	public void sol_14606() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		getSatisfy(N);
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_14606();
	}
}
