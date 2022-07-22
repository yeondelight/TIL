import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	class Node {
		double val;
		int cnt;
		Node(double val, int cnt) {
			this.val = val;
			this.cnt = cnt;
		}
	}
	
	public void sol_16953() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double A = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());
		
		Queue<Node> q = new LinkedList<>();
		Vector<Double> check = new Vector<>();
		q.add(new Node(A, 1));
		check.add(A);
		
		int res = -1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			if (n.val == B) {
				res = n.cnt;
				break;
			}
			
			double val = n.val;
			int cnt = n.cnt;
			if (val*2 <= B) {
				q.add(new Node(val*2, cnt+1));
				check.add(val*2);
			}
			if (val*10 + 1 <= B) {
				q.add(new Node(val*10 + 1, cnt+1));
				check.add(val*10 + 1);
			}
		}
		
		System.out.println(res);
	}
	
	public void dfs_15650(int num, int cnt) {		
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = num; i < N; i++) {
			if (check[num] == true) continue;
			check[num] = true;
			arr[cnt] = i + 1;
			dfs_15650(i + 1, cnt + 1);
			check[num] = false;
		}
	}
	
	public void sol_15650() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		check = new boolean[N+1];
		
		dfs_15650(0, 0);
		System.out.println(sb);
	}
	
	public void dfs_15652(int num, int cnt) {		
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = num; i <= N; i++) {
			arr[cnt] = i;
			dfs_15652(i, cnt + 1);
		}
	}
	
	public void sol_15652() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		dfs_15652(1, 0);
		System.out.println(sb);
	}
	
	public void dfs_15654(int cnt) {		
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(res[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (check[i])	continue;
			check[i] = true;
			res[cnt] = arr[i];
			dfs_15654(cnt + 1);
			check[i] = false;
		}
	}
	
	public void sol_15654() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = new int[M];
		arr = new int[N];
		check = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		dfs_15654(0);
		System.out.println(sb);
	}
	
	public static int N, M;
	public static int[] res;
	public static int[] arr;
	public static boolean[] check;
	public static StringBuilder sb = new StringBuilder();
	
	public void dfs_15657(int num, int cnt) {		
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(res[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = num; i < N; i++) {
			res[cnt] = arr[i];
			dfs_15657(i, cnt + 1);
		}
	}
	
	public void sol_15657() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = new int[M];
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		dfs_15657(0, 0);
		System.out.println(sb);
	}
	
	public static long A, B, C;
	
	public long conquer(long exp) {
		if (exp == 1) {
			return A % C;
		}
		long divMod = conquer(exp / 2);
		if (exp % 2 == 0) {
			return divMod * divMod % C;
		} else {
			return ((divMod * divMod % C) * (A % C)) % C;
		}
	}
	
	public void sol_1629() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(conquer(B));
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1629();
	}

}
