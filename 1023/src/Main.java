import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {
	
	public void sol_4358() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TreeMap<String, Integer> trees = new TreeMap<>();
		int cnt = 0;
		while (true) {
			String str = br.readLine();
			if (str == "" || str == null) {
				break;
			}
			cnt++;
			if (trees.containsKey(str)) {
				int val = trees.get(str);
				trees.put(str, val + 1);
			} else {
				trees.put(str, 1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (Entry<String, Integer> entry : trees.entrySet()) {
			double perc = (double)entry.getValue()/cnt;
			double val = (double)Math.round(perc*1000000)/10000;
			sb.append(entry.getKey());
			sb.append(' ');
			sb.append(String.format("%.4f", val));
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_4358();
	}
}
