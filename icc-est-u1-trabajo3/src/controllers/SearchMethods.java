package controllers;

import models.Person;

public class SearchMethods {

    public boolean isSortedByAge(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            if (persons[i].getAge() > persons[i + 1].getAge()) return false;
        }
        return true;
    }

    public boolean isSortedByName(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            if (persons[i].getName().compareToIgnoreCase(persons[i + 1].getName()) > 0) return false;
        }
        return true;
    }

    public Person binarySearchByAge(Person[] persons, int targetAge) {
        int bajo = 0;
        int alto = persons.length - 1;
        while (bajo <= alto) {
            int central = bajo + (alto-bajo)/ 2;
            int edadCentral = persons[central].getAge();

            if (edadCentral == targetAge) return persons[central];
            if (edadCentral < targetAge) {
                bajo = central + 1;
            } else {
                alto = central - 1;
            }
        }
        return null;
    }

    public Person binarySearchByName(Person[] persons, String targetName) {
        int bajo = 0;
        int alto = persons.length - 1;
        while (bajo <= alto) {
            int central = (bajo + alto) / 2;
            int comparacion = persons[central].getName().compareToIgnoreCase(targetName);

            if (comparacion == 0) return persons[central];
            if (comparacion < 0) {
                bajo = central + 1;
            } else {
                alto = central - 1;
            }
        }
        return null;
    }
}
