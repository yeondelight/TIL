import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_13413() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			String cStr = br.readLine();
			String nStr = br.readLine();
			int cntB2W = 0;
			int cntW2B = 0;
			for (int j = 0; j < N; j++) {
				boolean curr = cStr.charAt(j) == 'B' ? true : false;
				boolean next = nStr.charAt(j) == 'B' ? true : false;
				if (curr && !next)		cntB2W++;
				else if (!curr && next)	cntW2B++;
			}
			
			int diff = Math.abs(cntB2W - cntW2B);
			int ans = Math.min(cntB2W, cntW2B) + diff;
			
			// print
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}

	class Node implements Comparable {
		int start;
		int time;
		
		public Node (int start, int time) {
			this.start = start;
			this.time = time;
		}
		
		@Override
		public int compareTo(Object o) {
			Node n = (Node) o;
			if (this.start == n.start) {
				return this.time - n.time;
			}
			return this.start - n.start;
		}
	}
	
	public void sol_14469() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Node[] cow = new Node[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			cow[i] = new Node(start, time);
		}
		Arrays.sort(cow);
		
		int time = 0;
		for (Node n : cow) {
			if (n.start < time) {
				time += n.time;
			} else {
				time = n.start + n.time;
			}
		}
		
		System.out.println(time);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_14469();
	}
}
