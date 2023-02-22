import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_2503() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] canAnswer = new boolean[1000];
		Arrays.fill(canAnswer, true);
		
		// 아예 나올 수 없는 경우 제외
		for (int i = 0; i < 1000; i++) {
			int i1 = i / 100;
			int i2 = i % 100 / 10;
			int i3 = i % 10;
			if (i1 == 0 || i2 == 0 || i3 == 0) {	// 0은 포함 안됨
				canAnswer[i] = false;
			}
			if (i1 == i2 || i2 == i3 || i3 == i1) {	// 숫자 중복 안됨
				canAnswer[i] = false;
			}
		}
		
		
		for (int t = 0; t < N; t++) {	// t = test case
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			
			// 자리수별로 저장
			int[] origin = { num / 100, num % 100 / 10, num % 10 };
			
			
			for (int n = 123; n <= 987; n++) {
				
				if (!canAnswer[n]) {	// 이미 못한다고 판정났으면 패스
					continue;
				}
				
				// 자리수별로 저장
				int[] cmp = { n / 100, n % 100 / 10, n % 10 };

				// Strike, ball 판단
				int iStrike = 0;
				int iBall = 0;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (i == j && origin[i] == cmp[j])	iStrike++;
						if (i != j && origin[i] == cmp[j])	iBall++;
					}
				}
				
				// Strike, Ball 조건을 모두 만족해야한다.
				if (strike != iStrike || ball != iBall) {
					canAnswer[n] = false;
				}
			}
		}
		
		
		// print
		int cnt = 0;
		for (boolean b : canAnswer) {
			if (b)	cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public void sol_6986() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		double[] score = new double[N];
		for (int i = 0; i < N; i++) {
			score[i] = Double.parseDouble(br.readLine());
		}
		Arrays.sort(score);
		
		
		// 절사평균 구하기
		double cutSum = 0;
		for (int i = K; i < N-K; i++) {
			cutSum += score[i];
		}
		double cutAvg = cutSum / (N-2*K);
		
		// 보정평균 구하기
		double editSum = cutSum + score[K] * K + score[N-K-1] * K;
		double editAvg = editSum / N;
		
		
		// print
		System.out.println(String.format("%.2f", cutAvg));
		System.out.println(String.format("%.2f", editAvg));
	}
	
	public static void main(String[] main) throws Exception {
		new Main().sol_6986();
	}
}
