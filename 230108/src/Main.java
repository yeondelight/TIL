import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_19941() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		int strLen = str.length();
		
		int ans = 0;
		Queue<Integer> H = new LinkedList<>();
		Queue<Integer> P = new LinkedList<>();
		
		for (int i = 0; i < strLen; i++) {
			char curr = str.charAt(i);
			if (curr == 'H') {				// 햄버거
				boolean eaten = false;
				while(!P.isEmpty()) {		// 안먹은 사람이 있으면
					int lastP = P.poll();
					if (i - lastP <= K) {	// 그 중 조건을 만족하는 가장 먼 사람이 먹는다.
						ans++;
						eaten = true;
						break;
					}
				}
				if (!eaten) {				// 못먹었으면 위치 갱신
					H.offer(i);
				}
			} else {						// 사람
				boolean eaten = false;
				while(!H.isEmpty()) {		// 안먹은 햄버거가 있으면
					int lastH = H.poll();
					if (i - lastH <= K) {	// 그 중 조건을 만족하는 가장 먼 햄버거를 먹는다.
						ans++;
						eaten = true;
						break;
					}
				}
				if (!eaten) {				// 못먹었으면 위치 갱신
					P.offer(i);
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public void sol_20115() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		double sum = (double)num[N-1];
		for (int i = 0; i < N-1; i++) {
			double val = (double)num[i] / 2.0;
			sum += val;
		}
		
		DecimalFormat df = new DecimalFormat("#.#####");
		System.out.println(df.format(sum));
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_20115();
	}
}
