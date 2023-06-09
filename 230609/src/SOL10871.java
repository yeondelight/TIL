import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL10871 {
	
	public static BufferedReader br;
	
	public SOL10871() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	public void run() throws Exception {
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer stNX = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNX.nextToken());
		int X = Integer.parseInt(stNX.nextToken());
		
		StringTokenizer stNum = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int curr = Integer.parseInt(stNum.nextToken());
			if (curr < X) {
				sb.append(curr).append(' ');
			}
		}
		
		System.out.println(sb);
	}
}
