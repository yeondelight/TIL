import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	class Class implements Comparable<Class>{
		int start;
		int end;
		
		Class(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Class c) {
			if (this.start > c.start)		return 1;
			else if (this.start < c.start)	return -1;
			else return this.end - c.end;
		}
	}
	
	public void sol_11000() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Vector<Class> classes = new Vector<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			classes.add(new Class(S, E));
		}
		
		Collections.sort(classes);
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.offer(classes.get(0).end);
		
		for (int i = 1; i < N; i++) {
			int topEnd = q.peek();
			Class compare = classes.get(i);
			q.offer(compare.end);
			if (topEnd <= compare.start) {
				q.poll();
			}
		}
		
		System.out.println(q.size());
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11000();
	}
}