import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private String n;
	private int nLen;
	private int s;
	
	private StringBuilder sb;
	
	// init num
	private char[][][] num = {
			// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
			{{' ', '-', ' '}, {' ', ' ', ' '}, {' ', '-', ' '}, {' ', '-', ' '}, {' ', ' ', ' '}, {' ', '-', ' '}, {' ', '-', ' '}, {' ', '-', ' '}, {' ', '-', ' '}, {' ', '-', ' '}},
			{{'|', ' ', '|'}, {' ', ' ', '|'}, {' ', ' ', '|'}, {' ', ' ', '|'}, {'|', ' ', '|'}, {'|', ' ', ' '}, {'|', ' ', ' '}, {' ', ' ', '|'}, {'|', ' ', '|'}, {'|', ' ', '|'}},
			{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', '-', ' '}, {' ', '-', ' '}, {' ', '-', ' '}, {' ', '-', ' '}, {' ', '-', ' '}, {' ', ' ', ' '}, {' ', '-', ' '}, {' ', '-', ' '}},
			{{'|', ' ', '|'}, {' ', ' ', '|'}, {'|', ' ', ' '}, {' ', ' ', '|'}, {' ', ' ', '|'}, {' ', ' ', '|'}, {'|', ' ', '|'}, {' ', ' ', '|'}, {'|', ' ', '|'}, {' ', ' ', '|'}},
			{{' ', '-', ' '}, {' ', ' ', ' '}, {' ', '-', ' '}, {' ', '-', ' '}, {' ', ' ', ' '}, {' ', '-', ' '}, {' ', '-', ' '}, {' ', ' ', ' '}, {' ', '-', ' '}, {' ', '-', ' '}} 	
	};
	
	public void printRow(int numIdx) {
		for (int i = 0; i < nLen; i++) {	// i는 문자열의 몇번째 숫자인지
			int curr = n.charAt(i) - '0';
			
			sb.append(num[numIdx][curr][0]);
			for (int k= 0; k < s; k++) {	// 중간만 늘려서 출력
				sb.append(num[numIdx][curr][1]);
			}
			sb.append(num[numIdx][curr][2]);
			
			sb.append(' ');	// 각 숫자 사이에 하나의 공백
		}
		sb.append('\n');	// 줄바꿈
	}
	
	public void printCol(int numIdx) {
		for (int j = 0; j < s; j++) {			// j는 반복횟수
			for (int i = 0; i < nLen; i++) {	// i는 문자열의 몇번재 숫자인지
				int curr = n.charAt(i) - '0';
				
				sb.append(num[numIdx][curr][0]);
				for (int k = 0; k < s; k++) {	// 중간만 늘려서 출력
					sb.append(num[numIdx][curr][1]);
				}
				sb.append(num[numIdx][curr][2]);
				
				sb.append(' ');	// 각 숫자 사이에 하나의 공백
			}
			sb.append('\n');	// 줄바꿈
		}
	}
	
	public void sol_2290() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken());
		
		n = st.nextToken();
		nLen = n.length();
		
		sb = new StringBuilder();
		
		// 첫줄
		// num[0][해당숫자][자리수:0, 1, 2]
		printRow(0);
		
		
		// 2번째 ~ 중간 직전 줄
		// num[1][해당숫자][자리수:0, 1, 2]
		printCol(1);
		
		
		// 중간줄
		// num[2][해당숫자][자리수:0, 1, 2]
		printRow(2);
		

		// 중간 이후 ~ 끝 직전 줄
		// num[3][해당숫자][자리수:0, 1, 2]
		printCol(3);
		
		
		// 마지막줄
		// num[4][해당숫자][자리수:0, 1, 2]
		printRow(4);
		
		
		// 전체 결과 출력
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2290();
	}
}
