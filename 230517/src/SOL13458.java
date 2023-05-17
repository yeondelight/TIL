import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL13458 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N;
	public int[] A;
	public int B, C;
	
	public long ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		StringTokenizer stA = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(stA.nextToken());
		}
		
		StringTokenizer stBC = new StringTokenizer(br.readLine());
		B = Integer.parseInt(stBC.nextToken());
		C = Integer.parseInt(stBC.nextToken());
	}
	
	public void solution() {
		
		// 정감독관 한명씩 배치
		ans = N;
		for (int i = 0; i < N; i++) {
			A[i] = A[i] - B > 0 ? A[i] - B : 0;
		}
		
		// 부감독관 배치 수 계산
		for (int i = 0; i < N; i++) {
			
			int div = A[i] / C;
			int mod = A[i] % C;
			
			if (mod == 0) {
				ans += div;
			} else {
				ans += (div+1);
			}
		}
	}
	
	public void print() {
		System.out.print(ans);
	}
}
