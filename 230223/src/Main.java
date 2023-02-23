import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_8911() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		// R회전 : 북 - 동 - 남 - 서
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		
		for (int i = 0; i < T; i++) {
			
			int maxX = 0, maxY = 0;
			int minX = 0, minY = 0;
			
			int x = 0, y = 0;
			int turn = 0;
			
			String cmd = br.readLine();
			
			for (int j = 0; j < cmd.length(); j++) {
				
				char currCmd = cmd.charAt(j);
				
				switch(currCmd) {
					case 'F':	x += dx[turn];	y += dy[turn];	break;
					case 'B':	x -= dx[turn];	y -= dy[turn];	break;
					case 'L':	turn += 3;	turn %= 4;	break;
					case 'R':	turn++;		turn %= 4;	break;
				}
				
				minX = Math.min(minX, x);
				minY = Math.min(minY, y);
				maxX = Math.max(maxX, x);
				maxY = Math.max(maxY, y);
			}
			
			int area = (maxX - minX) * (maxY - minY);
			sb.append(area).append('\n');
		}
		
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_8911();
	}
}
