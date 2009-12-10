import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class represents a game board
 * @author Leoni Haagmans, Ronald Gerits, Martins Spilners
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
	
	/**
	 * Constructs a certain sized board with reference to next figure generator 
	 * @param x width
	 * @param y height
	 * @param next next figure generator
	 */
    public TheBoard(int x, int y, NextFigureBoard next)
    {
        board = new int[x][y];
        score = new Score();
        nextFigureBoard = next;
    }

    /**
     * Constructs a certain sized board
     * @param x width
     * @param y height
     */
    public TheBoard(int x, int y)
    {
        board = new int[x][y];
    }
    
    /**
     * Places a figure on the board
     * @param b figure
     * @param x x coordinate
     * @param y y coordinate
     */
    public void placePentomino(Figure b, int x, int y)
    {
    	for (int i = 0; i < 5; i++) {
			board[b.getX(i) + x][b.getY(i) + y] = b.getName();
		}
    	checkFullLines();
    }
    
    
    /**
     * Adds an active figure to the board.
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

    /**
     * returns offsets of the active pentomino
     * @return array of offsets
     */
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
    
    /**
     * returns active figures x coordinate with offset
     * @return x coordinate
     */
    public int getActiveFigureAbsoluteX() {
    	return activeFigurePositionX + getActiveFigureOffsets()[0];
    }

    /**
     * returns active figures y coordinate with offset
     * @return y coordinate
     */
    public int getActiveFigureAbsoluteY() {
    	return activeFigurePositionY + getActiveFigureOffsets()[1];
    }
    
    /**
     * moves active figure to left
     */
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
   
	/**
	 * moves active figure to the right
	 */
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
    
    /**
     * moves active figure to the bottom
     * @return true if is coliding with other figures
     */
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

    /**
     * moves active pentomino down until it hits other figure 
     */
    public void moveToBottom() {
    	while(moveDown()) {
    		// do nothiiiiing, just wait
    	}
    }
    
    /**
     * rotates active figure
     */
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

    /**
     * checks for full lines and remove them
     */
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
			
				i--;
			linesRemoved++;
		}
    	score.increaseScore(linesRemoved, justRemoved);
    }
    
    /**
     * returns board
     * @return board
     */
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

    /**
     * returns next figure picked randomly
     * @return random figure
     */
    public Figure getNextFigure() {
    	Figure ret = nextFigureBoard.getNext();
    	return ret;
    }
    
    /**
     * returns height of the board
     * @return height
     */
    public int getHeight()
    {
        return board[0].length;
    }

    /**
     * returns width of the board
     * @return width
     */
    public int getWidth()
    {
        return board.length;
    }
    
    /**
     * returns the count of lines that have been removed
     * @return count of lines
     */
    public int getLinesRemoved() {
    	return linesRemoved;
    }

    /**
     * returns total score
     * @return score
     */
    public int getScore()
    {
        return score.getScore();
    }

    /**
     * returns the number of level
     * @return level
     */
    public int getLevel()
    {
        return score.getLevel();
    }
    
    public HighScoreKeeper highScores;
    
    /**
     * resets the board to nicely fresh one
     */
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
