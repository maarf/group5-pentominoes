
public class NextFigureBoard extends TheBoard {

	private Figure[] figures;
	
	public NextFigureBoard(int x, int y, Figure[] figuresList) {
		super(x, y);
		figures = figuresList;
		addActiveFigure(figures[0].randomPicker(figures));
	}
	
	public Figure getNext() {
		int figure = activeFigure.getName();
		addActiveFigure(figures[0].randomPicker(figures));
		return new Figure(figure);
	}
	
}
