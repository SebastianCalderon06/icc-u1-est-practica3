package views;
import java.util.Scanner;
import models.Person;

public class View {
    
    Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n1. Agregar Persona");
        System.out.println("2. Ordenar Personas");
        System.out.println("3. Buscar Persona");
        System.out.println("4. Mostrar Personas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Person inputPerson() {
        System.out.print("Ingrese el nombre: ");
        scanner.nextLine(); // limpiar buffer
        String name = scanner.nextLine();
        System.out.print("Ingrese la edad: ");
        int age = scanner.nextInt();
        return new Person(name, age);
    }

    public int selectSortingMethod() {
        System.out.println("\nMétodo de ordenamiento:");
        System.out.println("1. Burbuja por nombre");
        System.out.println("2. Selección descendente por nombre");
        System.out.println("3. Inserción por edad");
        System.out.println("4. Inserción por nombre");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int selectSearchCriterion() {
        System.out.println("\nCriterio de búsqueda:");
        System.out.println("1. Por edad");
        System.out.println("2. Por nombre");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public void displayPersons(Person[] persons) {
        if (persons.length == 0) {
            System.out.println("No hay personas para mostrar.");
        } else {
            for (Person p : persons) {
                System.out.println(p);
            }
        }
    }

    public void displaySearchResult(Person person) {
        if (person != null) {
            System.out.println("Persona encontrada: " + person);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public int inputAge() {
        System.out.print("Ingrese la edad a buscar: ");
        return scanner.nextInt();
    }

    public String inputName() {
        System.out.print("Ingrese el nombre a buscar: ");
        scanner.nextLine(); // limpiar buffer
        return scanner.nextLine();
    }
}

