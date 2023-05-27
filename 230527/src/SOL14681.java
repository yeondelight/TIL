import java.io.BufferedReader;
import java.io.InputStreamReader;

class SOL14681 {
	
	public static BufferedReader br;
	
	public int x, y;
	public int quadrant;
	
	public SOL14681() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}

	public void getInput() throws Exception {
		x = Integer.parseInt(br.readLine());
		y = Integer.parseInt(br.readLine());
	}
	
	public void solution() {
		quadrant = 0;
		if (x > 0) {
			if (y > 0) {
				quadrant = 1;
			}
			else {
				quadrant = 4;
			}
		}
		else {
			if (y > 0) {
				quadrant = 2;
			}
			else {
				quadrant = 3;
			}
		}
	}
	
	public void print() {
		System.out.println(quadrant);
	}
}
