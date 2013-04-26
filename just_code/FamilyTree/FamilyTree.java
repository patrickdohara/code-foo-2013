/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package familytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shahyar
 */
public class FamilyTree {

    ArrayList<Generation> arrGenerations = new ArrayList<Generation>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String strName = new String();
        int nGeneration = -1;

        FamilyTree ft = new FamilyTree();

        System.out.print("Name (return to skip): ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            strName = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FamilyTree.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.print("Generation (return to skip): ");
        try {
            String strGeneration = br.readLine();
            if ((!strGeneration.equals(""))) {
                nGeneration = Integer.parseInt(strGeneration);
            }
        } catch (IOException ex) {
            Logger.getLogger(FamilyTree.class.getName()).log(Level.SEVERE, null, ex);
        }

        ft.fillArrGenerations();

        System.out.println("Family Tree:\n");
        System.out.println(ft.arrGenerations2String());
        System.out.println();
        System.out.println("Search Results:");
        System.out.println(ft.searchArrGenerations(strName, nGeneration));
    }

    public String searchArrGenerations(String strSearchName, int nSearchGeneration) {
        StringBuilder returnString = new StringBuilder();

        for (int i = 0; i < arrGenerations.size(); i++) {
            Generation currentGen = arrGenerations.get(i);

            if ((currentGen.getnGeneration() == nSearchGeneration) || (nSearchGeneration < 0)) {
                returnString.append("Generation: ").append(currentGen.getnGeneration()).append("\n");
                for (int j = 0; j < currentGen.getArrPersons().size(); j++) {
                    Person currentPerson = currentGen.getArrPersons().get(j);
                    String strCurrentName = currentPerson.getStrName();

                    if ((strCurrentName.contains(strSearchName)) || (strCurrentName.equals("")) || (strCurrentName == null)) {
                        returnString.append(currentPerson).append("\n");
                    }
                }
                returnString.append("\n");
            }
        }

        return returnString.toString();
    }

    public void fillArrGenerations() {
        Generation genZero = new Generation();
        genZero.setnGeneration(0);
        genZero.add("Richard Burke");
        genZero.add("Virginia Burke");

        Generation genOne = new Generation();
        genOne.setnGeneration(1);
        genOne.add("David Burke");
        genOne.add("Cindy Burke");
        genOne.add("Brian Burke");
        genOne.add("Barbara Burke");
        genOne.add("Nancy O'Hara");
        genOne.add("Michael O'Hara");

        Generation genTwo = new Generation();
        genTwo.setnGeneration(2);
        genTwo.add("Brian Burke Jr.");
        genTwo.add("Mary Burke");
        genTwo.add("Sean Burke");
        genTwo.add("Richard Burke");
        genTwo.add("Matthew Burke");
        genTwo.add("Ryan O'Hara");
        genTwo.add("Kevin O'Hara");
        genTwo.add("Patrick O'Hara");

        arrGenerations.add(genZero);
        arrGenerations.add(genOne);
        arrGenerations.add(genTwo);
    }

    private String arrGenerations2String() {
        StringBuilder returnString = new StringBuilder();

        for (int i = 0; i < arrGenerations.size(); i++) {
            returnString.append(arrGenerations.get(i)).append("\n");
        }

        return returnString.toString();
    }
}
