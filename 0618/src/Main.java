import java.io.*;
import java.util.*;

public class Main {
	
	 public void sol_1059() throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 // scan
		 int L = Integer.parseInt(br.readLine());
		 int[] num = new int[L];
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 for(int i = 0; i < L; i++) {
			 num[i] = Integer.parseInt(st.nextToken());
		 }
		 int n = Integer.parseInt(br.readLine());
		 
		 // sort
		 Arrays.sort(num);
		 
		 // check startNum, endNum of range
		 int startNum = 0;
		 int endNum = 0;
		 for(int i = 0; i < L; i++) {
			 if (i == 0 && n < num[i]) {			// if n is smaller than num[0]
				 startNum = 1;
				 endNum = num[i] - 1;
				 break;
			 } else if (i == L && n < num[i]) {		// if n is bigger than num[n-1]
				 startNum = num[i] + 1;
				 endNum = 50;
				 break;
			 } else if (num[i] < n && n < num[i + 1]) {		// if n is between num[i], num[i+1]
				 startNum = num[i] + 1;
				 endNum = num[i+1] - 1;
				 break;
			 } 
		 }
		 
		 // count ranges
		 int count = 0;
		 if (startNum < endNum) {
			 count = (n - startNum + 1) * (endNum - n + 1) - 1;
		 }
		 
		 System.out.println(count);
	 }
	
	 public static void main (String[] args) throws Exception {
		 new Main().sol_1059();
	 }
}
