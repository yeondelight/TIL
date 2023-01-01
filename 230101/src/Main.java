import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 참고링크
// https://steady-coding.tistory.com/55

public class Main {
	
	public void sol_1700() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] tabOrder = new int[K];	// i번째로 꽂아야 하는 용품은 뭔가
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			tabOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;	// 뽑는 횟수
		int size = 0;	// 현재 멀티탭의 크기
		boolean[] use = new boolean[101];
		
		for (int i = 0; i < K; i++) {
			int currIdx = tabOrder[i];
			if (use[currIdx]) {		// currIdx번 전기용품이 사용중이라면
				continue;			// 패스
			} else {				// currIdx번 전기용품이 사용중이지 않다면
				if (size < N) {		// tab에 꽂을 공간이 있으면 꽂는다.
					use[currIdx] = true;
					size++;
				} else {			// 공간이 없으면
					ans++;			// 뭘 빼야함
					ArrayList<Integer> nextUse = new ArrayList<>();
					for (int j = i; j < K; j++) {		// 미래 상황을 살피며
						int nextOrder = tabOrder[j];
						if (use[nextOrder] && !nextUse.contains(nextOrder)) {
							nextUse.add(nextOrder);		// 지금+미래에 사용되는건 안빼야함
						}
					}
					if (nextUse.size() < N) {			// 미래에 사용되는게 공간보다 작으면
						for (int j = i; j < K; j++) {	// 미래 상황을 살피며
							int nextOrder = tabOrder[j];
							if (use[nextOrder] && !nextUse.contains(nextOrder)) {
								use[nextOrder] = false;	// 미래에 안쓰이는거 발견하면
								break;					// 하나 빼고 탈출
							}
						}
					} else {							// 지금 꽃힌게 다 미래에도 쓰이면
						int removeIdx = nextUse.get(nextUse.size() - 1);
						use[removeIdx] = false;			// 가장 나중에 사용할거 하나 빼고 탈출
					}
					
					use[currIdx] = true;		// 새로 사용할거 꽃기
				}
			}
		}
		
		
		
		// print
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1700();
	}
}
