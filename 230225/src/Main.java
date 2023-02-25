import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_13414() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());	// 최대 수강 가능 인원
		int L = Integer.parseInt(st.nextToken());	// 대기목록 길이
		
		LinkedHashSet<String> waitQ = new LinkedHashSet<>();
		for (int i = 0; i < L; i++) {
			String curr = br.readLine();
			if (waitQ.contains(curr))	waitQ.remove(curr);
			waitQ.add(curr);
		}
		
		Iterator<String> resEntry = waitQ.iterator();
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K && resEntry.hasNext(); i++) {
			sb.append(resEntry.next());
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_13414();
	}
}
