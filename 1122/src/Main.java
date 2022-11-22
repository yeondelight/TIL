import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_2864() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		int minA = Integer.parseInt(A.replace('6', '5'));
		int minB = Integer.parseInt(B.replace('6', '5'));
		
		int maxA = Integer.parseInt(A.replace('5', '6'));
		int maxB = Integer.parseInt(B.replace('5', '6'));
		
		System.out.println((minA+minB) + " " + (maxA+maxB));
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2864();
	}
}
