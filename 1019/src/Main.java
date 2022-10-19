import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	public void sol_14425() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Vector<String> S = new Vector<>();
		for (int i = 0; i < N; i++) {
			S.add(br.readLine());
		}
		
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (S.contains(br.readLine())) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_14425();
	}
}
