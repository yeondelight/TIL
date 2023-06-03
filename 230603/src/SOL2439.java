import java.io.BufferedReader;
import java.io.InputStreamReader;

class SOL2439 {

	public static BufferedReader br;
	
	public int N;
	
	public SOL2439() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	public void run() throws Exception {
		getInput();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = N; j > i; j--) {
				sb.append(' ');
			}
			for (int j = 1; j <= i; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
