import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL1790 {
	
	public static BufferedReader br;
	
	public SOL1790() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	public int N, k;
	public int ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	}
	
	public void solution() {
		
		// 0. 가능한 자리수인가?
		int maxLen = getMaxLen();
		if (maxLen < k) {
			ans = -1;
			return;
		}
		
		// 1. 몇자리수 영역인가?
		int len = 1;
		int cnt = 9;
		
		int kCopy = k;
		while (kCopy > 0) {
			int currVal = (cnt * len);
			if (kCopy > currVal) {
				kCopy -= currVal;
				cnt *= 10;
				len++;
			}
			else {
				break;
			}
		} // len자리수 영역
		
		// 2. 몇의자리수인가?
		int div = (kCopy + len - 1) / len - 1;	// div번째 len자리수
		int mod = (kCopy + len - 1) % len;		// 의 mod번째 위치에 있는 수
		
		int unit = cnt / 9;
		if (mod == 0) {				// 0번째에 위치해있으면
			ans = div / unit + 1;	// 0부터 시작하는 수는 없으니까 하나 보정해줌
		}
		else {
			for (int i = 0; i < mod; i++) {
				div %= unit;
				unit /= 10;
			}
			if (div < unit)	ans = div % unit;
			else			ans = div / unit;
		}
	}
	
	public void print() {
		System.out.println(ans);
	}
	
	public int getMaxLen() {
		
		int len = 1;
		int cnt = 9;
		int val = 0;
		
		int n = N;
		while (n >= cnt) {
			val += (cnt * len);
			n -= cnt;
			cnt *= 10;
			len++;
		}
		
		val += (n * len);
		
		return val;
	}
}
