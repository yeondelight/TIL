import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	
	public void sol_1339() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Integer[] mappingNum = new Integer[26];		// A-Z에 대응하는 숫자
		for (int i = 0; i < 26; i++) {
			mappingNum[i] = 0;
		}
		
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			int cntNum = 1;
			for (int j = S.length() - 1; j >= 0; j--) {
				int idx = S.charAt(j) - 'A';
				mappingNum[idx] += cntNum;
				cntNum *= 10;
			}
		}
		
		Arrays.sort(mappingNum, Collections.reverseOrder());
		
		int sum = 0;
		for (int i = 9, j = 0; i > 0; i--, j++) {
			if (mappingNum[j] == 0) {
				break;
			}
			sum += (i * mappingNum[j]);
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1339();
	}
}
