import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_10972() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 내림차순이 끝나는 지점 찾기
		int i;
		int endOfDes = N-1;
		for (i = N-1; i > 0; i--) {
			if (num[i-1] < num[i]) {
				endOfDes = i-1;
				break;
			}
		}
		
		// 만약 내가 마지막이면
		if (i == 0) {
			System.out.println(-1);
			return;
		}
		
		
		// 자리를 교체할 수 찾기
		int wannaChange = N-1;
		for (i = N-1; i > endOfDes; i--) {
			if (num[endOfDes] < num[i]) {
				wannaChange = i;
				break;
			}
		}
		
		
		// 두 수 교체
		int temp = num[endOfDes];
		num[endOfDes] = num[wannaChange];
		num[wannaChange] = temp;
		
		
		// 바꾼 수 뒤의 값들은 오름차순 정렬해야함
		Arrays.sort(num, endOfDes+1, N);
		
		
		// print
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < N; i++) {
			sb.append(num[i]).append(' ');
		}
		
		System.out.println(sb);
	}
	
	public void sol_10973() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] num = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순이 끝나는 지점 찾기
		int i;
		int endOfInc = 0;
		for (i = N-1; i > 0; i--) {
			if (num[i-1] > num[i]) {
				endOfInc = i-1;
				break;
			}
		}
		
		// 만약 내가 마지막이면
		if (i == 0) {
			System.out.println(-1);
			return;
		}
		
		
		// 자리를 교체할 수 찾기
		int wannaChange = 0;
		for (i = N-1; i > endOfInc; i--) {
			if (num[endOfInc] > num[i]) {
				wannaChange = i;
				break;
			}
		}
		
		
		// 두 수 교체
		int temp = num[endOfInc];
		num[endOfInc] = num[wannaChange];
		num[wannaChange] = temp;
		
		
		// 바꾼 수 뒤의 값들은 오름차순 정렬해야함
		Arrays.sort(num, endOfInc+1, N, Collections.reverseOrder());
		
		
		// print
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < N; i++) {
			sb.append(num[i]).append(' ');
		}
		
		System.out.println(sb);
	}
	
	
	
	public static void main(String[] args) throws Exception {
		new Main().sol_10973();
	}
}
