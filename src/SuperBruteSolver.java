import java.util.ArrayList;

public class SuperBruteSolver {
		
	private Pentomino[] pentominoes;
	private Board board;
	private int width, height, choices, levels, solutionsCount;
	private int[] pentominoesMap, rotationsMap;
	private boolean walked = false;
	
	public SuperBruteSolver(Pentomino[] pentominoesList, int aWidth, int aHeight)
	{
		
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
		
//		pentominoes = pentominoesList;
		height = aHeight;
		width = aWidth;
		board = new Board(width, height);
		
		choices = pentominoes.length;
		levels = width * height / 5;
		solutionsCount = 0;
		
	}
	
	public int solve()
	{
		int moves = 0;
		// The first level
		for (Pentomino pent1 : pentominoes) {
			if (!board.addPentomino(pent1, board.getNextBlankX(), board.getNextBlankY())) {
				continue;
			}
			moves++;
			
			for (Pentomino pent2 : pentominoes) {
				if (pent2.getId() == pent1.getId() ||
						!board.addPentomino(pent2, board.getNextBlankX(), board.getNextBlankY())) {
					continue;
				}
				moves++;
				
				for (Pentomino pent3 : pentominoes) {
					if (pent3.getId() == pent1.getId() || pent3.getId() == pent2.getId() ||
							!board.addPentomino(pent3, board.getNextBlankX(), board.getNextBlankY())) {
						continue;
					}
					moves++;
					
					for (Pentomino pent4 : pentominoes) {
						if (pent4.getId() == pent1.getId() || pent4.getId() == pent2.getId() || pent4.getId() == pent3.getId() ||
								!board.addPentomino(pent4, board.getNextBlankX(), board.getNextBlankY())) {
							continue;
						}
						moves++;
						
						for (Pentomino pent5 : pentominoes) {
							if (pent5.getId() == pent1.getId() || pent5.getId() == pent2.getId() || pent5.getId() == pent3.getId() || pent5.getId() == pent4.getId() ||
									!board.addPentomino(pent5, board.getNextBlankX(), board.getNextBlankY())) {
								continue;
							}
							moves++;
							
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
									solutionsCount++;
									System.out.println(solutionsCount);
								}
								
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
