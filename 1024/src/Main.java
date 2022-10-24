import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Main {
	
	public void sol_9996() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "*");
		String P = "^" + st.nextToken() + "[a-z]*" + st.nextToken() + "$";
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			boolean match = Pattern.matches(P, S);
			if (match)	sb.append("DA");
			else		sb.append("NE");
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_1213() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// count Characters
		TreeMap<Character, Integer> map = new TreeMap<>();
		for (int i = 0; i < str.length(); i++) {
			char curr = str.charAt(i);
			if (map.containsKey(curr)) {
				int val = map.get(curr);
				map.put(curr, val + 1);
			}
			else {
				map.put(curr, 1);
			}
		}
		
		// check is possible
		boolean flag = true;
		char middleChar = ' ';
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 == 1) {
				if (flag) {
					flag = false;
					middleChar = entry.getKey();
				}
				else {
					System.out.println("I'm Sorry Hansoo");
					return;
				}
			}
		}
		
		// get palindrome
		Stack<Character> stack = new Stack<>();
		for (Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int val = entry.getValue();
			for (int i = 0; i < val / 2; i++) {
				stack.push(key);
			}
		}
		
		// merge string
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stack.size(); i++) {
			sb.append(stack.get(i));
		}
		
		if (middleChar != ' ') {
			sb.append(middleChar);
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1213();
	}

}
