import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_1543() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String find = br.readLine();
		
		int cnt = 0;
		for (int i = 0; i < str.length() - find.length() + 1;) {
			boolean flag = true;
			for (int j = 0; j < find.length(); j++) {
				if (str.charAt(i+j) != find.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt++;
				i += find.length(); 
			} else {
				i++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1543();
	}
}
