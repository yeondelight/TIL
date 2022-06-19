import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import Main.Meeting;

public class Main {

	class Meeting implements Comparable<Meeting>{
		int startTime;
		int endTime;
		int diff;
		public Meeting(int startTime, int endTime, int diff) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.diff = diff;
		}
		
		@Override
		public int compareTo(Meeting m) {
			if (diff > m.diff)		return 1;
			else if (diff < m.diff)	return -1;
			else {
				if (startTime > m.startTime)		return 1;
				else if (startTime < m.startTime)	return -1;
				else	return 0;
			}
		}
	}
	
	public void sol_1931() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Meeting> meets = new ArrayList<Meeting>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());
			int diff = endTime - startTime;
			meets.add(new Meeting(startTime, endTime, diff));
		}
		Collections.sort(meets);
		
		int count = 0;
		List<Integer> meeted = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			boolean check = true;
			Meeting m = meets.get(i);
			int temp = m.startTime;
			do {
				if (meeted.contains(temp))	check = false;
				temp++;
			} while (temp < m.endTime);
			
			temp = m.startTime;
			if (check) {
				count++;
				do {
					meeted.add(temp);
					temp++;
				} while (temp < m.endTime);
			}
		}
		
		System.out.println(count);
	}
	
	public static void main(String[] args) throws Exception{
		new Main().sol_1931();
	}

}
