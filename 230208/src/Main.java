import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1235() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<String> nums = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			nums.add(br.readLine());
		}
		
		int k;
		int numLen = nums.get(0).length();
		
		for (k = 1; k < numLen; k++) {
			
			boolean flag = true;
			HashSet<String> compNum = new HashSet<>();
			
			for (String str : nums) {
				String compStr = str.substring(numLen - k);
				if (compNum.contains(compStr)) {
					flag = false;
					break;
				} else {
					compNum.add(compStr);
				}
			}
			
			if (flag) {
				break;
			}
		}
		
		System.out.println(k);
	}
	
	public void sol_1244() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 스위치 개수
		boolean[] switches = new boolean[N+1];		// 스위치 상태
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			switches[i+1] = st.nextToken().charAt(0) == '1' ? true : false;
		}
		
		int S = Integer.parseInt(br.readLine());	// 학생수 (Student)
		
		for (int k = 0; k < S; k++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());	// 남/여
			int num = Integer.parseInt(st.nextToken());	// 받은 배수
			
			if (sex == 1) {		// 남학생은 자신의 배수에 해당하는 상태 변경
				for (int i = num; i <= N; i += num) {
					switches[i] = !switches[i];
				}
			} else {			// 여학생은 대칭 구간의 상태 모두 변경
				switches[num] = !switches[num];		// 일단 자기자신 먼저 변경
				int maxLen = Math.min(num-1, N-num);	// 최대 대칭 길이
				for (int i = 1; i <= maxLen; i++) {
					if (switches[num - i] != switches[num + i]) {
						break;
					} else {
						switches[num - i] = !switches[num - i];
						switches[num + i] = !switches[num + i];
					}
				}
			}
		}
		
		
		// print
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (switches[i])	sb.append(1);
			else				sb.append(0);
			sb.append(' ');
			if (i % 20 == 0)	sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_1337() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		
		int max = 1;
		for (int i = 0; i < N; i++) {
			int len = 1;		// 연속되는 길이
			int lastIdx = Math.min(N, i+5);
			for (int j = i+1; j < lastIdx; j++) {
				if (num[j] - num[i] < 5) {
					len++;
				}
			}
			max = Math.max(max, len);
		}
		
		if (max >= 5)	System.out.println(0);
		else			System.out.println(5 - max);
	}

	
	public static void main(String[] args) throws Exception {
		new Main().sol_1337();
	}
}
