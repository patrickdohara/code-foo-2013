/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordtransform;

import java.util.ArrayList;

/**
 *
 * @author Shahyar
 */
public class Path {

    private ArrayList<String> arrWords = new ArrayList<String>();
    
    public Path(String startWord) {
        this.arrWords.add(startWord);
    }

    public Path(Path basePath) {
        for (int i = 0; i < basePath.arrWords.size(); i++) {
            String nextWord = basePath.getArrWords().get(i);
            this.arrWords.add(nextWord);
        }
    }

    /**
     * @return the arrWords
     */
    public ArrayList<String> getArrWords() {
        return arrWords;
    }

    /**
     * @param arrWords the arrWords to set
     */
    public void setArrWords(ArrayList<String> arrWords) {
        this.arrWords = arrWords;
    }
    
    public void add(String newWord) {
        this.arrWords.add(newWord);
    }

    public int getDistance() {
        return arrWords.size() - 1;
    }

    public String toString() {
        StringBuilder returnString = new StringBuilder();

        returnString.append("Path Size: " + getDistance() + " steps\n");
        
        for (int i = 0; i < arrWords.size(); i++) {
            returnString.append(arrWords.get(i));
            if (i < arrWords.size() - 1) {
                returnString.append(" -> ");
            }
        }

        return returnString.toString();
    }
}
