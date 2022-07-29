import java.io.*;
import java.util.*;

public class Main {
	
	public static boolean[] check;
	
	public void dfs_15663(int len) {
		if (len == M) {
			for (int i = 0; i < M; i++) {
				sb.append(res[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		int checkDup = 0;
		for (int i = 0; i < N; i++) {
			if (check[i] || checkDup == arr[i]) {	
				continue;
			}
			check[i] = true;
			res[len] = arr[i];
			checkDup = res[len];
			dfs_15663(len+1);
			check[i] = false;
		}
	}

	public void sol_15663() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = new int[N];
		arr = new int[N];
		check = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		dfs_15663(0);
		System.out.println(sb);
	}
	
	public static int N, M;
	public static int[] res;
	public static int[] arr;
	public static StringBuilder sb;
	
	public void dfs_15666(int index, int len) {
		if (len == M) {
			for (int i = 0; i < M; i++) {
				sb.append(res[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		int checkDup = 0;
		for (int i = index; i < N; i++) {
			if (checkDup == arr[i]) {	
				continue;
			}
			res[len] = arr[i];
			checkDup = res[len];
			dfs_15666(i, len+1);
		}
	}
	
	public void sol_15666() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = new int[M];
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		dfs_15666(0, 0);
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_15666();
	}

}
