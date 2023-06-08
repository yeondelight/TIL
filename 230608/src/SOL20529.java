import java.io.BufferedReader;
import java.io.InputStreamReader;

class SOL27866 {
	
	public static BufferedReader br;
	
	public SOL27866() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	public void run() throws Exception {
		String str = br.readLine();
		int i = Integer.parseInt(br.readLine());
		System.out.println(str.charAt(i-1));
	}
}
