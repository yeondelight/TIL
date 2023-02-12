import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static BufferedReader br;
	public static StringBuilder sb;
	public static int N;
	
	public void printStar(int n, int lineNum) {
		if (n == 1) {
			sb.append('*');
			return;
		} else {
			int len = 4 * n - 3;	// 가장 긴 변의 길이 : 4n - 3
			if (lineNum == 0 || lineNum == len - 1) {		// 첫줄 or 마지막줄
				for (int i = 0; i < len; i++) {
					sb.append('*');
				}
			}
			else if (lineNum == 1 || lineNum == len - 2) {	// 두번째 or 마지막 하나 뒤
				sb.append('*');
				for (int i = 0; i < len - 2; i++) {
					sb.append(' ');
				}
				sb.append('*');
			}
			else {											// 그 외에는 n-1번째 호출이 필요함
				sb.append('*').append(' ');
				printStar(n-1, lineNum - 2);
				sb.append(' ').append('*');
			}
		}
	}
	
	public void sol_10994() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		int len = 4 * N - 3;
		for (int i = 0; i < len; i++) {
			printStar(N, i);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_10994();
	}
}
