import java.io.*;
import java.util.*;

public class Main {
	
	public void sol_11047() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Vector<Integer> money = new Vector<Integer>();
		for (int i = 0; i < N; i++) {
			money.add(Integer.parseInt(br.readLine()));
		}
		
		// cal
		Collections.reverse(money);
		int count = 0;
		int remain = K;
		boolean checkRemain = true;
		for (int i = 0; i < N; i++) {
			int m = money.get(i);
			if (remain >= m) {
				count += remain/m;
				remain %= m;
				if (remain == 0)	break;
			}
		}
		
		// print
		System.out.println(count);
	}
	
	public void sol_17219() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> pwMap = new HashMap<String, String>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String password = st.nextToken();
			pwMap.put(site, password);
		}
		
		for(int i = 0; i < M; i++) {
			String find = br.readLine();
			sb.append(pwMap.get(find)).append('\n');
		}
		
		System.out.print(sb);
	}
	
	public void sol_17626() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] doubles = new int[n+1];
		doubles[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j*j <= i; j++) {
				int remain = i - j*j;
				min = min > doubles[remain] ? doubles[remain] : min;
			}
			doubles[i] = min + 1;
		}
		
		System.out.println(doubles[n]);
	}
	
	public void sol_1620() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, String> dogamInt = new HashMap<>();
		Map<String, Integer> dogamStr = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int index = i + 1;
			String name = br.readLine();
			dogamInt.put(index, name);
			dogamStr.put(name, index);
		}
		
		// find
		for (int i = 0; i < M; i++) {
			String question = br.readLine();
			String reg = "[0-9]+";
			if (question.matches(reg)) {	// 숫자로 주어질 때
				int num = Integer.parseInt(question);
				sb.append(dogamInt.get(num)).append('\n');
			} else {						// 이름으로 주어질 때
				sb.append(dogamStr.get(question)).append('\n');
			}
		}
		
		System.out.print(sb);
	}
	
	public void sol_9095() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// cal
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i < 11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		// scan
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num]).append('\n');
		}
		
		// print
		System.out.println(sb);
	}

	public void sol_1463() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// cal
		int[] dp = new int[N+1];
		
		dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			if (i < 4) {
				dp[i] = 1;
				continue;
			}
			Vector<Integer> counts = new Vector<>();
			if (i % 3 == 0)	counts.add(1+dp[i/3]);
			if (i % 2 == 0)	counts.add(1+dp[i/2]);
			counts.add(1 + dp[i-1]);
			Collections.sort(counts);
			dp[i] = counts.get(0);
		}
		
		
		System.out.println(dp[N]);
	}
	
	public void sol_1003() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp0 = new int[N+1];
			int[] dp1 = new int[N+1];
			for (int j = 0; j <= N; j++) {
				if (j == 0) {
					dp0[j] = 1;
					continue;
				} else if (j == 1) {
					dp1[j] = 1;
					continue;
				}
				dp0[j] = dp0[j-1] + dp0[j-2];
				dp1[j] = dp1[j-1] + dp1[j-2];
			}
			sb.append(dp0[N]).append(' ').append(dp1[N]).append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static void main (String[] args) throws Exception{
		new Main().sol_1003();
	}
}
