import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class SOL1722 {
	
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static long[] FACTORIAL;
	
	public SOL1722() {
		
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		if (sb == null) {
			sb = new StringBuilder();
		}
		
		if (FACTORIAL == null) {
			FACTORIAL = new long[21];
			FACTORIAL[0] = FACTORIAL[1] = 1;
			for (int i = 2; i <= 20; i++) {
				FACTORIAL[i] = i * FACTORIAL[i-1];
			}
		}
	}
	
	public int N;
	
	public void run() throws Exception {
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cmd = Integer.parseInt(st.nextToken());
			
		if (cmd == 1) {
			// 받은 번호를 0번부터 시작하는 숫자로 바꾼다.
			long curr = Long.parseLong(st.nextToken()) - 1;
			ArrayList<Integer> arr = solution1(curr);
			for (int i : arr) {
				sb.append(i).append(' ');
			}
		}
			
		if (cmd == 2) {
			ArrayList<Integer> arr = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			long idx = solution2(arr);
			sb.append(idx);
		}
		
		System.out.println(sb);
	}
	
	public ArrayList<Integer> solution1(long num) {
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		boolean[] isUsed = new boolean[N+1];
		
		for (int n = N-1; n > 0; n--) {
			
			// 몇 번째 요소를 넣어야 하는지 확인
			int idx = (int) (num / FACTORIAL[n]);
			
			// idx번째 요소를 찾아 넣는다.
			int idxCnt = -1;
			for (int i = 1; i <= N; i++) {
				if (!isUsed[i]) {
					idxCnt++;
				}
				if (idxCnt == idx) {
					isUsed[i] = true;
					arr.add(i);
					break;
				}
			}
			
			num %= FACTORIAL[n];
		}
		
		// 마지막 요소 찾아 넣기
		for (int i = 1; i <= N; i++) {
			if (!isUsed[i]) {
				arr.add(i);
				break;
			}
		}

		return arr;
		
	}
	
	public long solution2(ArrayList<Integer> arr) {
		
		long ans = 0;
		
		boolean[] isUsed = new boolean[N+1];
		
		int n = N-1;	
		for (int a : arr) {
			
			// 몇 번째 요소인지 계산한다.
			int idx = 0;
			for (int i = 1; i <= N; i++) {
				if (i == a) {
					isUsed[i] = true;
					break;
				}
				if (!isUsed[i]) {
					idx++;
				}
			}
			
			ans = ans + idx * FACTORIAL[n];
			n--;
		}
		
		return ans + 1;
	}
}
