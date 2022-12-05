import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	class Point {
		int cnt;
		int val;
		public Point(int cnt, int val) {
			this.cnt = cnt;
			this.val = val;
		}
	}
	
	public void sol_13913() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if (N == K) {
			System.out.println(0);
			System.out.println(N);
			return;
		}
		
		int time = 0;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, N));
		
		int MAX = 200000;
		int[] visited = new int[MAX+1];
		Arrays.fill(visited, -1);
		
		while(!q.isEmpty()) {
			Point curr = q.poll();
			int currCnt = curr.cnt;
			int currVal = curr.val;
			if (currVal == K) {
				time = curr.cnt;
				break;
			}
			if (currVal - 1 >= 0 && visited[currVal-1] == -1) {
				visited[currVal-1] = currVal;
				q.offer(new Point(currCnt+1, currVal-1));
			}
			if (currVal + 1 <= MAX && visited[currVal+1] == -1) {
				visited[currVal+1] = currVal;
				q.offer(new Point(currCnt+1, currVal+1));
			}
			if (2 * currVal <= MAX && visited[2*currVal] == -1) {
				visited[2*currVal] = currVal;
				q.offer(new Point(currCnt+1, 2*currVal));
			}
		}
		
		// check route
		Stack<Integer> s = new Stack<>();
		int trackIdx = K;
		do {
			s.push(trackIdx);
			trackIdx = visited[trackIdx];
		} while (trackIdx != N);
		s.push(N);
		
		// print
		sb.append(time).append('\n');
		while(!s.isEmpty()) {
			sb.append(s.pop()).append(' ');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_13913();
	}
}
