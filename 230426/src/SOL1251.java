import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeSet;

class SOL1251 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int divide = 3;
	
	public char[] word;
	public int[] idx;
	
	public TreeSet<String> wordSet;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		String str = br.readLine();
		word = new char[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			word[i] = str.charAt(i);
		}
	}
	
	public void solution() {
		
		wordSet = new TreeSet<>();
		
		idx = new int[divide + 1];

		idx[0] = -1;
		idx[divide] = word.length - 1;
		
		for (int i = 0; i < word.length - divide + 1; i++) {
			idx[1] = i;
			backtracking(i, 2);
		}
		
	}
	
	public void print() {
		System.out.println(wordSet.first());
	}
	
	public void backtracking(int curr, int depth) {
		if (depth == divide) {
			// 조각 붙이기
			StringBuilder sb = new StringBuilder();
			for (int i = 0, d = 1; d <= divide; d++) {
				for (int j = idx[d]; j > idx[d-1]; j--, i++) {
					sb.append(word[j]);
				}
			}
			wordSet.add(sb.toString());
			return;
		}
		
		for (int i = curr + 1; i < word.length - 1; i++) {
			idx[depth] = i;
			backtracking(i, depth + 1);
		}
	}
}
