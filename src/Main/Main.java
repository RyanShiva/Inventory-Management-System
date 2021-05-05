package Main;

import Model.InHousePart;
import Model.Inventory;
import Model.OutsourcedPart;
import Model.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** This class creates an Inventory Management System app.*/
public class Main extends Application {

    /** This is the start method. This method loads the first screen when the program is run.
     * @param primaryStage JavaFx stage*/
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/Main Screen.fxml"));
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(new Scene(root, 968, 320));
        primaryStage.show();
    }

    /** This is the main method. This is the first method that is called when the java program is run.
     * A useful update to this application would be to store inventory data in a database or a file.
     * Currently, parts and products can be loaded when the main method is executed.
     * However, any changes made to the part and product lists will not be saved upon exiting the application.
     * In the updated application, changes made in a session would still be stored in computer memory as they are in the current version.
     * However, when the user clicks the exit button, an alert would ask the user if they want to save changes made before exiting the application.
     * If the user opts to save changes, then the allParts and allProducts lists would be copied to long term storage.
     * This would also eliminate the need to load part and product data in the main method.
     * Information about each part and product to be loaded would be stored in a separate file instead to be accessed each time the program is run.
     * @param args*/
    public static void main(String[] args) {

        InHousePart Part1 = new InHousePart(1, "Part A", 4.99, 5, 0, 50, 1001);
        InHousePart Part2 = new InHousePart(2, "Part B", 9.99, 10, 0, 50, 1002);
        OutsourcedPart Part3 = new OutsourcedPart(3, "Part C", 14.99, 12, 0, 50, "Company A");

        Inventory.addPart(Part1);
        Inventory.addPart(Part2);
        Inventory.addPart(Part3);

        Product Product1 = new Product(FXCollections.observableArrayList(Part1), 1001, "Product 1", 299.99, 5, 0, 50);
        Product Product2 = new Product(FXCollections.observableArrayList(Part1, Part3), 1002, "Product 2", 399.99, 6, 0, 50);
        Product Product3 = new Product(FXCollections.observableArrayList(Part2, Part3), 1003, "Product 3", 499.99, 9, 0, 50);

        Inventory.addProduct(Product1);
        Inventory.addProduct(Product2);
        Inventory.addProduct(Product3);

        launch(args);
    }
}