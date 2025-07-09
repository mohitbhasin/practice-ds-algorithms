import java.util.*;

class ExclusiveTimeOfFunctions {
	public static void main(String args[]) {
		List<String> events = new ArrayList<>();
		events.add("0:start:0");
		events.add("1:start:2");
		events.add("1:end:3");
		events.add("2:start:4");
		events.add("2:end:7");
		events.add("0:end:8");
		int n = 3;
		for(int val: exclusiveTime(n, events)) {
			System.out.print(val+",");
		}
	}

	public static int[] exclusiveTime(int n, List<String> logs) {
		Stack<String[]> stack = new Stack<>();
		int[] result = new int[n];
		for(String log: logs) {
			String[] currLog = log.split(":");
			if(currLog[1].equals("start")) {
				stack.push(currLog);
			} else {
				String[] temp = stack.pop();
				result[Integer.parseInt(currLog[0])]+=Integer.parseInt(currLog[2]) - Integer.parseInt(temp[2]) + 1;
				
				if(!stack.isEmpty()) {
					result[Integer.parseInt(stack.peek()[0])]-=Integer.parseInt(currLog[2]) - Integer.parseInt(temp[2]) + 1;
				}
			}
		}
		return result;
    }
}