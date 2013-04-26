/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Shahyar
 */
class LetterGrid {

    private ArrayList<LetterGridRow> arrRows = new ArrayList<LetterGridRow>();

    /**
     * @return the arrRows
     */
    public ArrayList<LetterGridRow> getRows() {
        return arrRows;
    }

    /**
     * @param arrRows the arrRows to set
     */
    public void setRows(ArrayList<LetterGridRow> arrRows) {
        this.arrRows = arrRows;
    }

    public String get(int i, int j) {
        return arrRows.get(i).get(j);
    }

    public void add(int i, String strValue) {

        arrRows.get(i).add(strValue);
    }

    public void loadLetterGridFromFile(String strFileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(strFileName));
        String strLine;

        while ((strLine = br.readLine()) != null && (!strLine.equals(""))) {
            String[] arrLine = strLine.split("\t");
            LetterGridRow letterGridRow = new LetterGridRow();

            for (int nColumn = 0; nColumn < arrLine.length; nColumn++) {
                letterGridRow.add(arrLine[nColumn]);
            }

            arrRows.add(letterGridRow);
        }
    }

    public String toString() {
        StringBuilder returnString = new StringBuilder();

        for (int i = 0; i < arrRows.size(); i++) {
            for (int j = 0; j < arrRows.get(i).getColumns().size(); j++) {
                returnString.append(get(i, j));
            }
            returnString.append("\n");
        }

        return returnString.toString();
    }
}

class LetterGridRow {

    private ArrayList<String> arrColumns = new ArrayList<String>();

    /**
     * @return the columns
     */
    public ArrayList<String> getColumns() {
        return arrColumns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(ArrayList<String> columns) {
        this.arrColumns = columns;
    }

    public String get(int i) {
        return arrColumns.get(i);
    }

    public void add(String strValue) {
        arrColumns.add(strValue);
    }
}