import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	public void sol_11478() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		HashSet<String> partS = new HashSet<>();
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 0; j <= S.length() - i; j++) {
				String T = S.substring(j, j+i);
				if (T != null) {
					partS.add(T);
				}
			}
		}
		
		System.out.println(partS.size());
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11478();
	}
}
