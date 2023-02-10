import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_3048() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		
		int totalLen = N1 + N2;
		char[] move = new char[totalLen];
		
		int A = 'A';
		boolean[] isGroup1 = new boolean[26];
		
		String group1 = br.readLine();
		int lenGroup1 = group1.length();
		for (int i = 0; i < lenGroup1; i++) {
			char curr = group1.charAt(i);
			move[lenGroup1 - (i + 1)] = curr;
			isGroup1[curr-'A'] = true;
		}
		
		String group2 = br.readLine();
		int lenGroup2 = group2.length();
		for (int j = 0; j < lenGroup2; j++) {
			char curr = group2.charAt(j);
			move[lenGroup1+j] = curr;
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < totalLen - 1; i++) {
				char curr = move[i];
				char next = move[i+1];
				if (isGroup1[curr - 'A'] && !isGroup1[next - 'A']) {
					move[i] = next;
					move[i+1] = curr;
					i++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (char c : move) {
			sb.append(c);
		}
		
		System.out.println(sb);
	}
	
	class Light {
		int red;
		int green;
		public Light (int r, int g) {
			red = r;
			green = g;
		}
	}
	
	public void sol_2980() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		boolean[] isLight = new boolean[L];
		Queue<Light> lightQ = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer stLight = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(stLight.nextToken());
			int R = Integer.parseInt(stLight.nextToken());
			int G = Integer.parseInt(stLight.nextToken());
			isLight[D] = true;
			lightQ.offer(new Light(R, G));
		}
		
		int time = 0;
		for (int i = 0; i < L; i++) {
			if (isLight[i]) {				// 현 위치에 신호등이 있다면
				Light l = lightQ.poll();	// 신호등 정보를 받아
				int currLightTime = time % (l.red + l.green);	// 현재 시간을 계산한다.
				if (currLightTime < l.red) {				// 만약 빨간불이면
					time += l.red - currLightTime;			// 남은 시간만큼 대기하고 출발
				}
			}
			time++;
		}
		
		System.out.println(time);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2980();
	}
}
