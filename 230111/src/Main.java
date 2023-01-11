import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_4889() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 1;
		
		while (true) {
			String str = br.readLine();
			
			// 입력의 마지막 줄인 경우 탈출
			if (str.charAt(0) == '-') {
				break;
			}
			
			int ans = 0;
			int stackSize = 0;
			for (int i = 0; i < str.length(); i++) {
				char curr = str.charAt(i);
				if (curr == '{') {
					stackSize++;
				} else {
					if (stackSize == 0) {
						ans++;
					} else {
						stackSize--;
					}
				}
			}
			
			ans = (ans+1)/2;
			ans += (stackSize+1)/2;
			
			sb.append(T).append(". ").append(ans).append('\n');
			
			T++;
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_4889();
	}
}
