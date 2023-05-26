import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class SOL2877 {
	
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public int K;
	public Stack<Integer> ansS;
	
	public SOL2877() {
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
		sb = new StringBuilder();
		K = Integer.parseInt(br.readLine());
	}
	
	public void solution() {
		
		// 저장할 Stack 초기화
		ansS = new Stack<>();
		
		// jari : 몇자리수인지 파악
		// maxJari : 그 자리수로 만들 수 있는 최대 수열의 수
		// 계산 후의 k : 그 자리수로 만들 수 있는 수열 중 몇번째인가
		int k = K;
		int maxJari = 1;
		while (k - maxJari >= 0) {
			k -= maxJari;
			maxJari *= 2;
		}
		
		int jari = (int) (Math.log(maxJari) / Math.log(2));
		
		while (jari > 0) {
			int div = k % 2;
			if (div == 0)	ansS.push(4);
			else			ansS.push(7);
			k /= 2;
			jari--;
		}
		
	}
	
	public void print() {
		while(!ansS.isEmpty()) {
			sb.append(ansS.pop());
		}
		System.out.println(sb);
	}

}
