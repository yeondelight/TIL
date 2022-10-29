import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_10930() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(str.getBytes());
		
		StringBuilder sb = new StringBuilder();
		for (byte b : md.digest()) {
			sb.append(String.format("%02x", b));
		}
		
		System.out.println(sb);
	}
	
	public void sol_3613() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		boolean isJava = false;
		boolean isCplus = false;
		boolean isError = false;
		
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '_') {
				if (i == 0 || i == S.length() - 1 || S.charAt(i-1) == '_') {
					isError = true;
					break;
				}
				isCplus = true;
			}
			if (Character.isUpperCase(S.charAt(i))) {
				if (i == 0) {
					isError = true;
					break;
				}
				isJava = true;
			}
		}
		
		// 둘 다 만족하는 경우
		// 첫 글자가 대문자인 경우 - isError에서 처리
		// 첫 || 마지막 글자가 '_'인 경우 - isError에서 처리
		// 두 번 연속으로 '_'가 쓰인 경우 - isError에서 처리
		if (isCplus && isJava || isError) {
			System.out.println("Error!");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		
		// C++ 형식인 경우
		if (isCplus) {
			StringTokenizer st = new StringTokenizer(S, "_");
			boolean isFirst = true;
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				for (int i = 0; i < token.length(); i++) {
					if (i == 0) {
						if (isFirst) {
							sb.append(token.charAt(i));
							isFirst = false;
						}
						else {
							sb.append(Character.toUpperCase(token.charAt(i)));
						}
					}
					else		sb.append(token.charAt(i));
				}
			}
		}
		
		// Java 형식인 경우
		else {
			for (int i = 0; i < S.length(); i++) {
				if (i == 0) {
					sb.append(Character.toLowerCase(S.charAt(i)));
					continue;
				}
				if (Character.isUpperCase(S.charAt(i))) {
					sb.append('_');
					sb.append(Character.toLowerCase(S.charAt(i)));
					continue;
				}
				else {
					sb.append(S.charAt(i));
				}
			}
		}
		
		System.out.println(sb);
	}
	
	public static void main (String[] args) throws Exception {
		new Main().sol_3613();
	}
}
