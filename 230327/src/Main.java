import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1024() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		boolean flag = false;
		int[] numList = new int[2];
		
		for (int l = L; l <= 100; l++) {
			
			// 길이가 짝수이면
			// N % L == L / 2여야 만들 수 있다.
			if ((l % 2 == 0) && (N % l == l / 2)) {
				int center = N / l;
				int diffVal = l / 2;
				numList[0] = center - diffVal + 1;
				numList[1] = center + diffVal;
				if (numList[0] >= 0) {	// 모든 수가 음의 정수가 아님을 체크
					flag = true;
					break;
				}
			}
			
			// 길이가 홀수이면
			// N % L == 0여야 만들 수 있다.
			if ((l % 2 == 1) && (N % l == 0)) {
				int center = N / l;
				int diffVal = l / 2;
				numList[0] = center - diffVal;
				numList[1] = center + diffVal;
				if (numList[0] >= 0) {	// 모든 수가 음의 정수가 아님을 체크
					flag = true;
					break;
				}
			}
		}

		
		// print
		if (flag) {
			StringBuilder sb = new StringBuilder();
			for (int i = numList[0]; i <= numList[1]; i++) {
				sb.append(i).append(' ');
			}
			System.out.println(sb);
		}
		else {
			System.out.println(-1);
		}
	}

	public void sol_1500() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long val = 1;
		int div = S / K;
		int mod = S % K;
		
		for (int i = 0; i < mod; i++)	val *= (div+1);
		for (int i = 0; i < K-mod; i++)	val *= div;
		
		System.out.println(val);
	}
	
	public void sol_17427() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += ((N/i) * i);
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_17427();
	}
}
