import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] parent;
	
	public int unionFind(int num) {
		if (parent[num] == num)	return num;
		return parent[num] = unionFind(parent[num]);
	}
	
	public void sol_1717() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int r1 = unionFind(a);
			int r2 = unionFind(b);
			if (cmd == 0) {		// 0으로 시작하는 입력인 경우 합집합
				if (r1 > r2) {
					parent[parent[a]] = parent[b];
				} else if (parent[a] < parent[b]) {
					parent[parent[b]] = parent[a];
				}
			}
			else {				// 1로 시작하는 입력인 경우 포함 확인
				if (r1 == r2)	sb.append("YES");
				else			sb.append("NO");
				sb.append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1717();
	}

}
