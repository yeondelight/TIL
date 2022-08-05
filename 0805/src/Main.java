import java.io.*;
import java.util.*;



public class Main {

	public static StringBuilder sb;
	public static Vector<Integer> tree;
	
	// postorder
	public void postOrder(int start, int end) {
		if (start >= end)	return;
		if (start == end-1) {	// 1개만 탐색시
			sb.append(tree.get(start)).append('\n');
			return;
		}
		
		// get start index of right
		int index = start + 1;
		while (index < end) {
			if (tree.get(start) < tree.get(index))	break;
			index++;
		}
		postOrder(start+1, index);				// left
		postOrder(index, end);					// right
		sb.append(tree.get(start)).append('\n');	// root
	}
	
	public void sol_5639() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		tree = new Vector<>();
		
		String str = "";
		while((str = br.readLine()) != null) {
			tree.add(Integer.parseInt(str));
		}
		
		postOrder(0, tree.size());
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_5639();
	}
}
