import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	class Lecture {
		int pay;
		int day;
		Lecture(int pay, int day){
			this.pay = pay;
			this.day = day;
		}
	}
	
	public void sol_2109() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Vector<Lecture> lectures = new Vector<>();
	
		int finDay = 0;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			lectures.add(new Lecture(p, d));
			finDay = Math.max(finDay, d);
		}
		
		int cost = 0;
		for (int i = finDay; i > 0; i--) {
			int maxIndex = -1;
			int maxVal = 0;
			for (int j = 0; j < lectures.size(); j++) {
				Lecture r = lectures.get(j);
				if (r.day >= i && maxVal < r.pay) {
					maxIndex = j;
					maxVal = lectures.get(j).pay;
				}
			}
			
			if (maxIndex != -1) {
				lectures.remove(maxIndex);
			}
			
			cost += maxVal;
		}
		
		System.out.println(cost);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2109();
	}
}
