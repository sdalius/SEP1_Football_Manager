package Files;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Controller for adding the match to the matchList object and also saving it to the Matches File
 * @author Group 1
 */

public class ControllerAddMatch implements Initializable {
    CoachingToolAdapter matchFile;
    MatchList matchArray;
   
    @FXML
    private ResourceBundle resources;
    @FXML
    private Button btnAddMatch;

    @FXML
    private URL location;
    @FXML
    private TextField dayfield;
    @FXML
    private TextField monthfield;
    @FXML
    private TextField yearfield;
    @FXML
    private TextField locationfield;
    @FXML
    private TextField subfield;
    @FXML
    private ChoiceBox<String> matchtypes = new ChoiceBox<>();

    @FXML
    private Button btnBack;
    
    /**
     * The Initialize method runs when this class has been opened or used.
     * @param location we don't use this, we can't delete them because it is abstract method.
     * @param resources we don't use this, we can't delete them because it is abstract method.
     */
    public void initialize(URL location, ResourceBundle resources) 
    {
       matchFile = new CoachingToolAdapter("Matches.bin");
       matchArray = new MatchList();
       matchArray = matchFile.getAllMatches();
       matchtypes.getItems().addAll("League", "Championship", "Friendly");
       matchtypes.getSelectionModel().select(0);
    }
    /**
     * Adds a match in the matchList object, and then it saves it to the Matches.bin file.
     * 
     */
    public void CreateAMatch()
    {
       try 
       {
          if (matchtypes.getValue() == "League")
          {
             matchArray.addMatch(new League(new MyDate(Integer.parseInt(dayfield.getText()),Integer.parseInt(monthfield.getText()),Integer.parseInt(yearfield.getText())),locationfield.getText(),Integer.parseInt(subfield.getText())));
          }
          else if (matchtypes.getValue() == "Friendly")
          {
             matchArray.addMatch(new Friendly(new MyDate(Integer.parseInt(dayfield.getText()),Integer.parseInt(monthfield.getText()),Integer.parseInt(yearfield.getText())),locationfield.getText(),Integer.parseInt(subfield.getText())));
          }
          else if (matchtypes.getValue() == "Championship")
          {
             matchArray.addMatch(new Championship(new MyDate(Integer.parseInt(dayfield.getText()),Integer.parseInt(monthfield.getText()),Integer.parseInt(yearfield.getText())),locationfield.getText(),Integer.parseInt(subfield.getText())));
          }
       }
       catch (NumberFormatException number) {
          Alert errorAlert = new Alert(AlertType.ERROR);
          errorAlert.setHeaderText("Input not valid");
          errorAlert.setContentText("Wrong input information.");
          errorAlert.showAndWait();
       }
       catch (IllegalArgumentException e) 
       {
          Alert errorAlert = new Alert(AlertType.ERROR);
          errorAlert.setHeaderText("Input information is invalid");
          errorAlert.setContentText("Input information is wrong. Check them once again.");
          errorAlert.showAndWait();
       }
       catch(NullPointerException ex)
       {
          Alert errorAlert = new Alert(AlertType.ERROR);
          errorAlert.setHeaderText("Some fields are empty");
          errorAlert.setContentText("Some fields are empty, fill them up!");
          errorAlert.showAndWait();
       }
       matchFile.saveMatches(matchArray);
    }
    /**
     * Returns to the Menu
     * @param event event caused by button clicked
     * @throws IOException thrown if fxml file can't be read
     */
    public void returnToMain(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("designMatch.fxml"));
       
       Parent mainViewParent = loader.load();
       Scene mainViewScene = new Scene(mainViewParent);
       
       Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
       window.setScene(mainViewScene);
       window.show();
    }
}
