import java.io.BufferedReader;
import java.io.InputStreamReader;

class SOL11536 {
	
	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int INCREASING = -1;
	public static int DECREASING = 1;
	public static int NEITHER = 0;
	
	public int N;
	public String[] names;
	
	public int flag;
	
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		names = new String[N];
		for (int i = 0; i < N; i++) {
			names[i] = br.readLine();
		}
	}
	
	public void solution() {
		
		// init
		boolean initVal = names[0].compareTo(names[1]) > 0;
		
		// check for all names
		for (int i = 1; i < N-1; i++) {
			boolean compareVal = names[i].compareTo(names[i+1]) > 0;
			if (initVal != compareVal) {
				flag = NEITHER;
				return;
			}
		}
		
		// set flag
		if (initVal)	flag = DECREASING;
		else			flag = INCREASING;
	}
	
	public void print() {
		if (flag == INCREASING)			System.out.println("INCREASING");
		else if (flag == DECREASING)	System.out.println("DECREASING");
		else							System.out.println("NEITHER");
	}
}
