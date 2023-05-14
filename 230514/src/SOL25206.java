import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL25206 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public double cnt;
	public double score;
	public double avg;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		
		cnt = 0.0;
		score = 0.0;
		
		while(true) {
			
			String str = br.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			
			StringTokenizer st = new StringTokenizer(str);
			String name = st.nextToken();
			double credit = Double.parseDouble(st.nextToken());
			String currScore = st.nextToken();
			
			// 등급이 P인 과목은 계산에서 제외해야한다.
			if (currScore.charAt(0) == 'P') {
				continue;
			}
			else {
				cnt += credit;	// 그 외의 경우 총 학점 수 누적
			}
			
			// 이하 점수
			double realScore = 0.0;
			switch(currScore.charAt(0)) {
				case 'A':	realScore += 4.0;	break;
				case 'B':	realScore += 3.0;	break;
				case 'C':	realScore += 2.0;	break;
				case 'D':	realScore += 1.0;	break;
			}
			
			if (currScore.length() == 2 && currScore.charAt(1) == '+') {
				realScore += 0.5;
			}
			
			score += realScore * credit;
		}
	}
	
	public void solution() {
		avg = score / cnt;
	}
	
	public void print() {
		System.out.println(avg);
	}
}
