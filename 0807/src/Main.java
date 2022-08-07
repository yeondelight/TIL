import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_12851() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int res = 0;
		int[] dist = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[N] = 0;
		q.add(N);
		
		while(!q.isEmpty()) {
			int X = q.poll();
			if (X == K) {
				res++;
			}
			
			if (X-1 >= 0 && dist[X-1] >= dist[X] + 1) {
				dist[X-1] = dist[X] + 1;
				q.add(X-1);
			}
			if (X+1 < 100001 && dist[X+1] >= dist[X] + 1) {
				dist[X+1] = dist[X] + 1;
				q.add(X+1);
			}
			if (2*X < 100001 && dist[2*X] >= dist[X] + 1) {
				dist[2*X] = dist[X] + 1;
				q.add(2*X);
			}
		}
		
		System.out.println(dist[K]);
		System.out.println(res);
	}
	
	
	public static void main(String[] args) throws Exception {
		new Main().sol_12851();
	}
}
