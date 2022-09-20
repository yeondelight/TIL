import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] parent;
	public static int[] friendCnt;
	
	public int unionFind(int num) {
		if (num == parent[num])	return num;
		return parent[num] = unionFind(parent[num]);
	}
	
	public void setUnion(int a, int b) {
		int r1 = unionFind(a);
		int r2 = unionFind(b);
		
		if (r1 > r2) {
			parent[r1] = r2;
			friendCnt[r2] += friendCnt[r1];
		} else if (r1 < r2) {
			parent[r2] = r1;
			friendCnt[r1] += friendCnt[r2];
		}
	}
	
	public void sol_4195() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int MAX = 200001;
		
		for (int i = 0; i < T; i++) {
			int F = Integer.parseInt(br.readLine());
			HashMap<String, Integer> index = new HashMap<>();
			int indexNum = 0;
			
			// init arr
			parent = new int[MAX];
			friendCnt = new int[MAX];
			for (int j = 0; j < MAX; j++) {
				parent[j] = j;
				friendCnt[j] = 1;
			}
			
			
			for (int j = 0; j < F; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();
				if (!index.containsKey(f1))	index.put(f1, indexNum++);
				if (!index.containsKey(f2))	index.put(f2, indexNum++);
				setUnion(index.get(f1), index.get(f2));
				int root = unionFind(index.get(f1));
				sb.append(friendCnt[root]).append('\n');
			}
		}

		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_4195();
	}

}
