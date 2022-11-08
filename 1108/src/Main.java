import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_1439() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		int cnt0 = 0;
		int cnt1 = 0;
		char prev = ' ';
		for (int i = 0; i < S.length(); i++) {
			if (i == 0) {
				if (S.charAt(i) == '0')	cnt0++;
				else					cnt1++;
			}
			else {
				if (prev != S.charAt(i)) {
					if (S.charAt(i) == '0')	cnt0++;
					else					cnt1++;
				}
			}
			prev = S.charAt(i);
		}
		
		System.out.println(Math.min(cnt0, cnt1));
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1439();
	}
}
