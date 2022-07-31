import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_11054() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dpIn = new int[N];
		int[] dpDe = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		
		// 증가
		for (int i = 0; i < N; i++) {		// A의 모든 원소에 대해 검사
			int index = i;
			for (int j = 0; j < i; j++) {	// 해당 원소의 앞부분을 검사하여
				if ((A[j] < A[i]) && (dpIn[index] < dpIn[j])) {	// 증가하는 경우 계산
					index = j;
				}
			}
			dpIn[i] = dpIn[index] + 1;
		}
		
		
		// 감소 : 역방향으로 증가를 탐색한다.
		for (int i = N-1; i >= 0; i--) {	// A의 모든 원소에 대해 검사
			int index = i;
			for (int j = N-1; j > i; j--) {	// 해당 원소의 앞부분을 검사하여
				if ((A[j] < A[i]) && (dpDe[index] < dpDe[j])) {	// 증가하는 경우 계산
					index = j;
				}
			}
			dpDe[i] = dpDe[index] + 1;
		}
		
		// 증가 + 감소 - 1
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dpIn[i] + dpDe[i] - 1);
		}
				
				
		System.out.println(max);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11054();
	}
}
