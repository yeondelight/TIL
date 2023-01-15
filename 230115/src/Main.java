import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_17615() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String ball = br.readLine();
		
		int red = 0;
		int blue = 0;
		int prevCum = 0;		// 같은 공이 누적된 합 : 처음
		int finalCum = 0;		// 같은 공이 누적된 합 : 마지막
		char prev = ball.charAt(0);
		
		for (int i = 0; i < N; i++) {
			char curr = ball.charAt(i);
			if (curr == 'R')	red++;
			else				blue++;
			if (prev == curr)	finalCum++;
			else {
				if (prevCum == 0) {
					prevCum = finalCum;
				}
				finalCum = 1;
			}
			prev = curr;
		}
		
		// 앞쪽으로 미는 경우
		int toFrontRed, toFrontBlue;
		if (ball.charAt(0) == 'R') {
			toFrontRed = red - prevCum;
			toFrontBlue = blue;
		}
		else {
			toFrontRed = red;
			toFrontBlue = blue - prevCum;
		}
		int toFront = Math.min(toFrontRed, toFrontBlue);
		
		// 뒤로 미는 경우
		int toBackRed, toBackBlue;
		if (ball.charAt(N-1) == 'R') {
			toBackRed = red - finalCum;
			toBackBlue = blue;
		}
		else {
			toBackRed = red;
			toBackBlue = blue - finalCum;
		}
		int toBack = Math.min(toBackRed, toBackBlue);
		
		System.out.println(Math.min(toFront, toBack));
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_17615();
	}
}
