import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	
	public static int[] main;
	public static int[] cmp;
	
	public void sol_2607() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 첫 단어의 정보 저장
		String firstWord = br.readLine();
		main = new int[26];
		
		for (int i = 0; i < firstWord.length(); i++) {
			main[firstWord.charAt(i) - 'A']++;
		}
		
		

		int cnt = 0;
		for (int n = 0; n < N - 1; n++) {
			// 이후 단어들의 정보 받기
			String nextWord = br.readLine();
			
			cmp = new int[26];
			
			for (int i = 0; i < nextWord.length(); i++) {
				cmp[nextWord.charAt(i) - 'A']++;
			}
			
			
			// 구성이 같은지 확인
			int strDiff = 0;
			for (int i = 0; i < 26; i++) {
				strDiff += Math.abs(main[i] - cmp[i]);
			}
			
			
			// 두 문자열이 다를 수 있는건 최대 2개의 문자
			// 길이 차이는 1 미만이어야 한다.
			if (strDiff <= 2 && Math.abs(firstWord.length() - nextWord.length()) <= 1) {
				cnt++;
			}
			
		}	// end of for(n);
		
		// 결과 출력
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2607();
	}
}
