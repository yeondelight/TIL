import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class SOL2840 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N, K;
	public char[] circle;
	
	public int currIdx;
	public boolean canPrint;
	public boolean[] charDuplicate;
	
	public void run() throws Exception {
		init();
		solution();
		print();
	}
	
	public void init() throws Exception {
		StringTokenizer stNK = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNK.nextToken());
		K = Integer.parseInt(stNK.nextToken());
		
		circle = new char[N];
	}
	
	public void solution() throws Exception {
		
		// circle init
		Arrays.fill(circle, '?');
		currIdx = 0;
		
		// rotate
		charDuplicate = new boolean[26];
		for (int k = 0; k < K; k++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int rotateCnt = Integer.parseInt(st.nextToken()) % N;
			char val = st.nextToken().charAt(0);
			
			currIdx = (currIdx - rotateCnt + N) % N;
			
			
			if (circle[currIdx] == val) {
				canPrint = true;
			}
			else if (circle[currIdx] == '?' && !charDuplicate[val-'A']) {
				canPrint = true;
				circle[currIdx] = val;
				charDuplicate[val-'A'] = true;
			} else {
				canPrint = false;
				break;
			}
		}
		
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		
		if (!canPrint) {
			sb.append('!');
		}
		else {
			int idx = currIdx;
			for (int i = 0; i < N; i++) {
				sb.append(circle[idx]);
				idx = (idx + 1 + N) % N;
			}
		}
		
		System.out.println(sb);
	}
}
