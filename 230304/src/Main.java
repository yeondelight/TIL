import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	public void sol_2002() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 입구 : 각 차별로 등록 순서 id 부여
		HashMap<String, Integer> carID = new HashMap<>(N);
		for (int i = 0; i < N; i++) {
			carID.put(br.readLine(), i);
		}
		
		// 출구 : 나온 id 순서 저장
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = carID.get(br.readLine());
		}
		
		// 0번부터 arr 확인
		// 현재 차량보다 늦게 들어온 애가 있으면 추가
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (arr[i] > arr[j]) {
					ans++;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2002();
	}
}
