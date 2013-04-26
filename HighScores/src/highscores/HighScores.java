/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package highscores;

import java.util.ArrayList;

/**
 *
 * @author Shahyar
 */
public class HighScores {

    private ArrayList<Score> arrScores = new ArrayList<Score>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HighScores hs = new HighScores();

        hs.loadArrScores();

        System.out.println("Scores before sorting:");
        System.out.println(hs.arrScores2String());

        hs.QuickSort(hs.arrScores, 0, hs.arrScores.size() - 1, (hs.arrScores.size() - 1) / 2);

        System.out.println("Scores after sorting:");
        System.out.println(hs.arrScores2String());
    }

    public void loadArrScores() {
        arrScores.add(new Score(1000, "PDO"));
        arrScores.add(new Score(12, "KRO"));
        arrScores.add(new Score(1231, "RJO"));
        arrScores.add(new Score(5000, "MRO"));
        arrScores.add(new Score(5001, "NBO"));
        arrScores.add(new Score(4999, "MCC"));
        arrScores.add(new Score(451, "WFA"));
        arrScores.add(new Score(1, "QFA"));
        arrScores.add(new Score(99, "WTF"));
        arrScores.add(new Score(600, "LOL"));

        arrScores.add(new Score(1100, "ADO"));
        arrScores.add(new Score(13, "BRO"));
        arrScores.add(new Score(1241, "CJO"));
        arrScores.add(new Score(5200, "DRO"));
        arrScores.add(new Score(5041, "WBO"));
        arrScores.add(new Score(5999, "ECC"));
        arrScores.add(new Score(4351, "FFA"));
        arrScores.add(new Score(14, "GFA"));
        arrScores.add(new Score(959, "HTF"));
        arrScores.add(new Score(60, "IOL"));

        arrScores.add(new Score(60, "BAC"));
    }

//    public ArrayList<Score> QuickSort(ArrayList<Score> currentArr, int leftStart, int rightStart) {
////        ArrayList<Score> returnArr = new ArrayList<Score>();
//
//        int leftPivot = leftStart;
//        int rightPivot = rightStart;
//
//        while (leftPivot < (rightPivot)) {
//            if (currentArr.get(leftPivot).compareTo(currentArr.get(rightPivot)) == 1) {
//                Score tmp = new Score(currentArr.get(leftPivot));
//                currentArr.set(leftPivot, new Score(currentArr.get(rightPivot)));
//                currentArr.set(rightPivot, new Score(tmp));
//
//
//                leftPivot++;
//            }
////            else {
//            if (leftPivot != rightPivot) {
//                rightPivot--;
//            }
////            }
//        }
//        
//        if (leftPivot == rightPivot) {
//            rightPivot++;
//        }
//
//        if (leftPivot - leftStart > 1) {
//            QuickSort(currentArr, leftStart, leftPivot);
//        }
//        if (rightStart - rightPivot > 1) {
//            QuickSort(currentArr, rightPivot, rightStart);
//        }
//
//        return currentArr;
//    }
    public ArrayList<Score> QuickSort(ArrayList<Score> currentArr, int leftStart, int rightStart, int nIndex) {
//        ArrayList<Score> returnArr = new ArrayList<Score>();

        float pivotScore = currentArr.get(nIndex).getnScore();
        int leftIndex = leftStart;
        int rightIndex = rightStart;

        while (leftIndex < (rightIndex)) {
            float leftScore = currentArr.get(leftIndex).getnScore();
            float rightScore = currentArr.get(rightIndex).getnScore();

            while (leftScore > pivotScore) {
                leftIndex++;
                leftScore = currentArr.get(leftIndex).getnScore();
            }

            while (rightScore < pivotScore) {
                rightIndex--;
                rightScore = currentArr.get(rightIndex).getnScore();
            }

            if ((leftIndex != rightIndex)) {
                Score tmp = new Score(currentArr.get(leftIndex));
                currentArr.set(leftIndex, new Score(currentArr.get(rightIndex)));
                currentArr.set(rightIndex, new Score(tmp));
                if (leftScore == rightScore) {
                    leftIndex++;
                }
            }
        }

        if (leftIndex == rightIndex) {
            rightIndex++;
        } else if (leftIndex > rightIndex) {
            int tmp = leftIndex;
            leftIndex = rightIndex;
            rightIndex = tmp;
        }

        if (leftIndex - leftStart > 1) {
            QuickSort(currentArr, leftStart, leftIndex, ((leftStart + leftIndex) / 2));
        }
        if (rightStart - rightIndex > 1) {
            QuickSort(currentArr, rightIndex, rightStart, ((rightStart + rightIndex) / 2));
        }

        return currentArr;
    }

    private String arrScores2String() {
        StringBuilder returnString = new StringBuilder();

        for (int i = 0; i < arrScores.size(); i++) {
            returnString.append(arrScores.get(i)).append("\n");
        }

        return returnString.toString();
    }
}
