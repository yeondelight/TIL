import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	class Workout {
		private int score;
		private int time;
		
		public Workout(int s, int t) {
			this.setScore(s);
			this.setTime(t);
		}
		
		private void reduceTime() {
			setTime(getTime() - 1);
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
	}
	
	public void sol_17952() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int score = 0;
		
		Stack<Workout> s = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int flag = Integer.parseInt(st.nextToken());
			
			if (flag == 1) {
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				if (T-1 == 0) {					// 받자마자 끝나는 경우
					score += A;
				} else {
					s.push(new Workout(A, T-1));
				}
			} else {
				if (!s.isEmpty()) {
					Workout curr = s.pop();
					curr.reduceTime();
					if (curr.getTime() == 0) {	// 이번에 다 한 경우
						score += curr.getScore();
					} else {
						s.push(curr);
					}
				}
			}
		}
		
		System.out.println(score);		
	}
	
	public void sol_1138() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> line = new ArrayList<>();
		line.add(N-1);
		for (int i = N-2; i >= 0; i--) {
			if (num[i] < line.size()) {
				line.add(num[i], i);
			} else {
				line.add(i);
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (int i : line) {
			sb.append(i+1).append(' ');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1138();
	}
}
