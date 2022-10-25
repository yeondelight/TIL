import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.regex.Pattern;

public class Main {
	
	public void sol_1013() throws Exception {
		String P = "^(100+1+|01)+$";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			boolean match = Pattern.matches(P, S);
			if (match)	sb.append("YES");
			else		sb.append("NO");
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public boolean checkPalindrome(Vector<Character> vec) {
		int i, j;
		int finIdx = vec.size() / 2;
		for (i = 0, j = vec.size() - 1; i <= finIdx; i++, j--) {
			if (vec.get(i) != vec.get(j)) {
				return false;
			}
		}
		return true;
	}
	
	public void sol_1254() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		// 효율성을 위해 문자열을 벡터로 이동
		Vector<Character> sVec = new Vector<>();
		for (int i = 0; i < S.length(); i++) {
			sVec.add(S.charAt(i));
		}
		
		// 문자열이 팰린드롬이 아닌 경우에만 push
		if (!checkPalindrome(sVec)) {
			// 추가할 index 설정
			int addIdx = S.length();
			for (int i = 0; i < S.length(); i++) {
				sVec.add(addIdx, S.charAt(i));
				if (checkPalindrome(sVec)) {
					break;
				}
			}
		}
		
		// 최종 Vector의 크기 출력
		System.out.println(sVec.size());
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1254();
	}
}
