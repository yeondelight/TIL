import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static Map<Integer, Long> fibos;
	
	public long fibo(int num) {
		if (fibos.containsKey(num)) {
			return fibos.get(num);
		} else {
			long ans = fibo(num-1) + fibo(num-2);
			fibos.put(num, ans);
			return ans;
		}
	}
	
	public void sol_2748() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		fibos = new HashMap<Integer, Long>();
		fibos.put(0, (long) 0);
		fibos.put(1, (long) 1);
		
		System.out.println(fibo(N));
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2748();
	}
}
