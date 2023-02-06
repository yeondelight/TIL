import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_5800() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] score = new int[N];
			for (int j = 0; j < N; j++) {
				score[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(score);
			
			int gap = 0;
			for (int j = 0; j < N-1; j++) {
				gap = Math.max(gap, Math.abs(score[j] - score[j+1]));
			}
			
			sb.append("Class ").append(i+1).append('\n');
			sb.append("Max ").append(score[N-1]).append(", ");
			sb.append("Min ").append(score[0]).append(", ");
			sb.append("Largest gap ").append(gap).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_9324() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int a = 'A';		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String M = br.readLine();
			
			boolean flag = true;
			int length = M.length();
			int[] alpha = new int[26];
			
			for (int j = 0; j < length; j++) {
				char c = M.charAt(j);
				int index = c - a;
				alpha[index]++;
				if (alpha[index] == 3) {
					if (j == length - 1 || M.charAt(j+1) != c) {
						flag = false;
						break;
					}
					alpha[index] = 0;
					j++;
					continue;
				}
			}
			
			if (flag)	sb.append("OK");
			else		sb.append("FAKE");
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

	public void sol_10709() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] ans = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			String row = br.readLine();
			int recentCloud = -1;
			for (int j = 0; j < W; j++) {
				boolean isCloud = row.charAt(j) == 'c' ? true : false;
				if (isCloud) {	// 현 위치가 구름인 경우 0
					ans[i][j] = 0;
					recentCloud = j;
				} else {		// 가장 최근 구름을 찾아야한다.
					if (recentCloud != -1) {	// 기다리면 구름이 오는 경우
						ans[i][j] = j - recentCloud;
					} else {					// 기다려도 구름이 안오는 경우
						ans[i][j] = -1;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(ans[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_11576() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		
		long m = Integer.parseInt(br.readLine());
		
		
		// A -> 10
		long dec = 0;
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < m; i++) {
			dec *= A;
			dec += Long.parseLong(st.nextToken());
		}
		
		// 10 -> B
		Stack<Long> s = new Stack<>();
		while (dec > 0) {
			s.push(dec % B);
			dec /= B;
		}
		
		
		// print
		StringBuilder sb = new StringBuilder();
		while (!s.isEmpty()) {
			sb.append(s.pop()).append(' ');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11576();
	}
}
