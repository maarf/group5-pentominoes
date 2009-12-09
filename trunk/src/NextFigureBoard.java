
public class NextFigureBoard extends TheBoard {

	private Figure[] figures;
	/**
	 * adds a next figure on the little board next to the big board
	 * @param x
	 * @param y
	 * @param figuresList
	 */
	public NextFigureBoard(int x, int y, Figure[] figuresList) {
		super(x, y);
		figures = figuresList;
		addActiveFigure(figures[0].randomPicker(figures));
	}
	/**
	 * gets the next pentomino that will be played
	 * @return
	 */
	public Figure getNext() {
		int figure = activeFigure.getName();
		addActiveFigure(figures[0].randomPicker(figures));
		return new Figure(figure);
	}
	
}
