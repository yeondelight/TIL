import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public String sec2str(int sec) {
		int min = sec / 60;
		sec %= 60;
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%02d", min));
		sb.append(':');
		sb.append(String.format("%02d", sec));
		return sb.toString();
	}
	
	public int str2sec(String str) {
		StringTokenizer st = new StringTokenizer(str, ":");
		int min = Integer.parseInt(st.nextToken());
		int sec = Integer.parseInt(st.nextToken());
		return min * 60 + sec;
	}
	
	public void sol_2852() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] score = new int[3];
		int[] winTime = new int[3];
		
		int prevTime = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken());
			int time = str2sec(st.nextToken());
			
			// 이전 상태에 따라 이기는 시간 추가 대상이 바뀐다.
			int diff = time - prevTime;
			if (score[1] > score[2])		winTime[1] += diff;
			else if (score[1] < score[2])	winTime[2] += diff;
			
			score[team]++;		// 득점 인정
			prevTime = time;	// 시간 갱신
		}
		
		// 최종 결과에 따라 한 번 더
		int diff = 48*60 - prevTime;
		if (score[1] > score[2])		winTime[1] += diff;
		else if (score[1] < score[2])	winTime[2] += diff;
		
		// print
		System.out.println(sec2str(winTime[1]));
		System.out.println(sec2str(winTime[2]));
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2852();
	}
}
