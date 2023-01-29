import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_11060() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] visited = new boolean[N];
		visited[0] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int t = 0; t < size; t++) {
				int curr = q.poll();
				if (curr == N-1) {
					System.out.println(time);
					return;
				}
				int start = curr + 1;
				int end = start + num[curr] > N ? N : start + num[curr];
				for (int i = start; i < end; i++) {
					if (!visited[i]) {
						visited[i] = true;
						q.offer(i);
					}
				}
			}
			time++;
		}
		
		System.out.println(-1);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11060();
	}
}
