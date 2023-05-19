import java.io.BufferedReader;
import java.io.InputStreamReader;

class SOL2302 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int MAX = 40;
	
	public int N, M;
	
	public boolean[] isVIP;
	public int ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		isVIP = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			int vip = Integer.parseInt(br.readLine());
			isVIP[vip] = true;
		}
	}
	
	public void solution() {
		
		// get fibos
		int[] fibo = new int[MAX+1];
		fibo[0] = fibo[1] = 1;
		for (int i = 2; i <= MAX; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		// get linked Seats
		ans = 1;
		int linkedSeatCnt = 0;
		for (int i = 1; i <= N; i++) {
			
			if (isVIP[i]) {
				ans *= fibo[linkedSeatCnt];
				linkedSeatCnt = 0;
			}
			else {
				linkedSeatCnt++;				
			}
		}

		ans *= fibo[linkedSeatCnt];
	}
	
	public void print() {
		System.out.println(ans);
	}
}
