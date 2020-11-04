package Files;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Files.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * Controller class for the Add Player
 * @author Group 1
 */
public class ControllerAddPlayer implements Initializable {
   CoachingToolAdapter playerFile;
   PlayerList playerArray;
    @FXML
    private ResourceBundle resources;
    @FXML
    private TextField namefield;
    @FXML
    private TextField numberfield;
    @FXML
    private TextField positionfield;
    @FXML
    ChoiceBox<String> statusfield= new ChoiceBox<>();
    @FXML
    private URL location;

    @FXML
    private Button btnAdd;
    /**
     * The Initialize method runs when this class has been opened or used.
     * This method reads from the file the PlayerListObject, and sets it to the PlayerArray variable.
     * Also, in choice box it adds choices: Available,Not Available,Injured,Suspended.
     * @param arg0 we don't use this, we can't delete them because it is abstract method.
     * @param arg1 we don't use this, we can't delete them because it is abstract method.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
       playerFile = new CoachingToolAdapter("Players.bin");
       playerArray = new PlayerList();
       playerArray = playerFile.getAllPlayers();
       statusfield.getItems().addAll("Available", "Not available", "Injured", "Suspended");
       statusfield.getSelectionModel().select(0);
    }
    /**
     * Creates a player inside the PlayerList object , which is PlayerArray.
     * And after it was added to the PlayerList, it saves the whole PlayerList object to the Players.bin.
    * @throws IOException 
     */
    @FXML
    public void CreateAPlayer() throws IOException 
    {
       try 
       {
          playerArray.addPlayer(new Player(namefield.getText(),Integer.parseInt(numberfield.getText()),positionfield.getText(),statusfield.getValue()));
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
       playerFile.savePlayers(playerArray);
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
