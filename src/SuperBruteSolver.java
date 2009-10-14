import java.util.ArrayList;

/**
 * Solves a board of certain size with given pentominoes.
 * This solver is kind of brute force. There is no much intelligence here. The board is
 * responsible for placing the pentomino on itself, so it helps a little bit.  
 * 
 * 15/09/2009
 * 
 * @author Martins Spilners, Roland Gerits, Leoni Haagmans
 * @version 0.1
 */

public class SuperBruteSolver {
		
	private Pentomino[] pentominoes;
	private Board board;
	private int solutionsCount;
	
	
	/**
	 * Constructs solver by making the board and finding all the mutations for all pentominoes.
	 * @param pentominoesList list of pentominoes
	 * @param aWidth width of the board
	 * @param aHeight height if the board
	 */
	public SuperBruteSolver(Pentomino[] pentominoesList, int aWidth, int aHeight)
	{
		// Lets get all the mutations of all pentominoes.
		ArrayList<Pentomino> allMutations = new ArrayList<Pentomino>();
		int totalMutationsCount = 0;
		
		for (Pentomino pentomino : pentominoesList) {
			Object[] mutations = pentomino.getMutations();
			totalMutationsCount += mutations.length;
			for (Object mutation : mutations) {
				allMutations.add((Pentomino) mutation);
			}
		}
		
		pentominoes = new Pentomino[totalMutationsCount];
		int i = 0;
		for (Pentomino pentomino : allMutations) {
			pentominoes[i] = pentomino;
			i++;
		}
		
		// Lets make the board.
		board = new Board(aWidth, aHeight);
		
		solutionsCount = 0;
	}
	
	
	/**
	 * The board solver.
	 * Basically it tries all the pentominoes at all six positions (first, second and so on).
	 * Some checks:
	 *  a) if the chosed pentomino already is somewhere on the board, we skip,
	 *  b) if the pentomino does not fit at the place, we skip.
	 * @return the count of possible boards that can be filled with given pentominoes
	 */
	public int solve()
	{
		int moves = 0;
		// The first pentomino.
		for (Pentomino pent1 : pentominoes) {
			if (!board.addPentomino(pent1, board.getNextBlankX(), board.getNextBlankY())) {
				continue;
			}
			moves++;
			
			// The second pentomino.
			for (Pentomino pent2 : pentominoes) {
				if (pent2.getId() == pent1.getId() ||
						!board.addPentomino(pent2, board.getNextBlankX(), board.getNextBlankY())) {
					continue;
				}
				moves++;
				
				// The third pentomino.
				for (Pentomino pent3 : pentominoes) {
					if (pent3.getId() == pent1.getId() || pent3.getId() == pent2.getId() ||
							!board.addPentomino(pent3, board.getNextBlankX(), board.getNextBlankY())) {
						continue;
					}
					moves++;
					
					// The fourth pentomino.
					for (Pentomino pent4 : pentominoes) {
						if (pent4.getId() == pent1.getId() || pent4.getId() == pent2.getId() || pent4.getId() == pent3.getId() ||
								!board.addPentomino(pent4, board.getNextBlankX(), board.getNextBlankY())) {
							continue;
						}
						moves++;
						
						// The fifth pentomino.
						for (Pentomino pent5 : pentominoes) {
							if (pent5.getId() == pent1.getId() || pent5.getId() == pent2.getId() || pent5.getId() == pent3.getId() || pent5.getId() == pent4.getId() ||
									!board.addPentomino(pent5, board.getNextBlankX(), board.getNextBlankY())) {
								continue;
							}
							moves++;
							
							// The sixth and last pentomino.
							for (Pentomino pent6 : pentominoes) {
								if (pent6.getId() == pent1.getId() || pent6.getId() == pent2.getId() || pent6.getId() == pent3.getId() || pent6.getId() == pent4.getId() || pent6.getId() == pent5.getId() ||
										!board.addPentomino(pent6, board.getNextBlankX(), board.getNextBlankY())) {
									continue;
								}
								moves++;
								
								// Uhh, huhh, soooo deeeepp!!!
								
								/*
								 * Some disclaimer:
								 * Yeah, I know it's bad to nest like more than three loops, but still,
								 * this is the first implementation that
								 * a) calculates the CORRECT result,
								 * b) does that all in a split second.
								 * So I hope that you'll forgive me. Of course I will think how to do this
								 * some other way. Recursion anyone?
								 */
								
								if (board.isSolved()) {
									// Actually this check should not be necessary because if the last
									// pentomino fit on the board, there should not be blank spots.
									// But for safety we still can do that. 
									solutionsCount++;
//									System.out.println(solutionsCount);
//									System.out.println(board.toString() + "\n");
								}
								
								
								// Once the pentomino has tried out, we can remove it and
								// try others.
								board.removePentomino(pent6);
							}
							board.removePentomino(pent5);
						}
						board.removePentomino(pent4);
					}
					board.removePentomino(pent3);
				}	
				board.removePentomino(pent2);
			}
			board.removePentomino(pent1);
		}

		System.out.println("Total nodes touched: " + moves);
		
		return solutionsCount;
	}	
}
