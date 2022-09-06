import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	class Repo{
		int day;
		int weight;
		Repo(int day, int weight){
			this.day = day;
			this.weight = weight;
		}
	}
	
	public void sol_13904() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Vector<Repo> repos = new Vector<>();
	
		int finDay = 0;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			repos.add(new Repo(d, w));
			finDay = Math.max(finDay, d);
		}
		
		int score = 0;
		for (int i = finDay; i > 0; i--) {
			int maxIndex = -1;
			int maxVal = 0;
			for (int j = 0; j < repos.size(); j++) {
				Repo r = repos.get(j);
				if (r.day >= i && maxVal < r.weight) {
					maxIndex = j;
					maxVal = repos.get(j).weight;
				}
			}
			
			if (maxIndex != -1) {
				repos.remove(maxIndex);
			}
			
			score += maxVal;
		}
		
		System.out.println(score);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_13904();
	}
}
