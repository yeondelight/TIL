import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL2420 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void run() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		System.out.println(Math.abs(N-M));
	}
}
