import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Main {
	
	public void sol_2671() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String P = "^(100+1+|01)+$";
		String S = br.readLine();
		boolean match = Pattern.matches(P, S);
		if (match)	System.out.println("SUBMARINE");
		else		System.out.println("NOISE");
	}
	
	public void sol_20291() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		TreeMap<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), ".");
			String name = st.nextToken();
			String ext = st.nextToken();
			if (map.containsKey(ext)) {
				int val = map.get(ext);
				map.put(ext, val+1);
			} else {
				map.put(ext, 1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (Entry<String, Integer> entry : map.entrySet()) {
			sb.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_20291();
	}
}
