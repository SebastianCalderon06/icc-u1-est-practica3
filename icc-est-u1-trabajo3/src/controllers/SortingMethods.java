package controllers;

import models.Person;

public class SortingMethods {

    public void sortByNameWithBubble(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - i - 1; j++) {
                if (persons[j].getName().compareToIgnoreCase(persons[j + 1].getName()) > 0) {
                    Person temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
    }

    public void sortByNameWithSelectionDes(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < persons.length; j++) {
                if (persons[j].getName().compareToIgnoreCase(persons[maxIndex].getName()) > 0) {
                    maxIndex = j;
                }
            }
            Person temp = persons[i];
            persons[i] = persons[maxIndex];
            persons[maxIndex] = temp;
        }
    }

    public void sortByAgeWithInsertion(Person[] persons) {
        int aux = 0;
        Person per;
        int tam = persons.length;
        for (int i = 1; i<tam ; i++){

            aux = persons[i].getAge();
            per = persons[i];
            int j = i-1;
            while (j>=0 && aux<persons[j].getAge()){
                persons[j+1] = persons[j];
                j= j-1;
                persons[j+1] = per;
        }
    }
    }

    public void sortByNameWithInsertion(Person[] persons) {
        Person per;
        int tam = persons.length;
        for (int i = 1; i < tam; i++) {
            per = persons[i];
            int j = i - 1;
            while (j >= 0 && persons[j].getName().compareToIgnoreCase(per.getName()) > 0) {
                persons[j + 1] = persons[j];
                j= j-1;
            }
            persons[j + 1] = per;
        }
    }
    }
