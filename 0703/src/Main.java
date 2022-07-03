import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public void sol_7662() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			for (int j = 0; j < K; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if (cmd.equals("D")) {	// Delete
					if (!map.isEmpty()) {
						int remove;
						if (num == 1)	remove = map.lastKey();
						else			remove = map.firstKey();
						if (map.put(remove, map.get(remove) - 1) == 1) {
							map.remove(remove);
						}
					}
				} else {				// Insert
					map.put(num, map.getOrDefault(num, 0) + 1);
				}
			}
			
			if (map.isEmpty()) {
				sb.append("EMPTY").append('\n');
			} else {
				sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_7662();
	}
}
