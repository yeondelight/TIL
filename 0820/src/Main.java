import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1806() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int len = N;	// 최소 길이
		boolean check = false;
		
		// 0부터 N-1까지를 시작점으로 잡는다.
		for (int i = 0; i < N; i++) {
			int sum = 0;
			// i부터 N-1까지를 끝점으로 잡고
			for (int j = i; j < N; j++) {
				sum += arr[j];	// i부터 j까지의 합 계산
				if (sum >= S) {	// 그 합이 S 이상이라면
					check = true;
					len = Math.min(len, j - i + 1);		// 최소길이 갱신
					break;								// j를 더 돌 필요 없으므로 탈출
				}
			}
		}
		
		if (check)	System.out.println(len);	// 합이 된다면 길이
		else		System.out.println(0);		// 합이 안된다면 0
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1806();
	}
}
