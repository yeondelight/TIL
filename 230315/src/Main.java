import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public void sol_10837() throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        
    	int K = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
    	
    	for (int c = 0; c < C; c++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            
            int remainGame = K - Math.max(M, N);
            int diff = Math.abs(M - N);
            
            boolean flag = false;
            
            if ( M < N && diff - remainGame <= 1) {
                flag = true;
            }
            
            if ( M > N && diff - remainGame <= 2) {
                flag = true;
            }
            
            if ( M == N ) {
                flag = true;
            }
            
            if(flag) {
                sb.append(1).append('\n');
            }
            else {
                sb.append(0).append('\n');
            }
    	}
    	
    	System.out.println(sb);
    }
    
	public static void main(String[] args) throws Exception {
		new Main().sol_10837();
	}
}