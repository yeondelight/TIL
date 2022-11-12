import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_1343() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String S = br.readLine();
		S = S.replace("XXXX", "AAAA");
		S = S.replace("XX", "BB");
		
		boolean flag = true;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'X') {
				flag = false;
				break;
			}
		}
		
		if (flag)	System.out.println(S);
		else		System.out.println("-1");
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1343();
	}
}
