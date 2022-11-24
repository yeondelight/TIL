import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_2810() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		boolean check = S.contains("LL");
		if (check) {
			S = S.replace("LL", "S");
			System.out.println(S.length()+1);
		}
		else {
			System.out.println(S.length());
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2810();
	}
}
