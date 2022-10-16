import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	class Node {
		int idx;
		int val;
		public Node (int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}

	public void sol_5014() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());	// 최대 층수
		int S = Integer.parseInt(st.nextToken());	// 현재 층수
		int G = Integer.parseInt(st.nextToken());	// 스타트링크 층수
		int U = Integer.parseInt(st.nextToken());	// 위로 갈 수 있는 층수
		int D = Integer.parseInt(st.nextToken());	// 아래로 갈 수 있는 층수
		
		int cnt = -1;			// 최소 이동 횟수 저장
		boolean[] visit = new boolean[F+1];	// 방문 여부 저장
		Queue<Node> q = new LinkedList<>();	// 다음 방문 노드
		visit[S] = true;
		q.add(new Node(S, 0));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			if (curr.idx == G) {	// G층에 도달시 탈출.
				cnt = curr.val;
				break;
			}
			if (curr.idx + U <= F && !visit[curr.idx + U]) {	// U를 누를 수 있으면
				visit[curr.idx + U] = true;
				q.add(new Node(curr.idx + U, curr.val + 1));
			}
			if (curr.idx - D > 0 && !visit[curr.idx - D]) {		// D를 누를 수 있으면
				visit[curr.idx - D] = true;
				q.add(new Node(curr.idx - D, curr.val + 1));
			}
		}
		
		if (cnt != -1)	System.out.println(cnt);
		else			System.out.println("use the stairs");
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_5014();
	}
}
