import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public boolean checkPseudoPalindrome (String str, int l, int r) {
		while (l < r) {
			if (str.charAt(l) == str.charAt(r)) {
				l++;
				r--;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public void sol_17609() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			int l = 0;
			int r = str.length() - 1;
			int ans = 0;
			while (l < r) {
				if (str.charAt(l) == str.charAt(r)) {
					l++;
					r--;
				} else {
					boolean left = checkPseudoPalindrome(str, l + 1, r);
					boolean right = checkPseudoPalindrome(str, l, r - 1);
					if (left || right) {
						ans = 1;
						break;
					} else {
						ans = 2;
						break;
					}
				}
			}
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_17609();
	}
}
