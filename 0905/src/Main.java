import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_17299() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		Map<Integer, Integer> F = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			if (F.containsKey(A[i])) {
				int val = F.get(A[i]);
				F.put(A[i], val+1);
			} else {
				F.put(A[i], 1);
			}
		}

		int[] NGF = new int[N];
		for (int i = 0; i < N; i++) {
			NGF[i] = -1;
		}
		
		Stack<Integer> s = new Stack<>();
		s.push(0);
		for (int i = 1; i < N; i++) {
			while (!s.isEmpty() && F.get(A[s.peek()]) < F.get(A[i])) {
				NGF[s.pop()] = A[i];
			}
			s.push(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(NGF[i]).append(' ');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_17299();
	}
}
