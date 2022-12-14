import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;

public class Main {
	
	public void sol_1744() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int oneCnt = 0;
		int zeroCnt = 0;
		Vector<Integer> minus = new Vector<>();
		Vector<Integer> plus = new Vector<>();
		
		for (int i = 0; i < N; i++) {
			int curr = Integer.parseInt(br.readLine());
			if (curr < 0) {
				minus.add(curr);
			} else if (curr > 1) {
				plus.add(curr);
			} else if (curr == 0){
				zeroCnt++;
			} else {
				oneCnt++;
			}
		}
		
		Collections.sort(minus);
		Collections.sort(plus, Collections.reverseOrder());
		
		int sum = 0;
		
		// 1은 곱하는것보다 그냥 더하는게 낫다.
		sum += oneCnt;
		
		// 양수는 큰 수부터 2개씩 묶어 저장한다.
		if (plus.size() % 2 == 1) {
			sum += plus.get(plus.size() - 1);
		}
		for (int i = 0; i < plus.size()-1; i+=2) {
			sum += (plus.get(i) * plus.get(i+1));
		}
		
		// 음수
		if (minus.size() % 2 == 1) {
			if (zeroCnt == 0) {
				sum += minus.get(minus.size() - 1);
			}
		}
		for (int i = 0; i < minus.size()-1; i+=2) {
			sum += (minus.get(i) * minus.get(i+1));
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1744();
	}
}
