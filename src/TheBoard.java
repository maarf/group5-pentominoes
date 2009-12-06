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
	private Figure activeFigure;
	private Figure[] figures;
	private int activeFigurePositionX;
	private int activeFigurePositionY;
	
    public TheBoard(int x, int y, Figure[] figuresList)
    {
        board = new int[x][y];
        figures = figuresList;
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
    	
    	// Lets check if the board is already full!
    	for (int i = 0; i < 5; i++) {
			if (board[activeFigure.getX(i) + activeFigurePositionX][activeFigure.getY(i) + activeFigurePositionY] != 0) {
				resetBoard();
			}
		}

    }

	public void moveLeft() {
    	if(activeFigurePositionX > 0) {
        	for (int i = 0; i < 5; i++) {
    			if (board[activeFigure.getX(i) + activeFigurePositionX - 1][activeFigure.getY(i) + activeFigurePositionY] != 0) {
    				return;
    			}
        	}
    		activeFigurePositionX -= 1;
    	}
    }
   
    public void moveRight() {
    	if(activeFigurePositionX < getWidth() - activeFigure.getWidth()) {
        	for (int i = 0; i < 5; i++) {
    			if (board[activeFigure.getX(i) + activeFigurePositionX + 1][activeFigure.getY(i) + activeFigurePositionY] != 0) {
    				return;
    			}
        	}
    		activeFigurePositionX += 1;
    	}
    }
    
    public boolean moveDown() {
    	if(activeFigurePositionY >= getHeight() - activeFigure.getHeight()) {
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
		}
    }
    
    public int[][] returnBoard()
    {
    	int[][] tempBoard = new int[getWidth()][getHeight()];
    	for (int i = 0; i < tempBoard.length; i++) {
			for (int j = 0; j < tempBoard[i].length; j++) {
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
    
    private void resetBoard() {
    	for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
    	addActiveFigure(activeFigure.randomPicker(figures));
    }
}
