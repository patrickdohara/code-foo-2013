/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package highscores;

/**
 *
 * @author Shahyar
 */
public class Score implements Comparable<Score> {

    private float nScore;
    private String strName;

    public Score(Score score) {
        this.nScore = score.getnScore();
        this.strName = score.getStrName();
    }

    public Score(float nScore, String strName) {
        this.nScore = nScore;
        this.strName = strName;
    }

    /**
     * @return the nScore
     */
    public float getnScore() {
        return nScore;
    }

    /**
     * @param nScore the nScore to set
     */
    public void setnScore(float nScore) {
        this.nScore = nScore;
    }

    /**
     * @return the strName
     */
    public String getStrName() {
        return strName;
    }

    /**
     * @param strName the strName to set
     */
    public void setStrName(String strName) {
        this.strName = strName;
    }

    @Override
    public int compareTo(Score compareScore) {
        int returnValue = 0;

        if (this.nScore < compareScore.getnScore()) {
            returnValue = -1;
        } else if (this.nScore > compareScore.getnScore()) {
            returnValue = 1;
        }

        return returnValue;
    }

    public String toString() {
        StringBuilder returnString = new StringBuilder();

        returnString.append("Name: ").append(strName).append("\tScore: ").append(nScore);

        return returnString.toString();
    }
}
