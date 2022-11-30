import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1449() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] dist = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(dist);
		
		int cnt = 0;
		double len = 0.5;
		for (int i = 0; i < N; i++) {
			if (dist[i] < len) {
				continue;
			} else {
				cnt++;
				len = dist[i] - 0.5 + L;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1449();
	}
}
