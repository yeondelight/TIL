import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1105() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String strL = st.nextToken();
		String strR = st.nextToken();

		// R이 L보다 길면 8 없이 만들 수 있음
		if (strL.length() != strR.length()) {
			System.out.println(0);
			return;
		}
		
		int cnt = 0;
		int repeat = strR.length();
		
		int L = Integer.parseInt(strL);
		int R = Integer.parseInt(strR);
		
		int unit = 1;
		for (int i = 1; i < repeat; i++) {
			unit *= 10;
		}
		
		// 앞에서부터 공통부분을 탐색한다.
		for (int i = 0; i < repeat; i++) {
			int curL = L / unit;
			int curR = R / unit;
			if (curL != curR) {		// 공통부분이 끝남 : break;
				break;
			}
			if (curL == 8) {	// 공통부분에 8이 있음 : cnt++
				cnt++;
			}
			L %= unit;
			R %= unit;
			unit /= 10;
		}
		
		System.out.println(cnt);
		
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1105();
	}
}
