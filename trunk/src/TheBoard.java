import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
    public Figure activeFigure;
	private int activeFigurePositionX;
	private int activeFigurePositionY;
	private int linesRemoved = 0;
	private Score score;
	public JFrame frame;
    
	private NextFigureBoard nextFigureBoard;
	
    public TheBoard(int x, int y, NextFigureBoard next)
    {
        board = new int[x][y];
        score = new Score();
        nextFigureBoard = next;
    }

    public TheBoard(int x, int y)
    {
        board = new int[x][y];
    }
    
    public void placePentomino(Figure b, int x, int y)
    {
    	for (int i = 0; i < 5; i++) {
			board[b.getX(i) + x][b.getY(i) + y] = b.getName();
		}
    	checkFullLines();
    }
    
    
    /**
     * Adds a figure to the board.
     * @param aFigure The figure to be added
     */
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
    		addActiveFigure(getNextFigure());
    		return false;    		
    	}
    	
    	for (int i = 0; i < 5; i++) {
			if (board[activeFigure.getX(i) + activeFigurePositionX][activeFigure.getY(i) + activeFigurePositionY + 1] != 0) {
	    		placePentomino(activeFigure, activeFigurePositionX, activeFigurePositionY);
	    		addActiveFigure(getNextFigure());
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
    	int justRemoved = 0;
    	lineCheck:
    	for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][board[0].length - i - 1] == 0) {
					continue lineCheck;
				}
			}
			justRemoved++; 
			for (int j = 0; j < board[0].length - i - 1; j++) {
				for (int j2 = 0; j2 < board.length; j2++) {
					board[j2][board[0].length - i - j - 1] = board[j2][board[0].length - i - j - 2];
				}
			}
			if (i > 0)
				i--;
			linesRemoved++;
		}
    	score.increaseScore(linesRemoved, justRemoved);
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

    public Figure getNextFigure() {
    	Figure ret = nextFigureBoard.getNext();
    	return ret;
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

    public int getScore()
    {
        return score.getScore();
    }

    public int getLevel()
    {
        return score.getLevel();
    }
    
    public HighScoreKeeper highScores;
    
    private void resetBoard() {
    	highScores.addScore(getScore(), (String)JOptionPane.showInputDialog(frame, "Your name, please..."));
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("highscores.dat"));
			out.writeObject(highScores);
		} catch (Exception e) { /* (-_-) */ }

    	
    	for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
    	linesRemoved = 0;
    	score = new Score();
    	addActiveFigure(getNextFigure());
    	
    }
}
