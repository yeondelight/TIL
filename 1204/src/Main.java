import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static int rootNum;
	public static int delNum;
	public static int leafCnt = 0;
	public static ArrayList<ArrayList<Integer>> g;
	
	public void dfs(int idx) {
		if (idx == delNum)	return;
		int leafs = 0;
		ArrayList<Integer> child = g.get(idx);
		for (int c : child) {
			dfs(c);
			if (c != delNum) {
				leafs++;
			}
		}
		if (leafs == 0) {
			leafCnt++;
		}
	}
	
	public void sol_1068() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		g = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			g.add(new ArrayList<Integer>());
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				rootNum = i;
			} else {
				g.get(parent).add(i);
			}
		}
		
		delNum = Integer.parseInt(br.readLine());
		dfs(rootNum);
		
		System.out.println(leafCnt);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1068();
	}
}
