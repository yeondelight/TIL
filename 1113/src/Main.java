import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
	
	public void sol_15904() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String P = "^\\D*U\\D*C\\D*P\\D*C\\D*$";
		
		boolean flag = Pattern.matches(P, S);
		
		if (flag)	System.out.println("I love UCPC");
		else		System.out.println("I hate UCPC");
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_15904();
	}
}
