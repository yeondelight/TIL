import java.io.BufferedReader;
import java.io.InputStreamReader;

class SOL2741 {
	
	public static BufferedReader br;
	
	public int N;
	public StringBuilder sb;
	
	public SOL2741() {
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
		for (int i = 1; i <= N; i++) {
			sb.append(i);
			sb.append('\n');
		}
	}
	
	public void print() {
		System.out.println(sb);
	}
}
