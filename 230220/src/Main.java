import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	public void sol_2659() throws Exception {
		// get all cross nums
		TreeSet<Integer> crossNum = new TreeSet<>();
		
		for (int n = 1111; n < 10000; n++) {			
			int temp = n;
			int[] num = new int[4];
			boolean isCrossNum = true;
			
			for (int i = 3; i >= 0; i--) {
				num[i] = temp % 10;
				temp /= 10;
				
				if (num[i] == 0) {	// 십자수엔 0이 없다
					isCrossNum = false;
					break;
				}
			}
			
			if (!isCrossNum) {
				continue;
			}
			
			int minCrossNum = 9999;
			
			for (int i = 0; i < 4; i++) {	// i를 기준으로 시계방향 돌기
				int val = 0;
				for (int j = 0; j < 4; j++) {
					int idx = (i + j) % 4;
					val *= 10;
					val += num[idx];
				}
				minCrossNum = Math.min(minCrossNum, val);
			}
			
			crossNum.add(minCrossNum);
		}
		
		
		// get input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num = new int[4];
		for (int i = 0; i < 4; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// get target num
		int target = 9999;
		
		for (int i = 0; i < 4; i++) {	// i를 기준으로 시계방향 돌기
			int val = 0;
			for (int j = 0; j < 4; j++) {
				int idx = (i + j) % 4;
				val *= 10;
				val += num[idx];
			}
			target = Math.min(target, val);
		}
		
		
		// cal num
		int cnt = 0;
		for (int i : crossNum) {
			cnt++;
			if (i == target) {
				break;
			}
		}
		
		
		// print
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2659();
	}
}
