import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class SOL2161 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N;
	public Queue<Integer> arr;
	public Queue<Integer> ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
	}
	
	public void solution() {
		
		arr = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			arr.offer(i);
		}
		
		ans = new LinkedList<>();
		while (arr.size() > 1) {
			ans.offer(arr.poll());
			arr.offer(arr.poll());
		}
		
		ans.offer(arr.poll());
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		while(!ans.isEmpty()) {
			sb.append(ans.poll());
			sb.append(' ');
		}
		System.out.println(sb);
	}

}