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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * This class is for Player list window. It sets the columns, gets all the information from the PlayerList, and stores them
 * inside the Tableview.
 * @author Group 1
 */

public class ControllerPlayerList implements Initializable{
   
   private CoachingToolAdapter playerFile = new CoachingToolAdapter("Players.bin");
   private PlayerList playerArray = new PlayerList();
	@FXML
	private Button returnBtn;
	
	@FXML
	private Button btnRemovePlayer;
	
	@FXML
	private TableView<Player> playerList;
	@FXML
	private TableColumn<Player, String> nameCol;
	@FXML
	private TableColumn<Player, String> posCol;
	@FXML
	private TableColumn<Player, Integer> numCol;
	@FXML
	private TableColumn<Player, String> statusCol;


   /**
    * It sets the values to the tableview from the Player 
    * @param location we are not using this, but it is a abstract class, so it cant be modified.
    * @param resources we are not using this, but it is a abstract class, so it cant be modified.
    */
	public void initialize(URL location, ResourceBundle resources) {
	   playerArray = playerFile.getAllPlayers();
		
		nameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("Name"));
		posCol.setCellValueFactory(new PropertyValueFactory<Player, String>("Position"));
		numCol.setCellValueFactory(new PropertyValueFactory<Player, Integer>("Number"));
		statusCol.setCellValueFactory(new PropertyValueFactory<Player, String>("Status"));
		
		playerList.getItems().addAll(playerArray.getAllPlayers());
	}
	  /**
    * Gets the selected object from the tableview, and when this function is called, it removes it from the matchlist
    * and saves it to the Matches.bin file. After it got saved, it Refreshes the tableview.
    */
	public void removePlayer()
	{
	   Player player = playerList.getSelectionModel().getSelectedItem();
	   try {
	      playerArray.removePlayer(player.getNumber());
	   }
	   catch (Exception e) {
         Alert errorAlert = new Alert(AlertType.ERROR);
         errorAlert.setHeaderText("Something is wrong");
         errorAlert.showAndWait();
      }
	   
	   playerFile.savePlayers(playerArray);
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Player has been removed successfully!");
      alert.setContentText("Player has been removed!");
      alert.showAndWait();
	   refreshTable();
	}
   /**
    * Refreshes the tableview, and calls the initialize method.
    */
	public void refreshTable()
	{
	   playerList.getItems().clear();
	   initialize(null,null);
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
