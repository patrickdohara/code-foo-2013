/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package familytree;

import java.util.Objects;

/**
 *
 * @author Shahyar
 */
public class Person implements Comparable<Person> {

    private String strName;
    private int nGeneration;

    Person(String strName, int nGeneration) {
        this.strName = strName;
        this.nGeneration = nGeneration;
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

    /**
     * @return the nGeneration
     */
    public int getnGenerataion() {
        return nGeneration;
    }

    /**
     * @param nGeneration the nGeneration to set
     */
    public void setnGenerataion(int nGenerataion) {
        this.nGeneration = nGenerataion;
    }

    @Override
    public int compareTo(Person comparePerson) {
        int returnValue = 0;

        if (this.nGeneration < comparePerson.getnGenerataion()) {
            returnValue = 1;
        } else if (this.nGeneration > comparePerson.getnGenerataion()) {
            returnValue = -1;
        } else {
            returnValue = this.strName.compareTo(comparePerson.getStrName());
        }

        return returnValue;
    }

    public String toString() {
        StringBuilder returnString = new StringBuilder();

        returnString.append("Name: ").append(strName);

        return returnString.toString();
    }
}
