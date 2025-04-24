import controllers.Controller;
import controllers.SortingMethods;
import controllers.SearchMethods;
import views.View;

public class App {
    public static void main(String[] args) {
        View view = new View();
        SortingMethods sortingMethods = new SortingMethods();
        SearchMethods searchMethods = new SearchMethods();
        Controller controller = new Controller(view, sortingMethods, searchMethods);

        controller.start();
    }
}
