import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL1817 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N, M;
	public int[] book;
	
	public int ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		
		if (N == 0) {
			return;
		}
		
		book = new int[N];
		StringTokenizer stBook = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			book[i] = Integer.parseInt(stBook.nextToken());
		}
	}
	
	public void solution() {
		
		if (N == 0) {
			return;
		}
		
		ans = 1;
		int currWeight = 0;
		
		for (int i = 0; i < N; i++) {
			
			// 현재 책을 기존의 박스에 넣을 수 있는 경우
			if (currWeight + book[i] <= M) {
				currWeight += book[i];
				continue;
			}
			
			// 그 외 경우 새 박스 까야함
			else {
				ans++;
				currWeight = book[i];
			}
		}
	}
	
	public void print() {
		System.out.println(ans);
	}

}