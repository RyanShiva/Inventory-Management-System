package View_Controller;

import Model.InHousePart;
import Model.Inventory;
import Model.OutsourcedPart;
import Model.Part;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/** This class controls the AddPart screen.*/
public class AddPartController implements Initializable {

    Stage stage;
    Parent scene;

    /** This method switches the screen to the location specified by the location parameter.
     * @param location path to the screen to load
     * @param event ActionEvent caused by the user clicking a button*/
    public void SwitchScreen (String location, ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource(location));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /** This method generates a unique part ID.
     * @return unique part id integer*/
    public int generateId() {
        int greatestId = 0;
        for(Part part : Inventory.getAllParts()) {
            if(part.getId() >= greatestId)
                greatestId = part.getId();
        }
        return ++greatestId;
    }


    @FXML
    private RadioButton inHouseRBtn;

    @FXML
    private RadioButton outsourcedRBtn;

    @FXML
    private Label machineIdOrCompanyNameLbl;

    @FXML
    private TextField idTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField invTxt;

    @FXML
    private TextField priceTxt;

    @FXML
    private TextField minTxt;

    @FXML
    private TextField maxTxt;

    @FXML
    private TextField machineIdOrCompanyNameTxt;

    @FXML
    /**This is the onActionDisplayMainScreen event handler. When the cancel button is clicked, this handler confirms the action and returns the user to the main screen.
     * @param event ActionEvent is generated when the user clicks the cancel button*/
    void onActionDisplayMainScreen(ActionEvent event) throws IOException {
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION, "This will clear all text field values. Do you want to continue?");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            SwitchScreen("/View_Controller/Main Screen.fxml", event);
        }
    }

    @FXML
    /**This is the switchLabelMachineId event handler. When the In House radio button is clicked, this handler changes the Company Name text field input to a Machine ID input.
     * @param event ActionEvent is generated when the user clicks the In House radio button*/
    void switchLabelMachineId(MouseEvent event) {
        machineIdOrCompanyNameLbl.setText("Machine ID");
        machineIdOrCompanyNameTxt.setPromptText("Machine ID");
    }

    @FXML
    /**This is the switchLabelCompanyName event handler. When the Outsourced radio button is clicked, this handler changes the Machine ID text field input to a Company Name input.
     * @param event ActionEvent is generated when the user clicks the Outsourced radio button*/
    void switchLabelCompanyName(MouseEvent event) {
        machineIdOrCompanyNameLbl.setText("Company Name");
        machineIdOrCompanyNameTxt.setPromptText("Company Name");
    }

    @FXML
    /**This is the onActionSavePart event handler. When the Save button is clicked, this handler saves the part and switches to the main screen.
     * @param event ActionEvent is generated when the user clicks the Save button*/
    void onActionSavePart(ActionEvent event) throws IOException {

        try {
            int id = generateId();
            String name = nameTxt.getText();
            double price = Double.parseDouble(priceTxt.getText());
            int stock = Integer.parseInt(invTxt.getText());
            int min = Integer.parseInt(minTxt.getText());
            int max = Integer.parseInt(maxTxt.getText());

            if(min >= max) {
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setContentText("Min must be less than Max!");
                alert.showAndWait();
                return;
            }
            if(stock < min || stock > max) {
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setContentText("Inventory must be between Min and Max!");
                alert.showAndWait();
                return;
            }

            if (inHouseRBtn.isSelected()) {
                int machineId = Integer.parseInt(machineIdOrCompanyNameTxt.getText());
                Inventory.addPart(new InHousePart(id, name, price, stock, min, max, machineId));
            } else {
                String companyName = machineIdOrCompanyNameTxt.getText();
                Inventory.addPart(new OutsourcedPart(id, name, price, stock, min, max, companyName));
            }

            SwitchScreen("/View_Controller/Main Screen.fxml", event);
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please enter a valid value for each text field.");
            alert.showAndWait();
        }
    }

    @Override
    /**This is the initialize method. This method initializes the controller.
     * @param rb
     * @param url*/
    public void initialize(URL url, ResourceBundle rb) {
        inHouseRBtn.setSelected(true);
    }

}
