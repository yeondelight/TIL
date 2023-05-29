import java.io.BufferedReader;
import java.io.InputStreamReader;

class SOL10872 {
	
	public static BufferedReader br;
	
	public int N;
	public int ans;
	
	public SOL10872() {
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
		ans = 1;
		for (int i = 1; i <= N; i++) {
			ans *= i;
		}
	}
	
	public void print() {
		System.out.println(ans);
	}
}
