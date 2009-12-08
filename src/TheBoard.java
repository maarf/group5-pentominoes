/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leoni Haagmans & Ronald Gerits
 */
public class TheBoard
{
    private int[][] board;
    private int[][] smallBoard;
    private Figure activeFigure;
    private Figure[] figures;
    private int activeFigurePositionX;
    private int activeFigurePositionY;
    private int linesRemoved = 0;
    private int linesRemovedInLastTime = 0;
    private int highscore = 0;
    private Game game;
	
    public TheBoard(int x, int y, Figure[] figuresList, Game aGame)
    {
        board = new int[x][y];
        figures = figuresList;
        game = aGame;
    }

    public TheBoard()
    {

    }
    
    public void placePentomino(Figure b, int x, int y)
    {
    	for (int i = 0; i < 5; i++) {
			board[b.getX(i) + x][b.getY(i) + y] = b.getName();
		}
    	checkFullLines();
    }

    public void addActiveFigure(Figure aFigure) {
    	activeFigure = aFigure;
    	activeFigurePositionX = 0;
    	activeFigurePositionY = 0;
    	activeFigurePositionX = - getActiveFigureAbsoluteX() + ((board.length - activeFigure.getWidth()) / 2);
    	activeFigurePositionY = - getActiveFigureAbsoluteY();
    	
    	// Lets check if the board is already full!
    	for (int i = 0; i < 5; i++) {
			if (board[activeFigure.getX(i) + activeFigurePositionX][activeFigure.getY(i) + activeFigurePositionY] != 0) {
				resetBoard();
			}
		}

    }

    public int[] getActiveFigureOffsets() {
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			if (activeFigure.getX(i) < minX) {
				minX = activeFigure.getX(i);
			}
			if (activeFigure.getY(i) < minY) {
				minY = activeFigure.getY(i);
			}
		}
		int[] ret = {minX, minY}; 
		return ret;

    }
    
    public int getActiveFigureAbsoluteX() {
    	return activeFigurePositionX + getActiveFigureOffsets()[0];
    }

    public int getActiveFigureAbsoluteY() {
    	return activeFigurePositionY + getActiveFigureOffsets()[1];
    }
    
	public void moveLeft() {
    	if(getActiveFigureAbsoluteX() > 0) {
        	for (int i = 0; i < 5; i++) {
    			if (board[activeFigure.getX(i) + activeFigurePositionX - 1][activeFigure.getY(i) + activeFigurePositionY] != 0) {
    				return;
    			}
        	}
    		activeFigurePositionX -= 1;
    	}
    }
   
    public void moveRight() {
    	if(getActiveFigureAbsoluteX() < getWidth() - activeFigure.getWidth()) {
        	for (int i = 0; i < 5; i++) {
    			if (board[activeFigure.getX(i) + activeFigurePositionX + 1][activeFigure.getY(i) + activeFigurePositionY] != 0) {
    				return;
    			}
        	}
    		activeFigurePositionX += 1;
    	}
    }
    
    public boolean moveDown() {
    	if(getActiveFigureAbsoluteY() >= getHeight() - activeFigure.getHeight()) {
    		placePentomino(activeFigure, activeFigurePositionX, activeFigurePositionY);
    		addActiveFigure(activeFigure.randomPicker(figures));
    		return false;    		
    	}
    	
    	for (int i = 0; i < 5; i++) {
			if (board[activeFigure.getX(i) + activeFigurePositionX][activeFigure.getY(i) + activeFigurePositionY + 1] != 0) {
	    		placePentomino(activeFigure, activeFigurePositionX, activeFigurePositionY);
	    		addActiveFigure(activeFigure.randomPicker(figures));
	    		return false;    		
			}
		}
    	
		activeFigurePositionY += 1;
		return true;
    }

    public void moveToBottom() {
    	while(moveDown()) {
    		// do nothiiiiing, just wait
    	}
    }
    
    public void rotateFigure() {
    	activeFigure.rotateClockwise();
    	for (int i = 0; i < 5; i++) {
			if (activeFigure.getX(i) + activeFigurePositionX < 0 ||
					activeFigure.getX(i) + activeFigurePositionX >= board.length ||
					activeFigure.getY(i) + activeFigurePositionY < 0 ||
					activeFigure.getY(i) + activeFigurePositionY >= board[0].length ||
					board[activeFigure.getX(i) + activeFigurePositionX][activeFigure.getY(i) + activeFigurePositionY] != 0) {
		    	activeFigure.rotateCounterClockwise();
				break;
			}
		}

    }

    public void checkFullLines() {
    	lineCheck:
    	for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][board[0].length - i - 1] == 0) {
					continue lineCheck;
				}
			}
			
			for (int j = 0; j < board[0].length - i - 1; j++) {
				for (int j2 = 0; j2 < board.length; j2++) {
					board[j2][board[0].length - i - j - 1] = board[j2][board[0].length - i - j - 2];
				}
			}
			if (i > 0)
				i--;
			linesRemoved++;
			game.initialize(getLinesRemoved());
		}
    }
    
    public int[][] returnBoard()
    {
    	int[][] tempBoard = new int[getWidth()][getHeight()];
    	for (int i = 0; i < tempBoard.length; i++)
        {
            for (int j = 0; j < tempBoard[i].length; j++)
            {
                tempBoard[i][j] = board[i][j];
            }
        }
    	
    	for (int i = 0; i < 5; i++) {
			tempBoard[activeFigure.getX(i) + activeFigurePositionX][activeFigure.getY(i) + activeFigurePositionY] = activeFigure.getName();
		}
        return tempBoard;
    }

    public int getHeight()
    {
        return board[0].length;
    }

    public int getWidth()
    {
        return board.length;
    }
    
    public int getLinesRemoved() {
    	return linesRemoved;
    }

    // José, you'll make the highscoremethod right? I just needed a getHighscore for the GUI!
    public int getHighscore()
    {
        return highscore;
    }
    
    private void resetBoard() {
    	for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
    	linesRemoved = 0;
    	game.reset();
    	addActiveFigure(activeFigure.randomPicker(figures));
    	
    }

    public void Start()
    {
        moveDown();
    }

    public void Stop()
    {
        resetBoard();
    }

    public void Pause()
    {

    }
}
