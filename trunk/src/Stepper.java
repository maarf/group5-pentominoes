


public class Stepper {

	public Stepper(int numberOfLevels, int numberOfChoices) {
		choices = numberOfChoices;
		levels = numberOfLevels;
		map = new int[levels];
	}
	
	public boolean step() {
		if(walked) // If already done
			return false;
		
		// If the tree is empty, fill it with fresh fruits!!!1
		if (map[0] == 0) {
			for (int i = 0; i < levels; i++) {
				map[i] = i + 1;
			}
			return true;
		}
		
		// Lets find the next available value for the last level
		for (int i = 0; i < choices - map[levels - 1]; i++) {
			if (isAvailable(levels, map[levels - 1] + 1 + i)) {
				map[levels - 1] = map[levels - 1] + 1 + i;
				return true;
			}
		}

		// So there are no more possible values for the last one, so we need to increment something
		int firstNiceLevel = 0;
		branchSearch:
		for (int i = 0; i < levels - 1; i++) {
			for (int j = 0; j < choices - map[levels - 2 - i]; j++) {
				if (isAvailable(levels - 1 - i, map[levels - 2 - i] + 1 + j)) {
					firstNiceLevel = levels - 1 - i;
					map[levels - 2 - i] = map[levels - 2 - i] + 1 + j;
					break branchSearch;
				}
			}
			// So this level have no more possible values, mark it for that shame!
			map[levels - 2 - i] = 0;
		}
		
		// In case we try to take another round
		if(map[0] == 0) {
			walked = true;
			return false;
		}
		
		// Lets fill the blank spots
		int lastNewValue = 0;
		for (int i = 0; i < levels - firstNiceLevel; i++) {
			for (int j = lastNewValue + 1; j < choices + 1; j++) {
				if (isAvailable(firstNiceLevel + 1 + i, j)) {
					map[firstNiceLevel + i] = j;
					lastNewValue = j;
					break;
				}
			}
		}
		return true;
	}
	
	public boolean isAvailable(int level, int choice) {
		for (int i = 0; i < level - 1; i++) {
			if (map[i] == choice) {
				return false;
			}
		}
		return true;
	}
	
	public int[] getMap() {
		return map;
	}
	
//	public String toString() {
//		// this is the WRONG way :)
//		return new String(map[0] + "	" + map[1] + "	" + map[2] + "	" + map[3] + "	" + map[4] + "	" + map[5]);
//	}
	
	private boolean walked = false;
	private int choices;
	private int levels;
	private int[] map;

}
