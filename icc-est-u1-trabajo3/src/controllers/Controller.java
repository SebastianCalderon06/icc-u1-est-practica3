package controllers;

import models.Person;
import views.View;

import java.util.Arrays;

public class Controller {
    private View view;
    private SortingMethods sorter;
    private SearchMethods searcher;
    private Person[] persons = new Person[0];

    public Controller(View view, SortingMethods sorter, SearchMethods searcher) {
        this.view = view;
        this.sorter = sorter;
        this.searcher = searcher;
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            int option = view.showMenu();
            switch (option) {
                case 1 -> addPersons();
                case 2 -> sortPersons();
                case 3 -> searchPerson();
                case 4 -> view.displayPersons(persons);
                case 5 -> exit = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void addPersons() {
        Person newPerson = view.inputPerson();
        persons = Arrays.copyOf(persons, persons.length + 1);
        persons[persons.length - 1] = newPerson;
    }

    private void sortPersons() {
        int option = view.selectSortingMethod();
        switch (option) {
            case 1 -> sorter.sortByNameWithBubble(persons);
            case 2 -> sorter.sortByNameWithSelectionDes(persons);
            case 3 -> sorter.sortByAgeWithInsertion(persons);
            case 4 -> sorter.sortByNameWithInsertion(persons);
            default -> System.out.println("Método no válido.");
        }
    }

    private void searchPerson() {
        int criterion = view.selectSearchCriterion();
        if (criterion == 1) {
            if (!searcher.isSortedByAge(persons)) {
                System.out.println("La lista no está ordenada por edad.");
                return;
            }
            int age = view.inputAge();
            Person result = searcher.binarySearchByAge(persons, age);
            view.displaySearchResult(result);
        } else if (criterion == 2) {
            if (!searcher.isSortedByName(persons)) {
                System.out.println("La lista no está ordenada por nombre.");
                return;
            }
            String name = view.inputName();
            Person result = searcher.binarySearchByName(persons, name);
            view.displaySearchResult(result);
        } else {
            System.out.println("Criterio inválido.");
        }
    }
}