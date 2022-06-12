import java.util.Stack;

class Solution {
	/*
    public int[] solution(int[] p) {
        int[] answer = new int[p.length];
        int[] copyP = p;
        
        int i, j, min, minIndex, temp;
        for (i = 0; i < answer.length; i++) {
        	answer[i] = 0;
        }
        
        for (i = 0; i < copyP.length; i++) {
        	min = copyP[i];
        	minIndex = i;
        	for (j = i; j < copyP.length; j++) {
        		if (copyP[j] < min) {
        			min = copyP[j];
        			minIndex = j;
        		}
        	}
        	if (i != minIndex) {
        		answer[i]++;
        		answer[minIndex]++;
        		temp = copyP[i];
        		copyP[i] = copyP[minIndex];
        		copyP[minIndex] = temp;
        	}
        }
        
        return answer;
    }
	
	public int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int[] answer = {0, 0};
        
        int i, j;
        int period;
        int[] paySum = new int[periods.length];
        boolean[][] isVIP = new boolean[periods.length][2];
        
        // check sum for now
        for (i = 0; i < periods.length; i++) {
        	paySum[i] = 0;
        	for (j = 0; j < 12; j++) {
        		paySum[i] += payments[i][j];
        	}
        }
        
        // check now
        for (i = 0; i < periods.length; i++) {
        	period = periods[i];
        	if (period < 24) {			// 2년 미만
        		isVIP[i][0] = false;
        	}
        	else if (period >= 60) {	// 5년 이상
        		if (paySum[i] < 600000) {
        			isVIP[i][0] = false;
        		}
        		else {
        			isVIP[i][0] = true;
        		}
        	}
        	else {	// 2~5년
        		if (paySum[i] < 900000) {
        			isVIP[i][0] = false;
        		}
        		else {
        			isVIP[i][0] = true;
        		}
        	}
        }
        
        // check sum for new
        for (i = 0; i < periods.length; i++) {
        	paySum[i] -= payments[i][0];
        	paySum[i] += estimates[i];
        }
        
        // check new
        for (i = 0; i < periods.length; i++) {
        	period = periods[i] + 1;
        	if (period < 24) {		// 2년 미만
        		isVIP[i][1] = false;
        	}
        	else if (period >= 60) {	// 5년 이상
        		if (paySum[i] < 600000) {
        			isVIP[i][1] = false;
        		}
        		else {
        			isVIP[i][1] = true;
        		}
        	}
        	else {	// 2~5년
        		if (paySum[i] < 900000) {
        			isVIP[i][1] = false;
        		}
        		else {
        			isVIP[i][1] = true;
        		}
        	}
        }
        
        // count X -> VIP
        for (i = 0; i < periods.length; i++) {
        	if (isVIP[i][0] == false && isVIP[i][1] == true) {
        		answer[0]++;
        	}
        	else if (isVIP[i][0] == true && isVIP[i][1] == false) {
        		answer[1]++;
        	}
        }
        
        return answer;
    }
	
	public int[] solution(int n, String[] plans, String[] clients) {
        int[] answer = new int[clients.length];
        
        int i, j, k;
        int key, value;
        StringTokenizer st;
        
        // init plans -> plan
        Map<Integer, List<Integer>> plan = new LinkedHashMap<>();
        List<Integer> planValue;
        List<Integer> planValueSum = new ArrayList<>();
        
        for (i = 0; i < plans.length; i++) {
        	st = new StringTokenizer(plans[i]);
        	key = Integer.parseInt(st.nextToken());
        	planValue = new ArrayList<>();
        	while (st.hasMoreTokens()) {
        		value = Integer.parseInt(st.nextToken());
        		planValueSum.add(value);
        	}
        	for (j = 0; j < planValueSum.size(); j++) {
        		planValue.add(planValueSum.get(j));
        	}
        	plan.put(key, planValue);
        }
        
        //init clients -> client
        Map<Integer, List<Integer>> client = new LinkedHashMap<>();
        List<Integer> clientValue;
        
        for (i = 0; i < clients.length; i++) {
        	clientValue = new ArrayList<>();
        	st = new StringTokenizer(clients[i]);
        	key = Integer.parseInt(st.nextToken());
        	while (st.hasMoreTokens()) {
        		value = Integer.parseInt(st.nextToken());
        		clientValue.add(value);
        	}
        	client.put(key, clientValue);
        }
        
        // find min plan
        i = 0;
        int ckey, pkey, minPlan = 0;
        boolean checkContains, checkExist;
        List<Integer> cvalue = new ArrayList<>();
        List<Integer> pvalue = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> c : client.entrySet()) {
        	ckey = c.getKey();
        	cvalue = c.getValue();
        	checkExist = false;
        	
        	
        	// 가장 높은 요금제로 minPlan 초기화
        	minPlan = 0;
        	for (Map.Entry<Integer, List<Integer>> p : plan.entrySet()) {
        		minPlan++;
        	}
        	
        	k = 0;
        	for (Map.Entry<Integer, List<Integer>> p : plan.entrySet()) {
        		k++;
        		checkContains = true;
        		pkey = p.getKey();
        		if (pkey < ckey)	continue;
        		pvalue = p.getValue();
        		
        		for (j = 0; j < cvalue.size(); j++) {
        			value = cvalue.get(j);
        			if (!pvalue.contains(value)) {
        				checkContains = false;
        				break;
        			}
        		}
        		
        		if (checkContains) {
        			checkExist = true;
        			if (minPlan > k) {
        				minPlan = k;
        			}
        		}
        	}
        	
        	if (checkExist) {
            	answer[i] = minPlan;
        	}
        	i++;
        }
        
        
        return answer;
    }
    
	class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public int solution(String[] grid, int k) {
        int answer = -1;
        
        int row = grid.length;
        int col = grid[0].length();
        char[][] map = new char[row][col];
        boolean[][] check = new boolean[row][col];

        Point p, temp;
        Stack<Point> stack = new Stack<>();
        
        // init map
        int i, j;
        String str;
        for (i = 0; i < row; i++) {
        	str = grid[0];
        	for (j = 0; j < col; j++) {
        		map[i][j] = str.charAt(j);
        		check[i][j] = false;
        	}
        }
        	
        // find way
        p = new Point(0, 0);
        int move = k;
    	check[p.x][p.y] = true;
    	
        while (p.x != (row - 1) || p.y != (col - 1)) {
        	if (move == 0) {
        		temp = p;
        		while(map[temp.x][temp.y] == 'F' && !stack.isEmpty()){
            		temp = stack.pop();
            		check[temp.x][temp.y] = false;
            	};
            	p.x = temp.x;
            	p.y = temp.y;
        		check[temp.x][temp.y] = true;
            	move = k;
            	answer++;
            	System.out.println(p.x + ", " + p.y + " " + move);
    		}
        	
        	if (p.x + 1 < row && map[p.x + 1][p.y] != '#' && check[p.x][p.y] == false) {
        		move--;
    			p.x = p.x + 1;
    			p.y = p.y;
    			check[p.x][p.y] = true;
    			stack.push(new Point(p.x, p.y));
    			System.out.println(p.x + ", " + p.y);
    			continue;
    		}
        	
        	if (p.x - 1 >= 0  && map[p.x - 1][p.y] != '#' && check[p.x - 1][p.y] == false) {
    			move--;
    			p.x = p.x - 1;
    			p.y = p.y;
    			check[p.x][p.y] = true;
    			stack.push(new Point(p.x, p.y));
    			System.out.println(p.x + ", " + p.y);
    			continue;
    		}
        	
        	if (p.y + 1 < col && map[p.x][p.y + 1] != '#' && check[p.x][p.y + 1] == false) {
    			move--;
    			p.x = p.x;
    			p.y = p.y + 1;
    			check[p.x][p.y] = true;
    			stack.push(new Point(p.x, p.y));
    			System.out.println(p.x + ", " + p.y);
    			continue;
    		}
        	
        	if (p.y - 1 >= 0 && map[p.x][p.y - 1] != '#' && check[p.x][p.y - 1] == false) {
    			move--;
    			p.x = p.x;
    			p.y = p.y - 1;
    			check[p.x][p.y] = true;
    			stack.push(new Point(p.x, p.y));
    			System.out.println(p.x + ", " + p.y);
    			continue;
    		}
        	
        	if (stack.isEmpty()) {
        		System.out.println("ERROR!");
        		return -1;
        	}
        	else {
        		move++;
        		p = stack.pop();
        		check[p.x][p.y] = false;
        		System.out.println("POP " + p.x + ", " + p.y);
        	}
        }
        
        return answer;
    }
	
    public static void main(String[] args) {
    	String[] grid = {
    			".F.FFFFF.F", ".########.", ".########F", "...######F",
    			"##.######F", "...######F", ".########F", ".########.",
    			".#...####F", "...#......"};
    	int k = 6;
    	
    	Solution s = new Solution();
    	System.out.println(s.solution(grid, k));
    }
    
    */
}