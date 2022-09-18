import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int L, C;
	public static char[] ch, ans;
	public static StringBuilder sb = new StringBuilder();
	
	public void backtracking(int idx, int cnt) {
		if (cnt == L) {
			int consonant = 0;	// 최소 2개의 자음
			int collection = 0;	// 최소 하나의 모음
			for (int i = 0; i < L; i++) {
				switch(ans[i]) {
				case 'a': case 'e': case 'i': case 'o': case 'u':
					collection++;
					break;
				default:
					consonant++;
					break;
				}
			}
			if (consonant >= 2 && collection >= 1) {	// 조건 만족시 출력
				for (int i = 0; i < L; i++) {
					sb.append(ans[i]);
				}
				sb.append('\n');
			}
			return;
		}
		else {
			for (int i = idx; i < C; i++) {
				ans[cnt] = ch[i];
				backtracking(i+1, cnt+1);
			}
		}
	}
	
	public void sol_1759() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ch = new char[C];
		ans = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			ch[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(ch);
		
		backtracking(0, 0);
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1759();
	}
}
