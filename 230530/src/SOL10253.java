import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL10253 {

	public static BufferedReader br;
	
	public SOL10253() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	public int a, b;
	public int ans;
	
	public void run() throws Exception {
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			getInput();
			solution();
			sb.append(b).append('\n');
		}
		System.out.println(sb);
	}
	
	public void getInput() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
	}
	
	public void solution() {		
		while (a > 1) {
			int x = b / a + 1;	
			
			a = a * x - b;
			b *= x;
			
			int gcd = getGCD(a, b);
			a /= gcd;
			b /= gcd;
		}
		
	}
	
	public int getGCD(int a, int b) {
		if (a < b)	return getGCD(b, a);
		if (b == 0)	return a;
		else		return getGCD(b, a%b);
	}
}
