import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_10162() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int A = 5 * 60;
		int B = 60;
		int C = 10;
		
		int cntA = T / A;
		T %= A;
		
		int cntB = T / B;
		T %= B;
		
		int cntC = T / C;
		T %= C;
		
		if (T != 0)	System.out.println("-1");
		else		System.out.println(cntA + " " + cntB + " " + cntC);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_10162();
	}
}
