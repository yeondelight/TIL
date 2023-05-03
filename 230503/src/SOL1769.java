import java.io.BufferedReader;
import java.io.InputStreamReader;

class SOL1769 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int X;
	public String strX;
	
	public int cnt;
	public boolean is3;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		strX = br.readLine();
		
		if (strX.length() == 1) {	// 한 자리 수인 경우 바로 판단 가능하다.
			cnt = 0;
			X = Integer.parseInt(strX);
		}
		else {						// 그 외 경우 적어도 한 번은 변환해야한다.
			cnt = 1;
			for (int i = 0; i < strX.length(); i++) {
				X += strX.charAt(i) -'0';
			}
		}
	}
	
	public void solution() {
		
		while (X / 10 > 0) {
			
			// 1. 횟수 카운트
			cnt++;	
			
			// 2. 각 자릿수별 합산
			int Y = 0;
			while (X / 10 > 0) {
				Y += X % 10;
				X /= 10;
			}
			Y += X;
			
			// 3. X값 갱신
			X = Y;
		}
		
		is3 = (X % 3 == 0);
	}
	
	public void print() {
		System.out.println(cnt);
		if (is3)	System.out.println("YES");
		else		System.out.println("NO");
	}

}