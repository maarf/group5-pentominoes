


public class BruteSolver
{
	
	private Pentomino[] pentominoes;
	private Board board;
	private int width, height, choices, levels, solutionsCount;
	private int[] pentominoesMap, rotationsMap;
	private boolean walked = false;
	
	public BruteSolver(Pentomino[] pentominoesList, int aWidth, int aHeight)
	{
		
		pentominoes = pentominoesList;
		height = aHeight;
		width = aWidth;
		board = new Board(width, height);
		
		choices = pentominoes.length;
		levels = width * height / 5;

	}	
	
	public int solve()
	{
		solutionsCount = 0;
		
		while(!walked) {
			if(step()) {
				
			}
		}
		
		return solutionsCount;
	}
	
	public boolean step()
	{

		int firstNiceLevel = 0;
		
		if (pentominoesMap[0] != 0) {
			// If the man is not blank, try to increment numbers
			// If we need to increment next number, we mark the previous one as 0
			
			branchSearch:
			for (int i = 0; i < levels; i++)
			{
				// We go through levels starting from the last one
				for (int j = 0; j < choices - pentominoesMap[levels - 1 - i]; j++)
				{
					// We go trough all possible choices left for that pentomino until some is possible  
					if (isAvailable(levels - i, pentominoesMap[levels - 1 - i] + 1 + j))
					{
						firstNiceLevel = levels - i;
						pentominoesMap[levels - 1 - i] = pentominoesMap[levels - 1 - i] + 1 + j;
						break branchSearch;
					}
				}
				// So this level have no more possible values, mark it for that shame!
				pentominoesMap[levels - 2 - i] = 0;
			}
		}
		
		// In case we try to take another round
		if(pentominoesMap[0] == 0 && solutionsCount > 0) {
			walked = true;
			return false;
		}
		
		// Lets fill the blank spots
		int lastNewValue = 0;
		for (int i = 0; i < levels - firstNiceLevel; i++) {
			for (int j = lastNewValue + 1; j < choices + 1; j++) {
				if (isAvailable(firstNiceLevel + 1 + i, j)) {
					pentominoesMap[firstNiceLevel + i] = j;
					lastNewValue = j;
					break;
				}
			}
		}
		return true;
	}
	
	
	
	private boolean isAvailable(int level, int choice) {
		for (int i = 0; i < level - 1; i++) {
			if (pentominoesMap[i] == choice) {
				return false;
			}
		}
		return true;
	}
	
	public int[] getMap() {
		return pentominoesMap;
	}
	
}
