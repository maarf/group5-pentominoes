public class Solver
{

	private Stepper stepper;
	private Board board;
	private Pentomino[] pentominoes;
	
	/**
	 * Initializes solver with the right size board, stepper and some other things
	 * @param pentominoesList the list of pentominoes
	 * @param boardWidth the number of columns the board has
	 * @param boardHeight the number of rows the board has
	 */
	public Solver(Pentomino[] pentominoesList, int boardWidth, int boardHeight)
	{
		stepper = new Stepper(boardWidth * boardHeight / 5, pentominoesList.length);
		board = new Board(boardWidth, boardHeight);
		pentominoes = pentominoesList;
	}
	
	public int solve()
	{
		int solvedBoards = 0;
		int step = 0;
		while(stepper.step()) {
			if (step % 1000 == 0)
				System.out.println(step + " " + solvedBoards);
			step++;
			int[] currentMap = stepper.getMap();
			// Clear the previous board
			board.clear();
			
			// Lets find each pentominoes mutation count
			int[] mutationCounts = new int[currentMap.length];
			int totalMutationsCount = 1;
			for (int i = 0; i < currentMap.length; i++) {
				int mutationsCount = pentominoes[currentMap[i] - 1].getMutations().length;
				totalMutationsCount = totalMutationsCount * mutationsCount;
				mutationCounts[i] = mutationsCount;
			}
			
			int[] mutationsMap = new int[currentMap.length];
			for (int i = 0; i < mutationsMap.length; i++) {
				mutationsMap[i] = 1;
			}
			
			for(int foo = 0; foo < totalMutationsCount; foo++) {
				
				// Iterating trough the selected pentominoes
				for (int i = 0; i < currentMap.length; i++) {
					Pentomino pent = (Pentomino) pentominoes[currentMap[i] - 1].getMutations()[mutationsMap[i] - 1];
					boolean added = board.addPentomino(pent, board.getNextBlankX(), board.getNextBlankY());
					if (!added) {
						break;
					}
				}
//				System.out.println(board.toString());
				if (board.isSolved()) {
					solvedBoards++;
				}
				
				
//				System.out.println("x:" +board.getNextBlankX() + " y:" + board.getNextBlankY());
//				System.out.println(currentMap[0] + "	" + currentMap[1] + "	" + currentMap[2] + "	" + currentMap[3] + "	" + currentMap[4] + "	" + currentMap[5]);
//				System.out.println(mutationCounts[0] + "	" + mutationCounts[1] + "	" + mutationCounts[2] + "	" + mutationCounts[3] + "	" + mutationCounts[4] + "	" + mutationCounts[5]);
//				System.out.println(mutationsMap[0] + "	" + mutationsMap[1] + "	" + mutationsMap[2] + "	" + mutationsMap[3] + "	" + mutationsMap[4] + "	" + mutationsMap[5]);
//				System.out.println();
//				System.out.println(board.toString());
//				System.out.println();
//				System.out.println();
			
//				try {
//					Thread.sleep(500);
//				} catch(Exception e) {
//					//break;
//				}

				
				board.clear();
				
				// Next mutation
				for (int i = 0; i < mutationsMap.length; i++) {
					int index = mutationsMap.length - 1 - i;
					if (mutationsMap[index] < mutationCounts[index]) {
						mutationsMap[index]++;
						break;
					} else {
						mutationsMap[index] = 1;
					}
				}
			}
		}
		return solvedBoards;
	}
	
}