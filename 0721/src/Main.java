import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	class Command {
		int num;
		String cmd;		
		Command(int num, String cmd){
			this.num = num;
			this.cmd = cmd;
		}
	}
	
	public void sol_9019() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			boolean[] check = new boolean[10001];
			
			String res = "";
			Queue<Command> q = new LinkedList<>();
			check[now] = true;
			q.offer(new Command(now, ""));
			
			while(true) {
				Command c = q.poll();
				if (c.num == next) {
					res = c.cmd;
					break;
				}
				
				int num = c.num;
				String cmd = c.cmd;
				
				// D
				int D = num * 2 % 10000;
				if (D < 10001 && !check[D]) {
					check[D] = true;
					q.offer(new Command(D, cmd + "D"));
				}
				
				// S
				int S = num > 0 ? num - 1 : 9999;
				if (S < 10001 && !check[S]) {
					check[S] = true;
					q.offer(new Command(S, cmd + "S"));
				}
				
				// L
				int L = num % 1000 * 10 + num / 1000;
				if (L < 10001 && !check[L]) {
					check[L] = true;
					q.offer(new Command(L, cmd + "L"));
				}
				
				// R
				int R = num % 10 * 1000 + num / 10;
				if (R < 10001 && !check[R]) {
					check[R] = true;
					q.offer(new Command(R, cmd + "R"));
				}
			}
			
			sb.append(res).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_9019();
	}

}
