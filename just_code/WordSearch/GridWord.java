/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearch;

import java.util.ArrayList;

/**
 *
 * @author Shahyar
 */
public class GridWord {

    private String strValue;
    private ArrayList<Location> arrLocations = new ArrayList<Location>();

    /**
     * @return the strValue
     */
    public String getStrValue() {
        return strValue;
    }

    /**
     * @param strValue the strValue to set
     */
    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    /**
     * @return the arrLocations
     */
    public ArrayList<Location> getArrLocations() {
        return arrLocations;
    }

    /**
     * @param arrLocations the arrLocations to set
     */
    public void setArrLocations(ArrayList<Location> arrLocations) {
        this.arrLocations = arrLocations;
    }
    
    public ArrayList<Location> copyArrLocations() {
        ArrayList<Location> returnList = new ArrayList<Location>();
        
        for (int i = 0; i < arrLocations.size(); i++) {
            Location loc = new Location();
            
            loc.setRow(arrLocations.get(i).getRow());
            loc.setCol(arrLocations.get(i).getCol());
            
            returnList.add(loc);
        }
        
        return returnList;
    }

    public Location get(int i) {
        return arrLocations.get(i);
    }

    public void addLocation(int row, int col) {
        Location loc = new Location();

        loc.setRow(row);
        loc.setCol(col);
        arrLocations.add(loc);
    }

    public String toString() {
        StringBuilder returnString = new StringBuilder();

        returnString.append("Word: ").append(strValue).append("\t");

        for (int i = 0; i < arrLocations.size(); i++) {
            returnString.append(arrLocations.get(i));
            if (i < arrLocations.size() - 1) {
                returnString.append(", ");
            }
        }

        return returnString.toString();
    }
    
    private class Location {

        private int row;
        private int col;

        /**
         * @return the row
         */
        public int getRow() {
            return row;
        }

        /**
         * @param row the row to set
         */
        public void setRow(int row) {
            this.row = row;
        }

        /**
         * @return the col
         */
        public int getCol() {
            return col;
        }

        /**
         * @param col the col to set
         */
        public void setCol(int col) {
            this.col = col;
        }

        public String toString() {
            return "(" + row + "," + col + ")";
        }
    }
}
