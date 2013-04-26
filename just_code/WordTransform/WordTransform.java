/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordtransform;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shahyar
 */
public class WordTransform {

    private ArrayList<String> arrWords = new ArrayList<String>();
    private ArrayList<Path> arrPaths = new ArrayList<Path>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String strFileName = "D:\\Coding\\code-foo-2013\\three-letter-words.txt";
        String strFileName = new String();
        String strStartWord = new String();
        String strEndWord = new String();

        WordTransform wt = new WordTransform();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Words File: ");
            strFileName = br.readLine().toUpperCase();
            wt.loadWordListFromFile(strFileName);
        } catch (Exception ex) {
            Logger.getLogger(WordTransform.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.print("Initial Word: ");
        while ((strStartWord.length() != 3) || (!wt.arrWords.contains(strStartWord))) {
            try {
                System.out.print("\nPlease enter a 3-letter word from the file " + strFileName + ": ");
                strStartWord = br.readLine().toUpperCase();
            } catch (IOException ex) {
                Logger.getLogger(WordTransform.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.print("Final Word: ");
        while ((strEndWord.length() != 3) || (!wt.arrWords.contains(strEndWord))) {
            try {
                System.out.print("\nPlease enter a 3-letter word from the file " + strFileName + ": ");
                strEndWord = br.readLine().toUpperCase();
            } catch (IOException ex) {
                Logger.getLogger(WordTransform.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(WordTransform.class.getName()).log(Level.SEVERE, null, ex);
        }

        Path startPath = new Path(strStartWord);
        wt.arrPaths.add(startPath);

        while (wt.findPaths()) {
        }

        if (wt.existsPath(strEndWord)) {
            System.out.println(wt.getPath(strEndWord));
        } else {
            System.out.println("Path from " + strStartWord + " to " + strEndWord + " not found, :-(");
        }
//        System.out.println();
//        System.out.println("DONE!");
    }

    public void loadWordListFromFile(String strFileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(strFileName));
        String strLine;

        while ((strLine = br.readLine()) != null && (!strLine.equals(""))) {
            arrWords.add(strLine);
        }
    }

    public int getDistance(String strLeft, String strRight) {
        int returnValue = 0;
        int nSize = strLeft.length();

        for (int i = 0; i < nSize; i++) {
            char strLeftWordChar = strLeft.toUpperCase().charAt(i);
            char strRightWordChar = strRight.toUpperCase().charAt(i);
            if (strLeftWordChar != strRightWordChar) {
                returnValue++;
            }
        }

        return returnValue;
    }

    public boolean findPaths() {
        boolean foundPath = false;

        int currentSize = arrPaths.size();

        for (int i = 0; i < currentSize; i++) {
            Path currentPath = arrPaths.get(i);
            String lastWord = currentPath.getArrWords().get(currentPath.getDistance());

            for (int j = 0; j < arrWords.size(); j++) {
                String strArrWord = arrWords.get(j);
                if (getDistance(lastWord, strArrWord) == 1) {
                    Path newPath = new Path(currentPath);

                    newPath.add(strArrWord);

                    arrPaths.add(newPath);
                    foundPath = true;

                    arrWords.remove(j);
                    j--;
                }
            }
        }

        return foundPath;
    }

    public boolean existsPath(String strEnd) {
        boolean returnValue = false;

        for (int i = 0; i < arrPaths.size(); i++) {
            Path currentPath = arrPaths.get(i);
            for (int j = 0; j < currentPath.getDistance() + 1; j++) {
                String lastWord = currentPath.getArrWords().get(currentPath.getDistance());
                if (lastWord.equalsIgnoreCase(strEnd)) {
                    returnValue = true;
                }
            }
        }

        return returnValue;
    }

    public Path getPath(String strEnd) {
        Path returnPath = null;

        for (int i = 0; i < arrPaths.size(); i++) {
            Path currentPath = arrPaths.get(i);
            for (int j = 0; j < currentPath.getDistance() + 1; j++) {
                String lastWord = currentPath.getArrWords().get(currentPath.getDistance());
                if (lastWord.equalsIgnoreCase(strEnd)) {
                    returnPath = currentPath;
                }
            }
        }

        return returnPath;
    }
}
