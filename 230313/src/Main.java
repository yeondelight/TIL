import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public int getGCD(int a, int b) {
        if ( b == 0 )	return a;
        if ( a < b )	return getGCD(b, a);
        return getGCD( b, a%b );
    }
    
    public void sol_1735() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer stA = new StringTokenizer(br.readLine());
        int numA = Integer.parseInt(stA.nextToken());
        int denA = Integer.parseInt(stA.nextToken());
        
        StringTokenizer stB = new StringTokenizer(br.readLine());
        int numB = Integer.parseInt(stB.nextToken());
        int denB = Integer.parseInt(stB.nextToken());
        
        //if it is divided by gcd
        int gcdA = getGCD(numA, denA);
        numA /= gcdA;
        denA /= gcdA;
        
        int gcdB = getGCD(numB, denB);
        numB /= gcdB;
        denB /= gcdB;
        
        
        // total
        int gcd = getGCD(denA, denB);
        
        int num = numA * denB / gcd + numB * denA / gcd;
        int den = denA * denB / gcd;
        
        int gcdT = getGCD(num, den);
        num /= gcdT;
        den /= gcdT;
        
        StringBuilder sb = new StringBuilder();
        sb.append(num).append(' ').append(den);
        
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().sol_1735();
    }
}