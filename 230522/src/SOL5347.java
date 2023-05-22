import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL5347 {

	public static BufferedReader br;
	public static StringBuilder sb;
	
	public int a, b;
	
	public SOL5347() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		if (sb == null) {
			sb = new StringBuilder();
		}
	}
	
	public void run() throws Exception {
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			getInput();
			solution();
			sb.append('\n');
		}
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stab = new StringTokenizer(br.readLine());
		a = Integer.parseInt(stab.nextToken());
		b = Integer.parseInt(stab.nextToken());
	}
	
	public void solution() {
		int gcd = getGCD(a, b);
		long lcm = (long) (a / gcd) * b;
		sb.append(lcm);
	}
	
	public void print() {
		System.out.println(sb);
	}
	
	public int getGCD(int a, int b) {
		if (a < b)			return getGCD(b, a);
		else if (b == 0)	return a;
		else				return getGCD(b, a%b);
	}
}
