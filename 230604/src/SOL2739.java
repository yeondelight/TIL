import java.io.BufferedReader;
import java.io.InputStreamReader;

class SOL2739 {

	public static BufferedReader br;
	
	public int N;
	public StringBuilder sb;
	
	public SOL2739() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
	}
	
	public void solution() {
		sb = new StringBuilder();
		for (int i = 1; i < 10; i++) {
			sb.append(N).append(" * ").append(i).append(" = ");
			sb.append(N*i).append('\n');
		}
	}
	
	public void print() {
		System.out.println(sb);
	}
}
