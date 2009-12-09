import java.io.Serializable;


public class HighScoreKeeper implements Serializable {

	private int[] scores;
	private String[] names; 
	
	public HighScoreKeeper() {
		scores = new int[6];
		names = new String[6];
	}
	
	public void addScore(int score, String name) {
		if (score > scores[4]) {
			names[5] = name;
			scores[5] = score;
			if (names[5] == null || names[5].equals("")) {
				return;
			}
		} else {
			return;
		}
		
		// Bubble sort, here we go
		for(int i = 0; i < scores.length - 1; i++) {
            for(int j = 0; j < scores.length - 1 - i; j++) {
                if(scores[j] < scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j+1];
                    scores[j + 1] = temp;
                    String temp2 = names[j];
                    names[j] = names[j+1];
                    names[j + 1] = temp2;
                }
            }
        }
		
	}
	
	public int[] getScores() {
		return scores;
	}

	public String[] getNames() {
		return names;
	}

	
}
