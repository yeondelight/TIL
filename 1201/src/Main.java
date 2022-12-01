import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	
	public void sol_1092() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> crane = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(crane, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		
		// 제일 무거운 박스가 크레인의 최대 무게 제한보다 크면 불가능
		if (crane.get(0) < box.get(0)) {
			System.out.println("-1");
			return;
		} else {
			int ans = 0;
			while (!box.isEmpty()) {
				ans++;
				int j = 0;
				for (int i = 0; i < N;) {
					if (j == box.size()) {
						break;
					} else if (crane.get(i) >= box.get(j)) {
						box.remove(j);
						i++;
					} else {
						j++;
					}
				}				
			}
			System.out.println(ans);
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1092();
	}
}
