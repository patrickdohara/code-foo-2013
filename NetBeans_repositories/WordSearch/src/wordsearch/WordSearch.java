/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shahyar
 */
public class WordSearch {

    private LetterGrid letterGrid = new LetterGrid();
    private ArrayList<String> arrWordList = new ArrayList<String>();
    private ArrayList<GridWord> arrGridWordList = new ArrayList<GridWord>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String strFileName = "D:\\Coding\\code-foo-2013\\word-search.txt";
        String strFileName = new String();

        WordSearch ws = new WordSearch();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Word Search File: ");
        try {
            strFileName = br.readLine().toUpperCase();
            ws.letterGrid.loadLetterGridFromFile(strFileName);
            ws.loadWordListFromFile(strFileName);
        } catch (Exception ex) {
            Logger.getLogger(WordSearch.class.getName()).log(Level.SEVERE, null, ex);
        }


        System.out.print(ws.letterGrid);
        System.out.println();
        System.out.print(ws.arrWordList2String());

        for (int row = 0; row < ws.letterGrid.getRows().size(); row++) {
            for (int col = 0; col < ws.letterGrid.getRows().get(row).getColumns().size(); col++) {
                ws.checkLocation(row, col, "", "init", new GridWord());
            }
        }

        System.out.println();
        System.out.print(ws.arrGridWordList2String());
    }

    private void loadWordListFromFile(String strFileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(strFileName));
        String strLine;

        while ((strLine = br.readLine()) != null && (!strLine.contains("find:"))) {
        }

        while ((strLine = br.readLine()) != null && (!strLine.equals(""))) {
            strLine = strLine.replaceAll(" ", "").toLowerCase();

            arrWordList.add(strLine);
        }

        Collections.sort(arrWordList);
    }

    private void checkLocation(int row, int col, String strCurrentValue, String strDirection, GridWord currentGridWord) {
        StringBuilder strNewValue = new StringBuilder();
        strNewValue.append(strCurrentValue).append(letterGrid.get(row, col));
//        strCurrentValue.append(letterGrid.get(row, col));

        GridWord gridWord = new GridWord();

        gridWord.setArrLocations(currentGridWord.copyArrLocations());

        if (wordListContainsSubword(strNewValue.toString())) {
            gridWord.addLocation(row, col);
            if (arrWordList.contains(strNewValue.toString())) {
                gridWord.setStrValue(strNewValue.toString());
                arrGridWordList.add(gridWord);
            } else {
                if (strDirection.equalsIgnoreCase("north-west") || strDirection.equalsIgnoreCase("init")) {
                    if ((row - 1 >= 0) && (col - 1 >= 0)) {
                        checkLocation(row - 1, col - 1, strNewValue.toString(), "north-west", gridWord);
                    }
                }
                if (strDirection.equalsIgnoreCase("north") || strDirection.equalsIgnoreCase("init")) {
                    if (row - 1 >= 0) {
                        checkLocation(row - 1, col, strNewValue.toString(), "north", gridWord);
                    }
                }
                if (strDirection.equalsIgnoreCase("north-east") || strDirection.equalsIgnoreCase("init")) {
                    if (row - 1 >= 0) {
                        if (col + 1 < letterGrid.getRows().get(row - 1).getColumns().size()) {
                            checkLocation(row - 1, col + 1, strNewValue.toString(), "north-east", gridWord);
                        }
                    }
                }

                if (strDirection.equalsIgnoreCase("west") || strDirection.equalsIgnoreCase("init")) {
                    if (col - 1 >= 0) {
                        checkLocation(row, col - 1, strNewValue.toString(), "west", gridWord);
                    }
                }
                if (strDirection.equalsIgnoreCase("east") || strDirection.equalsIgnoreCase("init")) {
                    if (col + 1 < letterGrid.getRows().get(row).getColumns().size()) {
                        checkLocation(row, col + 1, strNewValue.toString(), "east", gridWord);
                    }
                }

                if (strDirection.equalsIgnoreCase("south-west") || strDirection.equalsIgnoreCase("init")) {
                    if ((row + 1 < letterGrid.getRows().size()) && (col - 1 >= 0)) {
                        checkLocation(row + 1, col - 1, strNewValue.toString(), "south-west", gridWord);
                    }
                }
                if (strDirection.equalsIgnoreCase("south") || strDirection.equalsIgnoreCase("init")) {
                    if (row + 1 < letterGrid.getRows().size()) {
                        checkLocation(row + 1, col, strNewValue.toString(), "south", gridWord);
                    }
                }
                if (strDirection.equalsIgnoreCase("south-east") || strDirection.equalsIgnoreCase("init")) {
                    if (row + 1 < letterGrid.getRows().size()) {
                        if (col + 1 < letterGrid.getRows().get(row + 1).getColumns().size()) {
                            checkLocation(row + 1, col + 1, strNewValue.toString(), "south-east", gridWord);
                        }
                    }
                }
            }
        }
    }

    private boolean wordListContainsSubword(String strSubword) {
        boolean returnValue = false;

        for (int i = 0; i < arrWordList.size(); i++) {
            if (arrWordList.get(i).contains(strSubword)) {
                returnValue = true;
            }
        }

        return returnValue;
    }

    private String arrWordList2String() {
        StringBuilder returnString = new StringBuilder();

        for (int i = 0; i < arrWordList.size(); i++) {
            returnString.append(arrWordList.get(i)).append("\n");
        }

        return returnString.toString();
    }

    private String arrGridWordList2String() {
        StringBuilder returnString = new StringBuilder();

        for (int i = 0; i < arrGridWordList.size(); i++) {
            returnString.append(arrGridWordList.get(i)).append("\n");
        }

        return returnString.toString();
    }
}
