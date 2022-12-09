import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static int[] parent;
	
	public int unionFind(int num) {
		if (parent[num] == num)	return num;
		return parent[num] = unionFind(parent[num]);
	}
	
	public void sol_10775() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		parent = new int[G+1];
		for (int i = 0; i <= G; i++) {
			parent[i] = i;
		}
		
		int ans = 0;
		for (int i = 0; i < P; i++) {
			int gi = Integer.parseInt(br.readLine());
			int root = unionFind(gi);
			
			if (root == 0) {	// 0번에는 착륙 불가
				break;
			}
			else {				// 아직 착륙하지 않았으면 착륙시키기
				ans++;
				parent[root] = unionFind(root-1);
			}
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_10775();
	}

}
