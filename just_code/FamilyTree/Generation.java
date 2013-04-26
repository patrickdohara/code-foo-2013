/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package familytree;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Shahyar
 */
public class Generation implements Comparable<Generation> {

    private int nGeneration;
    private ArrayList<Person> arrPersons = new ArrayList<Person>();

    public void add(String strName) {
        arrPersons.add(new Person(strName, nGeneration));

        Collections.sort(arrPersons);
    }

    /**
     * @return the arrPersons
     */
    public ArrayList<Person> getArrPersons() {
        return arrPersons;
    }

    /**
     * @param arrPersons the arrPersons to set
     */
    public void setArrPersons(ArrayList<Person> arrPersons) {
        this.arrPersons = arrPersons;
    }

    /**
     * @return the nGeneration
     */
    public int getnGeneration() {
        return nGeneration;
    }

    /**
     * @param nGeneration the nGeneration to set
     */
    public void setnGeneration(int nGeneration) {
        this.nGeneration = nGeneration;
    }

    @Override
    public int compareTo(Generation compareGeneration) {
        return (compareGeneration.getnGeneration() - this.nGeneration);
    }

    public String toString() {
        StringBuilder returnString = new StringBuilder();

        returnString.append("Generation: ").append(nGeneration).append("\n");

        for (int i = 0; i < arrPersons.size(); i++) {
//            returnString.append("Name: ").append(arrPersons.get(i).getStrName()).append("\n");
            returnString.append(arrPersons.get(i)).append("\n");
        }

        return returnString.toString();
    }
}
