import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int A, B;
	
	public static int[] num;
	public static int size;
	
	public static boolean[] visited;
	public static int[] res;
	public static int ans;
	
	public void backtracking(int depth) {
		if (depth == size) {
			if (res[0] != 0) {	// 0으로 시작하지 않는다.
				int val = 0;
				for (int i = 0; i < size; i++) {
					val *= 10;
					val += res[i];
				}
				if (val < B) {	// B보다 작은 수여야 한다.
					ans = Math.max(ans, val);
				}
			}
		}
		
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				visited[i] = true;
				res[depth] = num[i];
				backtracking(depth+1);
				visited[i] = false;
			}
		}
	}

	public void sol_16943() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String strA = st.nextToken();
		A = Integer.parseInt(strA);
		B = Integer.parseInt(st.nextToken());

		// A의 숫자 배열로 저장하기
		size = strA.length();
		num = new int[size];
		
		for(int i = 0; i < size; i++) {
			num[i] = strA.charAt(i) - '0';
		}
		Arrays.sort(num);
		
		// backtracking
		visited = new boolean[size];
		res = new int[size];
		backtracking(0);
		
		// print
		if (ans != 0)	System.out.println(ans);
		else			System.out.println(-1);		// 0인 경우 만족하는 수가 없었다는 의미
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_16943();
	}
	
}
