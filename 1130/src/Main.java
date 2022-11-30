import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1783() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int[] road = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(road);
		
		int[] dist = new int[N-1];
		for (int i = 0; i < N-1; i++) {
			dist[i] = road[i+1] - road[i];
		}
		Arrays.sort(dist);
		
		long sum = 0;
		for (int i = 0; i < N-K; i++) {
			sum += dist[i];
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1783();
	}
}
