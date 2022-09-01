import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static double N, P, Q;
	public static Map<Double, Double> A;
	
	public double getA (double num) {
		if (A.containsKey(num)) {
			return A.get(num);
		}
		else {
			double valP = Math.floor(num/P);
			double valQ = Math.floor(num/Q);
			double val;
			if (valP == valQ)	val = 2 * getA(valP);
			else				val = getA(valP) + getA(valQ);
			A.put(num, val);
			return val;
		}
	}
	
	public void sol_1351() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Double.parseDouble(st.nextToken());
		P = Double.parseDouble(st.nextToken());
		Q = Double.parseDouble(st.nextToken());
		
		A = new HashMap<>();
		A.put(0.0, 1.0);
		
		System.out.println(String.format("%.0f", getA(N)));
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1351();	
	}
}
