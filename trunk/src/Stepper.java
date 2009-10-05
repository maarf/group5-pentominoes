import java.util.Scanner;

public class Stepper {
	
	public static void main(String[] args) {
		Stepper stepper = new Stepper();
		Scanner in = new Scanner(System.in);
		boolean stop = false;
		do {
			System.out.println(stepper.toString());
			stepper.step();
			if (in.next() == "q") {
				stop = true;
			}
		} while(!stop);
	}
	
	public Stepper() {
		this(6, 12);
	}
	
	public Stepper(int countOfLevels, int countOfChoices) {
		choices = countOfChoices;
		levels = countOfLevels;
		map = new int[levels];
	}
	
	public void step() {
		if (map[levels - 1] == choices - 1) {
			map[levels - 1] = 0;
			for (int i = 0; i < levels - 1; i++){
				if (map[levels - 2 - i] == choices - 1) {
					map[levels - 2 - i] = 0;
				} else {
					map[levels - 2 - i]++;
					break;
				}
			}
		} else {
			map[levels - 1]++;
		}
	}
	
	public String toString() {
		return new String(map[0] + " " + map[1] + " " + map[2] + " " + map[3] + " " + map[4] + " " + map[5]);
	}
	
	private int choices;
	private int levels;
	private int[] map;
}
